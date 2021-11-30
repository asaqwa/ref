package IOStream.ByteArrayInputStreamAsBuffer;

import java.io.*;

/*
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String file1 = "workout\\1.txt";
        String file2 = "workout\\2.txt";

//    try (BufferedReader r = new BufferedReader(new InputStreamReader(System.in))) {
//      file1 = r.readLine();
//      file2 = r.readLine();
//    }

        byte[] buffer = null;

        try (FileInputStream firstFileStream = new FileInputStream(file1)) {
            buffer = new byte[firstFileStream.available()];
            firstFileStream.read(buffer);
        }

        try (FileInputStream secondFileStream = new FileInputStream(file2);
             FileOutputStream fileOutput = new FileOutputStream(file1)) {
            while (secondFileStream.available()>0) fileOutput.write(secondFileStream.read());
            fileOutput.write(buffer);
        }
    }
}
