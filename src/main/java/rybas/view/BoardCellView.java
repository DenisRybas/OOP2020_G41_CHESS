package rybas.view;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import rybas.controller.BoardCellController;
import rybas.controller.Controller;

public class BoardCellView extends HBox {
    private Button button = new Button();
    private Controller<BoardCellView> controller;

    public void setButton(Button button) {
        button.setOnAction(this.button.getOnAction());
        this.button = button;
    }

    public Button getButton() {
        return button;
    }

    public Controller<BoardCellView> getController() {
        return controller;
    }

    public BoardCellView(final BoardCellController controller) {
        this.controller = controller;
        this.button.setOnAction(controller);
        this.getChildren().addAll(this.button);
    }
}
