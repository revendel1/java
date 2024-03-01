import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

public class Phone {
    private int id; // Идентификатор
    private String surname; // Фамилия
    private String name; // Имя
    private String patronymic; // Отчество
    private String address; // Адрес
    private int credit_number; // Номер кредитной карточки
    private double debit; // Дебет
    private double credit; // Кредит
    private LocalTime time_in_city; // Внутрегородское время
    private LocalTime time_between; // Междугороднее время

    public Phone(int id, String surname, String name, String patronymic, String address, int credit_number, double debit, double credit, LocalTime time_in_city, LocalTime time_between) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.address = address;
        this.credit_number = credit_number;
        this.debit = debit;
        this.credit = credit;
        this.time_in_city = time_in_city;
        this.time_between = time_between;
    }

    public int getId() { return this.id; }
    public void setId(int id) { this.id = id; }
    public String getSurname() { return this.surname; }
    public void setSurname(String surname) { this.surname = surname; }
    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }
    public String getPatronymic() { return this.patronymic; }
    public void setPatronymic(String patronymic) { this.patronymic = patronymic; }
    public String getAddress() { return this.address; }
    public void setAddress(String address) { this.address = address; }
    public int getCredit_number() { return this.credit_number; }
    public void setCredit_number(int credit_number) { this.credit_number = credit_number; }
    public double getDebit() { return this.debit; }
    public void setDebit(double debit) { this.debit = debit; }
    public double getCredit() { return this.credit; }
    public void setCredit(double credit) { this.credit = credit;}
    public LocalTime getTime_in_city() { return this.time_in_city; }
    public void setTime_in_city(LocalTime time_in_city) { this.time_in_city = time_in_city; }
    public LocalTime getTime_between() { return this.time_between; }
    public void setTime_between(LocalTime time_between) { this.time_between = time_between; }

    public String toString() {
        return "Phone{id=" + this.id + ", surname='" + this.surname + "', name=" + this.name + ", patronymic='" + this.patronymic + "', address=" + this.address + ", credit_number=" + this.credit_number + ", debit=" + this.debit + ", credit='" + this.credit + ", time_in_city=" + this.time_in_city + ", time_between=" + this.time_between + "'}";
    }

    // Поиск абонентов с превышением внутрегородского времени
    public static Phone[] searchByTimeInCity(Phone[] phones, LocalTime time) {
        ArrayList<Phone> result = new ArrayList<Phone>();

        for (Phone phone : phones) {
            if (phone.getTime_in_city().compareTo(time) > 0) {
                result.add(phone);
            }
        }

        return (Phone[])result.toArray(new Phone[result.size()]);
    }

    // Поиск абонентов с междугородним временем
    public static Phone[] wasTimeBetween(Phone[] phones) {
        ArrayList<Phone> result = new ArrayList<Phone>();
        LocalTime time = LocalTime.parse("00:00:00");

        for (Phone phone : phones) {
            if (phone.getTime_between().compareTo(time) > 0) {
                result.add(phone);
            }
        }

        return (Phone[])result.toArray(new Phone[result.size()]);
    }

    // Сортировка абонентов по ФИО
    public static Phone[] sortByFio(Phone[] phones) {
        Phone[] phones_copy = Arrays.copyOf(phones, phones.length);

        for (int i = 0; i < phones_copy.length; ++i) {
            for (int j = 0; j < phones_copy.length - 1; ++j) {
                int greater1 = phones_copy[j].getSurname().compareTo(phones_copy[j + 1].getSurname());
                int greater2 = phones_copy[j].getName().compareTo(phones_copy[j + 1].getName());
                int greater3 = phones_copy[j].getPatronymic().compareTo(phones_copy[j + 1].getPatronymic());
                if ((greater1 > 0) || (greater1 == 0 && greater2 > 0) || (greater1 == 0 && greater2 == 0 && greater3 > 0)) {
                    Phone temp = phones_copy[j];
                    phones_copy[j] = phones_copy[j+1];
                    phones_copy[j+1] = temp;
                }
            }
        }

        return phones_copy;
    }
}
