package Matrices;

import java.util.ArrayList;

public class Spiral {
    // https://practice.geeksforgeeks.org/problems/print-matrix-in-snake-pattern-1587115621/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
    static ArrayList<Integer> snakePattern(int matrix[][]) {
        ArrayList<Integer> res = new ArrayList<>();
        boolean isRight = true;
        for (int i = 0; i < matrix.length; i++) {
            if (isRight) {
                for (int j = 0; j < matrix[i].length; j++) {
                    res.add(matrix[i][j]);
                }
            } else {
                for (int j = matrix[i].length - 1; j >= 0; j--) {
                    res.add(matrix[i][j]);
                }
            }
            isRight = !isRight;
        }
        return res;
    }
}
