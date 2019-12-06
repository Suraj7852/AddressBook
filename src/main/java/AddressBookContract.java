import java.io.IOException;

public interface AddressBookContract {
    boolean addPerson(String name, String address, String city, String state, String zip, String phNo) throws IOException;
    boolean editPersonDetails(int slNo, String field, String value) throws IOException;
    boolean printEntries();
    boolean deleteAPerson(int slNo) throws IOException;
    boolean sortEntitiesByName() throws IOException;
    boolean sortEntitiesByZip() throws IOException;
    String createNewAddressBook(String path) throws IOException;
}
