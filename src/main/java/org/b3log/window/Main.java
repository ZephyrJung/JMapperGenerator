package org.b3log.window;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));
        primaryStage.setTitle("Mybatis Mapper Generator");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 380, 300));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
