package rybas.view;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import rybas.controller.AddToJsonController;
import rybas.controller.CreateNewGameController;

public class CreateNewGameView extends HBox {
    private final Button button = new Button("Create new Game");

    public Button getButton() {
        return button;
    }

    public CreateNewGameView(final CreateNewGameController controller) {
        button.setOnAction(controller);
        this.getChildren().addAll(button);
    }
}
