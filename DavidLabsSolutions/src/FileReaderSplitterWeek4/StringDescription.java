package FileReaderSplitterWeek4;

import java.util.Scanner;

public class StringDescription {

    public static void main (String [] args)
    {
        System.out.println("Please enter a word");
        Scanner sc = new Scanner(System.in);
        String word = sc.next();

        processWord(word);

    }

    public static void processWord(String word) {

        System.out.println("Word Length: " + word.length());
        System.out.println("First Letter: " + word.charAt(0));
        System.out.println("Last Letter: " + word.charAt(word.length()-1));

        processVowels(word);

    }

    public static void processVowels(String word) {

        int count = 0;

        word = word.toLowerCase();

        for (char c : word.toCharArray())
        {
            if (c =='a' || c =='e' || c =='i' || c =='o' || c =='u')
            {
                count++;
            }
        }

        System.out.print("Number of Vowels: " + count);

    }
}

