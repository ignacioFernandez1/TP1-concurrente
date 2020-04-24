import java.util.concurrent.TimeUnit;

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
        // Si el buffer esta lleno el producto se descarta
        if(!lleno) {
            cantidad++;
            colocados++;
            disponible=true;
            if(cantidad==25){
                lleno=true;
            }
        }
        else{
           descartados++;
        }
    }

    public synchronized void sacar(){
        if(disponible) {
            cantidad--;
            consumidos++;
            lleno = false;
            if (cantidad == 0) {
                disponible = false;
            }
        }
    }

    public int getDescartados(){return descartados;}
    public int getColocados(){return colocados;}
    public int getConsumidos(){return consumidos;}
    public int getCantidad(){return cantidad;}


    }
