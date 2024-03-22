package suanfa.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @Description 插入排序
 * @Author wangyao
 * @Data 2024/3/22 22:51
 */

public class InsertSort {

    public static void main(String[] args) {
        // 随机创建8万个数组
        int arr1[] = new int[80000];
        for(int i=0;i<arr1.length;i++){
            arr1[i] = (int)(Math.random()*80000);
        }
        // 排序前的时间
        Date start = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("开始时间是："+simpleDateFormat.format(start));
        insertSort(arr1);
        Date end = new Date();
        System.out.println("结束时间是："+simpleDateFormat.format(end));
    }
    public static void insertSort(int[] arr){
        for(int i=1;i<arr.length;i++){
            // 定义待插入待数 第二个数
            int insertVal = arr[i];
            int insertIndex = i-1; // 要插入的下标
            while (insertIndex>=0 && insertVal<arr[insertIndex]){
                // 将后面的数挪到前面
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }
            // 插入的变量 就等于后移的索引数据
            arr[insertIndex+1] = insertVal;
        }
    }
}
