
public class Buffer {

    private int cantidad;
    private int descartados;
    private int colocados;
    private int consumidos;
    private boolean disponible;
    private boolean lleno;

    public Buffer() {
        cantidad=0;
        descartados=0;
        colocados=0;
        consumidos=0;
        disponible=false;
        lleno=false;
    }

    public synchronized void poner(){
        System.out.println(Thread.currentThread().getName()+" esta intentando poner");
        // Si el buffer esta lleno el producto se descarta
        if(!lleno) {
            cantidad++;
            colocados++;
            System.out.println("poniendo " +Thread.currentThread().getName()+ ": Cantidad es igual a "+cantidad);

            disponible=true;
            if(cantidad==25){
                lleno=true;
            }
        }
        else{

           System.out.println("Se descarto el productovich del "+Thread.currentThread().getName());
           descartados++;
        }
        notify();
    }

    public synchronized void sacar() {
        System.out.println(Thread.currentThread().getName()+" esta intentando sacar");
        if(disponible) {
            cantidad--;
            consumidos++;
            lleno = false;
            System.out.println("sacando " + Thread.currentThread().getName() + ": Cantidad es igual a " + cantidad);
            if (cantidad == 0) {
                disponible = false;
            }
            notify();
        }
        else {
            System.out.println("El consumidor "+Thread.currentThread().getName() + " No encontro productos");
        }
    }

    public int getDescartados(){return descartados;}
    public int getColocados(){return colocados;}
    public int getConsumidos(){return consumidos;}


    }
