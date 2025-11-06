package example5;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "dir");
            pb.directory(new File("C:\\Users\\camil\\Escritorio\\DAM-FP\\2do\\Shared\\DAMFP\\Program_servicios_procesos\\dir"));
            pb.inheritIO();
            pb.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
