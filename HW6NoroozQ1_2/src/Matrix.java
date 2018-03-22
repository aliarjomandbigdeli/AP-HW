import java.util.ArrayList;
import java.util.Scanner;

public class Matrix {
    private double[][] mat;
    private int rows;
    private int cols;


    public Matrix() {
    }

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        mat = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            mat[i] = new double[cols];
        }
    }

    public double[][] getMat() {
        return mat;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

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

    public Matrix constMul(double b) {
        Matrix c = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                c.getMat()[i][j] = mat[i][j] * b;
            }
        }
        return c;
    }


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
                    String number = "";
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
