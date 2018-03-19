import java.util.ArrayList;
import java.util.Scanner;

public class Matrix {
    private ArrayList<ArrayList<Double>> mat;

    private Matrix(ArrayList<ArrayList<Double>> mat) {
        this.mat = mat;
    }

    public Matrix() {
        mat = new ArrayList<ArrayList<Double>>();
    }

    public ArrayList<ArrayList<Double>> getMat() {
        return mat;
    }

    public void setMat(ArrayList<ArrayList<Double>> mat) {
        this.mat = mat;
    }

    public Matrix add(Matrix b) {
        ArrayList<ArrayList<Double>> addMat = new ArrayList<ArrayList<Double>>();
        for (int i = 0; i < mat.size(); i++) {
            ArrayList<Double> row = new ArrayList<>();
            addMat.add(row);
            for (int j = 0; j < mat.get(i).size(); j++) {
                addMat.get(i).add(mat.get(i).get(j) + b.mat.get(i).get(j));
            }
        }
        return new Matrix(addMat);
    }

    public Matrix sub(Matrix b) {
        ArrayList<ArrayList<Double>> subMat = new ArrayList<ArrayList<Double>>();
        for (int i = 0; i < mat.size(); i++) {
            ArrayList<Double> row = new ArrayList<>();
            subMat.add(row);
            for (int j = 0; j < mat.get(i).size(); j++) {
                subMat.get(i).add(mat.get(i).get(j) - b.mat.get(i).get(j));
            }
        }
        return new Matrix(subMat);
    }

    public  void getValues(){
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
    }


    public void showMat() {
        for (int i = 0; i < mat.size(); i++) {
            for (int j = 0; j < mat.get(i).size(); j++) {
                System.out.print(mat.get(i).get(j) + ", ");
            }
            System.out.println();
        }
    }

}
