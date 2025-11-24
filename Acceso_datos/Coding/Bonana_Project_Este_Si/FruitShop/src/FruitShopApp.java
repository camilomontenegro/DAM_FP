import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FruitShopApp {

    private static List<Fruit> inventory = new ArrayList<>();

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
        File directory = new File("data");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        boolean exit = false;

        while (!exit) {
            showMenu();
            int userChoice = readUserChoice();
            System.out.println();

            switch (userChoice) {
                case 1 -> addFruit();
                case 2 -> listFruits();
                case 3 -> exportToFile();
                case 4 -> importFromFile();
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

    private static void addFruit() {
        double pricePerKg;
        int stock;
        System.out.println("\n=== AÑADIR FRUTA ===");
        System.out.print("Nombre: ");
        String name = sc.nextLine().trim();

        if (name.length() < 2) {
            System.out.println("🚫El nombre debe tener al menos 2 caracteres🚫");
            return;
        } else if (name.matches(".*\\d.*")) {
            System.out.println("🚫No puedes poner números🚫");
            return;
        }

        System.out.print("Precio/kg (0.00): ");

        try {
            pricePerKg = Double.parseDouble(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Pon un decimal!");
            return;
        }

        //Validation
        if (pricePerKg <= 0) {
            System.out.println("Tienes que poner un precio, no estamos regalando las fruticas!!!");
            return;
        }

        //Read stock
        System.out.print("Cantidad: ");

        try {
            stock = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Tienes que poner un entero!");
            return;
        }

        //validate
        if (stock <= 0) {
            System.out.println("¿Cómo vamos a añadir fruta al inventario si no pones ni una?");
            return;
        }

        //Create fruit

        Fruit fruit = new Fruit(nextId, name, pricePerKg, stock);
        inventory.add(fruit);
        nextId++;
        System.out.println();
        System.out.println("═════════════════════════");
        System.out.println("Haz añadido tu artículo!");
        System.out.println("═════════════════════════");
    }

    private static void listFruits() {
        System.out.println("=== LISTA DE FRUTA ===");

        if (inventory.isEmpty()) {
            System.out.println("Oops, no tienes nada de fruta!");
            return;
        }

        System.out.println("+----+------------+-----------+------------+");
        System.out.println("| ID | Nombre     | Precio/Kg | Stock      |");
        System.out.println("+----+------------+-----------+------------+");

        //Testing print
        //System.out.println(inventory.get(0));

        for (Fruit fruit : inventory) {
            int id = fruit.getId();
            String name = fruit.getName();
            double pricePerKg = fruit.getPricePerKg();
            int stockKg = fruit.getStockKg();

            System.out.printf("| %-2d | %-10s | %-9.2f | %-10d |\n", id, name, pricePerKg, stockKg);
        }

    }

    private static void exportToFile() {
        System.out.println("\n=== Exportar archivo ===");

        try {
            FileWriter fileWriter = new FileWriter(FILE_PATH, StandardCharsets.UTF_8);

            for (Fruit fruit : inventory) {
                String line = fruit.toFileFormat();
                fileWriter.write(line + "\n");
            }
            fileWriter.close();
            System.out.println("Archivo exportado a: " + FILE_PATH);
            System.out.println("Cantidad de artículos exportados: " + inventory.size());
        } catch (IOException e) {
            System.out.println("Hubo un error al exportar... Vuelve a intentarlo");
        }
    }

    private static void importFromFile() {

        try {
            FileReader fr = new FileReader(FILE_PATH, StandardCharsets.UTF_8);
            BufferedReader bf = new BufferedReader(fr);

            inventory.clear();

            nextId = 1;

            String line;
            int lineNumber = 0;
            int successCount = 0;
            int errorCount = 0;

            while ((line = bf.readLine()) != null) {
                lineNumber++;

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] parts = line.split(";");

                if (parts.length != 4) {
                    System.out.println("⚠ Línea " + lineNumber + " saltada (formato incorrecto): " + line);
                    errorCount++;
                    continue;
                }

                try {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1].trim();
                    double pricePerKg = Double.parseDouble(parts[2]);
                    int stockKg = Integer.parseInt(parts[3]);

                    if (name.length() < 2 || pricePerKg < 0 || stockKg < 0) {
                        System.out.println("⚠ Línea " + lineNumber + " saltada (hubo un error): " + line);
                        errorCount++;
                        continue;
                    }

                    //Creamos un nuevo objeto fruta y lo añadimos al inventario
                    Fruit fruit = new Fruit(id, name, pricePerKg, stockKg);
                    inventory.add(fruit);

                    if (id >= nextId) {
                        nextId = id + 1;
                    }

                    successCount++;


                } catch (NumberFormatException e) {
                    System.out.println("⚠ Línea " + lineNumber + " saltada (números inválidos)" + e.getMessage());
                    errorCount++;
                }
            }

            bf.close();
            System.out.println("Importación completada!");
            System.out.println("Frutas importadas: " + successCount);

            if (errorCount > 0) {
                System.out.println("Líneas con errores: " + errorCount);
            }

        } catch (IOException e) {
            System.out.println("No se pudo importar el archivo: " + e.getMessage());
        }

    }

}