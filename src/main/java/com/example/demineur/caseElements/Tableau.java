package com.example.demineur.caseElements;

import java.util.ArrayList;
import java.util.Random;

public class Tableau {

    private int x;
    private int y;
    private ArrayList<Case> cases;

    public Tableau(int x, int y) {
        this.x = x;
        this.y = y;
        this.cases = new ArrayList<>();
    }

    public ArrayList<Case> createCases(int numberOfMine, int mineProbability) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                Position position = new Position(i, j);
                this.cases.add(new Case(position));
                //System.out.printf(position.toString());
            }
            //System.out.printf("\n");
        }
        setMine(numberOfMine, mineProbability);
        calculateNeighbour(this.cases);
        setNumberOfMinesAround();


        System.out.println();
        System.out.println("Mines print" + "  " + numberOfMine);
        for (Case item : this.cases) {

            if (item.isMine()) {
                System.out.printf("(x)");
            } else {
                System.out.printf("("+item.getNumberOfMineAround()+")");
            }
            if (item.getPosition().getY() == y - 1) {
                System.out.printf("\n");
            }
        }
        return this.cases;
    }

    private void setNumberOfMinesAround() {
        for (Case item : this.cases) {
            int mineCounter = 0;
            ArrayList<Case> neighbour = item.getNeighbour();
            for (Case itemNeigh : neighbour) {
                if (itemNeigh.isMine()) {
                    mineCounter++;
                    item.setNumberOfMineAround(mineCounter);
                }

            }
        }
    }

    private void setMine(int numberOfMine, int mineProbability) {
        boolean decision = false;

        for (Case item : this.cases) {
            if (numberOfMine > 0) {
                decision = setMineDecision(mineProbability);
            } else {
                break;
            }
            if (decision) {
                if (!item.isMine()) {
                    item.setMine(true);
                    numberOfMine--;
                }
            }
        }
        if (numberOfMine > 0) {
            setMine(numberOfMine, mineProbability);
        }
    }

    private boolean setMineDecision(int minesPercentage) {
        int i = new Random().nextInt(minesPercentage);
        boolean val = i == 5;
        return val;
    }


    private void calculateNeighbour(ArrayList<Case> cases) {
        int xPermut = 0;
        for (Case item : cases) {
            //case x-1
            xPermut = item.getPosition().getX() - 1;
            if (xPermut >= 0) {//y
                doY(xPermut, item);
            }

            //case x
            xPermut = item.getPosition().getX();
            if (item.getPosition().getY() - 1 >= 0) {
                addToCaseList(item, xPermut, item.getPosition().getY() - 1);
            }
            if (item.getPosition().getY() + 1 < y) {//y
                addToCaseList(item, xPermut, item.getPosition().getY() + 1);

            }

            //case x+1
            xPermut = item.getPosition().getX() + 1;
            if (item.getPosition().getX() + 1 < x) {
                doY(xPermut, item);
            }
        }
        /*
        for (Case item : cases) {
            System.out.println();
            System.out.println("item  - > voisins");
            System.out.println("item  " + item.getPosition());
            for (Case itemCase : item.getNeighbour()) {
                System.out.println("CaseItem:  " + itemCase.getPosition());
            }
        }
         */
    }

    private void doY(int xPermut, Case item) {
        if (item.getPosition().getY() - 1 >= 0) {
            addToCaseList(item, xPermut, item.getPosition().getY() - 1);
        }
        addToCaseList(item, xPermut, item.getPosition().getY());
        if (item.getPosition().getY() + 1 < y) {
            addToCaseList(item, xPermut, item.getPosition().getY() + 1);
        }
    }

    private void addToCaseList(Case item, int xPermut, int i) {
        for (Case itemToAdd : this.cases) {
            if (itemToAdd.getPosition().getX() == xPermut && itemToAdd.getPosition().getY() == i) {
                item.getNeighbour().add(itemToAdd);
            }
        }
    }


    public ArrayList<Case> getCases() {
        return cases;
    }
}
