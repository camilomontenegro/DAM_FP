package ej1_carrerahilos;

public class CarreraHilos implements Runnable{

    private String nombre;

    public CarreraHilos(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {

        for (int i = 1; i <= 3; i++) {
            System.out.println(nombre + " -paso: " + i);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(nombre + " Ha terminado!");
    }
}
