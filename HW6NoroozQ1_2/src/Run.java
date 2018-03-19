import java.util.ArrayList;
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

        System.out.println("Result:");
        X.add(Y).showMat();
        System.out.println("Result:");
        X.sub(Y).showMat();
        System.out.println("Result:");
        X.mul(Y).showMat();
        System.out.println("Result:");
        X.constMul(4).showMat();


        Scanner inputStream = new Scanner(System.in);
        String line = inputStream.nextLine();




//        int indexOfOperator = 0;
//        int indexOfX = 0;
//        int indexOfY = 0;
//        int nextIndexOfComma = 0;
//
//        ArrayList<Double> row = new ArrayList<>();
//        matList.add(row);
//
//        for (int i = 0; i < line.length(); i++) {
//            if (line.charAt(i) == ',') {
//                nextIndexOfComma = i;
//                String number = "";
//                if (indexOfComma == 0)
//                    number = line.substring(indexOfComma, nextIndexOfComma);
//                else
//                    number = line.substring(indexOfComma + 1, nextIndexOfComma);
//
//                matList.get(lineCount).add(Double.parseDouble(number));
//            }
//            indexOfComma = nextIndexOfComma;
//        }
//
//        int lastIndexOfComma = line.lastIndexOf(",");
//        String lastNumber = line.substring(lastIndexOfComma + 1);
//        matList.get(lineCount).add(Double.parseDouble(lastNumber));




//        String number = "-10";
//        int result = Integer.parseInt(number);
//        System.out.println(result);



    }



}
