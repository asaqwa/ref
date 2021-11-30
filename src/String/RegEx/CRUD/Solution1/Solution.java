package String.RegEx.CRUD.Solution1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

/*
Прайсы
CRUD для таблицы внутри файла.
Напиши программу, которая считывает с консоли путь к файлу для операций CRUD и при запуске со следующим набором параметров:
-c productName price quantity
добавляет товар с заданными параметрами в конец файла, генерируя id (8 символов) самостоятельно путем инкремента максимального id, найденного в файле.

Значения параметров:
-c - флаг, который означает добавления товара.
productName - название товара, 30 символов.
price - цена, 8 символов.
quantity - количество, 4 символа.

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity

Данные дополнены пробелами до их длины.

Для чтения и записи файла нужно использовать FileReader и FileWriter соответственно.

Пример содержимого файла:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234

*/

public class Solution {
    public static void main(String[] args) throws Exception {

        args = new String[] {"-c", "Herd", "В", "файле", "данные", "хранятся", "в следующей последовательности", "1234,67890", "1234567"};

        if (args == null || args.length == 0) return;
        if ("-c".equals(args[0])) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            // String fileName = reader.readLine();
            reader.close();

            try (BufferedReader fReader = new BufferedReader(new FileReader("workout\\Products.txt"));
                 FileWriter fWriter = new FileWriter("workout\\Products.txt", true)) {
                int maxId = Integer.MIN_VALUE;


                while (fReader.ready()) {
                    String lastLine = fReader.readLine();
                    if (lastLine.isEmpty()) {
                        System.out.println("the line is empty");
                        break;
                    }
                    int id = Integer.parseInt(lastLine.substring(0, 8).trim());
                    if (id > maxId) maxId = id;
                }

                StringBuilder name = new StringBuilder();
                for (int i = 1; i<args.length-2; i++) {
                    name.append(args[i]).append(" ");
                }
                String newLine = String.format("\r\n%-8d%-30s%-8s%-4s", ++maxId,
                        name.length()>30? name.substring(0, 30) : name,
                        args[args.length-2].length()>8? args[args.length-2].substring(0, 8) : args[args.length-2],
                        args[args.length-1].length()>4? args[args.length-1].substring(0, 4) : args[args.length-1] );
                System.out.println(newLine);
                //fWriter.write(newLine);
            }
        }
    }
}
