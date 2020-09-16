public class BinarySearchIterative implements BinarySearchInterface{
    @Override
    public int binarySearch(int targetIntValue, int... sortedIntArray) {
        if(targetIntValue>sortedIntArray[sortedIntArray.length-1]){
            return -1;
        }
        int lowerBoundIndex = 0;
        int upperBoundIndex = sortedIntArray.length-1;
        int targetIntIndex;
        while(lowerBoundIndex<=upperBoundIndex){
            targetIntIndex = (lowerBoundIndex + upperBoundIndex)/2;
            if(targetIntValue==sortedIntArray[targetIntIndex]){
                return targetIntIndex;
            } else if(targetIntValue>sortedIntArray[targetIntIndex]){
                lowerBoundIndex = ++targetIntIndex;
            } else{
                upperBoundIndex = --targetIntIndex;
            }
        }
        return -1;
    }
}
