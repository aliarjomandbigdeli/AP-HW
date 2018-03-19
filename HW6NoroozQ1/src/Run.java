import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        System.out.println("Run..");


        System.out.println("Define the first matrix (X):");

        Matrix X = new Matrix();
        X.getValues();
        X.showMat();
        System.out.println("Define the second matrix (Y):");
        Matrix Y = new Matrix();
        Y.getValues();
        Y.showMat();

        System.out.println("Result:");
        X.add(Y).showMat();
        System.out.println("Result:");
        X.sub(Y).showMat();


        String number = "-10";
        int result = Integer.parseInt(number);
        System.out.println(result);


        Scanner inputStream = new Scanner(System.in);
        int dim = inputStream.nextInt();
        int[][] arr2d = new int[dim][];
        arr2d[0] =new int[3];
        arr2d[0][1]=9;
        System.out.println(arr2d[0][1]);


    }



}
