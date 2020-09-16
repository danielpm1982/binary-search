import java.security.SecureRandom;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int arrayLength=-1;
        while(!(arrayLength>=1&&arrayLength<=1000)){ //while a valid input number is not passed, keep asking for an int between 1 and 1000 (inclusive both)
            System.out.println("Type an int number to generate a random-value array of that given number length. Min: 1 ; Max: 1000.");
            try {
                arrayLength = s.nextInt();
            } catch (InputMismatchException e){
                s.next();
            }
        }
        final int[] INT_ARRAY = createAndPopulateArray(arrayLength); // if a valid length is inserted, create an array with that given length
        System.out.println("A "+arrayLength+"-length array, with random unordered int values, has been created !");
        System.out.println("Created unordered array\n"+ Arrays.toString(INT_ARRAY)); // the initial array is unordered and is ordered only right before the search is performed
        System.out.println("Type an int number to search in the created array using iterative and recursive binary search strategies:");
        final int TARGET_VALUE = s.nextInt();
        System.out.println();
        testIterativeBinarySearch(TARGET_VALUE, INT_ARRAY);
        System.out.println();
        testRecursiveBinarySearch(TARGET_VALUE, INT_ARRAY);
        System.out.println("\nSuccessfully executed !");
        s.close();
        System.exit(0);
    }
    private static int[] createAndPopulateArray(int arrayLength){ // create and populate an array of 1000x the given length (for later eliminating repetitions and keep sufficient elements), with random-generated element values, ranging from zero to 1000x the length. Then, after eliminating all repetitions, limit the length to the exact requested length value, throwing an error if the desired length has not been reached, returning the created array otherwise
        int[] result = new SecureRandom().ints(arrayLength*1000, 0, arrayLength*1000).distinct().
                limit(arrayLength).toArray();
        if(result.length==arrayLength){
            return result;
        } else{
            throw new RuntimeException("Failed to create array of length "+arrayLength+" !");
        }
    }
    private static void testIterativeBinarySearch(int TARGET_VALUE, int[] INT_ARRAY){ // create a binarySearchIterative instance and pass that on the call to the searchAndprint() method, which will call the execution of the search and print the result on the console
        final BinarySearchInterface binarySearchIterative = new BinarySearchIterative();
        SearchAndPrint.searchAndPrint(binarySearchIterative, TARGET_VALUE, INT_ARRAY);
    }
    private static void testRecursiveBinarySearch(int TARGET_VALUE, int[] INT_ARRAY){ // create a binarySearchRecursive instance and pass that on the call to the searchAndprint() method, which will call the execution of the search and print the result on the console
        final BinarySearchInterface binarySearchRecursive = new BinarySearchRecursive();
        SearchAndPrint.searchAndPrint(binarySearchRecursive, TARGET_VALUE, INT_ARRAY);
    }
}
