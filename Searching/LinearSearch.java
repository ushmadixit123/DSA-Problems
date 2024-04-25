import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr [] = new int[n];
        int target = 3;
        for(int i =0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        for(int i =0; i < n ; i++){
            if(arr[i] == target){
                System.out.println(i);
                break;
            }
        }
    }
}
