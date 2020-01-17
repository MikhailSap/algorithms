package recursion;

public class Tasks {
    private static int number;

    private static int CAPACITY_OF_BAG = 20;
    private static int maxV;
    private static Item[] items;

    public static void main(String[] args) {
        number = 5;
        System.out.println(exp(number, 2));

        number = 2;
        System.out.println(expOfTwo(number, 16));


        items = new Item[]{
                new Item(12, 4),
                new Item(2, 2),
                new Item(1, 2),
                new Item(16, 27),
                new Item(4, 10)
        };

        System.out.println(packBag(items.length, 0, 0));

    }

    public static int exp(int result, int exp) {
        if (exp == 1)
            return result;
        result *= number;
        return exp(result, exp-1);
    }

    //если показатель степени степень двойки
    public static int expOfTwo(int number, int exp) {
        if (exp == 1)
            return number;
        return expOfTwo(number * number, exp/2);
    }

    public static int packBag(int i, int currentW, int currentV) {
        int with;
        int without;
        if (i == 0) {
            if (currentW <= CAPACITY_OF_BAG) {
                return currentV;
            } else {
                return currentV = 0;
            }
        } else {
           with = packBag(i - 1, currentW + items[i-1].weight, currentV + items[i-1].value);
           without = packBag(i - 1, currentW, currentV);
        }

        if (with == 0 && without == 0) {
            return 0;
        } else if (with > 0 && without > 0) {
            return with > without ? with : without;
        } else if (with > 0) {
            return with;
        } else return without;
    }

    private static class Item {
        int weight;
        int value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

}
