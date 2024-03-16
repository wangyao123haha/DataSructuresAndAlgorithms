package suanfa.linkedlist;

/**
 * @Description 需求 使用head单项链表完成水浒英雄的排行榜
 * @Author wangyao
 * @Data 2024/3/13 22:15
 */

import java.util.Objects;
import java.util.Stack;

/**
 * 链表是以节点的方式存储
 * 每个节点都包含一个data域，next域->指向下个节点
 * 不一定是按照顺序存放
 * 链表分为带头都节点和不带头都节点
 */
public class SingleLinkedList {

    public static void main(String[] args) {
        // 创建节点
        HeroNode node1 = new HeroNode(2,"宋江","及时雨");
        HeroNode node2 = new HeroNode(4,"卢俊义","玉麒麟");
        HeroNode node3 = new HeroNode(6,"吴用","智多星");
        HeroNode node4 = new HeroNode(8,"林冲","豹子头");

        HeroNode node5 = new HeroNode(3,"李逵","小李");
        HeroNode node6 = new HeroNode(5,"武松","小武");
        HeroNode node7 = new HeroNode(7,"鲁智深","和尚");
        HeroNode node8 = new HeroNode(9,"杨志","小杨");
        // 创建链表
        SingleLinked singleLinked = new SingleLinked();
        singleLinked.addOrderBy(node2);
        singleLinked.addOrderBy(node4);
        singleLinked.addOrderBy(node3);
        singleLinked.addOrderBy(node1);
        singleLinked.list();
        SingleLinked singleLinke2 = new SingleLinked();
        singleLinke2.addOrderBy(node5);
        singleLinke2.addOrderBy(node6);
        singleLinke2.addOrderBy(node7);
        singleLinke2.addOrderBy(node8);

        System.out.println("未修改的节点信息");
        //HeroNode newHeroNode = new HeroNode(2,"张三","李四");
        //singleLinked.update(newHeroNode);
        singleLinked.list();
        //singleLinked.del(4);
        System.out.println("单链表中有效节点个数->"+getLength(singleLinked.getHead()));
        int index = 4 ;
        System.out.println("倒数第->"+index+"的节点对象是"+findLastIndexHead(singleLinked.getHead(),index));
        System.out.println("--------------------");
        //reverseList(singleLinked.getHead());
        System.out.println("---------------->从尾到头打印");
        //outReverse(singleLinked.getHead());
        HeroNode heroNode = mergeAllList(singleLinked.getHead(), singleLinke2.getHead());
        System.out.println("合并后未排序的节点");
    }
    // 合并两个有序到单链表，合并之后依然有序
    public static HeroNode mergeAllList(HeroNode l1,HeroNode l2){
        HeroNode dummy = new HeroNode(0, "", "");
        HeroNode current = dummy;
        while (l1 != null && l2 != null) {
            if (l1.no < l2.no) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }

        return dummy.next;
    }
    /**
     * 从尾到头打印列表
     * 利用栈结构先进后出原理
     */
    public static void outReverse(HeroNode head){
        // 判断当前链表是空 或者只有一个节点，直接打印
        if(head.next == null || head.next.next ==null){
            System.out.println(head);
        }
        // 定义一个栈结构
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
         while (cur!=null){
            stack.push(cur);
            cur = cur.next;
        }
        while (stack.size()>0){
            System.out.println(stack.pop());
        }

    }
    /**
     * 反转单链表
     */
    public static void reverseList(HeroNode head){
        // 如果当前链表是空 或者只有一个节点 无需反转，直接返回
        if(head.next == null || head.next.next == null){
            return;
        }
        // 定义辅助变量 遍历
        HeroNode cur = head.next;
        HeroNode next = null; // 指向当前节点的下一个节点
        HeroNode reverse = new HeroNode(0,"","");
        while (cur!=null){
            next = cur.next;
            cur.next = reverse.next;
            reverse.next = cur;
            cur = next;
        }
        head.next = reverse.next;
    }
    /**
     * 查找单链表中单倒数第n个节点
     * 接收head节点，接收index
     * 遍历整个节点，等到总长度
     * 获取size 从第一个开始遍历（size-index）就可以获取
     */
    public static HeroNode findLastIndexHead(HeroNode heroNode,int index){
        if(Objects.isNull(heroNode.next)){
            System.out.println("节点是空");
        }
        int length = getLength(heroNode);
        if(index<=0 || index>length){
            System.out.println("索引越界");
        }
        HeroNode cul = heroNode.next;
        for(int i = 0 ;i<length-index;i++){
            cul = cul.next;
        }
        return cul;
    }
    /**
     * 返回有效节点个数
     * @return
     */
    public static int getLength(HeroNode heroNode){
        if(Objects.isNull(heroNode.next)){
            return 0;
        }
        int length =0;
        HeroNode temp = heroNode.next;
        while (temp!=null){
            length++;
            temp = temp.next;
        }
        return length;
    }
}
class SingleLinked{

    // 定一个头节点
    private HeroNode head = new HeroNode(0,"","");

    public HeroNode getHead(){
        return head;
    }

    public void add(HeroNode node){
        // 找到当前列表的最后一个节点，让这个节点的next指向后一个节点
        //定一个temp指向头节点
        HeroNode temp  = head;
        // 循环查找最后一个节点
        while (true){
            if(temp.next==null){
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
    }
    // 按照顺序添加
    public void addOrderBy(HeroNode heroNode){
        HeroNode temp = head;
        boolean flag = false; // 表示编号是否添加
        while (true){
             if(temp.next == null){
                 // 链表的最后
                 break;
             }
             if(heroNode.no<temp.next.no){
                 // 找到位置
                break;
             } else if (temp.next.no == heroNode.no) {
                 // 编号已经存在
                 flag = true;
                 break;
             }
             temp = temp.next;
        }
        if(flag){
            System.out.println("插入的英雄编号"+heroNode.name+heroNode.no+"已经存在");
        }else{
            // 插入列表
            heroNode.next = temp.next;
            temp.next = heroNode;
        }

    }
    // 修改某个节点的信息 拿新的节点替换老节点
    public void update(HeroNode newHeroNode){
        // 判断节点是空
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        // 定义一个指针 也就是辅助节点
        HeroNode temp = head.next;
        boolean flag = false;
        while (true){
            if(temp == null){
                break;
            }
            if(temp.no == newHeroNode.no){
                // 找到数据
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        }else{
            System.out.println("没有找到对应的信息");
        }
    }
    public void del(int no){
        // 定义一个辅助变量
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if(temp.next == null){
                break;
            }
            if(temp.next.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.next = temp.next.next;
        }else{
            System.out.println("未找到节点");
        }
    }
    // 显示链表
    public void list(){
        // 判断列表是否为空
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        // 循环遍历节点
        while (true){
            if(temp ==null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

class HeroNode {

    public int no; //排号
    public String name; // 名称
    public String nickName;// 外号
    public HeroNode next; //下一个节点

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}