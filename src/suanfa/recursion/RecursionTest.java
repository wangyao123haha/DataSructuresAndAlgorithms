package suanfa.recursion;

/**
 * @Description 递归测试
 * @Author wangyao
 * @Data 2024/3/19 22:18
 */

public class RecursionTest {

    public static void main(String[] args) {
        test(4);
    }
    public static void test(int n){
        if(n>2){
            test(n-1);
        }
        System.out.println("n="+n);
    }
}
