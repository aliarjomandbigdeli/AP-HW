import java.util.ArrayList;
import java.util.Scanner;

/**
 * this class models matrix and it's operations like add, subtract, multiplication
 *
 * @author Ali ArjomandBigdeli
 * @since 3.22.2018
 */
public class Matrix {
    private double[][] mat;
    private int rows;
    private int cols;

    /**
     * constructor
     */
    public Matrix() {
    }

    /**
     * private constructor to use in userDefine method for doing 'new'
     *
     * @param rows number of rows
     * @param cols number of columns
     */
    private Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        mat = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            mat[i] = new double[cols];
        }
    }


    /**
     * getter of mat 2DArray
     *
     * @return mat 2DArray
     */
    public double[][] getMat() {
        return mat;
    }

    /**
     * getter of rows
     *
     * @return rows, number of rows
     */
    public int getRows() {
        return rows;
    }

    /**
     * getter of number of columns
     *
     * @return cols, number of columns
     */
    public int getCols() {
        return cols;
    }

    /**
     * add operation of matrices
     *
     * @param b second operand of adding
     * @return result appear in a third matrix
     */
    public Matrix add(Matrix b) {
        if (rows == b.rows && cols == b.cols) {
            Matrix c = new Matrix(rows, b.getCols());
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < b.getCols(); j++) {
                    c.getMat()[i][j] = mat[i][j] + b.getMat()[i][j];
                }
            }
            return c;
        } else {
            throw new RuntimeException("Dimensions don't match");
        }
    }

    /**
     * subtracting operation of matrices
     *
     * @param b second operand of subtracting
     * @return result appear in a third matrix
     */
    public Matrix sub(Matrix b) {
        if (rows == b.rows && cols == b.cols) {
            Matrix c = new Matrix(rows, b.getCols());
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < b.getCols(); j++) {
                    c.getMat()[i][j] = mat[i][j] - b.getMat()[i][j];
                }
            }
            return c;
        } else {
            throw new RuntimeException("Dimensions don't match");
        }
    }

    /**
     * multiplication operation of matrices
     *
     * @param b second operand of multiplication
     * @return result appear in a third matrix
     */
    public Matrix mul(Matrix b) {
        if (cols == b.rows) {
            Matrix c = new Matrix(rows, b.getCols());
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < b.getCols(); j++) {
                    for (int k = 0; k < cols; k++) {
                        c.getMat()[i][j] += mat[i][k] * b.getMat()[k][j];
                    }

                }
            }
            return c;
        } else {
            throw new RuntimeException("Dimensions don't match");
        }
    }

    /**
     * multiplication of constant number with a matrix
     *
     * @param b constant number
     * @return result appear in a third matrix
     */
    public Matrix constMul(double b) {
        Matrix c = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                c.getMat()[i][j] = mat[i][j] * b;
            }
        }
        return c;
    }

    /**
     * user can initialize a matrix with this method
     */
    public void userDefine() {
        int lineCount = 0;

        ArrayList<ArrayList<Double>> matList = new ArrayList<ArrayList<Double>>();
        Scanner inputStream = new Scanner(System.in);
        String line = inputStream.nextLine();

        while (true) {
            if (lineCount > 0)
                line = inputStream.nextLine();
            if (line.length() == 0)
                break;

            int indexOfComma = 0;
            int nextIndexOfComma = 0;

            ArrayList<Double> row = new ArrayList<>();
            matList.add(row);

            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == ',') {
                    if (line.charAt(i + 1) == ','){
                        throw new RuntimeException("Additional comma");
                    }
                    nextIndexOfComma = i;
                    String number = "0";
                    if (indexOfComma == 0)
                        number = line.substring(indexOfComma, nextIndexOfComma);
                    else
                        number = line.substring(indexOfComma + 1, nextIndexOfComma);

                    matList.get(lineCount).add(Double.parseDouble(number));
                }
                indexOfComma = nextIndexOfComma;
            }

            int lastIndexOfComma = line.lastIndexOf(",");
            String lastNumber = line.substring(lastIndexOfComma + 1);
            matList.get(lineCount).add(Double.parseDouble(lastNumber));

            ++lineCount;
        }

        rows = matList.size();
        cols = matList.get(0).size();
        mat = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            mat[i] = new double[cols];
        }

        for (int i = 0; i < rows; i++) {
            if (cols != matList.get(i).size()) {
                throw new RuntimeException("Dimensions don't match");
            }
            for (int j = 0; j < cols; j++) {
                mat[i][j] = matList.get(i).get(j);
            }
        }

    }


    /**
     * this shows a matrix
     */
    public void showMat() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (j == cols - 1)
                    System.out.print(mat[i][j]);
                else
                    System.out.print(mat[i][j] + ", ");
            }
            System.out.println();
        }
    }

}
