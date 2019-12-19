import java.util.Arrays;
import java.util.Random;

public class Sorting {
    public static void main(String[] args) {

        int[] test = getArray();

        int[] one = Arrays.copyOf(test, test.length);
        System.out.println("Time for insert sort: " + insertSort(one));

        int[] two = Arrays.copyOf(test, test.length);
        System.out.println("Time for bubble sort: " + bubbleSort(two));

        int[] three = Arrays.copyOf(test, test.length);
        System.out.println("Time for choice sort: " + selectionSort(three));

    }

    public static int[] getArray() {
        int[] array = new int[1000000];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }

    public static long insertSort(int[] array) {
        long t1 = System.currentTimeMillis();

        int tmp;
        for (int i = 1; i < array.length; i++) {
            tmp = array[i];
            for (int j = i - 1; j > - 1; j--) {
                if (tmp < array[j]) {
                    array[j + 1] = array[j];
                    if (j == 0)
                        array[j] = tmp;
                } else {
                    array[j + 1] = tmp;
                    break;
                }
            }
        }

        long t2 = System.currentTimeMillis();

        return t2 - t1;
    }

    public static long bubbleSort(int[] array) {
        long t1 = System.currentTimeMillis();

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (array[j] < array[j-1])
                swap(j, j-1, array);
            }
        }

        long t2 = System.currentTimeMillis();

        return t2 - t1;
    }

    public static long selectionSort(int[] array) {
        long t1 = System.currentTimeMillis();

        int indexOfMin;
        for (int i = 0; i < array.length - 1; i++) {
            indexOfMin = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array[indexOfMin])
                    indexOfMin = j;
            }
            if (i != indexOfMin)
                swap(i, indexOfMin, array);
        }

        long t2 = System.currentTimeMillis();

        return t2 - t1;
    }

    public static void swap(int indexOne, int indexTwo, int[] array) {
        array[indexOne] = array[indexOne] + array[indexTwo];
        array[indexTwo] = array[indexOne] - array[indexTwo];
        array[indexOne] = array[indexOne] - array[indexTwo];
    }
}
