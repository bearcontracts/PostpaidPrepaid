package PostpaidPrepaid;

public class Postpaid extends User {

        private static final double PRETPLATA = 150;
        private static final double RAZGOVORUMREZI = 2.8;
        private static final double NACIONALNIRAZGOVORI = 5.8;
        private static final double CONNECTIONFEE = 2.5;
        private static final double SMS = 2.2;
        private double racun;
        public Postpaid(String broj){

            super(broj);
            racun = PRETPLATA;
        }
        public Postpaid(final Postpaid postpaid){

            super(postpaid.getBroj());
            racun = postpaid.racun;
        }
        public void azuriraj_racun_razgovor (Call call)
        {
            double cena = NACIONALNIRAZGOVORI;
            if (call.getBroj().startsWith("064") || call.getBroj().startsWith("065")
                    || call.getBroj().startsWith("066"))
                cena = RAZGOVORUMREZI;
            double cena_razgovora = (CONNECTIONFEE + (call.getVreme().getSat() * 3600
                    + call.getVreme().getMinut() * 60 + call.getVreme().getSekunda())
                    * cena / 60)
                    * (100 + PDV) / 100.0;
            racun += cena_razgovora;
        }
        public void azuriraj_racun_SMS ()
        {
            racun += SMS * (100 + PDV) / 100.0;
        }
        public String toString ()
        {
            return super.toString() + " racun: " + racun;
        }
    }




