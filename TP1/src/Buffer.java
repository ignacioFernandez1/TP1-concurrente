
public class Buffer {

    public int cantidad;
    private boolean disponible;
    private boolean lleno;
    public int descartados;

    public Buffer() {
        cantidad=0;
        disponible=false;
        lleno=false;
        descartados=0;
    }

    public synchronized void poner(String name){
        System.out.println(name+" esta intentando poner");
        // Si el buffer esta lleno el producto se descarta
        if(!lleno) {
            cantidad++;
            System.out.println("poniendo " +name+ ": Cantidad es igual a "+cantidad);

            disponible=true;
            if(cantidad==25){
                lleno=true;
            }
        }
        else{

           System.out.println("Se descarto el productovich del "+name);
           descartados++;
        }
        notify();
    }

    public synchronized void sacar(String name) {
        System.out.println(name+" esta intentando sacar");
        while(!disponible){
          try {
              wait();
          }
          catch (InterruptedException ignored){}
        }
        cantidad--;
        lleno=false;
        System.out.println("sacando "+name+": Cantidad es igual a "+cantidad);
        if(cantidad==0){
            disponible=false;
        }
        notify();
    }




    }
