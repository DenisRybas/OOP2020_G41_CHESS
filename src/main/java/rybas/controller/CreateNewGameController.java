package rybas.controller;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import rybas.gui.ChessGame;
import rybas.models.MainModel;
import rybas.view.CreateNewGameView;

public class CreateNewGameController extends Controller<CreateNewGameView> {
    private final CreateNewGameView view = new CreateNewGameView(this);

    public CreateNewGameController(Stage primaryStage) {
        super(primaryStage);
    }

    @Override
    public CreateNewGameView getView() {
        return view;
    }

    @Override
    public void handle(ActionEvent event) {
        Stage primaryStage = ChessGame.getPrimaryStage();
        HBox game = new HBox();
        GridPane board = MainController.getInstance(primaryStage).createBoard(MainController.getInstance(ChessGame.getPrimaryStage()).getGameProcess().getField());
        AddToJsonController jsonController = new AddToJsonController(primaryStage);
        game.getChildren().addAll(board, jsonController.getView());
        primaryStage.setScene(new Scene(game, primaryStage.getScene().getWidth(), primaryStage.getScene().getHeight()));
    }
}
