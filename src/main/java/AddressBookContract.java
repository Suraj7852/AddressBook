import java.io.IOException;
import java.util.List;

public interface AddressBookContract {
    void addPerson(String name, String address, String city, String state, String zip, String phNo) throws IOException;
    void editPersonDetails(int slNo, String field, String value) throws IOException;
    void printEntries();
    void deleteAPerson(int slNo) throws IOException;
    void sortEntitiesByName() throws IOException;
}
