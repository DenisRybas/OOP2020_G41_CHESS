package rybas.figures;

import rybas.models.Cell;

public class Queen implements Figure, Movable {
    private Cell currentCell;
    private Figure.Type type;
    private Figure.Color color;

    public Queen(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public Type getType() {
        return Type.QUEEN;
    }

    @Override
    public Cell getCurrentCell() {
        return currentCell;
    }

    @Override
    public void setCurrentCell(Cell c) {
        currentCell = c;
    }

//    @Override
//    public LinkedHashMap<TypeOfMove, LinkedHashSet<Cell>> getPossibleMoves(Board b, Cell c) {
//        LinkedHashMap<TypeOfMove, LinkedHashSet<Cell>> pm = new LinkedHashMap<>();
//        pm.putAll(bishop.getPossibleMoves(b, c));
//        pm.putAll(rook.getPossibleMoves(b, c));
//        return pm;
//    }
//
//    @Override
//    public LinkedHashMap<TypeOfMove, LinkedHashSet<Cell>> getPossibleMoves(Board b) {
//        LinkedHashMap<TypeOfMove, LinkedHashSet<Cell>> pm = new LinkedHashMap<>();
//        pm.putAll(bishop.getPossibleMoves(b, this.currentCell));
//        pm.putAll(rook.getPossibleMoves(b, this.getCurrentCell()));
//        return pm;
//    }

    @Override
    public void move(Cell c) {
        currentCell = c;
    }
}
