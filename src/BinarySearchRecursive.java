public class BinarySearchRecursive implements BinarySearchInterface{
    @Override
    public int binarySearch(int targetIntValue, int... sortedIntArray) {
        // if the targetValue is greater than the highest element of the array,
        // the targetValue is not present in the array and -1 is returned
        if(targetIntValue>sortedIntArray[sortedIntArray.length-1]){
            return -1;
        }
        // initial boundaries are always the extreme values, as the whole array is to be searched
        // no optional custom bounds allowed
        int lowerBoundIndex = 0;
        int upperBoundIndex = sortedIntArray.length-1;
        // an inner helper method is called recursively until it returns the targetValue index or -1, if the value is not found
        // this helper method is called added with the bounds, which will be changed on every subsequent method call, either the lower or the upper one, until the stop point condition is reached
        return recursiveInternalMethod(targetIntValue, sortedIntArray, lowerBoundIndex, upperBoundIndex);
    }
    private int recursiveInternalMethod(final int targetIntValue, final int[] sortedIntArray, int lowerBoundIndex, int upperBoundIndex){
        if(lowerBoundIndex>upperBoundIndex){ // if the lowerBound is greater than the upperBound, a stop point has been reached and the element has not been found in the array. -1 is returned
            return -1;
        } else{
            int targetIntIndex = (lowerBoundIndex+upperBoundIndex)/2; // a new middle index is calculated based on the new bounds, on each method execution, for later comparison between its element value and the targetValue
            if (targetIntValue == sortedIntArray[targetIntIndex]) { // if the targetValue is the one at that middle index, then another stop point is reached, the element has been found and its index is returned
                return targetIntIndex;
            } else if(targetIntValue > sortedIntArray[targetIntIndex]) {
                return recursiveInternalMethod(targetIntValue, sortedIntArray, ++targetIntIndex, upperBoundIndex); // else, if the targetValue is greater than the value of the element at the middle index, than the same method call is returned recursively, now with a lowerBound index equal to that middle index + 1, as the searched element should be on the right of the element at that middle index
            } else {
                return recursiveInternalMethod(targetIntValue, sortedIntArray, lowerBoundIndex, --targetIntIndex); // else, if the targetValue is smaller than the value of the element at the middle index, than the same method call is returned recursively, now with a upperBound index equal to that middle index - 1, as the searched element should be on the left of the element at that middle index
            }
        }
    }
}
