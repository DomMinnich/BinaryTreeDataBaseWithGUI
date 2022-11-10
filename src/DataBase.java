public class DataBase {

//this class will read in a file with the format of FirstName LastName Position Site
//it will be stored into a SetArr of Employee objects
//then it will be mapped to a binary tree of SetArr indexed by the employee's ID

SetArr<Employee> employeesArray = new SetArr<Employee>();

//call FileIO and set the employeesArray to the return value
public DataBase(String fileName) {
    employeesArray = FileIO.readInFile(fileName);
}


//run through the employeesArray and get the employee id
//make a Binary tree using the employee id as the key




//make a binary tree of the employees' ID plus and index number
//ex: EmployeeID = "employeeID + "-" + "index number"
//ex: EmployeeID = "M-ABCA-01-00"
//ex: EmployeeID = "M-ABCI-01-01"

//return the binary tree





}

