class Surgeon implements Doctor {
    private String description; // Описание врача

    Surgeon(String description) {
        this.description = description;
    }

    public String getDescription() { return description; }

    public void profession() {
        System.out.println("Врач имеет профессию " + description);
    }

    public void specialization() {
        System.out.println("Врач имеет специализацию " + description + "ия");
    }
}