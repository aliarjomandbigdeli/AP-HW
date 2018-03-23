import java.util.Scanner;

/**
 * this class is for running code that get two matrices and an expression of them and show the result
 *
 * @author Ali ArjomandBigdeli
 * @since 3.22.2018
 */
public class Run {
    public static void main(String[] args) {
        System.out.println("Run..");


        System.out.println("Define the first matrix (X):");
        Matrix X = new Matrix();
        X.userDefine();
        System.out.println("Define the second matrix (Y):");
        Matrix Y = new Matrix();
        Y.userDefine();


        System.out.println("Enter your polynomial expression:");
        Scanner inputStream = new Scanner(System.in);
        String line = inputStream.nextLine();

        if (!line.contains("X") && !line.contains("Y")) {
            throw new RuntimeException("incorrect variable");
        }

        int indexOfOperator = -1;
        int indexOfX = -1;
        int indexOfY = -1;
        char operator = ' ';
        double firstCoefficient = 0;
        double secondCoefficient = 0;

        line = line.replace("(", "");
        line = line.replace(")", "");
        line = line.replace(" ", "");

        System.out.println(line);

        indexOfX = line.lastIndexOf("X");
        //System.out.println("indexOfX: " + indexOfX);
        indexOfY = line.lastIndexOf("Y");
        //System.out.println("indexOfY: " + indexOfY);
        int minIndex = indexOfX < indexOfY ? indexOfX : indexOfY;
        int maxIndex = indexOfX > indexOfY ? indexOfX : indexOfY;

        if (line.contains("X")) {
            String line2 = line.replace("X", "");
            if (line.length() - line2.length() == 2)
                throw new RuntimeException("Duplicate variable");
        }
        if (line.contains("Y")) {
            String line2 = line.replace("Y", "");
            if (line.length() - line2.length() == 2)
                throw new RuntimeException("Duplicate variable");
        }

        if (indexOfX != -1 && indexOfY != -1) {
            String operatorStr = "";
            operatorStr = line.substring(minIndex, maxIndex);
            operator = line.charAt(minIndex + 1);
            if (operator != '*' && operator != '+' && operator != '-') {
                System.err.println("Incorrect expression(operator)");
                throw new RuntimeException("Incorrect expression(operator)");
            }
            indexOfOperator = minIndex + 1;
            //System.out.println("operator: " + operator);
        }


        if (indexOfOperator == -1) {
            String number = "";
            number = line.substring(0, line.length() - 1);
            firstCoefficient = Double.parseDouble(number);

            if (line.charAt(line.length() - 1) == 'X') {
                System.out.println("Result:");
                X.constMul(firstCoefficient).showMat();
            } else if (line.charAt(line.length() - 1) == 'Y') {
                System.out.println("Result:");
                Y.constMul(firstCoefficient).showMat();
            } else {
                System.err.println("Incorrect expression");
            }
        } else {
            String number = "";
            number = line.substring(0, minIndex);
            firstCoefficient = Double.parseDouble(number);

            String number2 = "";
            number2 = line.substring(indexOfOperator + 1, maxIndex);
            secondCoefficient = Double.parseDouble(number2);

            System.out.println("Result:");
            if (indexOfX < indexOfY) {
                if (operator == '+') {
                    X.constMul(firstCoefficient).add(Y.constMul(secondCoefficient)).showMat();
                } else if (operator == '-') {
                    X.constMul(firstCoefficient).sub(Y.constMul(secondCoefficient)).showMat();
                } else if (operator == '*') {
                    X.constMul(firstCoefficient).mul(Y.constMul(secondCoefficient)).showMat();
                }
            } else {
                if (operator == '+') {
                    Y.constMul(firstCoefficient).add(X.constMul(secondCoefficient)).showMat();
                } else if (operator == '-') {
                    Y.constMul(firstCoefficient).sub(X.constMul(secondCoefficient)).showMat();
                } else if (operator == '*') {
                    Y.constMul(firstCoefficient).mul(X.constMul(secondCoefficient)).showMat();
                }
            }

        }


    }


}
