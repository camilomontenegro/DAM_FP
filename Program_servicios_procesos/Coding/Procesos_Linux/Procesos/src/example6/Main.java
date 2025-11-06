package example6;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            ProcessBuilder pb = new ProcessBuilder("notepad.exe");
            Process p = pb.start();
            System.out.println("Bloc de notas abierto");
            p.waitFor();
            System.out.println("Block de notas cerrado");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
