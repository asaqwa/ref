package String.CharSet;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Test {
    static void mainMethod(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]), "Windows-1251"));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1]), StandardCharsets.UTF_8))) {

            String s;
            while ((s = reader.readLine()) != null) {
                writer.write(s + "\n");
            }
        }
    }

    public static void myMain(String[] args) throws IOException {
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(args[0]), "Windows-1251") ;
             FileWriter writer = new FileWriter(args[1])) {
            while (reader.ready()) writer.write(reader.read());
        }
    }


    static void readingWriting() throws Exception {
        InputStream inputStream = new FileInputStream("filename");
        OutputStream outputStream = new PrintStream(System.out);
        Charset koi8 = Charset.forName("KOI8-R");
        Charset windows1251 = Charset.forName("Windows-1251");

        byte[] buffer = new byte[1000];
        inputStream.read(buffer);
        String s = new String(buffer, koi8);
        buffer = s.getBytes(windows1251);
        outputStream.write(buffer);
    }

    /*
    *
    *   SortedMap<String,Charset> charsets = Charset.availableCharsets();
    *
    *   Charset currentCharset = Charset.defaultCharset();
    *
    *   byte[] getBytes()
    *
    *   byte[] getBytes(Charset charset)   byte[] getBytes(String charsetName)
    *
    *   String(byte bytes[])      String(byte bytes[], Charset charset)     String(byte bytes[], String charsetName)
    *
    * */
}
