package rybas.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import rybas.gui.ChessGame;
import rybas.models.MainModel;
import rybas.models.cells.Cell;
import rybas.models.figures.FigureColor;
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
        FigureColor colorOfMovingFigure = null;
//        try {
        if (possibleMoves.get(TypeOfMove.STAY) != null)
            for (Cell c : possibleMoves.get(TypeOfMove.STAY)) {
                colorOfMovingFigure = c.getFigure().getColor();
            }
        if (possibleMoves.get(TypeOfMove.BEAT) == null &&
                possibleMoves.get(TypeOfMove.MOVE) == null &&
                mainController.getCells().get(view.getButton()).getFigure() != null) {
            if (mainController.getGameProcess().getActivePlayer().getColor() ==
                    mainController.getCells().get(view.getButton()).getFigure().getColor())
                highlightPossibleMoves();
        } else if (possibleMoves.get(TypeOfMove.BEAT).size() == 0 &&
                possibleMoves.get(TypeOfMove.MOVE).size() == 0 &&
                mainController.getCells().get(view.getButton()).getFigure() != null) {
            if (mainController.getGameProcess().getActivePlayer().getColor() ==
                    mainController.getCells().get(view.getButton()).getFigure().getColor())
                highlightPossibleMoves();
        } else if (possibleMoves.get(TypeOfMove.MOVE).contains(mainController.getCells().get(view.getButton())) &&
                mainController.getCells().get(view.getButton()).getFigure() != null) {
            if (mainController.getGameProcess().getActivePlayer().getColor() ==
                    mainController.getCells().get(view.getButton()).getFigure().getColor())
                highlightPossibleMoves();
        } else if (possibleMoves.get(TypeOfMove.BEAT).contains(mainController.getCells().get(view.getButton()))) {
            if (mainController.getGameProcess().getActivePlayer().getColor() !=
                    mainController.getCells().get(view.getButton()).getFigure().getColor())
                makeMove();
        } else if (mainController.getCells().get(view.getButton()).getFigure() != null) {
            if (mainController.getGameProcess().getActivePlayer().getColor() ==
                    mainController.getCells().get(view.getButton()).getFigure().getColor()) {
                resetGraphics();
                highlightPossibleMoves();
            }
        } else if (possibleMoves.size() != 0) {
            if (mainController.getGameProcess().getActivePlayer().getColor() ==
                    colorOfMovingFigure) {
                makeMove();
                resetGraphics();
            }
        }
//        } catch (NullPointerException ex) {
//            System.out.println(ex.getMessage());
//        }
    }

    private void highlightPossibleMoves() {
        MainController mainController = MainController.getInstance(ChessGame.getPrimaryStage());
        LinkedHashMap<Button, String> selectedCellsColors = new LinkedHashMap<>();
        ChessService chessService = new ChessService();
        LinkedHashMap<TypeOfMove, LinkedHashSet<Cell>> possibleMoves = chessService.getPossibleMoves(mainController.getGameProcess().getField(),
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
    }

    private void resetGraphics() {
        MainController mainController = MainController.getInstance(ChessGame.getPrimaryStage());
        for (Map.Entry<Button, String> cc : mainController.getSelectedCellsColors().entrySet()) {
            cc.getKey().setStyle(cc.getValue());
        }
        mainController.setSelectedCellsColors(new LinkedHashMap<>());
        mainController.setPossibleMoves(new LinkedHashMap<>());
    }

    private void makeMove() {
        MainController mainController = MainController.getInstance(ChessGame.getPrimaryStage());
        var possibleMoves = mainController.getPossibleMoves();

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

                                break;
                            }
                        mainController.setPossibleMoves(new LinkedHashMap<>());
                        mainController.setSelectedCellsColors(new LinkedHashMap<>());
                    }
                }
            }
            mainController.getGameProcess().nextPlayer();
        } catch (ConcurrentModificationException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
