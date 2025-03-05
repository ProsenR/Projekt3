package Kap11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TextDemo {

    public static void main(String[] args) throws IOException {

        String fileName = "Dateien.txt";
        byte[] bytes = Files.readAllBytes(Path.of(fileName));

    }
}
