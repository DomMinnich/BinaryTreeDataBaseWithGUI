import java.io.File;
import java.util.Scanner;

//Input file
//Creation of Employee objects
//Creation of SetArr from those Employee objects

public class FileIO {

    //make and employee object from each line of the file
    public static Employee makeEmployee(String line) {
        String[] parts = line.split(" ");
        String firstName = parts[0];
        String lastName = parts[1];
        String position = parts[2];
        String site = parts[3];
        String employeeID = site.substring(0, 1) + "-" + firstName.substring(0, 3) + lastName.substring(0, 1) + "-" + "01";
        Employee employee = new Employee(employeeID, firstName, lastName, position, site);
        return employee;
    }

    //read in the file and make an employee object for each line
    public static SetArr<Employee> readInFile(String fileName) {
        SetArr<Employee> employeesArray = new SetArr<Employee>();
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Employee employee = makeEmployee(line);
                employeesArray.add(employee);
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error reading file");
        }
        return employeesArray;
    }
}
