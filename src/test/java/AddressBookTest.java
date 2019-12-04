import org.junit.Test;

import java.io.IOException;

public class AddressBookTest {
    @Test
    public void addingAPersonToAddressBook() throws IOException {
        AddressBook addressBook = new AddressBook();
        addressBook.addPerson("suraj","D-T-1964","ranchi","jharkhand","834004","7739427302");
    }
}
