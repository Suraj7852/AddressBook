import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddressBook implements AddressBookContract {
    String SAMPLE_CSV_FILE_PATH_JSON = "/home/admin1/Desktop/suraj/AdressBook/src/main/resources/addressBook.json";
    @Override
    public void addPerson(String name, String address, String city, String state, String zip, String phNo) throws IOException {
        AddressBookPOJO addressBookPOJO = new AddressBookPOJO();
        List<AddressBookPOJO> addPersonList = new ArrayList<>();
        addressBookPOJO.setName(name);
        addressBookPOJO.setAddress(address);
        addressBookPOJO.setCity(city);
        addressBookPOJO.setState(state);
        addressBookPOJO.setZip(zip);
        addressBookPOJO.setPhoneNo(phNo);
        addPersonList.add(addressBookPOJO);
        writeToJSON(addPersonList);
    }

    private void writeToJSON(List<AddressBookPOJO> addPersonList) throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(addPersonList);
        FileWriter writer = new FileWriter(SAMPLE_CSV_FILE_PATH_JSON);
        writer.write(json);
        writer.close();
    }
}
