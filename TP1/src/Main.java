public class Main {

    public static void main(String[] args){
        int cant=10;
        Buffer buffer=new Buffer();
        Productor[] productores= new Productor[cant];
        Consumidor[] consumidores=   new Consumidor[cant];

        for(int i=0;i<cant;i++){
            productores[i]=new Productor(buffer,"productor"+i);
            consumidores[i]=new Consumidor(buffer,"consumidor"+i);
            productores[i].start();
            consumidores[i].start();
        }
    }





}
