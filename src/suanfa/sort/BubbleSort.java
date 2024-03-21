package suanfa.sort;

import java.util.Arrays;

/**
 * @Description 冒泡排序
 * @Author wangyao
 * @Data 2024/3/21 22:44
 */

public class BubbleSort {
    static int arr[] = {1,2,3,-1,-2};
    public static void main(String[] args) {
        sort(arr);

    }
    /**
     * 如果某次循环已经发现是最终排序 就不需要再次循环
     */
    public static void sort(int [] arr){
        int temp = 0;
        boolean flag = false;
        for(int i=0;i<arr.length-1;i++){
            for(int j =0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            System.out.println("第"+i+"趟排序后的结果");
            System.out.println(Arrays.toString(arr));
            if(!flag){
                break;
            }else{
                flag = false;
            }
        }
    }
}
