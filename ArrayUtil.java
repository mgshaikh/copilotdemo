/* 
 * static method to find the maximum element in an array using streams
 */

import java.util.Arrays;

public class ArrayUtil {
    public static int findMax(int[] arr) {
        return Arrays.stream(arr).max().getAsInt();
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 10, 5, 6, 7, 8, 9 };
        System.out.println("Max element in the array is: " + findMax(arr));
    }
}
