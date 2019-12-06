import java.io.IOException;
import java.util.Scanner;

public class mainAddressBook {
    public static void main(String[] args) throws IOException {
        AddressBook addressBook = new AddressBook();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag){
            System.out.println("Enter your choice: \n1.Create NewFile\n2.See Existing File\n3.Quit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter file Name: ");
                    String file = sc.next();
                    addressBook.createNewAddressBook(file);
                    break;
                case 2:
                    addressBook.printFiles();
                    System.out.println("Choose slNo to select: ");
                    int option = sc.nextInt();
                    String path = addressBook.openExistingFile(option);
                    System.out.println(path);
                    AddressBook addressBook1 = new AddressBook(path);
                    boolean status = true;
                    while ( status ) {
                        System.out.println("Enter your choice:\n1.ADD Person Details\n2.Edit Person Details\n3.Delete Person Detail\n4.Display Entity\n5.Sort By Name\n6.Sort By Zip\n7.save\n8.Go back to previous menu");
                        int choice1 = sc.nextInt();
                        switch (choice1) {
                            case 1:
                                addressBook1.addPerson("vishal","D-T-1964","Ranchi","Jharkhand","834003","7004049194");
                                break;
                            case 2:
                                addressBook1.printEntries();
                                System.out.println("Enter Serial number:");
                                int slNo = sc.nextInt();
                                System.out.println("Enter which field:");
                                String field = sc.next();
                                System.out.println("Enter value u want to update:");
                                String value = sc.next();
                                addressBook1.editPersonDetails(slNo,field,value);
                                break;
                            case 3:
                                addressBook1.printEntries();
                                System.out.println("Enter Serial number to delete:");
                                int anInt = sc.nextInt();
                                addressBook1.deleteAPerson(anInt);
                                break;
                            case 4:
                                addressBook1.printEntries();
                                break;
                            case 5:
                                addressBook1.sortEntitiesByName();
                                break;
                            case 6:
                                addressBook1.sortEntitiesByZip();
                                break;
                            case 7:
                                addressBook1.writeToJSON();
                            case 8:
                                status = false;
                                break;
                            default:
                                System.out.println("Wrong entries Please enter valid input");
                        }
                    }
                case 3:
                    flag = false;
                    break;
                default:
                    System.out.println("Wrong Entries Please enter valid input");
            }
        }
    }
}
