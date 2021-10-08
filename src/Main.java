import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = fileRead("numbers.txt");
        int max = findMax(numbers);
        writeMax("max.txt", max);
    }
    public  static List<Integer> fileRead(String url){
        List<Integer> numbers = new ArrayList<>();
        File file;
        try {
            file = new File(url);
            if (!file.exists()){
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null){
                numbers.add(Integer.parseInt(line));
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  numbers;
    }
    public static int findMax(List<Integer> arr){
        int max = arr.get(0);
        for (int i = 0; i < arr.size(); i++) {
            if (max < arr.get(i)){
                max = arr.get(i);
            }
        }
        return max;
    }
    public static void writeMax (String url , int max){
        File file;
        try {
            file = new File(url);
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Giá trị lớn nhất là: " + max);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
