package rybas.controller;

import javafx.event.ActionEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import rybas.models.Board;
import rybas.models.MainModel;
import rybas.services.SerializeService;
import rybas.view.AddToJsonView;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AddToJsonController extends Controller<AddToJsonView> {
//    private final Stage primaryStage; //TODO: primaryStage setView
    private final AddToJsonView view = new AddToJsonView(this);

    public AddToJsonController(Stage primaryStage) {
        super(primaryStage);
    }

    @Override
    public AddToJsonView getView() {
        return view;
    }

    @Override
    public void handle(ActionEvent event) {
        final Object source = event.getSource();
        if (source.equals(view.getButton())) {
            SerializeService<Board> serializeService = new SerializeService<>();
            String json = serializeService.serialize(MainModel.getInstance().getBoard());
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
        }
    }
}
