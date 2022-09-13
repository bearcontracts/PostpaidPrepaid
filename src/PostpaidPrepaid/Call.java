package PostpaidPrepaid;

public class Call {

    private String broj;
    private Time time;

    public Call(String broj, Time time) {
        this.broj = broj;
        this.time = new Time(time);
    }

    public Call(Call r){
        this(r.broj, r.time);
    }

    public String getBroj() {
        return broj;
    }
    public Time getVreme() {
        return time;
    }

    @Override
    public String toString() {
        return "PostpaidPrepaid.Call{" +
                "broj='" + broj + '\'' +
                ", time=" + time +
                '}';
    }


}
