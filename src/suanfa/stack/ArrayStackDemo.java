package suanfa.stack;

/**
 * @Description 数组模拟栈
 * @Author wangyao
 * @Data 2024/3/17 23:03
 */

public class ArrayStackDemo {

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(10);
    }
}
class  ArrayStack{

    private int maxSize;//栈最大深度
    private int[] stack;
    private int top = -1;

    public ArrayStack(int size){
        this.maxSize = size;
        stack = new int[this.maxSize];
    }
    public boolean isFull(){
        return top == maxSize-1;
    }
    public boolean isEmpty(){
        return top == -1;
    }
    public void push(int value){
        if(isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈是空的");
        }
        int value = stack[top];
        top--;
        return value;
    }
    public void showStack(){
        if(isEmpty()){
            System.out.println("栈是空的");
        }
        for(int i = top;i>=0;i--){
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }
}

