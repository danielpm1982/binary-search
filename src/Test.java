import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Type an int number to generate a random-value array of that given number length. Min: 1 ; Max: 1000.");
        final int ARRAY_LENGTH = s.nextInt();
        final int[] INT_ARRAY = createAndPopulateArray(ARRAY_LENGTH);
        System.out.println("A "+ARRAY_LENGTH+"-length array, with random unordered int values, has been created !");
        System.out.println("Created unordered array\n"+ Arrays.toString(INT_ARRAY));
        System.out.println("Type an int number to search at the created array using iterative and recursive binary search types:");
        final int TARGET_VALUE = s.nextInt();
        System.out.println();
        testIterativeBinarySearch(TARGET_VALUE, INT_ARRAY);
        System.out.println();
        testRecursiveBinarySearch(TARGET_VALUE, INT_ARRAY);
        System.out.println("\nSuccessfully executed !");
        s.close();
        System.exit(0);
    }
    private static int[] createAndPopulateArray(int arrayLength){
        int[] result = new SecureRandom().ints(arrayLength*1000, 0, arrayLength*1000).distinct().
                limit(arrayLength).toArray();
        if(result.length==arrayLength){
            return result;
        } else{
            throw new RuntimeException("Failed to create array of length "+arrayLength+" !");
        }
    }
    private static void testIterativeBinarySearch(int TARGET_VALUE, int[] INT_ARRAY){
        final BinarySearchInterface binarySearchIterative = new BinarySearchIterative();
        SearchAndPrint.searchAndPrint(binarySearchIterative, TARGET_VALUE, INT_ARRAY);
    }
    private static void testRecursiveBinarySearch(int TARGET_VALUE, int[] INT_ARRAY){
        final BinarySearchInterface binarySearchRecursive = new BinarySearchRecursive();
        SearchAndPrint.searchAndPrint(binarySearchRecursive, TARGET_VALUE, INT_ARRAY);
    }
}
