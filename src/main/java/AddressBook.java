import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AddressBook implements AddressBookContract {
    AddressBookPOJO addressBookPOJO = new AddressBookPOJO();
    List<AddressBookPOJO> addPersonList = new ArrayList<>();
    AddressBookPOJO[] readPersonDetails;
    String filePath;
    Gson gson = new Gson();
    boolean flag = false;

    public AddressBook(String path) throws FileNotFoundException {
        filePath = path;
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        readPersonDetails = gson.fromJson(br, AddressBookPOJO[].class);
    }

    public AddressBook(){

    }

    @Override
    public boolean addPerson(String name, String address, String city, String state, String zip, String phNo) {
        addressBookPOJO.setName(name);
        addressBookPOJO.setAddress(address);
        addressBookPOJO.setCity(city);
        addressBookPOJO.setState(state);
        addressBookPOJO.setZip(zip);
        addressBookPOJO.setPhoneNo(phNo);
        if (readPersonDetails.length > 0) {
            readJSONFile();
        }
        addPersonList.add(addressBookPOJO);
        flag = true;
        return flag;
    }

    @Override
    public boolean editPersonDetails(int slNo, String field, String value){
        readJSONFile();
        if (field.equals("name")){
            readPersonDetails[slNo].setName(value);
            flag = true;
        }
        else if(field.equals("address")){
            readPersonDetails[slNo].setAddress(value);
            flag = true;
        }
        else if(field.equals("city")){
            readPersonDetails[slNo].setCity(value);
            flag = true;
        }
        else if (field.equals("state")){
            readPersonDetails[slNo].setState(value);
            flag = true;
        }
        else if (field.equals("zip")){
            readPersonDetails[slNo].setZip(value);
            flag = true;
        }
        else if (field.equals("phoneNo")){
            readPersonDetails[slNo].setPhoneNo(value);
            flag = true;
        }
        else
            flag = false;
        addPersonList.add(addressBookPOJO);
        return flag;
    }

    @Override
    public boolean printEntries() {
        int slNo = 0;
        System.out.println("Sl"+"\t"+"Name"+"\t"+"Address"+"\t"+"    City"+"\t"+"State"+"\t"+"    Zip"+"\t"+"    Phone");
        for (int details=0; details<readPersonDetails.length; details++) {
            if (readPersonDetails[details].getName() != null)
                System.out.println(slNo + "\t" + readPersonDetails[details].getName() + "\t" + readPersonDetails[details].getAddress() + "\t" + readPersonDetails[details].getCity() + "\t" + readPersonDetails[details].getState() + "\t" + readPersonDetails[details].getZip() + "\t" + readPersonDetails[details].getPhoneNo());
            slNo++;
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean deleteAPerson(int slNo) throws IOException {
        for (int details=0; details<readPersonDetails.length; details++) {
            if (slNo != details)
                addPersonList.add(readPersonDetails[details]);
            flag = true;
        }
        addPersonList.add(addressBookPOJO);
        return flag;
    }

    @Override
    public void sortEntitiesByName() throws IOException {
        readJSONFile();
        Comparator<AddressBookPOJO> comparing = Comparator.comparing(AddressBookPOJO::getName);
        addPersonList.sort(comparing);
    }

    @Override
    public void sortEntitiesByZip() throws IOException {
        readJSONFile();
        Comparator<AddressBookPOJO> comparing = Comparator.comparing(AddressBookPOJO::getZip);
        addPersonList.sort(comparing);
    }

    @Override
    public void createNewAddressBook(String fileName) throws IOException {
        String path = "/home/admin1/Desktop/suraj/AdressBook/src/main/resources/";
        File file = new File(path+fileName+".json");
        file.createNewFile();
        List<String> list = new ArrayList<>();
        String json = gson.toJson(list);
        FileWriter writer = new FileWriter(file);
        writer.write(json);
        writer.close();
    }

    public void writeToJSON() throws IOException {
        String json = gson.toJson(addPersonList);
        FileWriter writer = new FileWriter(filePath);
        writer.write(json);
        readJSONFile();
        writer.close();
    }

    public void readJSONFile() {
        for (int details=0; details<readPersonDetails.length; details++) {
            if (readPersonDetails[details].getName() != null)
                addPersonList.add(readPersonDetails[details]);
        }
    }

    public File[] existingFile() {
        String path = "/home/admin1/Desktop/suraj/AdressBook/src/main/resources/";
        File file = new File(path);
        File[] files = file.listFiles();
        return files;
    }

    public String openExistingFile(int slNo) {
        Object filepath = null;
        File[] file = existingFile();
        filepath = file[slNo];
        return filepath.toString();
    }

    public void printFiles() {
        File[] files = existingFile();
        int slNo=0;
        System.out.println("slNo"+"\t"+"Files");
        for (File file: files) {
            System.out.println(slNo+"\t"+"\t"+file.getName());
            slNo++;
        }
    }
}
