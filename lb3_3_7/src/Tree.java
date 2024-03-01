import java.util.Arrays;

public class Tree {
    private List[] lists; // Листья дерева
    private String state; // Состояние дерева

    public Tree(int count) {
        lists = new List[count];
        for(int i = 0; i < count; ++i ) {
            lists[i] = new List();
        }
        state = "Дерево с листьями";
    }

    public void bloom() {
        state = "Цветущее дерево";
    } // Дерево зацвело

    // Дерево опало
    public void fallen() {
        lists = new List[0];
        state = "Опавшее дерево";
    }

    // Дерево покрылось инеем
    public void frost() {
        for(List list : lists) {
            list.frost();
        }
    }

    // Дерево пожелтело
    public void yellowish() {
        state = "Дерево с листьями";
        for(List list : lists) {
            list.yellowish();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (getClass() != obj.getClass()) return false;
        Tree tree = (Tree) obj;
        return Arrays.equals(lists, tree.lists) && state.equals(tree.state);
    }
    public int hashCode() {
        int res = state.hashCode();
        res = 31 * res + Arrays.hashCode(lists);
        return res;
    }
    public String toString() { return "Tree{ lists= " + Arrays.toString(lists) + ", state= '" + state + "' }"; }
}
