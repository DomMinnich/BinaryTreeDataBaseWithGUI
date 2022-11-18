import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Optional;

import javafx.animation.FadeTransition;
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
import javafx.scene.control.CheckBox;
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
import javafx.scene.layout.StackPane;
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

    // TODO make pane to cover the side panel except for the quit button

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

        // checkBoxPane
        // Pane checkBoxPane = new Pane();
        // // blankPane
        // Pane blankPane = new Pane();
        // blankPane.setPrefSize(40, 20);
        // // set background to black
        // BackgroundFill background24 = new BackgroundFill(Color.BLACK, null, null);
        // blankPane.setBackground(new Background(background24));
        // // set opacity to half
        // blankPane.setOpacity(0);

        // // make a check box

        // CheckBox checkBox = new CheckBox("Shortcuts Disabled");

        // checkBox.setTextFill(Color.YELLOW);

        // checkBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
        // if (newValue) {
        // checkBox.setTextFill(Color.LIGHTGREEN);

        // checkBox.setText("Shortcuts Enabled");
        // } else {
        // checkBox.setTextFill(Color.YELLOW);

        // }
        // });
        // checkBox.setTranslateX(200);
        // checkBoxPane.getChildren().addAll(checkBox, blankPane);
        // vbTop.getChildren().addAll(checkBoxPane);

        // Label ln = new Label("\n\n");
        // vbTop.getChildren().add(ln);

        // menuBlocker on start
        StackPane stackP = new StackPane();
        Pane menuBlocker = new Pane();
        menuBlocker.setMinSize(140, 530);
        menuBlocker.setMaxSize(140, 530);
        menuBlocker.setTranslateX(0);
        menuBlocker.setTranslateY(-20);
        menuBlocker.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");

        // Scrolling Pane
        Pane scrollBarPane = new Pane();
        ScrollPane scrollBar = new ScrollPane(scrollBarPane);
        scrollBar.setMaxSize(1100, 600);
        scrollBar.setMinSize(1100, 600);
        scrollBar.setFitToWidth(true);

        Button help = new Button("?");
        help.setTextFill(Color.FIREBRICK);
        help.setMinSize(30, 30);
        help.setMaxSize(30, 30);
        help.setLayoutX(1050);
        help.setLayoutY(10);

        Pane helpPane = new Pane();
        ScrollPane helpScrollBar = new ScrollPane(helpPane);
        helpScrollBar.setMaxSize(300, 200);
        helpScrollBar.setMinSize(300, 200);
        helpScrollBar.setLayoutX(800);
        helpScrollBar.setLayoutY(0);

        Pane blackBorder = new Pane();
        blackBorder.setMaxSize(303, 203);
        blackBorder.setMinSize(303, 203);
        blackBorder.setStyle("-fx-background-color: black;");
        blackBorder.setLayoutX(797);
        blackBorder.setLayoutY(0);

        helpScrollBar.setFitToWidth(true);
        Label commands = new Label();
        commands.setText(
                "Welcome to the Employee Database! \n\n"
                        +
                        "To Insert An Employee Press Insert Button\n" +
                        "To Delete An Employee Press Delete Button\n" +
                        "To Search For an Employee Press Search Button\n" +
                        "To Display All Employees Press Display All Button\n" +
                        "To Save And Exit Press Save And Exit Button\n" +
                        "To Exit Without Saving Press Quit Button\n\n" +
                        "To Add Another Data File Press Merge Button\n" +
                        "While In Seach use The Top Right Drop Box For Data\n" +
                        "Make Sure Searches Are Formated Correctly\n\n" +
                        "Thank You For Using The Employee Database!\n");
        helpPane.getChildren().add(commands);
        // set pane background to sky blue
        BackgroundFill background2 = new BackgroundFill(Color.LIGHTBLUE, null, null);
        helpPane.setBackground(new Background(background2));
        // set text color to white

        helpScrollBar.setVisible(false);
        help.setOnMouseEntered(e -> {
            scrollBarPane.getChildren().addAll(blackBorder, helpScrollBar);
            helpScrollBar.setVisible(true);
            helpPane.toFront();

        });

        // on mouse exit for the helpscrollbar remove the helpPane
        helpScrollBar.setOnMouseExited(e -> {
            helpScrollBar.setVisible(false);
            scrollBarPane.getChildren().removeAll(blackBorder, helpScrollBar);
        });

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
        arrow.translateXProperty().set(920);
        arrow.translateYProperty().set(210);
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
        scrollBarPane.getChildren().addAll(blueStart, help, upload);

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
                scrollBarPane.getChildren().addAll(sl, blueStart, help);
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
                search.translateYProperty().set(190);

                // checkBox.setTranslateX(0);

                // when success label reaches 0 opacity, add the search label
                timeline3.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        scrollBarPane.getChildren().addAll(search, arrow);
                        stackP.getChildren().removeAll(menuBlocker);
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

        stackP.setOnMouseClicked(e -> {
            Timeline shake = new Timeline(
                    new KeyFrame(Duration.ZERO, new KeyValue(upload.translateXProperty(), 450)),
                    new KeyFrame(Duration.seconds(0.1), new KeyValue(upload.translateXProperty(), 460)),
                    new KeyFrame(Duration.seconds(0.2), new KeyValue(upload.translateXProperty(), 450)),
                    new KeyFrame(Duration.seconds(0.3), new KeyValue(upload.translateXProperty(), 460)),
                    new KeyFrame(Duration.seconds(0.4), new KeyValue(upload.translateXProperty(), 450)),
                    new KeyFrame(Duration.seconds(0.5), new KeyValue(upload.translateXProperty(), 460)),
                    new KeyFrame(Duration.seconds(0.6), new KeyValue(upload.translateXProperty(), 450)),
                    new KeyFrame(Duration.seconds(0.7), new KeyValue(upload.translateXProperty(), 460)),
                    new KeyFrame(Duration.seconds(0.8), new KeyValue(upload.translateXProperty(), 450)),
                    new KeyFrame(Duration.seconds(0.9), new KeyValue(upload.translateXProperty(), 460)),
                    new KeyFrame(Duration.seconds(1), new KeyValue(upload.translateXProperty(), 450)));
            st.setText("Don't be silly upload first");
            shake.play();
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
                scrollBarPane.getChildren().addAll(sl, blueStart, help);
                Label searchLabel = new Label("Search:");
                searchLabel.setFont(font2);
                searchLabel.setTranslateX(450);
                searchLabel.setTranslateY(240);
                searchLabel.setTextFill(Color.WHITE);
                scrollBarPane.getChildren().add(searchLabel);

                // TODO: add other search functions (by name, by site, by position, etc)

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
                                if (binaryTree.contains(searchField.getText()) == true) {

                                    Employee emp = employeesArray
                                            .retreiveAtIndex(binaryTree.getRecordNum(searchField.getText()));
                                    if (emp.getFired() == false) {
                                        setEmployee(emp);
                                        scrollBarPane.getChildren().clear();
                                        scrollBarPane.getChildren().addAll(sl, blueStart, help);
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

                binaryTree.contains(searchField.getText());
            }
        };
        searchBt.setOnAction(searchEmployees);

        /////////////////////////// Quit Button ///////////////////////////
        Button quitBt = new Button("Quit");
        quitBt.setFont(font);
        quitBt.setMaxSize(120, 50);
        quitBt.setMinSize(120, 50);
        quitBt.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                    "Do you really want to close this application?", ButtonType.YES,
                    ButtonType.NO);
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
                    empData.setText("First Name: " + getEmployee().getFirstName());
                    break;
                case 2:
                    item.setText("Last Name");
                    empData.setText("Last Name: " + getEmployee().getLastName());
                    break;
                case 3:
                    item.setText("Position");
                    empData.setText("Position: " + getEmployee().getPosition());
                    break;
                case 4:
                    item.setText("Site");
                    empData.setText("Site: " + getEmployee().getSite());
                    break;

            }
            scrollBarPane.getChildren().clear();
            vbTop.getChildren().remove(arrow2);
            scrollBarPane.getChildren().addAll(sl, blueStart, help, employeeFound, empData, employeeFound2);
        });

        //////////////////// Display ALl ////////////////////
        Button DisplayAllBt = new Button(
                "Display All");
        DisplayAllBt.setFont(font);
        DisplayAllBt.setMaxSize(120, 50);
        DisplayAllBt.setMinSize(120, 50);
        EventHandler<ActionEvent> findPathAll = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                Label employeeDataBase = new Label("Employee DataBase");
                employeeDataBase.setFont(font3);
                employeeDataBase.setTextFill(Color.LIGHTGREEN);
                employeeDataBase.setTranslateX(10);
                employeeDataBase.setTranslateY(10);
                Label chartLabel = new Label("Employee ID\t\tLast Name\t\tFirst Name\t\tPosition\t\tSite");
                Font font5 = Font.font("yugothic", FontWeight.BOLD, FontPosture.ITALIC, 15);
                chartLabel.setFont(font5);
                chartLabel.setTextFill(Color.LIGHTGREEN);
                chartLabel.setTranslateX(10);
                chartLabel.setTranslateY(80);
                Label empDataList = new Label();
                scrollBarPane.getChildren().clear();
                scrollBarPane.getChildren().addAll(sl, blueStart, help, employeeDataBase, chartLabel);
                String tempStr = "";
                for (int i = 0; i < employeesArray.size(); i++) {
                    tempStr += employeesArray.retreiveAtIndex(i).toStringEmp();
                }

                empDataList.setText(tempStr);
                empDataList.setFont(font5);
                empDataList.setTextFill(Color.WHITE);
                empDataList.setTranslateX(10);
                empDataList.setTranslateY(150);
                scrollBarPane.getChildren().add(empDataList);
                // add to scroll bar pane

                // TODO: Display all employees in the tree as a chart like
            }
        };
        DisplayAllBt.setOnAction(findPathAll);

        //////////////////// Write Mazes ////////////////////
        Button writeDataBt = new Button(
                "Save and Exit");
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

                    // this will run through the array and write the employee tostringEmp to the
                    // file only if employee getFired is false
                    for (int i = 0; i < employeesArray.size(); i++) {
                        if (employeesArray.retreiveAtIndex(i).getFired() == false) {
                            fOut.println(employeesArray.retreiveAtIndex(i).toStringEmp());
                        }
                    }
                    fOut.close();
                } catch (FileNotFoundException ex) {
                    System.out.println("File not found");
                }
                primaryStage.close();
            }
        };
        writeDataBt.setOnAction(write);

        //////////////////// Delete////////////////////
        Button deleteBt = new Button(
                "Delete Employee");
        deleteBt.setFont(font);
        deleteBt.setMaxSize(120, 50);
        deleteBt.setMinSize(120, 50);
        EventHandler<ActionEvent> delete = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                // new textinputdialog
                System.out.println("delete called");
                TextInputDialog dialog = new TextInputDialog("Ex: A-ABCD-01");
                dialog.setTitle("Delete Employee");
                dialog.setHeaderText("Delete Employee");
                dialog.setContentText("Please enter the employee ID you wish to delete:");
                dialog.showAndWait();
                String result = dialog.getResult();
                if (binaryTree.contains(result)) {
                    employeesArray.retreiveAtIndex(binaryTree.getRecordNum(result)).setFired(true);
                    binaryTree.delete(result);
                    Label employeeDeleted = new Label("Would Not Want \nTo Be That Employee\n\t:(\nEmployee Fired & Deleted");
                    employeeDeleted.setFont(font3);
                    employeeDeleted.setTextFill(Color.LIGHTGREEN);
                    employeeDeleted.setTranslateX(100);
                    employeeDeleted.setTranslateY(200);
                    scrollBarPane.getChildren().clear();
                    scrollBarPane.getChildren().addAll(sl, blueStart, help, employeeDeleted);
                   //make a timeline to slowly fade out the label
                    FadeTransition fadeTransition = new FadeTransition(Duration.millis(4000), employeeDeleted);
                    fadeTransition.setFromValue(1.0);
                    fadeTransition.setToValue(0.0);
                    fadeTransition.play();
                    //when the timeline is done remove the label from the pane and call search again
                    fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            scrollBarPane.getChildren().remove(employeeDeleted);
                            searchBt.fire();
                        }
                    });


                } else {
                    // pop up error message
                    System.out.println("Error Employee Not Found");
                    Alert a = new Alert(Alert.AlertType.ERROR, "Error Employee Not Found",
                            ButtonType.OK);
                    a.showAndWait();
                }
            }
        };
        deleteBt.setOnAction(delete);

        //////////////////// Insert ////////////////////

        Button insertBt = new Button(
                "Insert New Employee");
        insertBt.setFont(font);
        insertBt.setMaxSize(120, 50);
        insertBt.setMinSize(120, 50);
        EventHandler<ActionEvent> insert = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                // TODO add insert functionality

            }
        };
        insertBt.setOnAction(insert);

        Button mergeFilesBt = new Button(
                "Merge Files");
        mergeFilesBt.setFont(font);
        mergeFilesBt.setMaxSize(120, 50);
        mergeFilesBt.setMinSize(120, 50);
        EventHandler<ActionEvent> merge = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                // TODO add merge functionality

            }
        };
        mergeFilesBt.setOnAction(merge);

        // Stage Configuration

        vbTop.getChildren().addAll(dataBoxTitle, employDataBox);
        vbTop.setPadding(new Insets(0, 10, 250, 10));
        vbBottom.getChildren().addAll(searchBt, DisplayAllBt, deleteBt, insertBt, mergeFilesBt, writeDataBt, quitBt);
        vbBottom.translateXProperty().set(3);
        vbBottom.translateYProperty().set(-10);
        vbTop.translateXProperty().set(3);
        vbBottom.setPadding(new Insets(-70, 10, 0, 10));
        vb.getChildren().addAll(vbTop, vbBottom);

        stackP.getChildren().addAll(vb, menuBlocker);

        hb.getChildren().addAll(scrollBar, stackP);
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