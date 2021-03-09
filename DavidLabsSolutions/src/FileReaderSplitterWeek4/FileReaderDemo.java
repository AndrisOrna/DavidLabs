package FileReaderSplitterWeek4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReaderDemo {

    public static void readFromFile(String dir) throws FileNotFoundException {

        File f = new File(dir);

        Scanner sc = new Scanner(f);

        System.out.println("file loaded");

        int count = 0;

        while(sc.hasNext())
        {
            String temp = sc.next();

            temp = temp.replace("'","");
            temp = temp.replace("\"","");
            temp = temp.replace(".","");
            temp = temp.replace(",","");
            temp = temp.replace("!","");

            if(count % 5 == 0)
            {
                System.out.println(temp);
            }

            count++;
        }

    }


    public static void main(String[] args) {

        String dir = "text.txt";

        try {
            readFromFile(dir);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("file not found");

        }
        catch (Exception e) {
            e.printStackTrace();
        }





    }
}
