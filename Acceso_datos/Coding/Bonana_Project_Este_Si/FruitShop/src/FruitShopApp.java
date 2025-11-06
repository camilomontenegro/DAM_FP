import java.util.ArrayList;
import java.util.Scanner;

public class FruitShopApp {

    private static ArrayList<Fruit> inventory = new ArrayList<>();

    private static Scanner sc = new Scanner(System.in);

    private static final String FILE_PATH = "data/fruits.txt";

    //contador para generar IDs únicos
    private static int nextId = 1;


    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║         Frutería Mari-CarMen       ║");
        System.out.println("╚════════════════════════════════════╝");
        System.out.println();
    }
}
