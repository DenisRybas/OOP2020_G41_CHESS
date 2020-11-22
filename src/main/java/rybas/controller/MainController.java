package rybas.controller;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import rybas.gui.ChessGame;
import rybas.models.Board;
import rybas.models.MainModel;
import rybas.models.cells.Cell;
import rybas.models.cells.CellColor;
import rybas.models.figures.TypeOfMove;
import rybas.services.ChessService;
import rybas.utils.FxUtils;
import rybas.view.BoardCellView;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class MainController {
    private static MainController instance;
    
    private CreateNewGameController createNewGame;
    private AddToJsonController addToJson;
    private GetFromJsonController getFromJson;

    private LinkedHashMap<TypeOfMove, LinkedHashSet<Cell>> possibleMoves;
    private LinkedHashMap<Button, Cell> cells;
    private LinkedHashMap<Button, String> selectedCellsColors;

    public LinkedHashMap<Button, String> getSelectedCellsColors() {
        return selectedCellsColors;
    }

    public void setSelectedCellsColors(LinkedHashMap<Button, String> selectedCellsColors) {
        this.selectedCellsColors = selectedCellsColors;
    }

    public LinkedHashMap<Button, Cell> getCells() {
        return cells;
    }

    public LinkedHashMap<TypeOfMove, LinkedHashSet<Cell>> getPossibleMoves() {
        return possibleMoves;
    }

    private MainController(Stage primaryStage) {
        this.addToJson = new AddToJsonController(primaryStage);
        this.getFromJson = new GetFromJsonController(primaryStage);
        this.createNewGame = new CreateNewGameController(primaryStage);
        this.possibleMoves = new LinkedHashMap<>();
        this.cells = new LinkedHashMap<>();
    }

    public CreateNewGameController getCreateNewGame() {
        return createNewGame;
    }

    public GetFromJsonController getGetFromJson() {
        return getFromJson;
    }

    public AddToJsonController getAddToJson() {
        return addToJson;
    }

    public void setPossibleMoves(LinkedHashMap<TypeOfMove, LinkedHashSet<Cell>> possibleMoves) {
        this.possibleMoves = possibleMoves;
    }

    public GridPane createBoard(Board board) {
        Cell[][] field = board.getField();
        GridPane fxField = new GridPane();
        var pathsToFImages = FxUtils.getFigureImages();
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                BoardCellController controller = new BoardCellController(ChessGame.getPrimaryStage());
                Button btn = new Button();
                String color = field[i][j].getColor() == CellColor.LIGHT ? "beige" : "brown";
                btn.setStyle("-fx-background-color: " + color + ";");
                btn.setMinWidth(60);
                btn.setMinHeight(60);
                if (field[i][j].getFigure() != null) {
                    var imv = new ImageView(pathsToFImages.get(field[i][j].getFigure().getType()).get(field[i][j].getFigure().getColor()));
                    btn.setGraphic(imv);
                }
                controller.getView().setButton(btn);
                cells.put(btn, field[i][j]);
                btn.setOnAction(controller);
//                btn.setOnAction(event -> {
//                    if (possibleMoves.size() != 0) {
//                        for (LinkedHashSet<Cell> c : possibleMoves.values())
//                            if (c.contains(cells.get(btn))) {
//                                cells.get(btn).setFigure(selectedCell.getFigure());
//                                selectedCell.setFigure(null);
//                                for (Map.Entry<Button, Cell> btnCell : cells.entrySet())
//                                    if (btnCell.getValue().equals(selectedCell)) {
//                                        btn.setGraphic(btnCell.getKey().getGraphic());
//                                        btnCell.getKey().setGraphic(new ImageView());
//
//                                    }
//                                possibleMoves = new LinkedHashMap<>();
//                            }
//                    } else {
//                        ChessService chessSVC = new ChessService();
//                        try {
//                            possibleMoves = chessSVC.getPossibleMoves(board, cells.get(btn));
////                            for (Cell moveCell : possibleMoves.get(TypeOfMove.MOVE))
////                                for (Map.Entry<Button, Cell> btnCell : cells.entrySet())
////                                    if (btnCell.getValue().equals(moveCell)) {
//////                                        btnCell.getKey().setStyle("-fx-background-color: green;");
////                                    }
////
////                            for (Cell beatCell : possibleMoves.get(TypeOfMove.BEAT))
////                                for (Map.Entry<Button, Cell> btnCell : cells.entrySet())
////                                    if (btnCell.getValue().equals(beatCell)) {
//////                                        btnCell.getKey().setStyle("-fx-background-color: red;");
////                                    }
//                        } catch (NullPointerException ex) {
//                            ex.getMessage();
//                        }
//                    }
//                    selectedCell = cells.get(btn);
//                });

                fxField.add(btn, j, i);
                btn.setPrefSize(60, 60);
            }
        }
        return fxField;
    }

    public static MainController getInstance(Stage primaryStage) {
        if (instance == null) {
            instance = new MainController(primaryStage);
        }
        return instance;
    }
}
