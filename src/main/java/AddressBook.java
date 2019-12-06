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

    public AddressBook(String path) throws AddressBookException {
        try {
            filePath = path;
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            readPersonDetails = gson.fromJson(br, AddressBookPOJO[].class);
        } catch (FileNotFoundException e) {
            throw new AddressBookException(AddressBookException.ExceptionType.NO_SUCH_FILE,"Please Enter proper file path");
        }
    }

    public AddressBook(){

    }

    @Override
    public boolean addPerson(String name, String address, String city, String state, String zip, String phNo) throws AddressBookException {
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
    public boolean editPersonDetails(int slNo, String field, String value) throws AddressBookException {
        try {
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
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new AddressBookException(AddressBookException.ExceptionType.ARRAY_INDEX_OUT_OF_BOUND,"Please enter valid slNo");
        }

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
    public boolean deleteAPerson(int slNo) {
        if (readPersonDetails.length>=slNo){
            for (int details=0; details<readPersonDetails.length; details++) {
                if (slNo != details)
                    addPersonList.add(readPersonDetails[details]);
                flag = true;
            }
            addPersonList.add(addressBookPOJO);
        }
        return flag;
    }

    @Override
    public boolean sortEntitiesByName() throws AddressBookException {
        readJSONFile();
        Comparator<AddressBookPOJO> comparing = Comparator.comparing(AddressBookPOJO::getName);
        addPersonList.sort(comparing);
        flag = true;
        return flag;
    }

    @Override
    public boolean sortEntitiesByZip() throws AddressBookException {
        readJSONFile();
        Comparator<AddressBookPOJO> comparing = Comparator.comparing(AddressBookPOJO::getZip);
        addPersonList.sort(comparing);
        flag = true;
        return flag;
    }

    @Override
    public String createNewAddressBook(String fileName,String path) throws AddressBookException {
        try {
            File file = new File(path+fileName+".json");
            file.createNewFile();
            List<String> list = new ArrayList<>();
            String json = gson.toJson(list);
            FileWriter writer = new FileWriter(file);
            writer.write(json);
            writer.close();
            return fileName+".json";
        } catch (IOException e) {
            throw new AddressBookException(AddressBookException.ExceptionType.IO_EXCEPTION,"You have entered some wrong path");
        }
    }

    public boolean writeToJSON() throws AddressBookException {
        try {
            String json = gson.toJson(addPersonList);
            FileWriter writer = new FileWriter(filePath);
            writer.write(json);
            readJSONFile();
            writer.close();
            return true;
        } catch (IOException e){
            throw new AddressBookException(AddressBookException.ExceptionType.IO_EXCEPTION,"You have entered some wrong path");
        }
    }

    public boolean readJSONFile() throws AddressBookException {
        try {
            for (int details=0; details<readPersonDetails.length; details++) {
                if (readPersonDetails[details].getName() != null)
                    addPersonList.add(readPersonDetails[details]);
                flag = true;
            }
            return flag;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new AddressBookException(AddressBookException.ExceptionType.ARRAY_INDEX_OUT_OF_BOUND,"Please enter valid slNo");
        }
    }

    public File[] existingFile(String path) throws AddressBookException{
        try {
            File file = new File(path);
            File[] files = file.listFiles();
            return files;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new AddressBookException(AddressBookException.ExceptionType.ARRAY_INDEX_OUT_OF_BOUND,"Please enter valid slNo");
        }
    }

    public String openExistingFile(int slNo, String path) throws AddressBookException {
        try {
            Object filepath = null;
            File[] file = existingFile(path);
            filepath = file[slNo];
            return filepath.toString();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new AddressBookException(AddressBookException.ExceptionType.ARRAY_INDEX_OUT_OF_BOUND,"Please enter valid slNo");
        }
    }

    public boolean printFiles(String path) throws AddressBookException {
        File[] files = existingFile(path);
        int slNo=0;
        System.out.println("slNo"+"\t"+"Files");
        for (File file: files) {
            System.out.println(slNo+"\t"+"\t"+file.getName());
            slNo++;
            flag = true;
        }
        return flag;
    }
}
