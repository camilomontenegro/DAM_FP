package Claude_exercises1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        try {
            ProcessBuilder pb = new ProcessBuilder("wsl", "bash", "-lc", "ifconfig");
            Process p = pb.start();

            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader er = new BufferedReader(new InputStreamReader(p.getErrorStream()));

            String line;

            while ((line = er.readLine()) != null) {
                System.out.println(line);
            }

            while ((line = br.readLine()) != null) {
                if (line.contains("inet")) {
                    System.out.println(line.trim());
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
