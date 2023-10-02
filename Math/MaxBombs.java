public class MaxBombs {
    private int distanceFormula(int x1, int y1, int x2, int y2) {
        return (int) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public int maximumDetonation(int[][] bombs) {
        int[] maxBombsExplode = new int[bombs.length];
        for (int i = 0; i < bombs.length; i++) {
            for (int j = i + 1; j < bombs.length - 1; j++) {
                if (distanceFormula(bombs[i][0], bombs[i][1], bombs[j][0], bombs[j][1]) <= bombs[i][2]) {
                    maxBombsExplode[i]++;
                }
            }
        }
        int max = maxBombsExplode[0];
        for (int i = 0; i < bombs.length; i++) {
            max = Math.max(max, maxBombsExplode[i]);
        }
        return max;
    }

}

class Main {
    public static void main(String[] args) {
        MaxBombs mt = new MaxBombs();

        int[][] bombs = { { 1, 1, 5 }, { 10, 11, 5 } };
        System.out.println(mt.maximumDetonation(bombs));

    }
}