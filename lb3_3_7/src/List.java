public class List {
    private String color; // Цвет листа
    private String state; // Состояние листа

    public List() {
        color = "Зеленый";
        state = "Обычный лист";
    }

    public void frost() {
        this.state = "Покрытый инеем лист";
    } // Лист покрылся инеем
    public void yellowish() {
        this.color = "Желтый";
    } // Лист пожелтел

    public String toString() { return "List{ state= '" + state + "' color= '" + color + "' }"; }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        List list = (List) o;
        return color.hashCode() == list.color.hashCode() && state.hashCode() == list.state.hashCode();
    }
    public int hashCode() {
        int result = color == null ? 0 : color.hashCode();
        return result + (state == null ? 0 : state.hashCode());
    }
}