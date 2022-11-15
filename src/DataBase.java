import java.io.File;

public class DataBase {

SetArr<Employee> employeesArray = new SetArr<Employee>();
FileIO fileIO = new FileIO();

public DataBase() {
    employeesArray = fileIO.readInFile();
}



//return the employeesArray
public SetArr<Employee> getEmployeesArray() {
    return employeesArray;
}
//return binary search tree
public BinaryTree<String> getBinaryTree() {
    BinaryTree<String> binaryTree = new BinaryTree<String>();
    for (int i = 0; i < employeesArray.size(); i++) {
        binaryTree.insert(employeesArray.retreiveAtIndex(i).getEmployeeID());
    }
    System.out.println("this is the binary tree");
    binaryTree.printTree();
    System.out.println("this is the end of the binary tree");
    return binaryTree;
}

}
