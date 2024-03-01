import java.util.List;

public class Administrator {
    private final int id; // id администратора
    private final String title; // Имя администратора

    Administrator(int id, String title){
        this.id = id;
        this.title = title;
    }

    // Метод удаляет услугу для абонента
    public void change_user_service(Abonent abonent, Service service) {
        List<Service> services = abonent.getServices();
        services.remove(service);
        abonent.setServices(services);
        System.out.println("Администратор удалил услугу.");
    }

    // Метод меняет номер абонента
    public void change_user_number(Abonent abonent, int number) {
        abonent.setNumber(number);
        System.out.println("Администратор поменял номер.");
    }

    // Метод отключает абонента
    public void disable_abonent(Abonent abonent) {
        abonent.setWorking(false);
        System.out.println("Администратор отключил абонента за неуплату.");
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
