package suanfa.stack;

/**
 * @Description
 * @Author wangyao
 * @Data 2024/3/18 22:16
 */

/**
 * 使用栈完成计算器表达符号计算
 * 1.通过一个索引指针，遍历表达式 index
 * 2.如果发现式数字 入栈数栈
 * 3.如果发现式符号，入符号栈
 *  如果符号栈是空，直接入栈，不为空就比较当前入栈的数据与栈中数据
 *  入栈符号小于或者等于栈中符号，从符号栈pop出一个符号，从数栈pop出两个数 进行运算
 *  得到结果后入数栈，反之 直接入符号栈
 *  4.当表达式扫描完毕，顺序从数栈和符号栈pop出相应的数和符号，运行
 *  5.最后在数栈只有一个数字，就是表达式结果
 */
public class CountStackDemo {

    public static void main(String[] args) {

        String expression = "80+3*60-1";
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        // 定义index
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper=0;
        int res=0;
        char ch =' '; // 每次扫描到到char
        String keepNum = "";// 拼接多位数
        // 循环扫描表达式
        while (true){
            // 依次得到每个字符
             ch = expression.substring(index, index + 1).charAt(0);
            // 校验ch是什么
            if(operStack.isOper(ch)){
                // 判断当前符号栈是否为空
                if(!operStack.isEmpty()){
                    // 如果符号栈有操作符，进行比较
                    if(operStack.priority(ch)<=operStack.priority(operStack.peek())){
                        // 小于就取出数据 进行运算
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1,num2,oper);
                        // 把运算结果压入数栈
                        numStack.push(res);
                        // 操作符入栈
                        operStack.push(ch);
                    }else{
                        operStack.push(ch);
                    }
                }else{
                       // 直接入栈
                    operStack.push(ch);
                }
            }else{
                // 数据直接入栈
                //numStack.push(ch-48); // 根据字符编码
                keepNum+=ch;
                if(index == expression.length()-1){
                    numStack.push(Integer.parseInt(keepNum));
                }else{
                    // 判断下个字符是不是数字，如果是数字继续扫描，如果是运算符，入栈
                    if(operStack.isOper(expression.substring(index+1,index+2).charAt(0))){
                        numStack.push(Integer.parseInt(keepNum));
                        // 清空拼接
                        keepNum="";
                    }
                }
            }
            index++;
            if(index>=expression.length()){
                break;
            }
        }
        // 表达式扫描完毕后 顺序从数栈与符号栈取数据运算
        while (true){
             // 如果符号栈为空，表示已经计算到最后到结果
            if(operStack.isEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2=numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1,num2,oper);
            numStack.push(res);
        }
        int result = numStack.pop();
        System.out.printf("表达式%s = %d",expression,result);


    }
}
class  ArrayStack2{

    private int maxSize;//栈最大深度
    private int[] stack;
    private int top = -1;

    public ArrayStack2(int size){
        this.maxSize = size;
        stack = new int[this.maxSize];
    }
    // 返回当前栈顶值
    public int peek(){
        return stack[top];
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
    //返回运算符的优先级，使用数字来表达
    public int priority(int oper){
        if(oper == '*' || oper == '/'){
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        }else{
            return -1;
        }
    }
    // 判断是不是一个运算符号
    public boolean isOper(char val){
        return val == '+' || val == '-' || val == '*' || val == '/';
    }
    // 计算数据
    public int cal(int num1,int num2,int oper){
        int res = 0; //计算结果
        switch (oper){
            case '+':
                res = num1+num2;
                break;
            case '-':
                res = num2-num1;// 注意顺序
                break;
            case '*':
                res = num1*num2;
                break;
            case '/':
                res = num2/num1;
                break;
            default:
                break;
        }
        return res;
    }
}
