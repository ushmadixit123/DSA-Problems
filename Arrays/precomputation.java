import java.util.Scanner;

class precomputation{
    // prefixMax Array =============================
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

    // preffixSum =======================
    public static int prefixSum(int[] arr, int n,int s, int e){
        int preffixSum[] = new int[n];
        preffixSum[0] = arr[0];
        for(int i = 1; i < n; i++){
            preffixSum[i] = preffixSum[i-1]+arr[i];
        }
        int sum =0;
        if(s != 0){
             sum = preffixSum[e] - preffixSum[s-1];
        }
        else{
             sum = preffixSum[e];

        }


        return sum;
    }
    // suffix Max 
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

    // suffix sum =========
    public static int suffixSum(int [] arr, int n, int s, int e){
        int suffixSum[] = new int[n];
        suffixSum[n-1] = arr[n-1];
        for(int i = n-2; i >= 0; i--){
            suffixSum[i] = suffixSum[i+1]+arr[i];
        }
        int sum = 0;
        if(e != n-1){
            sum = suffixSum[s] - suffixSum[e+1];
        }else{
            sum = suffixSum[s];
        }
        return sum;
    }
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i =0; i <n ; i++){
            arr[i] = sc.nextInt();
        }
        // Prefix max ======
        // int preffixMax[] = prefixMAx(arr,n);
        // for(int i =0; i <n;i++){
        //     System.out.println(preffixMax[i]);
        // }

        // prefix Sum ========
        // int s = sc.nextInt();
        // int e = sc.nextInt();

        // int preffixSum = prefixSum(arr,n,s,e);
        // System.out.println(preffixSum);

        // suffix Max ===============
        // int suffixMax[] = sufixMax(arr,n);
        // for(int i =0; i <n;i++){
        //         System.out.println(suffixMax[i]);
        // }

        // suffix Sum ===========
        int s = sc.nextInt();
        int e = sc.nextInt();
        int suffixSum = suffixSum(arr,n,s,e);
        System.out.println(suffixSum);

    }
}