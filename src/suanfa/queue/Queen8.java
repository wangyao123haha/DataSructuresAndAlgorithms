package suanfa.queue;

/**
 * @Description 八皇后
 * @Author wangyao
 * @Data 2024/3/20 22:30
 */

public class Queen8 {

    int max = 8;
    int array[] = new int[max];  //{1 3 5 7 2 0 6 4}
    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.check(0);
    }
    public void check(int n){
        if(n == max){
            print();
            return;
        }
        for(int i = 0;i<max;i++){
            array[n] = i;
            if(judge(n)){
                check(n+1);
            }
        }
    }
    /**
     * 校验皇后是否和以前摆到位置是否冲突
     * n 表示第n个皇后
     * 第一个判断条件是否在同一列  索引就是行，索引对应到值就是列
     * 第二个判断索引与上一个索引到相减到绝对值  如果等于 两个索引所对应到列到绝对值相等 说明在同一斜线
     */
    public boolean judge(int n){
        for(int i =0;i<n;i++){
            if(array[i] == array[n]
                || Math.abs(n-i)==Math.abs(array[n] - array[i])){
                return false;
            }
        }
        return true;
    }
    // 输出皇后摆放位置
    public void print(){
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
}
