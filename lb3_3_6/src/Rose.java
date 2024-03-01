import java.util.Arrays;
import java.util.Objects;

public class Rose {
    private Petal[] petals; // Массив лепестков
    private Bud bud; // Бутон цветка

    public Rose(int count) {
        petals = new Petal[count];
        for (int i = 0; i < count; i++) {
            petals[i] = new Petal("Красный");
        }
        bud = new Bud();
    }
    public Rose(int count, String color) {
        petals = new Petal[count];
        for (int i = 0; i < count; i++) {
            petals[i] = new Petal(color);
        }
        bud = new Bud();
    }

    // Цветом розы является цвет одного из ее лепестков
    public String getColor() { return petals[0].getColor(); }
    public void blossomed() { bud.blossomed(); } // Бутон цветет
    public void withered() { bud.withered(); }  // Бутон завял

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (getClass() != obj.getClass()) return false;
        Rose rose = (Rose) obj;
        return Arrays.equals(petals, rose.petals) && Objects.equals(bud, rose.bud);
    }
    public int hashCode() {
        int res = Objects.hashCode(bud);
        res = 31 * res + Arrays.hashCode(petals);
        return res;
    }
    public String toString() { return "Rose{ petals= " + Arrays.toString(petals) + ", bud= " + bud + " }"; }
}