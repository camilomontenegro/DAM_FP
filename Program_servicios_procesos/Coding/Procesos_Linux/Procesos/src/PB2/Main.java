package PB2;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            ProcessBuilder pb = new ProcessBuilder("cmd","/c","dir");
            pb.redirectOutput(new File("resultado.txt"));
            pb.redirectError(new File("Errores.txt"));
            pb.start();
            System.out.println("Comando ejecutado. Revisa en el .txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
