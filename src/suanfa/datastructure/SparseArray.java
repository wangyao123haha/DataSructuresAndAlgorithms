package suanfa.datastructure;

/**
 * @Description 稀疏数组实现
 * @Author wangyao
 * @Data 2024/3/10 23:08
 */

public class SparseArray {

    public static void main(String[] args) {
        // 定义个原始二维数组
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        // 输出原始二维数组
        System.out.println("原始二维数组");
        for(int[] ints: chessArr1){
             for(int i : ints){
                 System.out.printf("%d\t",i);
             }
            System.out.println();
        }
        // 将二维数组转稀疏数组
        // 得出非0数据
        int sum = 0;
        for(int i=0;i<chessArr1.length;i++){
            for(int j=0;j<chessArr1.length;j++){
                if(chessArr1[i][j]!=0){
                    sum++;
                }
            }
        }
        System.out.println("sum="+sum);
        // 创建对应的稀疏数组
        int spareArray[][] = new int[sum+1][3];
        // 给稀疏数组赋值
        spareArray[0][0] = chessArr1.length;
        spareArray[0][1] = chessArr1.length;
        spareArray[0][2] = sum;
        int count = 0;
        for(int i=0;i<chessArr1.length;i++){
            for(int j=0;j<chessArr1.length;j++){
                if(chessArr1[i][j]!=0){
                    count++;
                    spareArray[count][0] = i;
                    spareArray[count][1] = j;
                    spareArray[count][2] = chessArr1[i][j];
                }
            }
        }
        // 得到的稀疏数组
        System.out.println();
        System.out.println("得到的稀疏数组～");
        for(int[] ints: spareArray){
            for(int i : ints){
                System.out.printf("%d\t",i);
            }
            System.out.println();
        }

        // 将稀疏数组还原
        int chessArr2[][] = new int[spareArray[0][0]][spareArray[0][1]];
        // 将真实数据放入棋盘
        for(int i = 1;i<spareArray.length;i++){
            chessArr2[spareArray[i][0]][spareArray[i][1]] = spareArray[i][2];
        }
        for(int[] ints: chessArr2){
            for(int i : ints){
                System.out.printf("%d\t",i);
            }
            System.out.println();
        }
    }
}
