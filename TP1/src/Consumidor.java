import java.util.concurrent.TimeUnit;

public class Consumidor extends Thread {


    private Buffer buffer;

    public Consumidor(Buffer b,String nombre) {
        super(nombre);
        buffer = b;
    }

    @Override
    public void run() {
        for(int i=0;i<100;i++){

            buffer.sacar();

            try{
                sleep((long) (Math.random()*1500));
            }catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }
}


