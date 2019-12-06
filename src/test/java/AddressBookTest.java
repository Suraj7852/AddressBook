import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class AddressBookTest {
    AddressBook addressBook = new AddressBook();
    String pathAddress = "/home/admin1/Desktop/suraj/AdressBook/src/main/resources/";

    @Test
    public void addingAPersonToAddressBookThrowsException() {
        try {
            AddressBook addressBook = new AddressBook("/home/admin1/Desktop/suraj/AdressBook/src/main/resrces/addressBook.json");
            boolean b = addressBook.addPerson("shri", "D-T-1964", "ranchi", "jharkhand", "834003", "7739427302");
            Assert.assertTrue(b);
        } catch (AddressBookException e) {
            Assert.assertEquals(AddressBookException.ExceptionType.NO_SUCH_FILE,e.type);
        }
    }

    @Test
    public void addingAPersonToAddressBook(){
        try {
            String s = addressBook.openExistingFile(0,pathAddress);
            AddressBook addressBook = new AddressBook(s);
            boolean b = addressBook.addPerson("shri", "D-T-1964", "ranchi", "jharkhand", "834003", "7739427302");
            Assert.assertTrue(b);
        } catch (AddressBookException e) {
            Assert.assertEquals(AddressBookException.ExceptionType.NO_SUCH_FILE,e.type);
        }
    }

    @Test
    public void editPersonDetails() throws AddressBookException {
        String s = addressBook.openExistingFile(0,pathAddress);
        AddressBook addressBook = new AddressBook(s);
        Assert.assertTrue(addressBook.editPersonDetails(0, "name", "suraj"));
        Assert.assertTrue(addressBook.editPersonDetails(0, "address", "bhubaneswar"));
        Assert.assertTrue(addressBook.editPersonDetails(0, "city", "ranchi"));
        Assert.assertTrue(addressBook.editPersonDetails(0, "state", "jharkhand"));
        Assert.assertTrue(addressBook.editPersonDetails(0, "zip", "834004"));
        Assert.assertTrue(addressBook.editPersonDetails(0, "phoneNo", "9334158709"));
    }

    @Test
    public void editPersonDetailsIfWrongIndexValueThrowException(){
        try {
            String s = addressBook.openExistingFile(20,pathAddress);
            AddressBook addressBook = new AddressBook(s);
            Assert.assertTrue(addressBook.editPersonDetails(10, "name", "suraj"));
            Assert.assertTrue(addressBook.editPersonDetails(0, "address", "bhubaneswar"));
            Assert.assertTrue(addressBook.editPersonDetails(0, "city", "ranchi"));
            Assert.assertTrue(addressBook.editPersonDetails(0, "state", "jharkhand"));
            Assert.assertTrue(addressBook.editPersonDetails(0, "zip", "834004"));
            Assert.assertTrue(addressBook.editPersonDetails(0, "phoneNo", "9334158709"));
            Assert.assertFalse(addressBook.editPersonDetails(0, "fggg", "suraj"));
        } catch (AddressBookException e) {
            Assert.assertEquals(AddressBookException.ExceptionType.ARRAY_INDEX_OUT_OF_BOUND,e.type);
        }
    }

    @Test
    public void givenFileSerialNoNotFoundThenGIveException() {
        try {
            String s = addressBook.openExistingFile(7,pathAddress);
        } catch (AddressBookException e) {
            Assert.assertEquals(AddressBookException.ExceptionType.ARRAY_INDEX_OUT_OF_BOUND,e.type);
        }
    }


    @Test
    public void printingDetails() throws AddressBookException {
        String s = addressBook.openExistingFile(1,pathAddress);
        AddressBook addressBook = new AddressBook(s);
        Assert.assertTrue(addressBook.printEntries());
    }

    @Test
    public void deletingPersonDetails() throws AddressBookException {
        String s = addressBook.openExistingFile(1,pathAddress);
        AddressBook addressBook = new AddressBook(s);
        Assert.assertTrue(addressBook.deleteAPerson(2));
    }

    @Test
    public void deletingPersonDetailsIfIndexValueIsWrong() throws AddressBookException {
        String s = addressBook.openExistingFile(1,pathAddress);
        AddressBook addressBook = new AddressBook(s);
        Assert.assertFalse(addressBook.deleteAPerson(20));
    }

    @Test
    public void sortByName() throws AddressBookException {
        String s = addressBook.openExistingFile(1,pathAddress);
        AddressBook addressBook = new AddressBook(s);
        Assert.assertTrue(addressBook.sortEntitiesByName());
    }

    @Test
    public void sortByZip() throws AddressBookException {
        String s = addressBook.openExistingFile(1,pathAddress);
        AddressBook addressBook = new AddressBook(s);
        Assert.assertTrue(addressBook.sortEntitiesByZip());
    }

    @Test
    public void createAddressBook() throws AddressBookException {
        String newAddressBook2 = addressBook.createNewAddressBook("newAddressBook2",pathAddress);
        Assert.assertEquals("newAddressBook2.json",newAddressBook2);
    }

    @Test
    public void createAddressBookIfWrongPathThrowException() {
        try {
            String path = "/home/admin1/Desktop/suraj/AdressBook/src/main/reurces/";
            addressBook.createNewAddressBook("newAddressBook2",path);
        } catch (AddressBookException e) {
            Assert.assertEquals(AddressBookException.ExceptionType.IO_EXCEPTION,e.type);
        }
    }

    @Test
    public void existingAddressBook() throws AddressBookException {
        File[] files = addressBook.existingFile(pathAddress);
        int count = files.length;
        Assert.assertEquals(count,5);
    }

    @Test
    public void openExistingFile() throws AddressBookException {
        String s = addressBook.openExistingFile(1,pathAddress);
        AddressBook addressBook = new AddressBook(s);
        String s1 = addressBook.openExistingFile(0,pathAddress);
        Assert.assertEquals(s1,"/home/admin1/Desktop/suraj/AdressBook/src/main/resources/vishal.json");
    }

    @Test
    public void printFiles() throws AddressBookException {
        Assert.assertTrue(addressBook.printFiles(pathAddress));
    }

    @Test
    public void readingEntitiesFromJsonFile() throws AddressBookException {
        String s = addressBook.openExistingFile(0,pathAddress);
        AddressBook addressBook = new AddressBook(s);
        Assert.assertTrue(addressBook.readJSONFile());
    }

    @Test
    public void writingPersonDetailsToJsonFile() throws IOException, AddressBookException {
        String s = addressBook.openExistingFile(0,pathAddress);
        AddressBook addressBook = new AddressBook(s);
        Assert.assertTrue(addressBook.writeToJSON());
    }
}
