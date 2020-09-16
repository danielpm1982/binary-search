public interface BinarySearchInterface {
    // Used both for iterative as for recursive binary search implementations, this interface
    // receives a targetValue to be searched and an array where that value should be searched in
    // The boundaries are the extremes and the range is the whole array content, from the first
    // till the last element
    // No optional custom range allowed on this interface
    public int binarySearch(int targetValue, int... sortedIntArray);
}
