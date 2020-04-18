
public class Buffer {

    int cantidad;
    boolean disponible;
    boolean lleno;
    public Buffer() {
        cantidad=0;
        disponible=false;
        lleno=false;
    }

    public synchronized void poner(String name){
        // Si el buffer esta lleno el producto se descarta
        if(!lleno) {
            cantidad++;
            System.out.println("poniendo: Cantidad es igual a "+cantidad);
            disponible=true;
            if(cantidad==25){
                lleno=true;
            }
        }
        else{

           System.out.println("Se descarto el productovich del "+name);
        }
        notify();
    }

    public synchronized void sacar() {
        while(!disponible){
          try {
              wait();
          }
          catch (InterruptedException ignored){}
        }
        cantidad--;
        lleno=false;
        System.out.println("sacando: Cantidad es igual a "+cantidad);
        if(cantidad==0){
            disponible=false;
        }
        notify();
    }




    }
