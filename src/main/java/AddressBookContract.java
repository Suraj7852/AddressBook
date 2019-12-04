import java.io.IOException;

public interface AddressBookContract {
    void addPerson(String name, String address, String city, String state, String zip, String phNo) throws IOException;
}
