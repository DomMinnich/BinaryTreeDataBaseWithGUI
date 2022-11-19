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
import javafx.scene.input.MouseEvent;
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
        Font font5 = Font.font("yugothic", FontWeight.BOLD, FontPosture.ITALIC, 15);
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
        ComboBox<String> employDataBox = new ComboBox<String>();

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

        // // Arrow2 Png
        // Image image4 = new Image("arrow1.png", 120, 100, false, false);
        // BackgroundImage bg4 = new BackgroundImage(image4, BackgroundRepeat.NO_REPEAT,
        // BackgroundRepeat.NO_REPEAT,
        // BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        // Background arrowBg2 = new Background(bg4);

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

        // Pane arrow2 = new Pane();
        // arrow2.setMinSize(150, 100);
        // arrow2.setMaxSize(150, 100);
        // arrow2.setBackground(arrowBg2);
        // arrow2.setRotate(270);
        // arrow2.setTranslateX(-20);
        // arrow2.setScaleX(0.8);
        // arrow2.setScaleY(0.8);

        // // make timeline for arrow2 going up and down
        // Timeline timeline3 = new Timeline(
        // new KeyFrame(Duration.ZERO, new KeyValue(arrow2.translateYProperty(), 0)),
        // new KeyFrame(Duration.seconds(1), new KeyValue(arrow2.translateYProperty(),
        // 20)));
        // timeline3.setCycleCount(Timeline.INDEFINITE);
        // timeline3.setAutoReverse(true);

        // On Start
        scrollBarPane.getChildren().addAll(blueStart, help, upload);
        Label dataBoxTitle = new Label("Employee Data");

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

        Timeline pulse = new Timeline();
        pulse.setCycleCount(Timeline.INDEFINITE);
        pulse.setAutoReverse(true);
        // change color of dataBoxTitle to green then yellow, then red, then blue, then
        // green
        KeyValue kv005 = new KeyValue(dataBoxTitle.textFillProperty(), Color.GREEN);
        KeyFrame kf006 = new KeyFrame(Duration.millis(1000), kv005);
        KeyValue kv007 = new KeyValue(dataBoxTitle.textFillProperty(), Color.YELLOW);
        KeyFrame kf008 = new KeyFrame(Duration.millis(2000), kv007);
        KeyValue kv009 = new KeyValue(dataBoxTitle.textFillProperty(), Color.RED);
        KeyFrame kf010 = new KeyFrame(Duration.millis(3000), kv009);
        KeyValue kv011 = new KeyValue(dataBoxTitle.textFillProperty(), Color.BLUE);
        KeyFrame kf012 = new KeyFrame(Duration.millis(4000), kv011);
        pulse.getKeyFrames().add(kf006);
        pulse.getKeyFrames().add(kf008);
        pulse.getKeyFrames().add(kf010);
        pulse.getKeyFrames().add(kf012);

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
                searchLabel.setTranslateX(200);
                searchLabel.setTranslateY(240);
                searchLabel.setTextFill(Color.WHITE);
                scrollBarPane.getChildren().add(searchLabel);



//! ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



                // new text field for search by position
                TextField searchField2 = new TextField();
                searchField2.setPromptText("Enter Position Ex: Sales");
                searchField2.setTranslateX(200);
                searchField2.setTranslateY(300);
                searchField2.setMaxSize(200, 50);
                searchField2.setMinSize(200, 50);
                scrollBarPane.getChildren().add(searchField2);
                searchField2.setOnKeyPressed(new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent event) {
                        if (event.getCode() == KeyCode.ENTER) {
                            if (!searchField2.getText().isEmpty()) {
                                String idSearch2 = "";
                                String firstNameSearch2 = "";
                                String lastNameSearch2 = "";
                                String positionSearch2 = "";
                                String siteSearch2 = "";
//TODO turn off combobox for this search
                                for (int i = 0; i < employeesArray.size(); i++) {
                                    if (employeesArray.retreiveAtIndex(i).getPosition().equals(searchField2.getText())&& employeesArray.retreiveAtIndex(i).getFired() == false) {

                                        idSearch2 += employeesArray.retreiveAtIndex(i).getEmployeeID()+"\n";
                                        firstNameSearch2 += employeesArray.retreiveAtIndex(i).getFirstName()+"\n";
                                        lastNameSearch2 += employeesArray.retreiveAtIndex(i).getLastName()+"\n";
                                        positionSearch2 += employeesArray.retreiveAtIndex(i).getPosition()+"\n";
                                        siteSearch2 += employeesArray.retreiveAtIndex(i).getSite()+"\n";
                                    }
                                }
                                Label idLabel2 = new Label("ID:");
                                idLabel2.setFont(font5);
                                idLabel2.setTranslateX(10);
                                idLabel2.setTranslateY(100);
                                idLabel2.setTextFill(Color.YELLOW);
                                scrollBarPane.getChildren().add(idLabel2);
                                Label firstNameLabel2 = new Label("First Name:");
                                firstNameLabel2.setFont(font5);
                                firstNameLabel2.setTranslateX(150);
                                firstNameLabel2.setTranslateY(100);
                                firstNameLabel2.setTextFill(Color.YELLOW);
                                scrollBarPane.getChildren().add(firstNameLabel2);
                                Label lastNameLabel2 = new Label("Last Name:");
                                lastNameLabel2.setFont(font5);
                                lastNameLabel2.setTranslateX(300);
                                lastNameLabel2.setTranslateY(100);
                                lastNameLabel2.setTextFill(Color.YELLOW);
                                scrollBarPane.getChildren().add(lastNameLabel2);
                                Label positionLabel2 = new Label("Position:");
                                positionLabel2.setFont(font5);
                                positionLabel2.setTranslateX(450);
                                positionLabel2.setTranslateY(100);
                                positionLabel2.setTextFill(Color.YELLOW);
                                scrollBarPane.getChildren().add(positionLabel2);
                                Label siteLabel2 = new Label("Site:");
                                siteLabel2.setFont(font5);
                                siteLabel2.setTranslateX(600);
                                siteLabel2.setTranslateY(100);
                                siteLabel2.setTextFill(Color.YELLOW);
                                scrollBarPane.getChildren().add(siteLabel2);
                                Label idLabelData2 = new Label(idSearch2);
                                idLabelData2.setFont(font5);
                                idLabelData2.setTranslateX(10);
                                idLabelData2.setTranslateY(150);
                                idLabelData2.setTextFill(Color.WHITE);
                                scrollBarPane.getChildren().add(idLabelData2);
                                Label firstNameLabelData2 = new Label(firstNameSearch2);
                                firstNameLabelData2.setFont(font5);
                                firstNameLabelData2.setTranslateX(150);
                                firstNameLabelData2.setTranslateY(150);
                                firstNameLabelData2.setTextFill(Color.WHITE);
                                scrollBarPane.getChildren().add(firstNameLabelData2);
                                Label lastNameLabelData2 = new Label(lastNameSearch2);
                                lastNameLabelData2.setFont(font5);
                                lastNameLabelData2.setTranslateX(300);
                                lastNameLabelData2.setTranslateY(150);
                                lastNameLabelData2.setTextFill(Color.WHITE);
                                scrollBarPane.getChildren().add(lastNameLabelData2);
                                Label positionLabelData2 = new Label(positionSearch2);
                                positionLabelData2.setFont(font5);
                                positionLabelData2.setTranslateX(450);
                                positionLabelData2.setTranslateY(150);
                                positionLabelData2.setTextFill(Color.WHITE);
                                scrollBarPane.getChildren().add(positionLabelData2);
                                Label siteLabelData2 = new Label(siteSearch2);
                                siteLabelData2.setFont(font5);
                                siteLabelData2.setTranslateX(600);
                                siteLabelData2.setTranslateY(150);
                                siteLabelData2.setTextFill(Color.WHITE);
                                scrollBarPane.getChildren().add(siteLabelData2);
                                
                                employeeFound.setText(searchField2.getText() + " Personnel");
                                employDataBox.setDisable(true);
                               
                        
                                if (idSearch2 == "") {
                                    Alert a = new Alert(Alert.AlertType.ERROR,
                                            "Invalid Position or Search Format", ButtonType.OK);
                                    a.showAndWait();
                                    // clear the text field
                                    searchField2.clear();
                                } else {
                                    employeeFound.setFont(font3);
                                    employeeFound.setTextFill(Color.LIGHTGREEN);
                                    employeeFound.setTranslateX(340);
                                    employeeFound.setTranslateY(10);
                                    employeeFound2.setFont(font3);
                                    employeeFound2.setTextFill(Color.WHITE);
                                    employeeFound2.setTranslateX(10);
                                    employeeFound2.setTranslateY(10);
                                    scrollBarPane.getChildren().addAll(employeeFound, employeeFound2);
                                }

                            }
                        }
                    }
                });



//! ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                // new text field for search by site
                TextField searchField3 = new TextField();
                searchField3.setPromptText("Enter Site Ex: Chicago");
                searchField3.setTranslateX(700);
                searchField3.setTranslateY(300);
                searchField3.setMaxSize(200, 50);
                searchField3.setMinSize(200, 50);
                scrollBarPane.getChildren().add(searchField3);
                searchField3.setOnKeyPressed(new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent event) {
                        if (event.getCode() == KeyCode.ENTER) {
                            if (!searchField3.getText().isEmpty()) {
                                String site = "";
                                for (int i = 0; i < employeesArray.size(); i++) {
                                    if (employeesArray.retreiveAtIndex(i).getSite()
                                            .equals(searchField3.getText())&& employeesArray.retreiveAtIndex(i).getFired() == false) {
                                        pulse.play();
                                        setEmployee(employeesArray.retreiveAtIndex(i));
                                        scrollBarPane.getChildren().clear();
                                        scrollBarPane.getChildren().addAll(sl, blueStart, help);
                                        site += employeesArray.retreiveAtIndex(i).getFirstName() + " "
                                                + employeesArray.retreiveAtIndex(i).getLastName() + "\n";
                                    }

                                }
                                employeeFound.setText(site);
                                if (site == "") {
                                    Alert a = new Alert(Alert.AlertType.ERROR,
                                            "Invalid Site or Search Format", ButtonType.OK);
                                    a.showAndWait();
                                    // clear the text field
                                    searchField3.clear();
                                } else {
                                    employeeFound.setFont(font3);
                                    employeeFound.setTextFill(Color.LIGHTGREEN);
                                    employeeFound.setTranslateX(340);
                                    employeeFound.setTranslateY(10);
                                    employeeFound2.setFont(font3);
                                    employeeFound2.setTextFill(Color.WHITE);
                                    employeeFound2.setTranslateX(10);
                                    employeeFound2.setTranslateY(10);
                                    scrollBarPane.getChildren().addAll(employeeFound, employeeFound2);
                                }

                            }
                        }
                    }
                });


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
                                        pulse.play();
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
                                        scrollBarPane.getChildren().addAll(employeeFound, employeeFound2);
                                    }
                                }
                                // if the employee is not found, display an error message
                                else {
                                    Alert a = new Alert(Alert.AlertType.ERROR,
                                            "404 Not Found",
                                            ButtonType.OK);
                                    a.showAndWait();
                                    // clear the text field
                                    searchField.clear();
                                }
                                // if the format is not correct, display an error message
                            } else {
                                Alert a = new Alert(Alert.AlertType.ERROR,
                                        "Employee Search Format Error",
                                        ButtonType.OK);
                                a.showAndWait();
                                // clear the text field
                                searchField.clear();
                            }
                        }

                    }
                });

                binaryTree.contains(searchField.getText());

                // if any of the search fields are clicked, put the other search fields to half
                // opacity
                searchField.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        searchField.setOpacity(1);
                        searchField2.setOpacity(0.5);
                        searchField3.setOpacity(0.5);
                    }
                });
                searchField2.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        searchField2.setOpacity(1);
                        searchField.setOpacity(0.5);
                        searchField3.setOpacity(0.5);
                    }
                });
                searchField3.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        searchField3.setOpacity(1);
                        searchField.setOpacity(0.5);
                        searchField2.setOpacity(0.5);
                    }
                });

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
        Font font4 = Font.font("yugothic", FontWeight.BOLD, FontPosture.ITALIC, 17);
        dataBoxTitle.setFont(font4);
        dataBoxTitle.setTextFill(Color.LIGHTGREEN);
        Text item = new Text();
        item.setFont(font);
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
            // stop pulse animation
            pulse.stop();
            dataBoxTitle.setTextFill(Color.LIGHTGREEN);
            scrollBarPane.getChildren().clear();
            // vbTop.getChildren().remove(arrow2);
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
                Label chartLabel = new Label(
                        "Employee ID\t\t  First Name\t\t       Last Name\t\t   Position\t\t       Site");
               
                chartLabel.setFont(font5);
                chartLabel.setTextFill(Color.YELLOW);
                chartLabel.setTranslateX(10);
                chartLabel.setTranslateY(80);
                Label idLabel = new Label("ID");
                String idStr = "";
                idLabel.setFont(font5);
                idLabel.setTextFill(Color.WHITE);
                idLabel.setTranslateX(10);
                idLabel.setTranslateY(150);
                Label lastNameLabel = new Label("Last Name");
                String lastNameStr = "";
                lastNameLabel.setFont(font5);
                lastNameLabel.setTextFill(Color.WHITE);
                lastNameLabel.setTranslateX(150);
                lastNameLabel.setTranslateY(150);
                Label firstNameLabel = new Label("First Name");
                String firstNameStr = "";
                firstNameLabel.setFont(font5);
                firstNameLabel.setTextFill(Color.WHITE);
                firstNameLabel.setTranslateX(300);
                firstNameLabel.setTranslateY(150);
                Label positionLabel = new Label("Position");
                String positionStr = "";
                positionLabel.setFont(font5);
                positionLabel.setTextFill(Color.WHITE);
                positionLabel.setTranslateX(450);
                positionLabel.setTranslateY(150);
                Label siteLabel = new Label("Site");
                String siteStr = "";
                siteLabel.setFont(font5);
                siteLabel.setTextFill(Color.WHITE);
                siteLabel.setTranslateX(600);
                siteLabel.setTranslateY(150);
                
                scrollBarPane.getChildren().clear();
                scrollBarPane.getChildren().addAll(sl, blueStart, help, employeeDataBase, chartLabel);


                for (int i = 0; i < employeesArray.size(); i++) {
                    // if the employee is not firee
                    if (employeesArray.retreiveAtIndex(i).getFired() == false) {
                        idStr += employeesArray.retreiveAtIndex(i).getEmployeeID() + "\n";
                        lastNameStr += employeesArray.retreiveAtIndex(i).getLastName() + "\n";
                        firstNameStr += employeesArray.retreiveAtIndex(i).getFirstName() + "\n";
                        positionStr += employeesArray.retreiveAtIndex(i).getPosition() + "\n";
                        siteStr += employeesArray.retreiveAtIndex(i).getSite() + "\n";
                    }
                }

                idLabel.setText(idStr);
                lastNameLabel.setText(lastNameStr);
                firstNameLabel.setText(firstNameStr);
                positionLabel.setText(positionStr);
                siteLabel.setText(siteStr);

                scrollBarPane.getChildren().addAll(idLabel, lastNameLabel, firstNameLabel, positionLabel, siteLabel);
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
                File file = fileChooser.showSaveDialog(null);
                try (PrintWriter fOut = new PrintWriter(file)) {
                    for (int i = 0; i < employeesArray.size(); i++) {
                        if (employeesArray.retreiveAtIndex(i).getFired() == false) {
                            fOut.println(employeesArray.retreiveAtIndex(i).toPrinter());
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
                    Label employeeDeleted = new Label(
                            "Would Not Want \nTo Be That Employee\n\t:(\nEmployee Fired & Deleted");
                    employeeDeleted.setFont(font3);
                    employeeDeleted.setTextFill(Color.LIGHTGREEN);
                    employeeDeleted.setTranslateX(100);
                    employeeDeleted.setTranslateY(200);
                    scrollBarPane.getChildren().clear();
                    scrollBarPane.getChildren().addAll(sl, blueStart, help, employeeDeleted);
                    // make a timeline to slowly fade out the label
                    FadeTransition fadeTransition = new FadeTransition(Duration.millis(4000), employeeDeleted);
                    fadeTransition.setFromValue(1.0);
                    fadeTransition.setToValue(0.0);
                    fadeTransition.play();
                    // when the timeline is done remove the label from the pane and call search
                    // again
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