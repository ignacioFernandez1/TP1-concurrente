import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        int cant = 10;
        Buffer buffer = new Buffer();
        Productor[] productores = new Productor[cant];
        Consumidor[] consumidores = new Consumidor[cant];

        long tInicio =  System.currentTimeMillis();

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

        long tFinal =  System.currentTimeMillis();

        System.out.println("Productos descartados: " + buffer.getDescartados());
        System.out.println("Productos totales colocados: " + buffer.getColocados());
        System.out.println("Productos totales consumidos: " + buffer.getConsumidos());
        System.out.println("Tiempo transcurrido: " + (tFinal-tInicio)/1000 + " segundos");



    }

}
