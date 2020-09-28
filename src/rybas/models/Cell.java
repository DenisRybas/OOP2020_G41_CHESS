package rybas.models;

import rybas.figures.Figure;

import java.awt.*;

public class Cell {
    private Figure f;
    private Cell left, right;
    private Cell up, down;
    private Cell upRight, downRight;
    private Cell upLeft, downLeft;
    private CellColor c;
    enum CellColor {
        LIGHT,
        DARK
    }

    public Cell(Figure f, Cell left, Cell right, Cell up, Cell down,
                Cell upRight, Cell downRight, Cell upLeft, Cell downLeft) {
        this.f = f;
        this.left = left;
        this.right = right;
        this.up = up;
        this.down = down;
        this.upRight = upRight;
        this.downRight = downRight;
        this.upLeft = upLeft;
        this.downLeft = downLeft;
    }

    public Cell(Figure f, CellColor c) {
        this.f = f;
        this.c = c;
    }

    public Cell() {
        this.f = null;
    }

    public void setF(Figure f) {
        this.f = f;
    }

    public void setLeft(Cell left) {
        this.left = left;
    }

    public void setRight(Cell right) {
        this.right = right;
    }

    public void setUp(Cell up) {
        this.up = up;
    }

    public void setDown(Cell down) {
        this.down = down;
    }

    public void setUpRight(Cell upRight) {
        this.upRight = upRight;
    }

    public void setDownRight(Cell downRight) {
        this.downRight = downRight;
    }

    public void setUpLeft(Cell upLeft) {
        this.upLeft = upLeft;
    }

    public void setDownLeft(Cell downLeft) {
        this.downLeft = downLeft;
    }

    public Cell getLeft() {
        return left;
    }

    public Cell getRight() {
        return right;
    }

    public Cell getUp() {
        return up;
    }

    public Cell getDown() {
        return down;
    }

    public Cell getUpRight() {
        return upRight;
    }

    public Cell getDownRight() {
        return downRight;
    }

    public Cell getUpLeft() {
        return upLeft;
    }

    public Cell getDownLeft() {
        return downLeft;
    }

    public Figure.Type getValue() {
        return f.getType();
    }
}
