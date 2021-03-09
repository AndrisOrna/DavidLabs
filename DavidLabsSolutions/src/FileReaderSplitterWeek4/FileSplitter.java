package FileReaderSplitterWeek4;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileSplitter {

    public static void splitFile(String [] words, int numFile)
    {
        if (numFile > words.length)
            numFile = words.length;

        File [] files = new File[numFile];

        for(int i = 0; i < files.length; i++)
        {
            files[i] = new File("file" + (i+1)+".txt");
        }

        int partion = words.length/numFile;

        for(int i = 0; i < numFile; i++)
        {
            try {
                PrintWriter pw = new PrintWriter(files[i]);

                for (int j = (i * partion); j < ((i + 1) * partion); j++){

                    pw.println(words[j]);

                }
                pw.close();//save filewords

            }
            catch(Exception e)
            {
                System.out.println("PW Exception");
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        File f = new File("text.txt");

        String words = "";

        try {
            Scanner sc = new Scanner(f);

            while(sc.hasNextLine())
            {
                words = words + sc.nextLine();
                words = words.replace("'","");
                words = words.replace("\"","");
                words = words.replace(".","");
                words = words.replace(",","");
                words = words.replace("!","");
            }

            String [] wordsArray = words.split(" ");

            splitFile(wordsArray, 300);

        }
        catch (Exception e)
        {
            System.out.println("Scanner Exception");
            e.printStackTrace();
        }


    }
}
