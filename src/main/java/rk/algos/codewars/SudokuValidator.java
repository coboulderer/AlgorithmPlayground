package rk.algos.codewars;

public class SudokuValidator {

    public static boolean check(int[][] sudoku) {
        boolean valid = false;
        valid = rowSums(sudoku);
        if (valid) {
            valid = colSums(sudoku);
        }
        return valid;
    }

    private static boolean rowSums(int[][] sudoku) {
        for (int i = 0; i < sudoku.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < sudoku[i].length; j++) {
                rowSum += sudoku[i][j];
            }
            if (rowSum != 45) {
                return false;
            }
        }
        return true;
    }

    private static boolean colSums(int[][] sudoku) {
       for (int j = 0; j < sudoku[0].length; j++) {
           int colSum = 0;
           for (int i = 0; i < sudoku.length; i++) {
               colSum += sudoku[i][j];
           }
           if (colSum != 45) {
               return false;
           }
       }
        return true;
    }
}
