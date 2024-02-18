package net.mp3skater.main;

import java.util.Scanner;

public class Matrix {

    private double[][] field; // Actual number-array
    private final int n; // Size of the Matrix

    public Matrix(int n) {
        this.n = n;
        field = new double[n][n+1];
    }

    public double[] solveMatrix() {
        double[] ans = new double[n];

        return ans;
    }
    public void fillMatrix() {
        Scanner sc = new Scanner(System.in);

        for(int row = 0; row < n; row++) {
            for(int col = 0; col <= n; col++) {
                field[row][col] = sc.nextInt();
            }
        }
    }
    public Matrix getExceptMatrix(int exRow, int exCol) {
        return getExceptMatrix(exRow, exCol, 0);
    }
    private Matrix getExceptMatrix(int notRow, int notCol, int currentPos) {
        // Returns a Matrix with all Values that don't have the same row and column.

        assert notRow <= n && notCol <= n;
        // CREATE SUB-MATRIX
        Matrix m = new Matrix(n-1);
        // FILL MATRIX
        for(int row = 0; row < n; row++) {
            for(int col = 0; col <= n; col++) {
                if(row != notRow && col != notCol) {
                    m.field[currentPos/(n)]
                            [currentPos%(n)] = field[row][col];
                    currentPos++;
                }
            }
        }
        return m;
    }
    public void add(Matrix addM) {
        // Add another matrix with the same size

        assert n==addM.n;
        // Addition of all the corresponding elements (same row and col)
        for(int row = 0; row<=n; row++) {
            for(int col = 0; col<n; col++) {
                field[row][col] += addM.field[row][col];
            }
        }
    }
    public void sub(Matrix addM) {
        // Add another matrix with the same size

        assert n==addM.n;
        // Subtraction of all the corresponding elements (same row and col)
        for(int row = 0; row<=n; row++) {
            for(int col = 0; col<n; col++) {
                field[row][col] -= addM.field[row][col];
            }
        }
    }
    public void mul(Matrix addM) {
        // Add another matrix with the same size

        assert n==addM.n;
        // Multiplication of all the corresponding elements (same row and col)
        for(int row = 0; row<=n; row++) {
            for(int col = 0; col<n; col++) {
                field[row][col] *= addM.field[row][col];
            }
        }
    }
    public void div(Matrix addM) {
        // Add another matrix with the same size

        assert n==addM.n;
        // Division of all the corresponding elements (same row and col)
        for(int row = 0; row<=n; row++) {
            for(int col = 0; col<n; col++) {
                field[row][col] /= addM.field[row][col];
            }
        }
    }
    public double get2times2MatrixDet(Matrix m) {
        // Returns the determinant of a Matrix with n == 2.

        assert m.n == 2;
        // |matrix| = ad - bd for matrix = [{a, b} {c, d}]
        return m.field[0][0]*m.field[1][1]-m.field[0][1]*m.field[1][0];
    }
    public double getDet() {
        return getDet(this);
    }
    private double getDet(Matrix calcMat) {
        // RECURSIVE STEP
        if(calcMat.n != 2) {
            double sum = 0;
            for(int index = 0; index<calcMat.n; index++) {
                sum += (index%2==0? 1:-1)* calcMat.field[0][index]* getDet(calcMat.getExceptMatrix(0, index));
            }
            return sum;
        }
        // BASIS CASE
        return get2times2MatrixDet(calcMat);
    }
    public void printMatrix() {
        // ALL PIECES
        for(double[] row : field) {
            for(double col : row) {
                System.out.print(col + "  ");
            }
            System.out.println();
        }
    }
    public double[][] getField() {
        return field;
    }
    public void setField(double[][] field) {
        this.field = field;
    }
}