import java.io.File;

public class DataBase {
SetArr<Employee> employeesArray = new SetArr<Employee>();


FileIO fileIO = new FileIO();


Gui gui = new Gui();


File file = gui.getFileG();



FileIO.readInFile(file);


//return the employeesArray
public SetArr<Employee> getEmployeesArray() {
    return employeesArray;
}


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

