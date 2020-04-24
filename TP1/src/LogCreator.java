import java.util.concurrent.TimeUnit;

public class LogCreator extends Thread{

    private Buffer buffer;
    private Consumidor[] cons;

    public LogCreator(Buffer b, Consumidor[] c) {
        buffer = b;
        cons = c;
    }

    @Override
    public void run() {
        while(true){
            try{
                log();
                TimeUnit.SECONDS.sleep(2);
            }catch(InterruptedException ignored){
                break;
           }
        }
    }

    public void log(){
        System.out.println("--------------------------------------------");
        System.out.println("Cantidad en buffer: " + buffer.getCantidad());
        for(int i = 0; i < 10 ; i++){
                System.out.println(cons[i].getName() + ": " + cons[i].getState());
        }
        System.out.println("--------------------------------------------");
    }
}
