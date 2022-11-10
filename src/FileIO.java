import java.io.File;
import java.util.Scanner;

// get file from scanner
//each line is an employee
//each line is in the format of "FirstName,LastName,Position,Site"
//the employeeID is the first letter of the site, then a "-" then the first 3letters of their first name then the first letter of their last name then a "-" then a 2 digit number representing how many of the same employee id there are
//ex: EmployeeID = "M-ABCA-01"
//then add the employee to the set
//return the set
public class FileIO {
    public static SetArr<Employee> readInFile(String fileName) {
        SetArr<Employee> employeesArray = new SetArr<Employee>();
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] employeeInfo = line.split(" ");
                String FirstName = employeeInfo[0];
                String LastName = employeeInfo[1];
                String Position = employeeInfo[2];
                String Site = employeeInfo[3];
                String EmployeeID = Site.substring(0, 1) + "-" + FirstName.substring(0, 3).toUpperCase() + LastName.substring(0, 1).toUpperCase() + "-" + "01";
                Employee employee = new Employee(EmployeeID, FirstName, LastName, Position, Site);
                employeesArray.add(employee);
                System.out.println("employee added");
                System.out.println(employee.toString());
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeesArray;
    }
}