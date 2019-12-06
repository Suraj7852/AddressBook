import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AddressBookTest {
    AddressBook addressBook = new AddressBook();
    @Test
    public void addingAPersonToAddressBook() throws IOException {
        String s = addressBook.openExistingFile(0);
        AddressBook addressBook = new AddressBook(s);
        boolean b = addressBook.addPerson("shri", "D-T-1964", "ranchi", "jharkhand", "834003", "7739427302");
        Assert.assertTrue(b);
    }

    @Test
    public void editPersonDetails() throws IOException {
        String s = addressBook.openExistingFile(1);
        AddressBook addressBook = new AddressBook(s);
        Assert.assertTrue(addressBook.editPersonDetails(0, "name", "suraj"));
        Assert.assertTrue(addressBook.editPersonDetails(0, "address", "bhubaneswar"));
        Assert.assertTrue(addressBook.editPersonDetails(0, "city", "ranchi"));
        Assert.assertTrue(addressBook.editPersonDetails(0, "state", "jharkhand"));
        Assert.assertTrue(addressBook.editPersonDetails(0, "zip", "834004"));
        Assert.assertTrue(addressBook.editPersonDetails(0, "phoneNo", "9334158709"));
        Assert.assertFalse(addressBook.editPersonDetails(0, "fggg", "suraj"));
    }

    @Test
    public void printingDetails() throws FileNotFoundException {
        String s = addressBook.openExistingFile(1);
        AddressBook addressBook = new AddressBook(s);
        Assert.assertTrue(addressBook.printEntries());
    }

    @Test
    public void deletingPersonDetails() throws IOException {
        String s = addressBook.openExistingFile(1);
        AddressBook addressBook = new AddressBook(s);
        Assert.assertTrue(addressBook.deleteAPerson(0));
    }

    @Test
    public void sortByName() throws IOException {
        String s = addressBook.openExistingFile(1);
        AddressBook addressBook = new AddressBook(s);
        Assert.assertTrue(addressBook.sortEntitiesByName());
    }

    @Test
    public void sortByZip() throws IOException {
        String s = addressBook.openExistingFile(1);
        AddressBook addressBook = new AddressBook(s);
        Assert.assertTrue(addressBook.sortEntitiesByZip());
    }

    @Test
    public void createAddressBook() throws IOException {
        String s = addressBook.openExistingFile(1);
        AddressBook addressBook = new AddressBook(s);
        String newAddressBook2 = addressBook.createNewAddressBook("newAddressBook2");
        Assert.assertEquals("newAddressBook2.json",newAddressBook2);
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
