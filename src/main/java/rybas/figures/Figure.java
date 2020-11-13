package rybas.figures;

public class Figure {
    private FigureType type;
    private FigureColor color;

    public Figure(FigureType type, FigureColor color) {
        this.type = type;
        this.color = color;
    }

    public FigureColor getColor() {
        return color;
    }

    public FigureType getType() {
        return type;
    }
}
