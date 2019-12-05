import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class AddressBookTest {
    @Test
    public void addingAPersonToAddressBook() throws IOException {
        AddressBook addressBook = new AddressBook("/home/admin1/Desktop/suraj/AdressBook/src/main/resources/newAddressBook.json");
        addressBook.addPerson("shri","D-T-1964","ranchi","jharkhand","834003","7739427302");
    }

    @Test
    public void editPersonDetails() throws IOException {
        AddressBook addressBook = new AddressBook();
        addressBook.editPersonDetails(1,"city","Bangalore");
    }

    @Test
    public void printingDetails() throws FileNotFoundException {
        AddressBook addressBook = new AddressBook("/home/admin1/Desktop/suraj/AdressBook/src/main/resources/addressBook.json");
        addressBook.printEntries();
    }

    @Test
    public void deletingPersonDetails() throws IOException {
        AddressBook addressBook = new AddressBook("/home/admin1/Desktop/suraj/AdressBook/src/main/resources/addressBook.json");
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

    @Test
    public void createAddressBook() throws IOException {
        AddressBook addressBook = new AddressBook();
        addressBook.createNewAddressBook("newAddressBook");
    }

    @Test
    public void existingAddressBook() throws IOException {
        AddressBook addressBook = new AddressBook();
        addressBook.existingFile();
    }

    @Test
    public void openExistingFile() throws IOException {
        AddressBook addressBook = new AddressBook();
        addressBook.openExistingFile(0);
        addressBook.addPerson("shubham","D-T-1964","ranchi","jharkhand","834003","7739427302");
    }

    @Test
    public void printFiles() {
        AddressBook addressBook = new AddressBook();
        addressBook.printFiles();
    }
}
