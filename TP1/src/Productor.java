public class Productor extends Thread {

    private Buffer buffer;

    public Productor(Buffer b,String nombre) {
        super(nombre);
        buffer=b;

    }

    @Override
    public void run() {
        for(int i=0;i<100;i++){

            try{
                sleep((long) (Math.random()*1500));
            }catch (InterruptedException e) {
                e.printStackTrace();
            }

            buffer.poner();

        }

    }
}
