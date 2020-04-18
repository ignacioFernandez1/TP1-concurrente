public class Productor extends Thread {

    private Buffer buffer;

    public Productor(Buffer b,String nombre) {
        super(nombre);
        buffer=b;

    }

    @Override
    public void run() {
        for(int i=0;i<100;i++){

            buffer.poner(currentThread().getName());

            try{
                sleep((long) (Math.random()*100));
            }catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }
}
