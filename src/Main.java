
public class Main {

    public static void main(String[] args) {

        int[] numbers = new int[]{4,2,6,1,3,5,7};

        divide(numbers, 0, numbers.length-1);

        for(int i = 0; i < numbers.length; i++){
            System.out.print(numbers[i]);
        }

    }

    static void divide(int[] arr, int start, int end){

        //If the start is equal to the end or bigger (it doesn't make sense this last one), it means
        if(start >= end) {
            return;
        }

        int pivot = arr[end];
        int small = start -1;
        int temp;

        //we compare the pivot to each element
        for (int i = start; i < end; i++){
            if (arr[i] < pivot){
                small++;
                temp = arr[small]; //it saves the temporal value
                arr[small] =  arr[i];
                arr[i] = temp;
            }
        }

        //we change the last element (the pivot to the position small + 1) the place where it belongs
        small++;
        temp = arr[small]; //it saves the temporal value
        arr[small] =  arr[end];
        arr[end] = temp;

        //at this point, our array is ordered, lower values on the left, and higher to the right the small index is the limit
        divide(arr, start, (small - 1));
        divide(arr, (small+1), end);

    }


}