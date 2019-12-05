import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class AddressBookTest {
    @Test
    public void addingAPersonToAddressBook() throws IOException {
        AddressBook addressBook = new AddressBook();
        addressBook.addPerson("shubham","D-T-1964","ranchi","jharkhand","834003","7739427302");
    }

    @Test
    public void editPersonDetails() throws IOException {
        AddressBook addressBook = new AddressBook();
        addressBook.editPersonDetails(1,"city","Bangalore");
    }

    @Test
    public void printingDetails() throws FileNotFoundException {
        AddressBook addressBook = new AddressBook();
        addressBook.printEntries();
    }

    @Test
    public void deletingPersonDetails() throws IOException {
        AddressBook addressBook = new AddressBook();
        addressBook.deleteAPerson(0);
    }

    @Test
    public void sortByName() throws IOException {
        AddressBook addressBook = new AddressBook();
        addressBook.sortEntitiesByName();
    }

    @Test
    public void sortByZip() throws IOException {
        AddressBook addressBook = new AddressBook();
        addressBook.sortEntitiesByZip();
    }
}
