import java.util.Scanner;

class maximizeExpression{
    public static int[] preffixMax(int[] arr, int n , int p){
        int preffixMaxArr[] = new int[n];
        preffixMaxArr[0] = arr[0]*p;
        for(int i =1; i <n; i++){
            if(preffixMaxArr[i-1] > arr[i]*p){
                preffixMaxArr[i] = preffixMaxArr[i-1];
            }else{
                preffixMaxArr[i] = arr[i]*p;
            }
        }
        return preffixMaxArr;
    }
    public static int[] suffixMax(int[] arr, int n , int r){
        int suffixMaxArr[] = new int[n];
        suffixMaxArr[n-1] = arr[n-1]*r;
        for(int i =n-2; i >= 0; i--){
            if(suffixMaxArr[i+1] > arr[i]*r)
            {
                suffixMaxArr[i] = suffixMaxArr[i+1];
            }
            else
            {
                suffixMaxArr[i] = arr[i]*r;
            }
        }
        return suffixMaxArr;
    }
    public static void main(String[] args) {
        // We are given an array and we have to maximize expression p*arr[i] + q *arr[j] + r*arr[k] where i < j < k;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i =0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int p = sc.nextInt();
        int q = sc.nextInt();
        int r = sc.nextInt();
        // prefix max
        int preffixMaxArr[] = preffixMax(arr,n, p);

        // suffix max
        int suffixMaxArr [] = suffixMax(arr,n,r);
        int ans = Integer.MIN_VALUE;
        for(int i = 1; i <= n-2; i++){
            if(ans < preffixMaxArr[i-1]+q*arr[i]+suffixMaxArr[i+1]){
                ans = preffixMaxArr[i-1]+q*arr[i]+suffixMaxArr[i+1];
            }
            else{
                ans = ans;
            }
        }
        System.out.println(ans);

    }
}