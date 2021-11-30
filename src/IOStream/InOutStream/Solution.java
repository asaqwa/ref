package IOStream.InOutStream;


import java.io.*;

/*
Переопределение сериализации в потоке

package com.javarush.task.task20.task2022;
*/

public class Solution implements Serializable, AutoCloseable {

    public static void main(String[] args) {
        try (Solution solution = new Solution("workout\\object.txt")){
            solution.writeObject("String");
            ByteArrayOutputStream buf = new ByteArrayOutputStream();
            ObjectOutputStream outputStream = new ObjectOutputStream(buf);
            outputStream.writeObject(solution);

            ObjectInputStream load = new ObjectInputStream(new ByteArrayInputStream(buf.toByteArray()));
            try (Solution sol2 = (Solution) load.readObject()) {
                sol2.writeObject("new string");
            }

            outputStream.close();
            load.close();

            buf.close();  // https://docs.oracle.com/javase/6/docs/api/java/io/ByteArrayOutputStream.html#close()
//      Closing a ByteArrayOutputStream has no effect.
//            To release the memory, make sure there are no references to it and let the Garbage Collector do its thing. Just like with any other normal object.
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private transient FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }
}
