import java.util.ArrayList;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        System.out.println("Run..");

        //ArrayList<String> words = new ArrayList<String>();
        ArrayList<ArrayList<Double>> mat = new ArrayList<ArrayList<Double>>();

        int lineCount = 0;


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
            mat.add(row);

            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == ',') {
                    nextIndexOfComma = i;
                    String number = "";
                    if (indexOfComma == 0)
                        number = line.substring(indexOfComma, nextIndexOfComma);
                    else
                        number = line.substring(indexOfComma + 1, nextIndexOfComma);

                    mat.get(lineCount).add(Double.parseDouble(number));
                }
                indexOfComma = nextIndexOfComma;
            }

            int lastIndexOfComma = line.lastIndexOf(",");
            String lastNumber = line.substring(lastIndexOfComma + 1);
            mat.get(lineCount).add(Double.parseDouble(lastNumber));

            ++lineCount;
        }




        for (int i = 0; i < mat.size(); i++) {
            for (int j = 0; j < mat.get(i).size(); j++) {
                System.out.print(mat.get(i).get(j) + ", ");
            }
            System.out.println();
        }


        String number = "-10";
        int result = Integer.parseInt(number);
        System.out.println(result);

    }
}
