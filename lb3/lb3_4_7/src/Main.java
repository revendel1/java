import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Инициализация сущностей
        Service service1 = new Service(1, "Service 1", 10);
        Service service2 = new Service(2, "Service 2", 100);
        Service service3 = new Service(3, "Service 3", 1000);
        List<Service> services = new ArrayList<Service>(){{
            add(service1);
            add(service2);
            add(service3);
        }};
        Abonent abonent = new Abonent(1, "Abonent 1", services);
        List<Abonent> abonents = new ArrayList<Abonent>(){{add(abonent); }};
        Administrator administrator = new Administrator(1, "Administrator 1");
        List<Administrator> administrators = new ArrayList<Administrator>(){{add(administrator); }};
        Telephone_system telephone_system = new Telephone_system(5, services, abonents, administrators);
        System.out.println(telephone_system);

        // Абонент просит сменить ему номер телефона
        System.out.println(abonent);
        abonent.ask_for_number(administrator, 1234567);
        System.out.println(abonent);
        // Абонент просит удалить услугу
        System.out.println();
        abonent.ask_for_service(administrator, service2);
        System.out.println(abonent);
        System.out.println(telephone_system);

        System.out.println();
        abonent.setTalk_time(LocalTime.parse("12:00:00")); // Допущение, что абонент наговорил 12 часов
        telephone_system.newMonth(); // система начинает следующий расчетный период и выставляет счета
        System.out.println(abonent);
        System.out.println();
        telephone_system.newMonth(); // если начинаем следующий расчетный период, а абонент не заплатил за счет
        System.out.println(abonent); // то он блокируется системой, пока не оплатит его
        System.out.println();

        // Абонент платит за услуги и разблокируется системой
        abonent.pay_for_services();
        System.out.println(abonent);
        System.out.println();

        // Администратор отключает абонента
        administrator.disable_abonent(abonent);
        System.out.println(abonent);
    }
}