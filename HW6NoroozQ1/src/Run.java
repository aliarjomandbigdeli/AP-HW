import java.util.ArrayList;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        System.out.println("Run..");

        ArrayList<String> words = new ArrayList<String>();
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

            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == ',') {
                    nextIndexOfComma = i;
                    String word = "";
                    if (indexOfComma == 0)
                        word = line.substring(indexOfComma, nextIndexOfComma);
                    else
                        word = line.substring(indexOfComma + 1, nextIndexOfComma);
                    words.add(word);
                }
                indexOfComma = nextIndexOfComma;
            }

            int lastIndexOfComma = line.lastIndexOf(",");
            String lastWord = line.substring(lastIndexOfComma + 1);
            words.add(lastWord);


            ++lineCount;
        }


    }
}
