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
        String newAddressBook2 = addressBook.createNewAddressBook("newAddressBook2");
        Assert.assertEquals("newAddressBook2.json",newAddressBook2);
    }

    @Test
    public void existingAddressBook() {
        File[] files = addressBook.existingFile();
        int count = files.length;
        Assert.assertEquals(count,5);
    }

    @Test
    public void openExistingFile() throws IOException {
        String s = addressBook.openExistingFile(1);
        AddressBook addressBook = new AddressBook(s);
        String s1 = addressBook.openExistingFile(0);
        Assert.assertEquals(s1,"/home/admin1/Desktop/suraj/AdressBook/src/main/resources/vishal.json");
    }

    @Test
    public void printFiles() {
        Assert.assertTrue(addressBook.printFiles());
    }

    @Test
    public void readingEntitiesFromJsonFile() throws FileNotFoundException {
        String s = addressBook.openExistingFile(0);
        AddressBook addressBook = new AddressBook(s);
        Assert.assertTrue(addressBook.readJSONFile());
    }

    @Test
    public void writingPersonDetailsToJsonFile() throws IOException {
        String s = addressBook.openExistingFile(0);
        AddressBook addressBook = new AddressBook(s);
        Assert.assertTrue(addressBook.writeToJSON());
    }
}
