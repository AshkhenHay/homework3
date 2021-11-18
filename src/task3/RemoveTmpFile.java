package task3;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class RemoveTmpFile {


    public static void main(String[] args) {
        String path = "C:\\Users\\user\\Downloads";
        File file = new File(path);
        List<String> fileNameList = new ArrayList<>();
        if (file.isDirectory()) {

            File[] files = file.listFiles();
            for (File file1 : files) {
                String name = file1.getName();
                String substring = name.substring(name.lastIndexOf(".") + 1);
                if (substring.equals("tmp")) {
                    file1.delete();
                } else {
                    fileNameList.add(file1.getName());
                }

            }
        }

    }

}