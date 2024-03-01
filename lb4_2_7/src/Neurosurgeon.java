class NeuroSurgeon extends Surgeon {
    private int experience; // Стаж работы

    NeuroSurgeon(String description, int experience) {
        super(description);
        this.experience = experience;
    }

    public void profession() {
        System.out.println("Врач имеет профессию " + getDescription() + " с опытом работы " + experience + " лет.");
    }
}