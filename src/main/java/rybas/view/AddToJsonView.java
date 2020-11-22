package rybas.view;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import rybas.controller.AddToJsonController;

public class AddToJsonView extends HBox {
    private final Button button = new Button("Add to json");

    public Button getButton() {
        return button;
    }

    public AddToJsonView(final AddToJsonController controller) {
        button.setOnAction(controller);
        this.getChildren().addAll(button);
    }
}
