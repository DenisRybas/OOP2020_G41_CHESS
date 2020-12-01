package rybas.view;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import rybas.controller.GetFromJsonController;

public class GetFromJsonView extends HBox {
    private final Button button = new Button("Get from json");

    public Button getButton() {
        return button;
    }

    public GetFromJsonView(final GetFromJsonController controller) {
        button.setOnAction(controller);
        this.getChildren().addAll(button);
    }
}
