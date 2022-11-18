import java.io.File;

public class DataBase {

    SetArr<Employee> employeesArray = new SetArr<Employee>();
    FileIO fileIO = new FileIO();

    public DataBase() {
        employeesArray = fileIO.readInFile();
    }

    // return the employeesArray
    public SetArr<Employee> getEmployeesArray() {
        return employeesArray;
    }

    // return binary search tree
    public BinaryTree<String> getBinaryTree() {
        BinaryTree<String> binaryTree = new BinaryTree<String>();
        System.out.println("           ");
        for (int i = 0; i < employeesArray.size(); i++) {
            binaryTree.insert(employeesArray.retreiveAtIndex(i).getEmployeeID());
            // print out the employeeID and first name
            System.out.println(employeesArray.retreiveAtIndex(i).getEmployeeID() + " "
                    + employeesArray.retreiveAtIndex(i).getFirstName()+" "+i);
            
            //retrieve the position of the node in the tree
            System.out.println("position "+binaryTree.getRecordNum(employeesArray.retreiveAtIndex(i).getEmployeeID()));
        }
        System.out.println("           ");
        System.out.println("this is the binary tree");
        binaryTree.printTree();
        System.out.println("this is the end of the binary tree");
        return binaryTree;
    }

}
