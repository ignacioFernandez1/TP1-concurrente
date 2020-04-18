import java.util.concurrent.TimeUnit;

public class Consumidor extends Thread {


    Buffer buffer;

    public Consumidor(Buffer b,String nombre) {
        super(nombre);
        buffer = b;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println(currentThread().getName()+" esta intentando sacar");
            buffer.sacar();

            try{
                sleep((long) (Math.random()*200));
            }catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }
}


