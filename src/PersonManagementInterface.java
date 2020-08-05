
public interface PersonManagementInterface {
	void addPersonRecord(PersonInfo personInfo);
	void updateRecord(int id, long phoneNumber, AddressInfo address);
	void display();
	void delete(int id);
	void sortByLastName();
	void sortByZipCode();
}
