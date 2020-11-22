package rybas.controller;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
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
        GridPane board = MainController.getInstance(primaryStage).createBoard(MainModel.getInstance().getBoard());
        primaryStage.setScene(new Scene(board, primaryStage.getScene().getWidth(), primaryStage.getScene().getHeight()));
    }
}
