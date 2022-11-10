public class DataBase {
SetArr<Employee> employeesArray = new SetArr<Employee>();

//call FileIO and set the employeesArray to the return value
public DataBase(String fileName) {
    employeesArray = FileIO.readInFile(fileName);
}

//make a binary tree using the employeesArray
public BinaryTree<Employee> makeTree() {
    BinaryTree<Employee> tree = new BinaryTree<Employee>();
    for (int i = 0; i < employeesArray.size(); i++) {
        tree.insert(employeesArray.get(i));
    }
    return tree;
}