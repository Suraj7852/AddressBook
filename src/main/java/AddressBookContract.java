import java.io.IOException;

public interface AddressBookContract {
    boolean addPerson(String name, String address, String city, String state, String zip, String phNo) throws IOException, AddressBookException;
    boolean editPersonDetails(int slNo, String field, String value) throws IOException, AddressBookException;
    boolean printEntries();
    boolean deleteAPerson(int slNo) throws IOException;
    boolean sortEntitiesByName() throws IOException, AddressBookException;
    boolean sortEntitiesByZip() throws IOException, AddressBookException;
    String createNewAddressBook(String path,String fileName) throws IOException, AddressBookException;
}
