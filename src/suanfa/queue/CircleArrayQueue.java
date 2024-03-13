package suanfa.queue;

import java.util.Scanner;

/**
 * @Description 数组环形队列
 * @Author wangyao
 * @Data 2024/3/12 23:22
 */

public class CircleArrayQueue {

    public static void main(String[] args) {

        // 测试数组模拟环形
        CircleArray circleArray = new CircleArray(5);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while (loop){
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据");
            System.out.println("g(get): 获取数据");
            System.out.println("h(head): 获取头部数据");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    try {
                        circleArray.show();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'a':
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    try {
                        circleArray.addQueue(value);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    try {
                        int  queue = circleArray.getQueue();
                        System.out.printf("取出的数据是%d\n",queue);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int queue = circleArray.headQueue();
                        System.out.printf("取出的头部数据是%d\n",queue);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;

            }
        }
        System.out.println("程序退出");
    }
}
class CircleArray{

    private int maxSize; //最大容量
    private int front; // 其实位置是0第一个元素
    private int rear; //指向队列尾部最后一个值的后一位
    private int[] arr; //数组

    public CircleArray(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }
    public boolean isFull(){
        return (rear+1)%maxSize == front;
    }
    public boolean isEmpty(){
        return front == rear;
    }
    public void addQueue(int n)throws Exception{
        if(isFull()){
            throw new Exception("队列已满");
        }
        arr[rear] = n;
        rear = (rear+1)%maxSize;
        System.out.println("当前rear值是->"+rear);
    }
    public int getQueue()throws Exception{
        if(isEmpty()){
            throw new Exception("队列为空");
        }
        // 先把front对应的值保存临时变量
        // 将front 后移
        int value = arr[front];
        front = (front+1)%maxSize;
        return value;
    }
    public void show()throws Exception{
        if(isEmpty()){
            throw new Exception("队列为空");
        }
        for(int i = front;i<front+size();i++){
            System.out.println(arr[i%maxSize]);
        }
    }
    public int size(){
        return (rear+maxSize-front)%maxSize;
    }
    // 显示头元素
    public int headQueue()throws Exception{
        if(isEmpty()){
            throw new Exception("队列为空");
        }
        return arr[front];
    }


}
