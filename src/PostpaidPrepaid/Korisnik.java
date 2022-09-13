package PostpaidPrepaid;

public abstract class Korisnik {

    private String broj;
    static final  int PDV = 18;

    public Korisnik(String broj) {
        this.broj = broj;
    }

    public Korisnik(Korisnik k){
        this(k.broj);
    }

    public String getBroj() {
        return broj;
    }

    public abstract void azuriraj_racun_razgovor(Razgovor razgovor);
    public abstract void azuriraj_racun_SMS();

    public static boolean validan(String broj){

        for (int i=0; i<broj.length();i++)
            if(!Character.isDigit(broj.charAt(i)))
                return false;

        return (broj.startsWith("064") || broj.startsWith("065") || broj.startsWith("066")) && (broj.length() == 9 || broj.length() == 10);

    }

    @Override
    public String toString() {
        return "PostpaidPrepaid.Korisnik{" +
                "broj='" + broj + '\'' +
                '}';
    }
}
