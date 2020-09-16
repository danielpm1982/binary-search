public class Test {
    public static void main(String[] args) {
        final int TARGET_VALUE = 230;
        final int[] INT_ARRAY = {9,8,7,6,5,4,3,2,1,30,50,140,230,667,999,2000,5675,54,32,98};
        testIterativeBinarySearch(TARGET_VALUE, INT_ARRAY);
        testRecursiveBinarySearch(TARGET_VALUE, INT_ARRAY);
    }
    private static void testIterativeBinarySearch(int TARGET_VALUE, int[] INT_ARRAY){
        final BinarySearchInterface binarySearchIterative = new BinarySearchIterative();
        SearchAndPrint.searchAndPrint(binarySearchIterative, TARGET_VALUE, INT_ARRAY);
        System.out.println();
    }
    private static void testRecursiveBinarySearch(int TARGET_VALUE, int[] INT_ARRAY){
        final BinarySearchInterface binarySearchRecursive = new BinarySearchRecursive();
        SearchAndPrint.searchAndPrint(binarySearchRecursive, TARGET_VALUE, INT_ARRAY);
        System.out.println();
    }
}
