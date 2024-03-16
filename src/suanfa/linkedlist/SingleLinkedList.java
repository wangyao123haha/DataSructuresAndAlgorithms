package suanfa.linkedlist;

/**
 * @Description 需求 使用head单项链表完成水浒英雄的排行榜
 * @Author wangyao
 * @Data 2024/3/13 22:15
 */

/**
 * 链表是以节点的方式存储
 * 每个节点都包含一个data域，next域->指向下个节点
 * 不一定是按照顺序存放
 * 链表分为带头都节点和不带头都节点
 */
public class SingleLinkedList {

    public static void main(String[] args) {
        // 创建节点
        HeroNode node1 = new HeroNode(1,"宋江","及时雨");
        HeroNode node2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode node3 = new HeroNode(3,"吴用","智多星");
        HeroNode node4 = new HeroNode(4,"林冲","豹子头");
        // 创建链表
        SingleLinked singleLinked = new SingleLinked();
        singleLinked.addOrderBy(node2);
        singleLinked.addOrderBy(node4);
        singleLinked.addOrderBy(node3);
        singleLinked.addOrderBy(node1);
        singleLinked.list();
        System.out.println("未修改的节点信息");
        HeroNode newHeroNode = new HeroNode(2,"张三","李四");
        singleLinked.update(newHeroNode);
        singleLinked.list();
        singleLinked.del(4);
        singleLinked.list();
    }

}
class SingleLinked{

    // 定一个头节点
    private HeroNode head = new HeroNode(0,"","");

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