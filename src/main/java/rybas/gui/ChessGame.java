package rybas.gui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import rybas.controller.CreateNewGameController;
import rybas.controller.GetFromJsonController;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class ChessGame extends Application {

    private static Stage primaryStage;

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane mainMenu = new GridPane();
        HBox mainMenuButtons = new HBox();
        mainMenuButtons.getChildren().addAll(new CreateNewGameController(primaryStage).getView());
        mainMenuButtons.getChildren().addAll(new GetFromJsonController(primaryStage).getView());
        mainMenu.setAlignment(Pos.CENTER);
        mainMenu.add(mainMenuButtons, 0, 0);
        final Scene scene = new Scene(mainMenu, 800, 600);

        primaryStage.setTitle("Chess");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        primaryStage.setMinWidth(primaryStage.getWidth());
        primaryStage.setMinHeight(primaryStage.getHeight());
        ChessGame.primaryStage = primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}