package task2;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ReadWriteFile {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("fileReader.csv"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("fileWriter.csv"));

        List<Customer> customers = new ArrayList<>();
        String line = "";
        while ((line = reader.readLine()) != null) {

            String[] data = line.split(",");
            Customer customer = new Customer();
            customer.setName(data[0]);
            customer.setPhone(data[1]);
            customer.setScore(Integer.parseInt(data[2]));
            customers.add(customer);
        }
            List<Customer> collect = customers.stream()
                    .sorted(Comparator.comparingInt(Customer::getScore))
                    .collect(Collectors.toList());

            for (Customer cust : collect) {
                writer.write(cust.getName()+",");
                writer.write(cust.getPhone()+",");
                writer.write(cust.getScore()+",");
            }


        reader.close();
        writer.close();
    }
}
