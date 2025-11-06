package exercises2;

public class Main {
    public static void main(String[] args) {
        GestorProcesos g = new GestorProcesos();
        g.ejecutarComando("dir");
        g.redirigirSalida("ipconfig", "salidajajajaja.txt");
        g.mostrarErrores("Comandojajajaj");
    }
}
