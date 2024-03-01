public class Main {
    public static void main(String[] args) {
        Surgeon surgeon = new Surgeon("Хирург");
        surgeon.profession();
        surgeon.specialization();

        System.out.println();

        NeuroSurgeon neurosurgeon = new NeuroSurgeon("Нейрохирург", 5);
        neurosurgeon.profession();
        neurosurgeon.specialization();
    }
}