package String.RegEx.CRUD.Solution2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
Прайсы 2
*/

public class Solution {
    public static void main(String[] args) {

        args = new String[] {"-d", "19847983", "В", "файле", "данные", "хранятся", "в следующей последовательности", "1234,67890", "1234567"};

        // if (args == null || args.length == 0) return;
        List<Product> products = new ArrayList<>();

        switch (args[0]) {
            case "-u":
                String fileName = "workout\\Products.txt";
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                    //fileName = reader.readLine();
                } catch (Exception ignore) {};

                try (BufferedReader fReader = new BufferedReader(new FileReader(fileName))) {
                    while (fReader.ready()) {
                        String newP = fReader.readLine();
                        products.add(new Product(newP));
                    }
                } catch (Exception ignore) {ignore.printStackTrace();}

                int id = Integer.parseInt(args[1]);
                StringBuilder name = new StringBuilder();
                for (int i = 2; i<args.length-2; i++) {
                    name.append(args[i]).append(" ");
                }
                Product newProdukt = new Product(args[args.length-2], args[args.length-1], id, name.toString());

                for (int i = 0 ; i < products.size(); i++) {
                    if (products.get(i).id == id) {
                        products.set(i, newProdukt);
                        break;
                    }
                }

                try (FileWriter fWriter = new FileWriter(fileName)) {
                    for (int i = 0 ; i < products.size(); i++) {
                        Product product = products.get(i);
                        String s = i != 0? ("\n" + product.toString()) : product.toString();
                        fWriter.write(s);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "-d":
                fileName = "workout\\Products.txt";
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                    //fileName = reader.readLine();
                } catch (Exception ignore) {};

                try (BufferedReader fReader = new BufferedReader(new FileReader(fileName))) {
                    while (fReader.ready()) {
                        String newP = fReader.readLine();
                        products.add(new Product(newP));
                    }
                } catch (Exception ignore) {ignore.printStackTrace();}

                id = Integer.parseInt(args[1]);
                for (int i = 0 ; i < products.size(); i++) {
                    if (products.get(i).id == id) {
                        products.remove(i);
                        break;
                    }
                }

                try (FileWriter fWriter = new FileWriter(fileName)) {
                    for (int i = 0 ; i < products.size(); i++) {
                        Product product = products.get(i);
                        String s = i != 0? ("\n" + product.toString()) : product.toString();
                        fWriter.write(s);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
        for (Product product : products) System.out.println(product);
    }


    public static class Product {
        int id;
        String name;
        String prise;
        String quantity;

        public Product(String prise, String quantity, int id, String ... names) {
            this.id = id;
            StringBuilder name = new StringBuilder();
            for (String line : names) name.append(line).append(" ");
            this.name = name.length()>30 ? name.substring(0, 30) : name.toString();
            this.prise = prise.length()>8 ? prise.substring(0, 8) : prise ;
            this.quantity = quantity.length()>4 ? quantity.substring(0, 4) : quantity ;
        }

        public Product(String productLine) {
            if (productLine == null || productLine.isEmpty() || productLine.length()<46) throw new IllegalArgumentException();
            id = Integer.parseInt(productLine.substring(0, 8).trim());
            name = productLine.substring(8, 38);
            prise = productLine.substring(38, 46);
            quantity = productLine.substring(46);
        }

        @Override
        public String toString() {
            return String.format("%-8d%-30s%-8s%-4s", id, name, prise, quantity);
        }
    }
}
