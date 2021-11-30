package IOStream.WorkWithFiles;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
Сортировка четных чисел из файла
*/

public class ReadingWithScanner {
    public static void main(String[] args) throws Exception {
        // напишите тут ваш код
        InputStream in = System.in;
        System.setIn(new ByteArrayInputStream("workout\\numbers.txt".getBytes()));
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = consoleReader.readLine();
        consoleReader.close();
        System.setIn(in);

        ArrayList<Integer> evens = new ArrayList<>();
        Scanner fileScanner = new Scanner(new FileInputStream(fileName));
        while (fileScanner.hasNext()) {
            int i = fileScanner.nextInt();
            if ((i&1)==0) evens.add(i);
        }
        fileScanner.close();

        Collections.sort(evens);
        for (int i : evens) System.out.println(i);
    }
}
