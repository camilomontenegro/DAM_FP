package Claude_ex2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Type a project name: ");
            String userCmd = sc.nextLine();

            String command = "mkdir " + userCmd + "\\src " + userCmd + "\\bin " + userCmd + "\\docs " + userCmd + "\\resources ";

            ProcessBuilder pb = new ProcessBuilder("cmd", "/c", command);
            Process p = pb.start();
            p.waitFor();
            System.out.println("Project structure created sucessfully!");

            /*BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }*/

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
