package sleep;

public class MiHilo implements Runnable{

    @Override
    public void run() {
        System.out.println("Empiezo a trabajar en: " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
            System.out.println("Ha terminado después de 2 segundos");
        } catch (InterruptedException e) {
            System.out.println("Me han interrumpido mientras dormia");
        }
    }
}
