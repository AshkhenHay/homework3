package task1;


import java.io.*;
import java.net.URL;

public class BufferdInputStream {


    public static void getPage(String address) throws IOException {
        URL url = new URL(address);

        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

        BufferedWriter writer = new BufferedWriter(new FileWriter("Download.html"));

        String line;
        while ((line = reader.readLine()) != null) {
            writer.write(line);
        }
        reader.close();
        writer.close();

    }

    public static void main(String[] args) {
        try {
            getPage("http://www.example.com/");

        } catch (Exception ex) {
            System.out.println("ERROR");
        }
    }

}



