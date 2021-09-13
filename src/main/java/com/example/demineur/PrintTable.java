package com.example.demineur;

public class PrintTable {

    private int x;
    private int y;


    public PrintTable(int x, int y){
        this.x = x;
        this.y = y;
        System.out.println("------------------------");
        printLane(x, y);
        System.out.println("------------------------");
    }

    private void printLane(int x, int y) {
        for (int i= 0; i<x; i++){
            for(int j= 0; j<y; j++){
                System.out.printf("0-");
            }
            System.out.printf("\n");
        }
    }
}
