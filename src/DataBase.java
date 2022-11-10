import java.util.Scanner;

public class DataBase {
SetArr<Employee> employeesArray = new SetArr<Employee>();

//call FileIO and set the employeesArray to the return value
public DataBase(String fileName) {
    employeesArray = FileIO.readInFile(fileName);
}

//return the employeesArray
public SetArr<Employee> getEmployeesArray() {
    return employeesArray;
}




public static void main(String[] args) {
   //get the file name from user
    //create a new DataBase object
    //call the printEmployees method

    System.out.println("Enter the file name: ");
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the file name: ");
    String fileName = scanner.nextLine();
    DataBase dataBaseArr = new DataBase(fileName);
    System.out.println("employee first name = "+dataBaseArr.getEmployeesArray().retreiveAtIndex(0).getFirstName());
    


    
}

}