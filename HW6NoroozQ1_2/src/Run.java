import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        System.out.println("Run..");


        System.out.println("Define the first matrix (X):");

        Matrix X = new Matrix();
        X.userDefine();
        System.out.println("Define the second matrix (Y):");
        Matrix Y = new Matrix();
        Y.userDefine();

//        System.out.println("Result:");
//        X.add(Y).showMat();
//        System.out.println("Result:");
//        X.sub(Y).showMat();
//        System.out.println("Result:");
//        X.mul(Y).showMat();
//        System.out.println("Result:");
//        X.constMul(4).showMat();

        System.out.println("Enter your polynomial expression:");
        Scanner inputStream = new Scanner(System.in);
        String line = inputStream.nextLine();


        int indexOfOperator = -1;
        int indexOfX = -1;
        int indexOfY = -1;
        char operator = ' ';
        double firstCoefficient = 0;
        double secondCoefficient = 0;



        indexOfX = line.lastIndexOf("X");
        System.out.println("indexOfX: " + indexOfX);
        indexOfY = line.lastIndexOf("Y");
        System.out.println("indexOfY: " + indexOfY);
        int minIndex = indexOfX < indexOfY ? indexOfX : indexOfY;
        int maxIndex = indexOfX > indexOfY ? indexOfX : indexOfY;

        if (indexOfX != -1 && indexOfY != -1) {
            String operatorStr = "";
            operatorStr = line.substring(minIndex, maxIndex);
            if (operatorStr.contains("*")) {
                indexOfOperator = line.lastIndexOf("*");
                operator = line.charAt(indexOfOperator);
            } else if (operatorStr.contains("+")) {
                indexOfOperator = line.lastIndexOf("+");
                operator = line.charAt(indexOfOperator);
            } else if (operatorStr.contains("-")) {
                indexOfOperator = line.lastIndexOf("-");
                operator = line.charAt(indexOfOperator);
            }
            System.out.println("operator: " + operator);
        }


        if (indexOfOperator == -1) {
            String number = "";
            if (line.charAt(0) == '(' && line.charAt(line.length() - 2) == ')') {
                number = line.substring(1, line.length() - 2);
                firstCoefficient = Double.parseDouble(number);

            } else {
                number = line.substring(0, line.length() - 1);
                firstCoefficient = Double.parseDouble(number);
            }

            if (line.charAt(line.length() - 1) == 'X') {
                System.out.println("Result:");
                X.constMul(firstCoefficient).showMat();
            } else if (line.charAt(line.length() - 1) == 'Y') {
                System.out.println("Result:");
                Y.constMul(firstCoefficient).showMat();
            }
        } else {
            String number = "";
            if (line.charAt(0) == '(' && line.charAt(minIndex - 1) == ')') {
                //System.out.println("Hello");
                number = line.substring(1, minIndex - 1);
                firstCoefficient = Double.parseDouble(number);

            } else {
                number = line.substring(0, minIndex);
                firstCoefficient = Double.parseDouble(number);
            }

            //work on bones mark
            String number2 = "";
            if (line.charAt(indexOfOperator + 1) == '(' && line.charAt(maxIndex - 1) == ')') {
                //System.out.println("Hello");
                number2 = line.substring(indexOfOperator + 2, maxIndex - 1);
                secondCoefficient = Double.parseDouble(number2);

            } else {
                number2 = line.substring(indexOfOperator + 1, maxIndex);
                secondCoefficient = Double.parseDouble(number2);
            }

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


        //matList.get(lineCount).add(Double.parseDouble(lastNumber));


//        String number = "-10";
//        int result = Integer.parseInt(number);
//        System.out.println(result);


    }


}
