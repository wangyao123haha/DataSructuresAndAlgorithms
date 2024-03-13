package suanfa.queue;

/**
 * @Description 数组模拟队列
 * @Author wangyao
 * @Data 2024/3/12 21:47
 */

public class ArrayQueueDemo {
    // 队列原则  遵循先入先出
    public static void main(String[] args) {
        // 存在一个问题 数组队列只能用一次  存放完数据之后索引指针已经指向尾部没办法置0
    }
}

class ArrayQueue{

    private int maxSize; //最大容量
    private int front; // 指向队列头 前一个位置
    private int rear; //指向队列尾部最后一个值
    private int[] arr; //数组

    public ArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }
    //判断队列是否满
    public boolean isFull(){
        return rear == maxSize-1;
    }
    // 判断队列是空
    public boolean isEmpty(){
        return front == rear;
    }
    // 添加数据队列
    public void addQueue(int n){
        // 校验队列满
        if(isFull()){
            System.out.println("不能添加数据，队列已满");
            return;
        }
        // 索引后移
        rear++;
        // 存放数据
        arr[rear] = n;
    }
    // 取数据
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，不能取数据");
        }
        front++;
        return arr[front];
    }
    // 显示队列数据
    public void showQueue(){
        if(isEmpty()){
            return;
        }
        for(int i =0 ;i<arr.length;i++){
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }
}

