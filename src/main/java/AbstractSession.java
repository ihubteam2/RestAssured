public class AbstractSession {

    public static void main(String[] args){


        BS4Car bs4Car = new BS8Car();
        bs4Car.pollution();
        bs4Car.steering();
        bs4Car.seats();

    }
}

abstract class BS4Car{

    public void steering(){
        System.out.println("i have power Steering");
    }
    abstract void pollution() ;

    abstract void seats();

    abstract void body();

}

abstract class BS6Car extends BS4Car{

    public void pollution(){
        System.out.println("Pollution is defined");
    }

    public void seats(){
        System.out.println("Seat Adjustment has been defined");
    }

}

class BS8Car extends BS6Car{

    public void body(){}

}


