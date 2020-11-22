package rybas.gui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import rybas.controller.AddToJsonController;
import rybas.controller.CreateNewGameController;
import rybas.controller.GetFromJsonController;
import rybas.models.cells.Cell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import rybas.models.Board;
import rybas.models.cells.CellColor;
import rybas.models.figures.TypeOfMove;
import rybas.services.ChessService;
import rybas.services.SerializeService;
import rybas.utils.Defaults;
import rybas.utils.FxUtils;
import rybas.view.AddToJsonView;
import rybas.view.GetFromJsonView;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class ChessGame extends Application {

    private static Stage primaryStage;
    private Board board;
    private LinkedHashMap<Button, Cell> cells;
    private GridPane fxField;
    private LinkedHashMap<TypeOfMove, LinkedHashSet<Cell>> possibleMoves;
    private Cell selectedCell;

    {
        fxField = new GridPane();
        cells = new LinkedHashMap<>();
        possibleMoves = new LinkedHashMap<>();
    }

    public Board getBoard() {
        return board;
    }

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

//        BorderPane startMenu = createStartMenu();
//        createNGButton.setOnAction(event -> {
//            board = new Board();
//            createBoard(board);
//            primaryStage.setScene(new Scene(fxField, Defaults.SCREENWIDTH, Defaults.SCREENHEIGHT));
//        });
//
//        loadFromJsonButton.setOnAction(e -> {
//            SerializeService<Board> serializeService = new SerializeService<>();
//
//            FileChooser fileChooser = new FileChooser();
//            StringBuilder builder = new StringBuilder();
//            File file = fileChooser.showOpenDialog(null);
//            if (file != null) {
//                try {
//                    Files.lines(file.toPath()).forEach(builder::append);
//                } catch (IOException ex) {
//                    System.out.println(ex.getMessage());
//                }
//                board = serializeService.deserialize(builder.toString(), board);
//            }
//        });
//
//        GridPane options = createOptions();
////        startMenu.setRight(options);
//        Scene scene = new Scene(startMenu, Defaults.SCREENWIDTH, Defaults.SCREENHEIGHT);
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