package PostpaidPrepaid;

public class Vreme {
    private int sat;
    private  int minut;
    private int sekunda;

    public Vreme(int sat, int minut, int sekunda) {
        this.sat = sat;
        this.minut = minut;
        this.sekunda = sekunda;
    }

    public Vreme(Vreme v){
        this(v.sat,v.minut,v.sekunda);
    }

    public int getSat() {
        return sat;
    }

    public int getMinut() {
        return minut;
    }

    public int getSekunda() {
        return sekunda;
    }

    public Vreme sledeci_minut(){
        if(minut + 1 < 59)
            return new Vreme(sat,minut + 1 , 0);
        else
            return new Vreme(sat + 1, 0, 0);
    }

    public static boolean validan(int sat, int minut,int sekunda){
        return sat >= 0 && minut >= 0 && minut <= 59 && sekunda >= 0 && sekunda <=59;
    }

    @Override
    public String toString() {
        return "PostpaidPrepaid.Vreme{" +
                "sat=" + sat +
                ", minut=" + minut +
                ", sekunda=" + sekunda +
                '}';
    }
}
