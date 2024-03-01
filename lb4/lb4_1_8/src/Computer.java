import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Resource> resources; // Список ресурсов компьютера

    Computer() {
        resources = new ArrayList<>();
    }

    // Добавить новый ресурс
    public void addResource(int id, String description) {
        Resource resource = new Resource(id, description);
        this.resources.add(resource);
    }

    public void printResources() {
        System.out.println("Ресурсы компьютера:");
        for (Resource resource : this.resources) {
            System.out.println(resource);
        }
    }

    // Внутренний класс для хранения информации о ресурсах
    private class Resource {
        private int id; // Идентификатор
        private String description; // Описание ресурса

        Resource(int id, String description) {
            this.id = id;
            this.description = description;
        }

        @Override
        public String toString() {
            return "Resource{ " +
                    "id=" + id +
                    ", description= '" + description + '\'' +
                    '}';
        }
    }
}
