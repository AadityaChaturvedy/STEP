import java.util.Random;
import java.util.Arrays;

public class MatrixOperations {

    private static final Random random = new Random();

    public static double[][] createRandomMatrix(int rows, int cols) {
        if (rows <= 0 || cols <= 0) {
            System.err.println("Error: Matrix dimensions must be positive.");
            return null;
        }
        double[][] matrix = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(10); // Random integers 0-9
            }
        }
        return matrix;
    }

    public static void displayMatrix(double[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            System.out.println("Matrix is null or empty.");
            return;
        }
        for (double[] row : matrix) {
            for (double element : row) {
                System.out.printf("%6.1f", element); // Adjusted formatting
            }
            System.out.println();
        }
        System.out.println();
    }

    public static double[][] addMatrices(double[][] matrixA, double[][] matrixB) {
        if (matrixA == null || matrixB == null ||
            matrixA.length != matrixB.length || matrixA[0].length != matrixB[0].length) {
            System.err.println("Error: Matrices must have the same dimensions for addition.");
            return null;
        }
        int rows = matrixA.length;
        int cols = matrixA[0].length;
        double[][] result = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
        return result;
    }

    public static double[][] subtractMatrices(double[][] matrixA, double[][] matrixB) {
        if (matrixA == null || matrixB == null ||
            matrixA.length != matrixB.length || matrixA[0].length != matrixB[0].length) {
            System.err.println("Error: Matrices must have the same dimensions for subtraction.");
            return null;
        }
        int rows = matrixA.length;
        int cols = matrixA[0].length;
        double[][] result = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrixA[i][j] - matrixB[i][j];
            }
        }
        return result;
    }

    public static double[][] multiplyMatrices(double[][] matrixA, double[][] matrixB) {
        if (matrixA == null || matrixB == null || matrixA[0].length != matrixB.length) {
            System.err.println("Error: Inner dimensions must match for multiplication (colsA == rowsB).");
            return null;
        }
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int colsB = matrixB[0].length;
        double[][] result = new double[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        return result;
    }

    public static double[][] transposeMatrix(double[][] matrix) {
        if (matrix == null || matrix.length == 0) return null;
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] transpose = new double[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        return transpose;
    }

    public static void main(String[] args) {
        System.out.println("--- Simplified Matrix Operations ---");

        // Create two 2x3 matrices
        System.out.println("Matrix P (2x3):");
        double[][] matrixP = createRandomMatrix(2, 3);
        displayMatrix(matrixP);

        System.out.println("Matrix Q (2x3):");
        double[][] matrixQ = createRandomMatrix(2, 3);
        displayMatrix(matrixQ);

        // Create a 3x2 matrix
        System.out.println("Matrix R (3x2):");
        double[][] matrixR = createRandomMatrix(3, 2);
        displayMatrix(matrixR);

        // Addition (P + Q)
        System.out.println("--- Addition (P + Q) ---");
        double[][] sumPQ = addMatrices(matrixP, matrixQ);
        displayMatrix(sumPQ);

        // Subtraction (P - Q)
        System.out.println("--- Subtraction (P - Q) ---");
        double[][] diffPQ = subtractMatrices(matrixP, matrixQ);
        displayMatrix(diffPQ);

        // Multiplication (P * R)
        System.out.println("--- Multiplication (P * R) ---");
        double[][] productPR = multiplyMatrices(matrixP, matrixR);
        displayMatrix(productPR); // Result should be 2x2

        // Transpose (P)
        System.out.println("--- Transpose (P) ---");
        double[][] transposeP = transposeMatrix(matrixP);
        displayMatrix(transposeP); // Result should be 3x2

        // Transpose (R)
        System.out.println("--- Transpose (R) ---");
        double[][] transposeR = transposeMatrix(matrixR);
        displayMatrix(transposeR); // Result should be 2x3
    }
}
