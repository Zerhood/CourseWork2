import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arrayInt = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] newArray = printArrayAt3To7Indexes(arrayInt);
        System.out.println(Arrays.toString(newArray));
    }

    public static int[] printArrayAt3To7Indexes(int[] array) {
        int[] newAr = new int[5];
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                array[i] += 1;
            }
            if (i >= 3 && i <=7) {
                newAr[count] = array[i];
                count++;
            }
        }
        return newAr;
    }
}