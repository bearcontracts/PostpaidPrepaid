package PostpaidPrepaid;

public class Prepaid extends Korisnik{
    private static final double call=7.5;
    private static final double friendsFamily=4.5;
    private static final double connectionFee=2.8;
    private static final double SMS = 0.9;
    private double kredit;
    private String[] friendsFamilyNumbers = new String[3];

    public Prepaid(String broj, double kredit, String[] ffNumbers) {
        super(broj);
        this.kredit = kredit;
        for(int i=0; i<friendsFamilyNumbers.length;i++){
            friendsFamilyNumbers[i]=ffNumbers[i];
        }
    }
    public Prepaid(final Prepaid p)
    {
        super(p.getBroj());
        kredit = p.kredit;
        for (int i = 0; i < friendsFamilyNumbers.length; i++)
            friendsFamilyNumbers[i] = p.friendsFamilyNumbers[i];
    }
    public void dopuniKredit(double dopuna){
        kredit+=dopuna;
    }

    @Override
    public void azuriraj_racun_razgovor(Razgovor k) {
        double cena = call;
        Vreme vreme=null;
        if(k.getVreme().getSat()==0 && k.getVreme().getMinut()==0){
            vreme=new Vreme(0,1,0);
        }
        else if(k.getVreme().getSekunda()>30){
            vreme=k.getVreme().sledeci_minut();
        }
        else {
            vreme = new Vreme(k.getVreme().getSat(), k.getVreme().getMinut(), 0);
        }
        for(int i = 0; i<friendsFamilyNumbers.length;i++){
            if(k.getBroj().equals(friendsFamilyNumbers[i])){
                cena = friendsFamily;
                break;
            }
        }
        double ukupnaCenaPoziva=(connectionFee+(vreme.getSat()*60+ vreme.getMinut()*cena)*(100 +PDV)/100.0);
        if(kredit<ukupnaCenaPoziva){
            kredit=0;
        }
        else
            kredit-=ukupnaCenaPoziva;
    }

    @Override
    public void azuriraj_racun_SMS() {
        kredit -=SMS*(100+PDV)/100.0;
        if(kredit<0)
            kredit=0;

    }
    public String toString()
    {
        String numToString = "";
        for (int i = 0; i < friendsFamilyNumbers.length; i++)
            if (friendsFamilyNumbers[i] != null)
                numToString += friendsFamilyNumbers[i] + " ";
        return super.toString() + " kredit: " + kredit +  "friendsFamilyNumbers:"
                + numToString;
    }
}
