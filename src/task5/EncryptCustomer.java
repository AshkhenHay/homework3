package task5;

import task2.Customer;

import java.io.*;
import java.util.Base64;

public class EncryptCustomer {
    public static void main(String[] args) {
        Customer customer = encodeCustomer();

        decodeCustomer(customer);
    }

    private static void decodeCustomer(Customer customer) {
        try {

            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("cardNumber.txt"));


            Customer customer1 = (Customer) inputStream.readObject();

            byte[] decode = Base64.getDecoder().decode(customer1.getCardNumber());
            String dencodeString = new String(decode);
            System.out.println(dencodeString);
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();


        }
    }

    private static Customer encodeCustomer() {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("cardNumber.txt"));
            Customer customer = new Customer("Anna", "+374 55  55 44 66", 5, "1122333");
            String encode = Base64.getEncoder().encodeToString(customer.getCardNumber().getBytes());
            customer.setCardNumber(encode);
            outputStream.writeObject(customer);
            return customer;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
