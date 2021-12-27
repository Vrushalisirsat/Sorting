public class MergeSort {

    //Time Complexity = O(nlogn)
    public static void conquer(int arr[],int si,int mid,int ei) {
        int merged[] = new int[ei - si +1];
        int idx1 = si;
        int idx2 = mid + 1;
        int x = 0;

           //Conquer step

                 //Time Complexity =  O(n)
        while(idx1 <= mid && idx2 <= ei) {
            if(arr[idx1] <= arr[idx2]) {
                merged[x++] = arr[idx2++];
            }

        }
        while(idx1 <= mid) {
            merged[x++] = arr[idx1++];
        }

        while(idx2 <= ei) {
            merged[x++] = arr[idx2++];
        }

        for(int i=0, j=si; i<merged.length; i++, j++) {
            arr[j] = merged[i];
        }

    }

    public static void divide(int arr[],int si,int ei)  {

        if(si >= ei)  {
            return;
        }

              //Time Complexity = O(logn)

       int  mid = si + (ei - si)/2;     //to calculate mid
        divide(arr, si, mid);
        divide(arr, mid+1,ei);
        conquer(arr, si, mid, ei);
    }
    
    public static void main(String args[]) {
        int arr[] = {6,3,9,5,2,8};
        int n = arr.length;

        divide(arr , 0, n-1); 

        //print

        for(int i=0; i<n; i++)  {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
