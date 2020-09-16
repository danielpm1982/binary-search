public class BinarySearchRecursive implements BinarySearchInterface{
    @Override
    public int binarySearch(int targetIntValue, int... sortedIntArray) {
        if(targetIntValue>sortedIntArray[sortedIntArray.length-1]){
            return -1;
        }
        int lowerBoundIndex = 0;
        int upperBoundIndex = sortedIntArray.length-1;
        return recursiveInternalMethod(targetIntValue, sortedIntArray, lowerBoundIndex, upperBoundIndex);
    }

    private int recursiveInternalMethod(final int targetIntValue, final int[] sortedIntArray, int lowerBoundIndex, int upperBoundIndex){
        int targetIntIndex;
        while(lowerBoundIndex<=upperBoundIndex){
            targetIntIndex = (lowerBoundIndex + upperBoundIndex)/2;
            if(targetIntValue==sortedIntArray[targetIntIndex]){
                return targetIntIndex;
            } else if(targetIntValue>sortedIntArray[targetIntIndex]){
                lowerBoundIndex = ++targetIntIndex;
                recursiveInternalMethod(targetIntValue, sortedIntArray, lowerBoundIndex, upperBoundIndex);
            } else{
                upperBoundIndex = --targetIntIndex;
                recursiveInternalMethod(targetIntValue, sortedIntArray, lowerBoundIndex, upperBoundIndex);
            }
        }
        return -1;
    }
}
