public class BinarySearchIterative implements BinarySearchInterface{
    @Override
    public int binarySearch(int targetIntValue, int... sortedIntArray) {
        // if targetValue has a higher value than the last highest value of the ordered array,
        // than that value is not present in the array and -1 is returned
        if(targetIntValue>sortedIntArray[sortedIntArray.length-1]){
            return -1;
        }
        // the boundaries for the search are the 1st and last element of the ordered array
        // no custom bounds accepted through this interface
        int lowerBoundIndex = 0;
        int upperBoundIndex = sortedIntArray.length-1;
        int targetIntIndex; // the index of the targetValue being searched
        while(lowerBoundIndex<=upperBoundIndex){ // the stop point for the iteration is when the lowerBoundIndex gets greater than the upperBoundIndex, which means the whole array has already been searched and the element has not been found in any of its indexes
            targetIntIndex = (lowerBoundIndex + upperBoundIndex)/2; // on each while iteration, the index of the middle element is calculated for comparison of its element value with the targetValue
            if(targetIntValue==sortedIntArray[targetIntIndex]){ // if the targetValue is exactly that of the middle index, then the targetValue has been found in the array and its index is then returned
                return targetIntIndex;
            } else if(targetIntValue>sortedIntArray[targetIntIndex]){ // if the middle index element value didn't match the targetValue, the it is compared the targetValue with the middle index element value and, if the target value is greater, than the searched element should be on the right of the middle index element, considering that the array is ordered
                lowerBoundIndex = ++targetIntIndex; // so, the lowerBound index is reassigned to be 1 index greater than the current middle index, and the iteration continues, now with a reduction of 50% on the length to be searched on each next and subsequent iterations. Every iteration reduces in 50% the number of array elements to be searched
            } else{
                upperBoundIndex = --targetIntIndex; // if the middle index element value didn't match the targetValue, and if the target value is lower, than the searched element should be on the left of the middle index element and not on its right. Then, the upperBound is reassigned instead and is set to be 1 value lower than the current middle index. On each iteration, it is also reduced in 50% the length of the array to be searched on the next iteration
            }
        }
        return -1; // if the targetValue is not found, the while iteration ends and -1 is returned
    }
}
