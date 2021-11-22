package task4;

import task2.Customer;

import java.io.*;

public class SerializeCustomer   {
    public static void main(String[] args) {
        serializeCustomer();
        System.out.println(deserializeCustomer());

    }

    public static void serializeCustomer() {
        Customer customer = new Customer("Ani", "+37455-55-55-55", 6,"558778445");
        String name = customer.getName();
        int score = customer.getScore();
        FileOutputStream fileOut = null;
        ObjectOutputStream out = null;
        try {
            fileOut = new FileOutputStream("fileWrite.txt");
            out = new ObjectOutputStream(fileOut);
            out.writeObject(name);
            out.writeObject(score);
            fileOut.close();
            out.close();
            System.out.println("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static String deserializeCustomer() {
        FileInputStream fileIn = null;
        ObjectInputStream in = null;
        try {
            fileIn = new FileInputStream("fileWrite.txt");
            in = new ObjectInputStream(fileIn);
           Object customer= in.readObject();

            in.close();
            fileIn.close();
            return customer.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
