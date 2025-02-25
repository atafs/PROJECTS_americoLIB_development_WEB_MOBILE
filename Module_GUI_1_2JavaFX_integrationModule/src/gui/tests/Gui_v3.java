package gui.tests;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Gui_v3 extends Application {

    Stage window;
    Scene scene, scene2;
    private String pathCSS = "gui/styles/myStyle_v1.css";

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        primaryStage.setResizable(false);
        window.setTitle("Ellucian - Jira Issues");
        
        //SCENE01 ##############################################
        //GridPane with 10px padding around edge
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        //BUTTONS
        Button createTasks = new Button("CREATE TASKS");
        GridPane.setConstraints(createTasks, 0, 1);
        createTasks.getStyleClass().add("button-blue");
        
        Button loadAttachments = new Button("LOAD ATTACHMENTS");
        GridPane.setConstraints(loadAttachments, 1, 1);
        loadAttachments.getStyleClass().add("button-red");
        
        Button createSubTasks = new Button("CREATE SUB-TASKS");
        GridPane.setConstraints(createSubTasks, 2, 1);
        createSubTasks.getStyleClass().add("button-green");
        
        Button createAll = new Button("CREATE ALL");
        GridPane.setConstraints(createAll, 3, 1);
        createAll.getStyleClass().add("button-purple");
        
        //IMAGE
        Image image = new Image("media/morphis.jpg");
        ImageView iv1 = new ImageView();
        iv1.setImage(image);

        //Add everything to grid
        grid.getChildren().addAll(createTasks, loadAttachments, createSubTasks, createAll);
        
        //LISTENERS FOR BUTTONS
        createTasks.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("createTasks");
                printMessageInConsole("createTasks");
                window.setScene(scene2);
            }
        });
        
        loadAttachments.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("loadAttachments");
                printMessageInConsole("loadAttachments");
                window.setScene(scene2);
            }
        });
        
        createSubTasks.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("createSubTasks");
                printMessageInConsole("createSubTasks");
                window.setScene(scene2);
            }
        });
        
        createAll.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("createAll");
                printMessageInConsole("createAll");
                window.setScene(scene2);
            }
        });
        //######################################################

        //SCENE02 ##############################################
        //Button 2
        Button back = new Button("Back to Menu");
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("createAll");
                printMessageInConsole("createAll");
                window.setScene(scene);
            }
        });

        //LAYOUT02
        StackPane layout2 = new StackPane();
        layout2.getChildren().add(back);
        scene2 = new Scene(layout2, 800, 400);
        //scene2.setFill(Color.BLACK);
        scene2.getStylesheets().add(pathCSS);
        
        //######################################################

        //LAYOUT01
        Group root = new Group();
        scene = new Scene(root);
        scene.getStylesheets().add(pathCSS);
        scene.setFill(Color.BLACK);
        HBox box = new HBox();
        box.getChildren().add(grid);
        box.getChildren().add(iv1);
        root.getChildren().add(box);

        window.setScene(scene);
        window.sizeToScene(); 
        window.show();
    }
    
    //CALL STATIC METHOD
    public static void printMessageInConsole(String message) {
    	System.err.println(message);
    }
}