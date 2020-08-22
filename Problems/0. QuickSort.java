public class QuickSort {
    static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low - 1; //index of smaller element

        for(int j = low; j < high; j++){
            if (arr[j] < pivot) { //if current element is smaller than the pivot
                i++;

                //swap current element with arr[i](put smaller element at the front)
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        //finally swap the pivot element to the pivot position
        //now all elements to the left are smaller than the pivot
        //all to the right are >= pivot
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        //the position of the pivot element
        return i+1;
    }

    static void sort(int[] arr, int low, int high){
        if (low < high) {
            int pi = partition(arr, low, high);

            //left subarray partition
            sort(arr, low, pi-1);

            //right subarray partition
            sort(arr, pi + 1, high);
        }
    }

    static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        sort(arr, 0, arr.length - 1);
        printArr(arr);
    }
}