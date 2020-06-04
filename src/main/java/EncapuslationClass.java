class EncapusClass {

    private int i;
    private String S;
    private double d;

    public String getS() {
        return S;
    }

    public void setS(String s) {
        S = s;
    }

    public double getD() {
        return d;
    }

    public void setD(double d) {
       this.d = d;
    }

    public int getI() {
        return i;
    }
    public void setI(int i) {
        this.i = i;
    }
}

public class EncapuslationClass {

    public static void main(String[] args){

        EncapusClass caps = new EncapusClass();
        caps.setI(10);
        caps.getI();
        caps.getS();





    }

}