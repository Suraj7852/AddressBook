import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AddressBook implements AddressBookContract {
    String SAMPLE_CSV_FILE_PATH_JSON = "/home/admin1/Desktop/suraj/AdressBook/src/main/resources/addressBook.json";
    Gson gson = new Gson();
    BufferedReader br = new BufferedReader(new FileReader(SAMPLE_CSV_FILE_PATH_JSON));
    AddressBookPOJO[] readPersonDetails = gson.fromJson(br, AddressBookPOJO[].class);
    AddressBookPOJO addressBookPOJO = new AddressBookPOJO();
    List<AddressBookPOJO> addPersonList = new ArrayList<>();

    public AddressBook() throws FileNotFoundException {
    }

    @Override
    public void addPerson(String name, String address, String city, String state, String zip, String phNo) throws IOException {
        addressBookPOJO.setName(name);
        addressBookPOJO.setAddress(address);
        addressBookPOJO.setCity(city);
        addressBookPOJO.setState(state);
        addressBookPOJO.setZip(zip);
        addressBookPOJO.setPhoneNo(phNo);
        addPersonList.add(addressBookPOJO);
        if (readPersonDetails!=null) {
            readJSONFile();
        }
        writeToJSON(addPersonList);
    }

    @Override
    public void editPersonDetails(int slNo, String field, String value) throws IOException {
        readJSONFile();
        if (field.equals("name"))
            readPersonDetails[slNo].setName(value);
        else if(field.equals("address"))
            readPersonDetails[slNo].setAddress(value);
        else if(field.equals("city"))
            readPersonDetails[slNo].setCity(value);
        else if (field.equals("state"))
            readPersonDetails[slNo].setState(value);
        else if (field.equals("zip"))
            readPersonDetails[slNo].setZip(value);
        else if (field.equals("phoneNo"))
            readPersonDetails[slNo].setPhoneNo(value);
        else
            System.out.println("Enter proper field");
        addPersonList.add(addressBookPOJO);
        writeToJSON(addPersonList);
    }

    @Override
    public void printEntries() {
        int slNo = 0;
        System.out.println("Sl"+"\t"+"Name"+"\t"+"Address"+"\t"+"    City"+"\t"+"State"+"\t"+"    Zip"+"\t"+"    Phone");
        for (int details=0; details<readPersonDetails.length; details++) {
            if (readPersonDetails[details].getName() != null)
                System.out.println(slNo + "\t" + readPersonDetails[details].getName() + "\t" + readPersonDetails[details].getAddress() + "\t" + readPersonDetails[details].getCity() + "\t" + readPersonDetails[details].getState() + "\t" + readPersonDetails[details].getZip() + "\t" + readPersonDetails[details].getPhoneNo());
            slNo++;
        }
    }

    @Override
    public void deleteAPerson(int slNo) throws IOException {
        for (int details=0; details<readPersonDetails.length; details++) {
            if (slNo != details)
                addPersonList.add(readPersonDetails[details]);
        }
        addPersonList.add(addressBookPOJO);
        writeToJSON(addPersonList);
    }

    private void writeToJSON(List<AddressBookPOJO> addPersonList) throws IOException {
        String json = gson.toJson(addPersonList);
        FileWriter writer = new FileWriter(SAMPLE_CSV_FILE_PATH_JSON);
        writer.write(json);
        readJSONFile();
        writer.close();
    }

    private void readJSONFile() {
        for (int details=0; details<readPersonDetails.length; details++) {
            if (readPersonDetails[details].getName() != null)
                addPersonList.add(readPersonDetails[details]);
        }
    }
}
