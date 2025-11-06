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

        //createDataFolder();
        boolean exit = false;

        while (!exit) {
            showMenu();
            int userChoice = readUserChoice();
            System.out.println();

            switch (userChoice) {
                case 1 -> addFruit();
                /*case 2 -> listFruits();
                case 3 -> exportToFile();
                case 4 -> importFromFile();*/
                case 5 -> {
                    exit = true;
                    System.out.println("Hasta luego Mari Loli!");
                }
                default -> System.out.println("Opción no válida, vuelve a elegir");
            }
            System.out.println();
        }
        sc.close();
    }

    private static void showMenu() {
        System.out.println("════════════════════════════════════");
        System.out.println("MENU: \n1. Añadir fruta al inventario \n2. Listar frutas en inventario \n3. Exportar a TXT \n4. Importar desde TXT \n5. salir");
        System.out.println("════════════════════════════════════");
        System.out.print("Selecciona opción: ");
    }

    private static int readUserChoice() {
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static String addFruit() {
        return "";
    }
}
