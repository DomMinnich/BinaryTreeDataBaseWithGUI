
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

    // setter and getter for and Employee object
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

    // ! Start Method
    public void start(Stage primaryStage) throws Exception {

        // Main Font
        Font font = Font.font("yugothic", FontWeight.BOLD, FontPosture.ITALIC, 10);
        Font font2 = Font.font("Monospaced", FontWeight.BOLD, FontPosture.REGULAR, 30);
        Font font3 = Font.font("Monospaced", FontWeight.BOLD, FontPosture.REGULAR, 60);
        Color rgb = Color.rgb(65, 126, 192);

        // Boxes
        HBox hb = new HBox();
        VBox vbTop = new VBox();
        VBox vbBottom = new VBox();
        VBox vb = new VBox();
        BackgroundFill background = new BackgroundFill(rgb, null, null);
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

        // Arrow2 Png
        Image image4 = new Image("arrow1.png", 120, 100, false, false);
        BackgroundImage bg4 = new BackgroundImage(image4, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background arrowBg2 = new Background(bg4);

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

        Pane arrow2 = new Pane();
        arrow2.setMinSize(150, 100);
        arrow2.setMaxSize(150, 100);
        arrow2.setBackground(arrowBg2);
        arrow2.setRotate(270);
        arrow2.setTranslateX(-20);
        arrow2.setScaleX(0.8);
        arrow2.setScaleY(0.8);

        // make timeline for arrow2 going up and down
        Timeline timeline3 = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(arrow2.translateYProperty(), 0)),
                new KeyFrame(Duration.seconds(1), new KeyValue(arrow2.translateYProperty(), 20)));
        timeline3.setCycleCount(Timeline.INDEFINITE);
        timeline3.setAutoReverse(true);

        // On Start
        scrollBarPane.getChildren().addAll(blueStart, upload);

        Label st = new Label("UPLOAD YOUR FILE HERE");
        st.setFont(font2);
        st.setTextFill(Color.WHITE);
        st.translateXProperty().set(350);
        st.translateYProperty().set(100);
        scrollBarPane.getChildren().add(st);
        Text sl = new Text("");
        sl.setFont(font);
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
                DataBase dataBase = new DataBase();
                setEmployeesArray(dataBase.getEmployeesArray());
                setBinaryTree(dataBase.getBinaryTree());
                System.out.println("this is the tostring for arr");
                System.out.println(employeesArray.toString());

                // timeline and animation for arrow to move a little left then right
                Timeline timeline = new Timeline();
                timeline.setCycleCount(Timeline.INDEFINITE);
                timeline.setAutoReverse(true);
                KeyValue kv = new KeyValue(arrow.translateXProperty(), 850);
                KeyFrame kf = new KeyFrame(Duration.millis(500), kv);
                timeline.getKeyFrames().add(kf);
                timeline.play();

                Label success = new Label("FILE UPLOADED SUCCESSFULLY");
                success.setFont(font3);
                success.setTextFill(Color.LIGHTGREEN);
                success.translateXProperty().set(300);
                success.translateYProperty().set(200);
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

        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);
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
        KeyValue kv13 = new KeyValue(readEmployDataBt.translateYProperty(), 210);
        KeyFrame kf14 = new KeyFrame(Duration.millis(1000), kv13);
        timeline2.getKeyFrames().add(kf12);
        timeline2.getKeyFrames().add(kf14);
        if (readEmployDataBt.isHover() == false) {
            timeline2.play();
        }
        readEmployDataBt.setOnMouseEntered(e -> {
            upload.setScaleX(1.1);
            upload.setScaleY(1.1);
            readEmployDataBt.setScaleX(1.1);
            readEmployDataBt.setScaleY(1.1);
            st.setText("YEAH RIGHT THERE!");
            st.translateXProperty().set(400);
            st.translateYProperty().set(100);
            timeline.stop();
            timeline2.stop();
        });

        readEmployDataBt.setOnMouseExited(e -> {
            upload.setScaleX(1);
            upload.setScaleY(1);
            readEmployDataBt.setScaleX(1);
            readEmployDataBt.setScaleY(1);
            st.setText("NO NO, GO BACK! RIGHT HERE!");
            st.translateXProperty().set(340);
            st.translateYProperty().set(100);
            timeline.play();
        });

        //////////////////// SEARCH ////////////////////
        Button searchBt = new Button("Search");
        searchBt.setFont(font);
        searchBt.setMaxSize(120, 50);
        searchBt.setMinSize(120, 50);
        Label employeeFound = new Label("");
        Label employeeFound2 = new Label("Employee: ");
        EventHandler<ActionEvent> searchEmployees = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                scrollBarPane.getChildren().clear();
                scrollBarPane.getChildren().addAll(sl, blueStart);
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
                            if (!searchField.getText().isEmpty()
                                    && searchField.getText().matches("[A-Z]{1}-[A-Z]{4}-[0-9]{2}")) {
                                if (binaryTree.search(searchField.getText()) == true) {
                                    Employee emp = employeesArray
                                            .retreiveAtIndex(binaryTree.findPosition(searchField.getText()) - 1);
                                    System.out.println("emp = " + emp.toString());
                                    if (emp.getFired() == false) {
                                        setEmployee(emp);
                                        scrollBarPane.getChildren().clear();
                                        scrollBarPane.getChildren().addAll(sl, blueStart);
                                        employeeFound.setText(emp.getFirstName() + " " + emp.getLastName());
                                        employeeFound.setFont(font3);
                                        employeeFound.setTextFill(Color.LIGHTGREEN);
                                        employeeFound.setTranslateX(340);
                                        employeeFound.setTranslateY(10);
                                        employeeFound2.setFont(font3);
                                        employeeFound2.setTextFill(Color.WHITE);
                                        employeeFound2.setTranslateX(10);
                                        employeeFound2.setTranslateY(10);
                                        timeline3.play();
                                        vbTop.getChildren().add(arrow2);
                                        scrollBarPane.getChildren().addAll(employeeFound, employeeFound2);
                                    }
                                }
                                // if the employee is not found, display an error message
                                else {
                                    Alert a = new Alert(Alert.AlertType.ERROR,
                                            "404 Not Found",
                                            ButtonType.OK);
                                    a.showAndWait();
                                }
                                // if the format is not correct, display an error message
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
        dataBoxTitle.setFill(Color.LIGHTGREEN);
        Text item = new Text();
        item.setFont(font);
        ComboBox<String> employDataBox = new ComboBox<String>();
        employDataBox.setMaxSize(120, 50);
        employDataBox.setMinSize(120, 50);
        employDataBox.getItems().addAll("ID", "First Name", "Last Name", "Position", "Site");
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
                    // scrollBarPane.getChildren().remove(empData);
                    empData.setText("First Name: " + getEmployee().getFirstName());
                    break;
                case 2:
                    item.setText("Last Name");
                    // scrollBarPane.getChildren().remove(empData);
                    empData.setText("Last Name: " + getEmployee().getLastName());
                    break;
                case 3:
                    item.setText("Position");
                    // scrollBarPane.getChildren().remove(empData);
                    empData.setText("Position: " + getEmployee().getPosition());
                    break;
                case 4:
                    item.setText("Site");
                    // scrollBarPane.getChildren().remove(empData);
                    empData.setText("Site: " + getEmployee().getSite());
                    break;

            }
            scrollBarPane.getChildren().clear();
            // remove arrow2 from vbTop
            vbTop.getChildren().remove(arrow2);
            scrollBarPane.getChildren().addAll(sl, blueStart, employeeFound, empData, employeeFound2);
        });

        //////////////////// Display ALl ////////////////////
        Button DisplayAllBt = new Button(
                "Display All");
        DisplayAllBt.setFont(font);
        DisplayAllBt.setMaxSize(120, 50);
        DisplayAllBt.setMinSize(120, 50);
        EventHandler<ActionEvent> findPathAll = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {

                // TODO: Display all employees in the tree as a chart like
            }
        };
        DisplayAllBt.setOnAction(findPathAll);

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
        vbBottom.getChildren().addAll(searchBt, DisplayAllBt, writeDataBt, quitBt);
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