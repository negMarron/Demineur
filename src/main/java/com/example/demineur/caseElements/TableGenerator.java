package com.example.demineur.caseElements;

import java.util.ArrayList;

public class TableGenerator {


    public TableGenerator() {

    }

    public ArrayList<Case> generate(int x, int y, int numberOfMine) {
        System.out.println(x*y);
        System.out.println(x+ " x "+y+"  mines: "+numberOfMine);//nombre de mines
        Tableau table = new Tableau(x, y );
        return table.createCases(numberOfMine, 10); // mineProbability in %
    }

    public int calculateLargeur(int y) {
        int result = 0;
        int largeurInit = (int) (y - (Math.random() * (2 - 0)));
        result = largeurInit;
        if (y == 4) {
            return y;
        } else if (y - largeurInit < 0) {
            result = calculateLargeur(y);
        }
        return result;
    }

    public static void main(String[] args) {

        TableGenerator tableGenerator = new TableGenerator();
        int y = (int) (Math.random() * (6 - 0) + 4);
        int x = tableGenerator.calculateLargeur(y);
        int numberOfMine = x*y/8;
        tableGenerator.generate(x, y, numberOfMine);

    }
}
