package suanfa.linkedlist;

/**
 * @Description 双向链表
 * @Author wangyao
 * @Data 2024/3/17 17:29
 */

public class DoubleLinkedList {
    public static void main(String[] args) {
        // 创建节点
        HeroNode2 node1 = new HeroNode2(1,"宋江","及时雨");
        HeroNode2 node2 = new HeroNode2(2,"卢俊义","玉麒麟");
        HeroNode2 node3 = new HeroNode2(3,"吴用","智多星");
        HeroNode2 node4 = new HeroNode2(4,"林冲","豹子头");


    }
}
class DoubleLinked{
    HeroNode2 head = new HeroNode2(0,"","");
    public HeroNode2 getHead(){
        return head;
    }
    // 遍历双向列表
    public void list(){
        // 判断列表是否为空
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        // 循环遍历节点
        while (true){
            if(temp ==null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
    // 添加节点
    public void add(HeroNode2 node){
        // 找到当前列表的最后一个节点，让这个节点的next指向后一个节点
        //定一个temp指向头节点
        HeroNode2 temp  = head;
        // 循环查找最后一个节点
        while (true){
            if(temp.next==null){
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
    }
    // 删除节点
    public void del(int no){
        // 定义一个辅助变量
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true){
            if(temp == null){
                break;
            }
            if(temp.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            //temp.next = temp.next.next; 这是单向
            // 双向
            temp.pre.next = temp.next;
            if(temp.next!=null){
                temp.next.pre = temp.pre;
            }
        }else{
            System.out.println("未找到节点");
        }
    }

}
class HeroNode2{
    public int no; //排号
    public String name; // 名称
    public String nickName;// 外号
    public HeroNode2 next; //下一个节点
    public HeroNode2 pre;//上一个节点

    public HeroNode2(int no, String name, String nickName) {
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