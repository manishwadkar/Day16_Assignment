import java.util.Scanner;

public class DriverMethodsImpl implements DriverMethodsInerface {

	@Override
	public PersonInfo getPersonInfo(Scanner input) {

		System.out.println("Enter Person Details");
		PersonInfo personInfo = new PersonInfo();

		System.out.println("Enter Id: ");
		personInfo.setId(input.nextInt());

		System.out.println("Enter first name: ");
		personInfo.setFirstName(input.next());

		System.out.println("Enter last name: ");
		personInfo.setLastName(input.next());

		System.out.println("Enter phone number: ");
		personInfo.setPhoneNumber(input.nextLong());

		System.out.println("Enter Address Details: ");
		AddressInfo address = new AddressInfo();

		System.out.println("Enter city: ");
		address.setCity(input.next());

		System.out.println("Enter state: ");
		address.setState(input.next());

		System.out.println("Enter zipCode: ");
		address.setZipCode(input.nextInt());

		personInfo.setAddress(address);

		return personInfo;
	}

	@Override
	public PersonInfo getUpdatedDetails(Scanner input) {

		System.out.println("Enter Person Details To Update : ");
		PersonInfo personInfo = new PersonInfo();

		System.out.println("Enter Id: ");
		personInfo.setId(input.nextInt());

		System.out.println("Enter phone number: ");
		personInfo.setPhoneNumber(input.nextLong());

		System.out.println("Enter Address Details: ");
		AddressInfo address = new AddressInfo();

		System.out.println("Enter city: ");
		address.setCity(input.next());

		System.out.println("Enter state: ");
		address.setState(input.next());

		System.out.println("Enter zipCode: ");
		address.setZipCode(input.nextInt());

		personInfo.setAddress(address);

		return personInfo;

	}

}
