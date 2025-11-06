package example;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        try {
            ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "dir");
            //En linux new ProccessBuilder("ls", "-l");
            Process proceso = pb.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader((proceso.getInputStream())));

            String linea;

            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }

            int exitCode = proceso.waitFor();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
