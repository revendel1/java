import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public class Telephone_system {
    private final double talk_cost; // Цена за минуту разговора
    private List<Service> services; // Список услуг
    private List<Abonent> abonents; // Список абонентов
    private List<Administrator> administrators; // Список администраторов

    Telephone_system(double talk_cost, List<Service> services, List<Abonent> abonents, List<Administrator> administrators){
        this.talk_cost = talk_cost;
        this.services = services;
        this.abonents = abonents;
        this.administrators = administrators;
    }

    // Начало следующего расчетного периода, система выставляет счета абонентам
    public void newMonth() {
        for (Abonent abonent : abonents) {
            // Если абонент еще обслуживается, но имеет неоплаченный счет, то он блокируется
            if (abonent.isWorking() && abonent.getInvoice() != null) {
                abonent.setWorking(false);
                System.out.println("Абонент был отключен системой за неуплату.");
                return;
            }
            double cost = 0; // Рассчитывается цена за услуги и разговоры за месяц
            for (Service service : abonent.getServices()) {
                cost += service.getCost();
            }
            LocalTime time = abonent.getTalk_time();
            cost += (time.getHour() * 60 + time.getMinute()) * talk_cost;
            abonent.setInvoice(new Invoice(1, new Date(), cost)); // Выставляется счет
            abonent.setTalk_time(LocalTime.parse("00:00:00")); // Сбрасывается кол-во разговоров
            System.out.println("Абоненту " + abonent.getId() + ": '" + abonent.getTitle() + "' был выставлен счет");
        }
    }

    @Override
    public String toString() {
        return "Telephone_system{" +
                "talk_cost=" + talk_cost +
                ", services=" + services +
                ", abonents=" + abonents +
                ", administrators=" + administrators +
                '}';
    }
}
