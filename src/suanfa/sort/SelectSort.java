package suanfa.sort;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @Description 选择排序
 * @Author wangyao
 * @Data 2024/3/21 23:02
 */

public class SelectSort {

    static int arr[] = {4,2,8,1,-1,-1,-6,10};
    public static void main(String[] args) {
        // 随机创建8万个数组
        int arr1[] = new int[80000];
        for(int i=0;i<arr1.length;i++){
            arr1[i] = (int)Math.random()*8000000;
        }
        // 排序前的时间
        Date start = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("开始时间是："+simpleDateFormat.format(start));
        selectSort(arr1);
        Date end = new Date();
        System.out.println("结束时间是："+simpleDateFormat.format(end));
    }

    public static void selectSort(int [] arr){
        for(int i = 0;i<arr.length-1;i++){
            int minIndex = i;
            int min = arr[i];
            for(int j=i+1;j<arr.length;j++){
                if(min>arr[j]){
                    min = arr[j];
                    minIndex = j;
                }
            }
            if(minIndex!=i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
}
