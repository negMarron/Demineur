package com.example.demineur.caseElements;

import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Case extends Rectangle {

    private Position position;
    private Drapeau drapeau;
    private boolean isMine = false;
    private int numberOfMineAround = 0;
    private ArrayList<Case> neighbour = new ArrayList<Case>();

    public Case(Position position, Drapeau drapeau, boolean isMine, int numberOfMineAround) {
        this.position = position;
        this.drapeau = drapeau;
        this.isMine = isMine;
        this.numberOfMineAround = numberOfMineAround;
    }

    public Case(Position position) {
        this.position = position;

    }

    public int getNumberOfMineAround() {
        return numberOfMineAround;
    }

    public void setNumberOfMineAround(int numberOfMineAround) {
        this.numberOfMineAround = numberOfMineAround;
    }

    public boolean isMine() {
        return isMine;
    }

    public void setMine(boolean mine) {
        isMine = mine;
    }

    public ArrayList<Case> getNeighbour() {
        return neighbour;
    }

    public void setNeighbour(ArrayList<Case> neighbour) {
        this.neighbour = neighbour;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Case{" + position +
                ", isMine=" + isMine +
                ", numberOfMine=" + numberOfMineAround +
                ", neighbourSize=" + neighbour.size() +
                '}';
    }
}
