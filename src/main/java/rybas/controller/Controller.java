package rybas.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public abstract class Controller<T> implements EventHandler<ActionEvent> {
    private final Stage primaryStage; //TODO: primaryStage setView

    public Controller(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public abstract T getView();

    @Override
    public abstract void handle(ActionEvent event);
}
