package app;

import model.Biblioteca;
import model.Cliente;
import model.Usuario;
import util.JsonIO;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.BinaryOperator;

public class MainApp {

    private static final Path RUTA = Paths.get("data", "biblioteca.json");

    public static void main(String[] args) {

        try {

            File json = RUTA.toFile();

            if (!json.exists()) {
                Biblioteca biblio = cargaDatos();

                JsonIO.write(json, biblio);

                System.out.println("Exportado con éxito a: " + json.getAbsolutePath());
            }

            Biblioteca importada = JsonIO.read(json, Biblioteca.class);

            System.out.println("Biblioteca importada: ");
            System.out.println("Nombre " + importada.getNombre());

            System.out.println("Usuarios: ");

            importada.getUsuarios().forEach(u -> System.out.println(" - " + u));



        } catch (Exception e) {
            System.err.println("Error ejecutando la app" + e.getMessage());
        }
    }

    private static Biblioteca cargaDatos() {
        Biblioteca b = new Biblioteca("Biblioteca Cher");

        List<Usuario> usuarios = List.of(
                new Usuario(1, "Cher Rodríguez", "cher@hotmail.com", true),
                new Usuario(2, "Paco Rodríguez", "cher@hotmail.com", true),
                new Usuario(3, "David Rodríguez", "cher@hotmail.com", true)
        );
        List<Cliente> clientes = List.of(
                new Cliente(1, "Cher Fernández", "644328440", 0.0),
                new Cliente(2, "Paco Fernández", "644328440", 12),
                new Cliente(3, "David Fernández", "644328440", 5000)
        );

        b.setUsuarios(usuarios);
        b.setClientes(clientes);

        return b;
    }
}
