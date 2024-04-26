import java.util.Scanner;

public class LastOccurence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i =0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        int low = 0;
        int high = n-1;
        while(low <= high){
          
            int mid = (low + high)/2;
            if(arr[mid] == target){
                if(mid != n-1){
                    if(arr[mid+1] != target){
                        System.out.println(mid);
                        break;
                    }else{
                        low = mid +1;
                    }
                }else{
                    System.out.println(mid);
                    break;
                }
            }
            else if(target < arr[mid]){
                high = mid -1;
            }
            else{
                low = mid+1;
            }
        }
    }
    
}
