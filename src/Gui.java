
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSplitPaneUI;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
import javafx.util.Duration;

public class Gui extends Application {

    //setter and getter for and Employee object
    private Employee employee;
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    public Employee getEmployee() {
        return employee;
    }

    // make binarytree and setarr objects
    BinaryTree<String> binaryTree = new BinaryTree<String>();
    SetArr<Employee> employeesArray = new SetArr<Employee>();

    // set binary tree
    public void setBinaryTree(BinaryTree<String> binaryTree) {
        this.binaryTree = binaryTree;
    }

    // set employees array

    public void setEmployeesArray(SetArr<Employee> employeesArray) {
        this.employeesArray = employeesArray;
    }

    // get binary tree

    public BinaryTree<String> getBinaryTreeG() {
        return binaryTree;
    }

    // get employees array

    public SetArr<Employee> getEmployeesArrayG() {
        return employeesArray;
    }

    // ! Get the file of employee data

    // make variable for getBinaryTree

    // ! Start Method
    public void start(Stage primaryStage) throws Exception {

        // Main Font
        Font font = Font.font("yugothic", FontWeight.BOLD, FontPosture.ITALIC, 10);
        Font font2 = Font.font("Monospaced", FontWeight.BOLD, FontPosture.REGULAR, 30);
        Font font3 = Font.font("Monospaced", FontWeight.BOLD, FontPosture.REGULAR, 60);

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

        // Blue Background
        Image image1 = new Image("blue2.jpg", 2000, 2000, false, false);
        BackgroundImage bg1 = new BackgroundImage(image1, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background firstScreen = new Background(bg1);

        // Upload Png
        Image image2 = new Image("fileUpload.png", 200, 200, false, false);
        BackgroundImage bg2 = new BackgroundImage(image2, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background uploadBg = new Background(bg2);

        // Arrow Png
        Image image3 = new Image("arrow1.png", 120, 100, false, false);
        BackgroundImage bg3 = new BackgroundImage(image3, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background arrowBg = new Background(bg3);

        // Image Panes

        Pane blueStart = new Pane();
        blueStart.setMinSize(2000, 2000);
        blueStart.setMaxSize(2000, 2000);
        blueStart.setBackground(firstScreen);

        Pane upload = new Pane();
        upload.setMinSize(200, 200);
        upload.setMaxSize(200, 200);
        upload.translateXProperty().set(450);
        upload.translateYProperty().set(200);
        upload.setBackground(uploadBg);

        Pane arrow = new Pane();
        arrow.setMinSize(150, 100);
        arrow.setMaxSize(150, 100);
        arrow.translateXProperty().set(880);
        arrow.translateYProperty().set(320);
        arrow.setBackground(arrowBg);

        scrollBarPane.getChildren().addAll(blueStart, upload);

        // On Start
        Label st = new Label("UPLOAD YOUR FILE HERE");
        st.setFont(font2);
        st.setTextFill(Color.WHITE);
        // set the position of the label above the upload button
        st.translateXProperty().set(350);
        st.translateYProperty().set(100);

        scrollBarPane.getChildren().add(st);

        Text sl = new Text("");

        sl.setFont(font);
        Color rgb = Color.rgb(65, 126, 192);
        sl.setFill(rgb);
        scrollBarPane.getChildren().addAll(sl);

        //////////////////// Read Button ////////////////////
        Button readEmployDataBt = new Button("Read Input Data");
        readEmployDataBt.setStyle("-fx-text-fill: green");
        readEmployDataBt.setFont(font);
        readEmployDataBt.setMinSize(200, 200);
        readEmployDataBt.setMaxSize(200, 200);
        readEmployDataBt.translateXProperty().set(450);
        readEmployDataBt.translateYProperty().set(200);
        readEmployDataBt.setOpacity(0);

        EventHandler<ActionEvent> readInputData = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                scrollBarPane.getChildren().clear();
                scrollBarPane.getChildren().addAll(sl, blueStart);

                // TODO
                DataBase dataBase = new DataBase();
                setEmployeesArray(dataBase.getEmployeesArray());
                setBinaryTree(dataBase.getBinaryTree());
                System.out.println("this is the tostring for arr");
                System.out.println(employeesArray.toString());

                // timeline and animation for arrow to move a little left then right
                Timeline timeline = new Timeline();
                // run the animation for infinite times
                timeline.setCycleCount(Timeline.INDEFINITE);
                timeline.setAutoReverse(true);
                KeyValue kv = new KeyValue(arrow.translateXProperty(), 850);
                KeyFrame kf = new KeyFrame(Duration.millis(500), kv);
                timeline.getKeyFrames().add(kf);
                timeline.play();

                // timeline so that label success has looses opcity for 2 seconds

                Label success = new Label("FILE UPLOADED SUCCESSFULLY");
                success.setFont(font3);
                success.setTextFill(Color.LIGHTGREEN);
                success.translateXProperty().set(300);
                success.translateYProperty().set(200);
                // make label 600, by 200
                success.setMinSize(600, 200);
                success.setMaxSize(600, 200);

                scrollBarPane.getChildren().add(success);

                Timeline timeline3 = new Timeline();
                timeline3.setCycleCount(1);
                timeline3.setAutoReverse(true);
                KeyValue kv7 = new KeyValue(success.opacityProperty(), 0);
                KeyFrame kf8 = new KeyFrame(Duration.millis(3000), kv7);
                timeline3.getKeyFrames().add(kf8);
                timeline3.play();

                Label search = new Label("CLICK HERE TO SEARCH");
                search.setFont(font2);
                search.setTextFill(Color.WHITE);
                search.translateXProperty().set(700);
                search.translateYProperty().set(300);

                // when success label reaches 0 opacity, add the search label
                timeline3.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        scrollBarPane.getChildren().addAll(search, arrow);
                    }
                });

            }
        };

        readEmployDataBt.setOnAction(readInputData);
        scrollBarPane.getChildren().add(readEmployDataBt);

        // make timeline for the upload button
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);
        // grow and shrink the upload button and the image
        KeyValue kv = new KeyValue(upload.scaleXProperty(), 1.1);
        KeyValue kv2 = new KeyValue(upload.scaleYProperty(), 1.1);
        KeyValue kv3 = new KeyValue(readEmployDataBt.scaleXProperty(), 1.1);
        KeyValue kv4 = new KeyValue(readEmployDataBt.scaleYProperty(), 1.1);
        KeyFrame kf = new KeyFrame(Duration.millis(1000), kv, kv2, kv3, kv4);
        timeline.getKeyFrames().add(kf);

        Timeline timeline2 = new Timeline();
        timeline2.setCycleCount(Timeline.INDEFINITE);
        timeline2.setAutoReverse(true);
        KeyValue kv11 = new KeyValue(upload.translateYProperty(), 210);
        KeyFrame kf12 = new KeyFrame(Duration.millis(1000), kv11);
        // make upload image move a little up and down
        KeyValue kv13 = new KeyValue(readEmployDataBt.translateYProperty(), 210);
        KeyFrame kf14 = new KeyFrame(Duration.millis(1000), kv13);
        timeline2.getKeyFrames().add(kf12);
        timeline2.getKeyFrames().add(kf14);

        // if mouse has not enetered the upload button, then play the timeline 2, else
        // stop it

        if (readEmployDataBt.isHover() == false) {
            timeline2.play();
        }

        readEmployDataBt.setOnMouseEntered(e -> {
            // grow the image
            upload.setScaleX(1.1);
            upload.setScaleY(1.1);
            // grow the button
            readEmployDataBt.setScaleX(1.1);
            readEmployDataBt.setScaleY(1.1);
            // set st text to "YEAH RIGHT THERE!"
            st.setText("YEAH RIGHT THERE!");
            // recenter the text
            st.translateXProperty().set(400);
            st.translateYProperty().set(100);
            // stop the timeline
            timeline.stop();
            timeline2.stop();
        });

        readEmployDataBt.setOnMouseExited(e -> {
            // shrink the image
            upload.setScaleX(1);
            upload.setScaleY(1);
            // shrink the button
            readEmployDataBt.setScaleX(1);
            readEmployDataBt.setScaleY(1);
            // set st text to "UPLOAD YOUR FILE HERE"

            st.setText("NO NO, GO BACK! RIGHT HERE!");
            // recenter the text
            st.translateXProperty().set(340);
            st.translateYProperty().set(100);
            timeline.play();

            // make animation to grow and string the button and image

        });

        // Button searchBt2 = new Button("Search");
        // searchBt2.setFont(font);
        // searchBt2.setMaxSize(120, 50);
        // searchBt2.setMinSize(120, 50);
        // // center the button
        // searchBt2.setTranslateX(200);
        // searchBt2.setTranslateY(300);

        //////////////////// Find Path Single ////////////////////
        Button searchBt = new Button("Search");
        searchBt.setFont(font);
        searchBt.setMaxSize(120, 50);
        searchBt.setMinSize(120, 50);
        // center the button
        // searchBt.setTranslateX(200);
        // searchBt.setTranslateY(300);
        Label employeeFound = new Label("");
        EventHandler<ActionEvent> searchEmployees = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                scrollBarPane.getChildren().clear();
                scrollBarPane.getChildren().addAll(sl, blueStart);

                // label for the search bar
                Label searchLabel = new Label("Search:");
                searchLabel.setFont(font2);
                searchLabel.setTranslateX(450);
                searchLabel.setTranslateY(240);
                searchLabel.setTextFill(Color.WHITE);
                scrollBarPane.getChildren().add(searchLabel);
                TextField searchField = new TextField();
                searchField.setPromptText("Enter Employee ID Ex: A-ABCD-01");
                searchField.setTranslateX(450);
                searchField.setTranslateY(300);
                searchField.setMaxSize(200, 50);
                searchField.setMinSize(200, 50);

                scrollBarPane.getChildren().add(searchField);
                

                // check to see if enter was pressed in the search field
                searchField.setOnKeyPressed(new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent event) {
                        if (event.getCode() == KeyCode.ENTER) {
                            // make label of the binary tree
                            // DataBase dataBase = new DataBase();
                            Label b = new Label(getBinaryTreeG().toString());
                            b.setFont(font2);
                            b.setTextFill(Color.WHITE);
                            scrollBarPane.getChildren().add(b);

                            if (!searchField.getText().isEmpty()
                                    && searchField.getText().matches("[A-Z]{1}-[A-Z]{4}-[0-9]{2}")) {
                                System.out.println("passed 1");
                                System.out.println("this is the text" + searchField.getText());
                                if (binaryTree.search(searchField.getText()) == true) {
                                    System.out.println("passed 2");
                                    Employee emp = employeesArray
                                            .retreiveAtIndex(binaryTree.findPosition(searchField.getText()) - 1);
                                    // print emp
                                    System.out.println("emp = " + emp.toString());
                                    // make label of the employee

                                    if (emp.getFired() == false) {
                                        setEmployee(emp);
                                        System.out.println("passed 3");
                                        scrollBarPane.getChildren().clear();
                                        scrollBarPane.getChildren().addAll(sl, blueStart);
                                        //set label text to "Employee: "+ emp.getFirstName() + " " + emp.getLastName()
                                        employeeFound.setText("Employee: " + emp.getFirstName() + " " + emp.getLastName());
                                        employeeFound.setFont(font2);
                                        //center x
                                        employeeFound.setTranslateX(450);
                                        employeeFound.setTranslateY(150);
                                        scrollBarPane.getChildren().add(employeeFound);

                                        // Label empLabel = new Label(emp.toString());
                                        // empLabel.setFont(font2);
                                        // empLabel.setTextFill(Color.WHITE);
                                        // empLabel.setTranslateX(20);
                                        // empLabel.setTranslateY(400);
                                        // scrollBarPane.getChildren().add(empLabel);

                                    }
                                }
                                // if the employee is not found, display an error message
                                else {
                                    Alert a = new Alert(Alert.AlertType.ERROR,
                                            "404 Not Found",
                                            ButtonType.OK);
                                    a.showAndWait();
                                }
                            } else {
                                Alert a = new Alert(Alert.AlertType.ERROR,
                                        "Employee ID Format Error",
                                        ButtonType.OK);
                                a.showAndWait();
                            }

                        }
                    }
                });

                binaryTree.search(searchField.getText());
                // scrollBarPane.getChildren().clear();
                // scrollBarPane.getChildren().addAll(sl, blueStart, searchBt2);
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
        Font font4 = Font.font("yugothic", FontWeight.BOLD, FontPosture.ITALIC, 17);
        dataBoxTitle.setFont(font4);
        dataBoxTitle.setFill(Color.BLUE);
        Text item = new Text();
        item.setFont(font);
        ComboBox<String> employDataBox = new ComboBox<String>();
        employDataBox.setMaxSize(120, 50);
        employDataBox.setMinSize(120, 50);
        employDataBox.getItems().addAll("ID", "First Name", "Last Name", "Position", "Site");
      //  employDataBox.getSelectionModel().selectFirst();
        employDataBox.setOnAction(e -> {
            Label empData = new Label();
            empData.setFont(font2);
            empData.setTextFill(Color.WHITE);
            empData.setTranslateX(400);
            empData.setTranslateY(300);

            int itemSeleted = employDataBox.getSelectionModel().getSelectedIndex();
            switch (itemSeleted) {
                
                case 0:
                    item.setText("ID");
                    empData.setText("ID: " + getEmployee().getEmployeeID());
                    break;
                case 1:
                    item.setText("First Name");
                  //  scrollBarPane.getChildren().remove(empData);
                    empData.setText("First Name: " + getEmployee().getFirstName());
                    break;
                case 2:
                    item.setText("Last Name");
                  //  scrollBarPane.getChildren().remove(empData);
                    empData.setText("Last Name: " + getEmployee().getLastName());
                    break;
                case 3:
                    item.setText("Position");
                 //   scrollBarPane.getChildren().remove(empData);
                    empData.setText("Position: " + getEmployee().getPosition());
                    break;
                case 4:
                    item.setText("Site");
                 //   scrollBarPane.getChildren().remove(empData);
                    empData.setText("Site: " + getEmployee().getSite());
                    break;

            }
            scrollBarPane.getChildren().clear();
            scrollBarPane.getChildren().addAll(sl, blueStart, employeeFound, empData);
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