package rybas.gui;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import rybas.models.Board;
import rybas.serializers.Serializer;
import rybas.services.SerializeService;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ServiceLoader;
import java.util.logging.Logger;

public class ChessGame extends Application {

    private Board board;

    {
        board = new Board();
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();

//        primaryStage.getIcons().add(Helper.loadImage("images/icon.png", 16, 16));

        BorderPane menu = new BorderPane();
        menu.setPadding(new Insets(10, 10, 10, 0));

        GridPane options = new GridPane();
        options.setAlignment(Pos.BOTTOM_RIGHT);

        SerializeService<Board> serializeService = new SerializeService<>();
        Button addToJsonButton = new Button("Add to Json");
        addToJsonButton.setOnAction(e -> {
            String json = serializeService.serialize(board);
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(null);
            if (file != null) {
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                    writer.write(json);
                    writer.close();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });
        options.add(addToJsonButton, 1, 0);

        Button loadFromJsonButton = new Button("Load from Json");
        loadFromJsonButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            StringBuilder builder = new StringBuilder();
            File file = fileChooser.showOpenDialog(null);
            if (file != null) {
                try {
                    Files.lines(file.toPath()).forEach(builder::append);
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
            board = serializeService.deserialize(builder.toString(), board);
        });
        options.add(loadFromJsonButton, 2, 0);

        menu.setRight(options);
        pane.setBottom(menu);
        Scene scene = new Scene(pane, 440, 490);

        primaryStage.setTitle("Chess");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        primaryStage.setMinWidth(primaryStage.getWidth());
        primaryStage.setMinHeight(primaryStage.getHeight());

    }
}