import tree.MyTreeMap;

public class Main {
    public static void main(String[] args) {
        MyTreeMap<Integer, Integer> [] trees = new MyTreeMap[20];

        for (int i = 0; i < 20; i++) {
            trees[i] = new MyTreeMap<Integer, Integer>();
            while (trees[i].height() < 6) {
                int put = rnd(-100, 100);
                trees[i].put(put, put);
            }
        }

        float countBalancedTree = 0;
        int maxSize = 0;

        for (MyTreeMap tree : trees) {
            System.out.println(tree);
            if (tree.size() > maxSize)
                maxSize = tree.size();
            if (tree.isBalanced())
                countBalancedTree++;
        }

        System.out.println("The percentage of non balanced trees is " + ((20 - countBalancedTree)/20)*100);
        System.out.println(maxSize);
    }

    public static int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}
