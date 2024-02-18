package net.mp3skater.main;

public class Main {
    public static void main(String[] args) {

        Matrix matrix = new Matrix(2);

        matrix.fillMatrix();
        matrix.printMatrix();

        System.out.print("\nGet Determinant from matrix: " + matrix.getDet() + "\n");

        Matrix newM = matrix.getExceptMatrix(1,1);
        System.out.print("\nGet Sub-matrix(1,1) from matrix:\n");
        newM.printMatrix();

        System.out.print("\nGet 2*2 from matrix: " + newM.getDet());

        matrix.add(matrix);
        matrix.printMatrix();

        matrix.mul(matrix);
        matrix.printMatrix();

        matrix.div(matrix);
        matrix.printMatrix();

        matrix.sub(matrix);
        matrix.printMatrix();
    }
}