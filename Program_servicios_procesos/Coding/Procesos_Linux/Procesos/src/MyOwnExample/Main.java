package MyOwnExample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        try {
            ProcessBuilder pb = new ProcessBuilder("wsl", "bash", "-lc", "ls -l");
            Process p = pb.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            p.waitFor();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
