import java.util.concurrent.TimeUnit;

public class Consumidor extends Thread {


    private Buffer buffer;
    private int estado;

    public Consumidor(Buffer b,String nombre) {
        super(nombre);
        buffer = b;
        estado = 1; //1->DISPONIBLE ; 0->CONSUMIENDO
    }

    @Override
    public void run() {
        for(int i=0;i<110;i++){

            boolean saco = buffer.sacar();

            if(saco){
                try{
                    estado = 0;
                    sleep((long) (Math.random()*1500));
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else{
                try{
                    estado = 1;
                    sleep((long) (Math.random()*500));
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public int getEstado(){return estado;}
}


