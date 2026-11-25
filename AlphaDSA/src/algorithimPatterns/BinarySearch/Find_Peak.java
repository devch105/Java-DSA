package algorithimPatterns.BinarySearch;

public class Find_Peak {
    
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 1};
        System.out.println("Peak Element : "+findPeakElement(arr));
    }

    public static int findPeakElement(int nums[]){
        int left =0;
        int right = nums.length-1;

        while(left<right){
            int mid = left +(right-left)/2;

            if(nums[mid]< nums[mid+1]){
                left = mid+1;
            }else if(nums[mid]> nums[mid+1]){
                right = mid;
            }else {
                return mid;
            }

        }
        return left;
    }
}
