import java.util.Scanner;

public class MaximumChunks {
    public static boolean canBeChunked(int arr[],int i , int j){
        int cnt = 0;
        for(int k = i ; k <= j; k++){
            if(arr[k] >= i && arr[k] <= j){
                cnt++;
            }
        }
        if(cnt == (j-i+1)){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        // Maximum chunk problem =====
        // you are given an array a[n] where elements of  array are from [0,1,2... n-1]
        // you have to split the array into multiple chunks
        // you have to sort the chunks and then concatenate those chunks and it should result into a sorted array

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i =0; i <n; i++){
            arr[i] = sc.nextInt();
        }

        // brute force approach

        // int i =0;
        // int numberOfChunks = 0;
        // while(i < n){
        //     int j;
        //     for( j = i; j <n; j++){
        //         if(canBeChunked(arr,i,j)){
        //             break;
        //         }
        //     }
        //     i = j+1;
        //     numberOfChunks++;

        // }
        // System.out.println(numberOfChunks);

        // this problem can be solved in terms of preffix max; where preffix max is equals to the index then we can consider it a chunk
        int max = Integer.MIN_VALUE;
        int maxChunks = 0;
        for(int k =0; k <n; k++){
            if(max > arr[k]){
                max = max;
            }else{
                max = arr[k];
            }

            if(max == k){
                maxChunks++;
            }
        }
        System.out.println(maxChunks);


    }
}
