package rybas.controller;

import javafx.css.Style;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import rybas.gui.ChessGame;
import rybas.models.MainModel;
import rybas.models.cells.Cell;
import rybas.models.cells.CellColor;
import rybas.models.figures.TypeOfMove;
import rybas.services.ChessService;
import rybas.view.BoardCellView;

import java.util.*;

public class BoardCellController extends Controller<BoardCellView> {
    private BoardCellView view = new BoardCellView(this);

    public BoardCellController(Stage primaryStage) {
        super(primaryStage);
    }

    @Override
    public BoardCellView getView() {
        return view;
    }

    @Override
    public void handle(ActionEvent event) {
        MainController mainController = MainController.getInstance(ChessGame.getPrimaryStage());
        var possibleMoves = mainController.getPossibleMoves();
        if (possibleMoves.size() == 0 && mainController.getCells().get(view.getButton()).getFigure() != null) {
            LinkedHashMap<Button, String> selectedCellsColors = new LinkedHashMap<>();
            ChessService chessService = new ChessService();
            possibleMoves = chessService.getPossibleMoves(MainModel.getInstance().getBoard(),
                    mainController.getCells().get(view.getButton()));
            mainController.setPossibleMoves(possibleMoves);
            LinkedHashSet<Cell> beatMoves = possibleMoves.get(TypeOfMove.BEAT);
            LinkedHashSet<Cell> moves = possibleMoves.get(TypeOfMove.MOVE);
            for (Map.Entry<Button, Cell> bc : mainController.getCells().entrySet()) {
                if (beatMoves.contains(bc.getValue())) {
                    selectedCellsColors.put(bc.getKey(), bc.getKey().getStyle());
                    bc.getKey().setStyle("-fx-background-color: red;");
                }
                if (moves.contains(bc.getValue())) {
                    selectedCellsColors.put(bc.getKey(), bc.getKey().getStyle());
                    bc.getKey().setStyle("-fx-background-color: green;");
                }
            }
            mainController.setSelectedCellsColors(selectedCellsColors);
        } else if (possibleMoves.size() != 0) {
            Cell cellToMove = mainController.getCells().get(view.getButton());
            try {
                for (LinkedHashSet<Cell> moves : possibleMoves.values()) {
                    if (moves.contains(cellToMove)) {
                        var cells = new ArrayList<>(possibleMoves.get(TypeOfMove.STAY));
                        var firstCell = cells.get(0);
                        if (!firstCell.equals(cellToMove)) {
                            cellToMove.setFigure(firstCell.getFigure());
                            firstCell.setFigure(null);
                            for (Map.Entry<Button, Cell> btnCell : mainController.getCells().entrySet())
                                if (btnCell.getValue().equals(firstCell)) {
                                    view.getButton().setGraphic(btnCell.getKey().getGraphic());
                                    btnCell.getKey().setGraphic(new ImageView());
                                    for (Map.Entry<Button, String> cellClr : mainController.getSelectedCellsColors().entrySet())
                                        cellClr.getKey().setStyle(cellClr.getValue());
                                    mainController.getPossibleMoves().clear();
                                    mainController.getSelectedCellsColors().clear();
                                    break;
                                }
                        }
                    }
                }
            } catch (ConcurrentModificationException ex) {
                System.out.println(ex.getMessage());
            }
        } else if (mainController.getCells().get(view.getButton()).getFigure() != null) {
            //TODO: new figure selected
            possibleMoves.clear();
            for (Map.Entry<Button, String> cellClr : mainController.getSelectedCellsColors().entrySet())
                cellClr.getKey().setStyle(cellClr.getValue());
            mainController.getSelectedCellsColors().clear();

        }
    }

}
