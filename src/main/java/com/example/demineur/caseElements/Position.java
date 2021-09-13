package com.example.demineur.caseElements;

public class Position {

    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "{" + x +
                "," + y +
                '}';
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
