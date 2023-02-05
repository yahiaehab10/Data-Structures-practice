package Trees;

public class Test {

    public static void main(String[] args) {
        BTree t = new BTree();
        t.add(7);
        t.add(4);
        t.add(10);
        t.add(11);
        t.add(9);
        t.add(3);
        t.add(6);
        t.displayTree();

        System.out.println(t.numLeftChildNodes());

    }
}
