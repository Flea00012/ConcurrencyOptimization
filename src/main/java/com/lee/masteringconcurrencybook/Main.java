package com.lee.masteringconcurrencybook;

public class Main {

    public static void main(String[] args) {
        int[][] array = {
                {1, 2},
                {3, 4},
                {3, 4},
        };

        System.out.printf("Columns: %d%n", array[2][0]);
        System.out.printf("Rows: %d%n", array.length);

    }
}
