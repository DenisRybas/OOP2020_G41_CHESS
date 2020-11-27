package rybas.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import rybas.GameProcess;
import rybas.gui.ChessGame;
import rybas.models.Board;
import rybas.models.MainModel;
import rybas.services.SerializeService;
import rybas.view.GetFromJsonView;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class GetFromJsonController extends Controller<GetFromJsonView> implements EventHandler<ActionEvent> {
    //    private final Stage primaryStage; //TODO: primaryStage setView
    private final GetFromJsonView view = new GetFromJsonView(this);

    public GetFromJsonController(Stage primaryStage) {
        super(primaryStage);
    }

    @Override
    public GetFromJsonView getView() {
        return view;
    }


    @Override
    public void handle(ActionEvent event) {
        SerializeService<GameProcess> serializeService = new SerializeService<>();
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
        GameProcess process = new GameProcess();
        MainController.getInstance(ChessGame.getPrimaryStage()).setGameProcess(serializeService.deserialize(builder.toString(), process));
    }
}
