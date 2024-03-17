package suanfa.linkedlist;

import java.util.Objects;

/**
 * @Description 约瑟夫环形链表
 * @Author wangyao
 * @Data 2024/3/17 21:29
 */

public class JosePho {

    public static void main(String[] args) {
            CircleBoyLinked circleBoyLinked = new CircleBoyLinked();
            circleBoyLinked.add(5);
            circleBoyLinked.list();
            circleBoyLinked.countBoy(1,2,5);
    }
}
class CircleBoyLinked{
    // 定义第一个节点
    private Boy first = null;
    public void add(int nums){
        if(nums<1){
            System.out.println("请至少添加一个");
            return;
        }
        // 辅助指针
        Boy curBoy = null;
        for(int i = 1;i<=nums;i++){
            Boy boy = new Boy(i);
            if(i==1){
                // 第一个指向自己
                first = boy;
                first.setNext(first);
                curBoy = first;
            }else{
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy; // 将自己给到辅助变量
            }
        }
    }
    public void list(){
        if(Objects.isNull(first)){
            System.out.println("链表为空");
            return;
        }
        Boy cur = first;
        while (true){
            System.out.println("小孩的编号是"+cur.getNo());
            if(cur.getNext() == first){
                break;
            }
            cur = cur.getNext();
        }
    }

    /**
     *
     * @param startNo 从第n个数开始
     * @param countNum 数几个
     * @param nums 总过几个人
     */
    public void countBoy(int startNo,int countNum,int nums){
        if(first == null || startNo<1 || startNo>nums){
            System.out.println("参数输入有误，请重新输入");
        }
        Boy helper = first;
        while (true){
            if (helper.getNext() == first){
                break;
            }
            helper = helper.getNext();
        }
        // 报数前 先让first 与helper 移动 startNo-1次
        for(int i = 0;i<startNo-1;i++){
            first = first.getNext();
            helper = helper.getNext();
        }
        // 当开始报数时，first与helper各自移动m-1次 因为是从自己开始先数当
        while (true){
            if(helper == first){
                break;
            }
            for(int i = 0;i<countNum-1;i++){
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.printf("小孩%d出圈\n",first.getNo() );
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后一个小孩%d出圈\n",first.getNo() );
    }
}
class Boy{
    private int no;
    private Boy next;
    public Boy(int no){
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
