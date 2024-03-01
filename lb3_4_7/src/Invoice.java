import java.util.Date;
import java.util.Calendar;

public class Invoice {
    private final int id; // id счета
    private final Date date; // Дата выставления счета
    private final double cost; // Сумма на оплату

    public Invoice(int id, Date date, double cost) {
        this.id = id;
        this.date = date;
        this.cost = cost;
    }

    public String toString() { return "Invoice{ " + "id=" + id + ", date=" + date + ", cost=" + cost + " }"; }
}
