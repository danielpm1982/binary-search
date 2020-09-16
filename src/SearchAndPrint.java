import java.util.Arrays;

public class SearchAndPrint {
    public static void searchAndPrint(BinarySearchInterface binarySearchInterface, int TARGET_VALUE, int[] INT_ARRAY){
        // Setting up binary search:
        String searchType = binarySearchInterface instanceof BinarySearchIterative ?
                "Binary Search - Iterative Method" : "Binary Search - Recursive Method";
        System.out.println(searchType+" - Started...");
        System.out.println("Target value = "+TARGET_VALUE);
        System.out.println("Original unordered array\n"+ Arrays.toString(INT_ARRAY));
        Arrays.sort(INT_ARRAY);
        System.out.println("Ordered array\n"+Arrays.toString(INT_ARRAY));
        final String[] STRING_PRINT_ARRAY = Arrays.stream(INT_ARRAY).boxed().map(String::valueOf).toArray(String[]::new);
        // Executing binary search
        int targetIntIndex = binarySearchInterface.binarySearch(TARGET_VALUE, INT_ARRAY);
        // Showing result
        if(targetIntIndex>=0){
            STRING_PRINT_ARRAY[targetIntIndex] = ">>> "+STRING_PRINT_ARRAY[targetIntIndex]+" <<<";
            System.out.println("\""+TARGET_VALUE+"\" value is located at the array \n"+Arrays.toString(STRING_PRINT_ARRAY)+"\nat index i = "+targetIntIndex+".");
        } else{
            System.out.println("\""+TARGET_VALUE+"\" value does not exist on the array "+Arrays.toString(STRING_PRINT_ARRAY));
        }
        System.out.println(searchType+" - Ended !");
    }
}
