import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Abonent {
    private final int id; // id абонента
    private int number; // Номер абонента
    private final String title; // Имя абонента
    private List<Service> services; // Список услуг абонента
    private Invoice invoice; // Выставленный абоненту счет
    private boolean working; // Отключен ли абонент
    private LocalTime talk_time; // Время разговоров абонента

    Abonent(int id, String title, List<Service> services) {
        this.id = id;
        this.title = title;
        this.number = (int) (Math.random() * 10000000);
        this.services = new ArrayList<>(services);
        this.invoice = null;
        this.talk_time = LocalTime.parse("00:00:00");
        this.working = true;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public List<Service> getServices() { return services; }
    public void setServices(List<Service> services) { this.services = services; }
    public void setNumber(int number) { this.number = number; }
    public Invoice getInvoice() { return invoice; }
    public void setInvoice(Invoice invoice) { this.invoice = invoice; }
    public boolean isWorking() { return working; }
    public void setWorking(boolean working) { this.working = working; }
    public LocalTime getTalk_time() { return talk_time; }
    public void setTalk_time(LocalTime talk_time) { this.talk_time = talk_time; }

    // Метод отправляет просьбу администратору удалить услугу
    public void ask_for_service(Administrator administrator, Service service) {
        System.out.println("Просьба администратору удалить услугу..");
        administrator.change_user_service(this, service);
    }

    // Метод отправляет просьбу администратору поменять номер
    public void ask_for_number(Administrator administrator, int number) {
        System.out.println("Просьба администратору поменять номер..");
        administrator.change_user_number(this, number);
    }

    // Абонент платит по счетам
    public void pay_for_services() {
        System.out.println("Оплата услуг..");
        this.invoice = null;
        this.working = true;
        System.out.println("Услуги оплачены!");
    }

    public String toString() {
        return "Abonent{ " +
                "id=" + id +
                ", number=" + number +
                ", title='" + title + '\'' +
                ", services=" + services +
                ", invoice=" + invoice +
                ", working=" + working +
                ", talk_time=" + talk_time +
                '}';
    }
}
