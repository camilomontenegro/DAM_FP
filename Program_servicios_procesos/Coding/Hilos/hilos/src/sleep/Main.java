package sleep;

public class Main {
    public static void main(String[] args) {
        //Sleep method
        MiHilo mh = new MiHilo();
        Thread hilo = new Thread(mh);

        hilo.start();
        System.out.println("Hilo Main sigue ejecutandose");

    }
}
