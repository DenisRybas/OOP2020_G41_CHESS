package rybas.figures;

public class Figure {
    FigureType type;
    FigureColor color;

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
