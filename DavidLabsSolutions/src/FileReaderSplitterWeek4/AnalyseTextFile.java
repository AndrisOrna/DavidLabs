package FileReaderSplitterWeek4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AnalyseTextFile {

    public static int processVowels(String word) {


        int count = 0;

        word = word.toLowerCase();

        for (char c : word.toCharArray())
        {
            if (c =='a' || c =='e' || c =='i' || c =='o' || c =='u')
            {
                count++;
            }
        }

        return count;

    }

    public static void main(String[] args) throws FileNotFoundException {

        File f =  new File("text.txt");

        Scanner sc = new Scanner(f);

        double countWords = 0;
        double numVowels = 0;


        while(sc.hasNext())
        {
            String temp = sc.next();

            temp = temp.replace("'","");
            temp = temp.replace("\"","");
            temp = temp.replace(".","");
            temp = temp.replace(",","");
            temp = temp.replace("!","");

            System.out.println(temp);
            numVowels = numVowels + processVowels(temp);

            countWords++;
        }
        System.out.println("Number of words" + countWords);
        System.out.println("Number of vowels" + numVowels);
        System.out.println("Number of vowels per word is: " + (numVowels/countWords));
    }


}
