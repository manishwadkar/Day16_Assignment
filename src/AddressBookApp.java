import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class AddressBookApp implements PersonManagementInterface {

	List<PersonInfo> personInfoList = new ArrayList<PersonInfo>();

	@Override
	public void addPersonRecord(PersonInfo personInfo) {

		personInfoList.add(personInfo);
	}

	@Override
	public void updateRecord(int id, long phoneNumber, AddressInfo address) {

		for (int i = 0; i < personInfoList.size(); i++) {

			PersonInfo personInfo = personInfoList.get(i);

			if (personInfo.getId() == id) {
				personInfo.setPhoneNumber(phoneNumber);
				personInfo.setAddress(address);
			}
		}
		System.out.println("Record is not present");
		display();
	}

	@Override
	public void display() {

		for (int i = 0; i < personInfoList.size(); i++) {

			System.out.println(personInfoList.get(i));

		}
	}

	@Override
	public void delete(int id) {

		for (int i = 0; i < personInfoList.size(); i++) {

			PersonInfo personInfo = personInfoList.get(i);

			if (personInfo.getId() == id) {

				personInfoList.remove(i);
			}
		}
		System.out.println("Record is not present");
		display();

	}

	@Override
	public void sortByLastName() {

		Collections.sort(personInfoList, new Comparator<PersonInfo>() {

			@Override
			public int compare(PersonInfo person1, PersonInfo person2) {

				String person1Name = person1.getLastName().toUpperCase();
				String person2Name = person2.getLastName().toUpperCase();

				return person1Name.compareTo(person2Name);
			}
		});

		display();
	}

	@Override
	public void sortByZipCode() {

		Collections.sort(personInfoList, new Comparator<PersonInfo>() {

			@Override
			public int compare(PersonInfo person1, PersonInfo person2) {

				return person1.getAddress().getZipCode() - person2.getAddress().getZipCode();
			}
		});

		display();

	}

	public static void main(String[] args) {

		AddressBookApp addressBookApp = new AddressBookApp();
				
		int choice;
		Scanner sc = new Scanner(System.in);
		DriverMethodsImpl driverMethodsImpl = new DriverMethodsImpl();

		do {
			System.out.println("\nWelcome to Address Book Management");
			System.out.println("1.Add records to Address Book");
			System.out.println("2.Display records in the Address Book");
			System.out.println("3.Update record in the Address Book");
			System.out.println("4.Delete Record from the Address Book");
			System.out.println("5.Sort records by Last Name");
			System.out.println("6.Sort records by Zip Code");
			System.out.println("7.Exit");
			System.out.println("Enter your choice");
			choice = sc.nextInt();

			switch (choice) {

			case 1:
				PersonInfo personInfo = driverMethodsImpl.getPersonInfo(sc);
				addressBookApp.addPersonRecord(personInfo);
				break;
				
			case 2:
				addressBookApp.display();
				break;
				
			case 3:
				PersonInfo updatedDetails = driverMethodsImpl.getUpdatedDetails(sc);
				addressBookApp.updateRecord(updatedDetails.getId(), updatedDetails.getPhoneNumber(), updatedDetails.getAddress());
				break;
				
			case 4:

				System.out.println("Enter Person's Id to be deleted: ");
				int id = sc.nextInt();
				addressBookApp.delete(id);
				break;
				
			case 5:
				addressBookApp.sortByLastName();
				break;
				
			case 6:
				addressBookApp.sortByZipCode();
				break;

			case 7:
				System.exit(0);
			default:
				System.out.println("Incorrect Input!!! Please enter a choice between 1 to 7");
			}
		}while(choice != 7);
		sc.close();
	
	}

}
