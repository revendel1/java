public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree(3);
        System.out.println("Дерево: " + tree);
        System.out.println();

        tree.bloom();
        System.out.println("Дерево зацвело: " + tree);
        System.out.println();

        tree.yellowish();
        System.out.println("Дерево пожелтело: " + tree);
        System.out.println();

        tree.frost();
        System.out.println("Дерево покрылось инеем: " + tree);
        System.out.println();

        tree.fallen();
        System.out.println("Дерево опало: " + tree);
        System.out.println();
    }
}