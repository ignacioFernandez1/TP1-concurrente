import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        int cant = 10;
        Buffer buffer = new Buffer();
        Productor[] productores = new Productor[cant];
        Consumidor[] consumidores = new Consumidor[cant];

        for (int i = 0; i < cant; i++) {
            productores[i] = new Productor(buffer, "productor" + i);
            consumidores[i] = new Consumidor(buffer, "consumidor" + i);
            productores[i].start();
            consumidores[i].start();
        }

        for (int i = 0; i < cant; i++) {
            try{
                productores[i].join();
                consumidores[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Productos descartados: " + buffer.descartados);


        for (int i = 0; i < cant; i++) {
            System.out.println("Consumidor " + i + ": " + consumidores[i].getState());
        }
    }

}
