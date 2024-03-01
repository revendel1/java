class Bud {
    private boolean blooming; // Цветет или завял

    public Bud() {
        blooming = false;
    }

    public void blossomed() {
        blooming = true;
    } // Бутон расцвел
    public void withered() {
        blooming = false;
    } // Бутон завял

    public String toString() { return "Bud{ is blooming? " + blooming + " }"; }
}