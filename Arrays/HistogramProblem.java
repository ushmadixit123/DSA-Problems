import java.util.Scanner;

class HistogramProblem{
    public static int[] prefixMAx(int[] arr ,int n){
        int preffixMaxArr[] = new int[n];
        preffixMaxArr[0] = arr[0];
        for(int i = 1; i <n; i++){
            if(preffixMaxArr[i-1] > arr[i]){
                preffixMaxArr[i] = preffixMaxArr[i-1];
            }
            else{
                preffixMaxArr[i] = arr[i];
            }
        }
       
        return preffixMaxArr;
    }
    public static int[] sufixMax(int[] arr, int n){
        int suffixMax[] = new int[n];
        suffixMax[n-1] = arr[n-1];
        for(int i = n-2; i >= 0; i--){
            if(suffixMax[i+1] > arr[i]){
                suffixMax[i]  = suffixMax[i+1];
            }else{
                suffixMax[i] = arr[i];
            }
        }
        return suffixMax;
    }
    public static void main(String[] args) {
        // We are given a problem named Histogram Problem =====
        // we have to find how much water gets collection on all pillars===

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr [] = new int[n];
        for(int i = 0; i <n; i++){
            arr[i] = sc.nextInt();
        }
        
        // preffixMaxArray
        int preffixMax[] = prefixMAx(arr,n);
        int suffixMax[] = sufixMax(arr,n);
        int totalWaterStored = 0;
        for(int i = 1; i < n-1 ;i++){
            int height = 0;
           
            if(preffixMax[i-1] > suffixMax[i+1]){
                height = suffixMax[i+1];
            }
            else{
                height = preffixMax[i-1];
            }
            if(height > arr[i]){
                int decidingHeight = height - arr[i];
                totalWaterStored += decidingHeight;
            }
        }
        System.out.println(totalWaterStored);
    }
}