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


//        String number = "-10";
//        int result = Integer.parseInt(number);
//        System.out.println(result);



    }



}
