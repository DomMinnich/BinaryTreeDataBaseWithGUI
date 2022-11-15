
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Gui extends Application {

    // make binarytree variable
    BinaryTree<String> binaryTree = new BinaryTree<String>();
    // make setArr variable
    SetArr<Employee> employeesArray = new SetArr<Employee>();

    // ! Get the file of employee data

    // make variable for getBinaryTree

    // ! Start Method
    public void start(Stage primaryStage) throws Exception {

        // Main Font
        Font font = Font.font("yugothic", FontWeight.BOLD, FontPosture.ITALIC, 10);
        Font font2 = Font.font("Monospaced", FontWeight.BOLD, FontPosture.REGULAR, 30);

        // Labels

        // Boxes
        HBox hb = new HBox();
        VBox vbTop = new VBox();
        VBox vbBottom = new VBox();
        VBox vb = new VBox();
        BackgroundFill background = new BackgroundFill(Color.LIGHTGREY, null, null);
        vb.setBackground(new Background(background));

        // Scrolling Pane
        Pane scrollBarPane = new Pane();
        ScrollPane scrollBar = new ScrollPane(scrollBarPane);
        scrollBar.setMaxSize(1100, 600);
        scrollBar.setMinSize(1100, 600);
        scrollBar.setFitToWidth(true);

        Image image1 = new Image("blue2.jpg", 2000, 2000, false, false);
        BackgroundImage bg1 = new BackgroundImage(image1, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background firstScreen = new Background(bg1);

        // Image Panes

        Pane blueStart = new Pane();
        blueStart.setMinSize(2000, 2000);
        blueStart.setMaxSize(2000, 2000);
        blueStart.setBackground(firstScreen);

        scrollBarPane.getChildren().add(blueStart);

        // On Start
        Label st = new Label("Click \"Read Employee Data\" To Input Your Data");
        st.setFont(font2);
        st.setTextFill(Color.GOLD);
        st.setTranslateX(200);
        st.setTranslateY(50);
        scrollBarPane.getChildren().add(st);

        Text sl = new Text("");

        sl.setFont(font);
        Color rgb = Color.rgb(65, 126, 192);
        sl.setFill(rgb);
        scrollBarPane.getChildren().addAll(sl);

        //////////////////// Read Button ////////////////////
        Button readEmployDataBt = new Button("Read Mazes");
        readEmployDataBt.setStyle("-fx-text-fill: green");
        readEmployDataBt.setFont(font);
        // center the button
        readEmployDataBt.setTranslateX(200);
        readEmployDataBt.setTranslateY(100);

        EventHandler<ActionEvent> readInputData = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                scrollBarPane.getChildren().clear();
                scrollBarPane.getChildren().addAll(sl, blueStart);
                // TextInputDialog numOfMazes = new TextInputDialog("5");
                // numOfMazes.setTitle("Number of Mazes");
                // numOfMazes.setHeaderText("Enter The Number of Mazes To Be Read In");
                // numOfMazes.setContentText("Number of Mazes:");
                // numOfMazes.showAndWait();
                // set mazeCount to the number of mazes to be read in
                // setMazeCount(Integer.parseInt(numOfMazes.getEditor().getText()));

                // FileIO fIO = new FileIO();
                // fIO.readInFile();
                // FileChooser fileChooser = new FileChooser();
                // fileChooser.setTitle("Open Resource File");
                // File file = fileChooser.showOpenDialog(null);
                // fIO.setFile(file);
                // System.out.println("set the file in gui");
                DataBase dataBase = new DataBase();
                SetArr<Employee> employeesArray = dataBase.getEmployeesArray();
                System.out.println("this is the tostring for arr");
                System.out.println(employeesArray.toString());
                BinaryTree<String> binaryTree = dataBase.getBinaryTree();
                Label treeString = new Label(binaryTree.treeToString());
                scrollBarPane.getChildren().add(treeString);
                System.out.println("tree prints");
                binaryTree.printTree();

            }
        };
        readEmployDataBt.setOnAction(readInputData);
        scrollBarPane.getChildren().add(readEmployDataBt);

        //////////////////// Find Path Single ////////////////////
        Button searchBt = new Button("Search");
        searchBt.setFont(font);
        searchBt.setMaxSize(120, 50);
        searchBt.setMinSize(120, 50);
        EventHandler<ActionEvent> searchEmployees = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                scrollBarPane.getChildren().clear();
                scrollBarPane.getChildren().addAll(sl, blueStart);

                TextField searchField = new TextField();
                searchField.setPromptText("Enter Employee ID");
                searchField.setTranslateX(200);
                searchField.setTranslateY(100);
                scrollBarPane.getChildren().add(searchField);
                // if the search field is not empty and matches the employee id format, letter
                // then "-" then 4 letters then "-" then 2 numbers
                if (!searchField.getText().isEmpty() && searchField.getText().matches("[A-Z]{1}-[A-Z]{4}-[0-9]{2}")) {
                    // if the employee is found, display the employee's information
                    if (binaryTree.search(searchField.getText()) == true) {
                        Employee emp = employeesArray.retreiveAtIndex(binaryTree.findPosition(searchField.getText()));
                        if (emp.fired = false) {
                            Label employeeFound = new Label(emp.getFirstName() + " " + emp.getLastName());
                            employeeFound.setFont(font);
                            employeeFound.setTranslateX(200);
                            employeeFound.setTranslateY(150);
                            scrollBarPane.getChildren().add(employeeFound);
                        }
                    }
                    // if the employee is not found, display an error message
                    else {
                        Alert a = new Alert(Alert.AlertType.ERROR, "Error With Employee ID Format Or 404 Not Found",
                                ButtonType.OK);
                        a.showAndWait();
                    }
                }
                binaryTree.search(searchField.getText());
            }
        };
        searchBt.setOnAction(searchEmployees);

        /////////////////////////// Quit Button ///////////////////////////
        Button quitBt = new Button("Quit");
        quitBt.setFont(font);
        quitBt.setMaxSize(120, 50);
        quitBt.setMinSize(120, 50);
        quitBt.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you really want to close this application?",
                    ButtonType.YES, ButtonType.NO);
            ButtonType result = alert.showAndWait().orElse(ButtonType.NO);
            if (ButtonType.NO.equals(result)) {
                e.consume();
            } else {
                primaryStage.close();
            }
        });

        //////////////////// ComboBox ////////////////////
        Text dataBoxTitle = new Text("Employee Data");
        Font font3 = Font.font("yugothic", FontWeight.BOLD, FontPosture.ITALIC, 17);
        dataBoxTitle.setFont(font3);
        dataBoxTitle.setFill(Color.BLUE);
        Text item = new Text();
        item.setFont(font);
        ComboBox<String> employDataBox = new ComboBox<String>();
        employDataBox.setMaxSize(120, 50);
        employDataBox.setMinSize(120, 50);
        employDataBox.getItems().addAll("ID", "First Name", "Last Name", "Position", "Site");
        employDataBox.getSelectionModel().selectFirst();
        employDataBox.setOnAction(e -> {
            int itemSeleted = employDataBox.getSelectionModel().getSelectedIndex();
            switch (itemSeleted) {
                case 0:
                    item.setText("ID");
                    break;
                case 1:
                    item.setText("First Name");
                    break;
                case 2:
                    item.setText("Last Name");
                    break;
                case 3:
                    item.setText("Position");
                    break;
                case 4:
                    item.setText("Site");
                    break;
            }
        });
        // setMazeSelected(mazeSelected);
        // if (mazeSelected > mazeCount) {
        // // pop up error message
        // System.out.println("Error Maze Not Imported On Slot Selected");
        // Alert a = new Alert(Alert.AlertType.ERROR, "Error Maze Not Imported On Slot
        // Selected",
        // ButtonType.OK);
        // a.showAndWait();
        // } else {
        // scrollBarPane.getChildren().clear();
        // scrollBarPane.getChildren().addAll(sl, greyBack);
        // sTLabel.setText("| Maze " + mazeSelected + " Selected");
        // scrollBarPane.getChildren().addAll(blackPng, runningPacMan, pacManDude);
        // try (Scanner fileInput = new Scanner(getFile())) {
        // maze = new Maze(fileInput);
        // maze.setMaze(maze);
        // BreadthFirstMazeRunner runner = new BreadthFirstMazeRunner(maze,
        // maze.getStart(), maze.getFinish());
        // boolean b = runner.runMaze();
        // if (solveAll == true && b == true) {
        // mazeNormalString.setText(maze.toString());
        // mazeNormalString.setTextFill(Color.CYAN);
        // mazeSolvedString.setText(maze.toString(runner.pathTaken));
        // scrollBarPane.getChildren().addAll(mazeSolvedString, mazeNormalString,
        // titleHasSolution);

        // } else if (solveAll == true && b == false) {
        // mazeFailedString.setText(maze.toString());
        // scrollBarPane.getChildren().addAll(mazeFailedString, titleNoSolution);

        // } else {
        // mazeNormalString.setText(maze.toString());
        // scrollBarPane.getChildren().add(mazeNormalString);
        // }

        // } catch (FileNotFoundException e1) {
        // e1.printStackTrace();
        // }
        // }

        //////////////////// Find Path All ////////////////////
        Button findPathAllBt = new Button(
                "Find Path (All)");
        findPathAllBt.setFont(font);
        findPathAllBt.setMaxSize(120, 50);
        findPathAllBt.setMinSize(120, 50);
        EventHandler<ActionEvent> findPathAll = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                // solveAll = true;
                // findPathAllBt.setTextFill(Color.RED);
                // mazeSelectionCBox.getSelectionModel().clearSelection();
                // scrollBarPane.getChildren().clear();
                // scrollBarPane.getChildren().addAll(sl, greyBack, pacManMaze, titlePickAMaze);
            }
        };
        findPathAllBt.setOnAction(findPathAll);

        //////////////////// Write Mazes ////////////////////
        Button writeDataBt = new Button(
                "Save Data");
        writeDataBt.setFont(font);
        writeDataBt.setMaxSize(120, 50);
        writeDataBt.setMinSize(120, 50);
        EventHandler<ActionEvent> write = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Save File");
                // fileChooser.setInitialFileName(fName);
                File file = fileChooser.showSaveDialog(null);
                try (PrintWriter fOut = new PrintWriter(file)) {
                    // // int mazeSelected =
                    // mazeSelectionCBox.getSelectionModel().getSelectedIndex() + 1;
                    // // setMazeSelected(mazeSelected);
                    // if (mazeSelected > mazeCount) {
                    // // pop up error message
                    // System.out.println("Error Maze Not Imported On Slot Selected");
                    // Alert a = new Alert(Alert.AlertType.ERROR, "Error Maze Not Imported On Slot
                    // Selected",
                    // ButtonType.OK);
                    // a.showAndWait();

                    // } else {
                    // // System.out.println("maze selected is: " + mazeSelected);
                    // Label printFinished = new Label("Printed All The Solved Paths To File!");
                    // printFinished.setFont(font2);
                    // printFinished.setTextFill(Color.YELLOW);
                    // printFinished.setTranslateX(200);
                    // printFinished.setTranslateY(50);
                    // scrollBarPane.getChildren().clear();
                    // scrollBarPane.getChildren().addAll(sl, greyBack, pacManMaze, printFinished);
                    // for (int i = 0; i < mazeCount; i++) {
                    // int m = getMazeSelected();
                    // m = i + 1;
                    // setMazeSelected(m);
                    // try (Scanner fileInput = new Scanner(getFile())) {
                    // maze = new Maze(fileInput);
                    // maze.setMaze(maze);
                    // BreadthFirstMazeRunner runner = new BreadthFirstMazeRunner(maze,
                    // maze.getStart(),
                    // maze.getFinish());
                    // boolean b = runner.runMaze();
                    // fOut.println(maze.getRows());
                    // fOut.println(maze.getCols());
                    // if (b == true) {
                    // fOut.println(maze.toString(runner.pathTaken));
                    // } else {
                    // fOut.println(maze.toString());
                    // }
                    // } catch (FileNotFoundException e1) {
                    // e1.printStackTrace();
                    // }
                    // }
                    // }
                } catch (FileNotFoundException e2) {
                    e2.printStackTrace();
                }
            }
        };
        writeDataBt.setOnAction(write);

        // Stage Configuration
        vbTop.getChildren().addAll(dataBoxTitle, employDataBox);
        vbTop.setPadding(new Insets(20, 10, 250, 10));
        vbBottom.getChildren().addAll(searchBt, findPathAllBt, writeDataBt, quitBt);
        vbBottom.setPadding(new Insets(0, 10, 0, 10));
        vb.getChildren().addAll(vbTop, vbBottom);
        hb.getChildren().addAll(scrollBar, vb);
        Scene sc = new Scene(
                hb);
        primaryStage.setScene(sc);
        primaryStage.setMaxHeight(640);
        primaryStage.setMaxWidth(1250);
        primaryStage.setMinHeight(640);
        primaryStage.setMinWidth(1250);
        primaryStage.show();
    }
}