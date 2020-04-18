public class Productor extends Thread {

    Buffer buffer;

    public Productor(Buffer b,String nombre) {
        super(nombre);
        buffer=b;

    }




    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println(currentThread().getName()+" esta intentando poner");
            buffer.poner(currentThread().getName());

            try{
                sleep((long) (Math.random()*100));
            }catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }
}
