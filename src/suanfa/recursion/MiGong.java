package suanfa.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 迷宫
 * @Author wangyao
 * @Data 2024/3/19 22:39
 */

public class MiGong {
    public static void main(String[] args) {
        // 二维数组模拟迷宫
        int [][] map = new int[8][7];
        for(int i =0;i<7;i++){
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for(int i= 0;i<8;i++){
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] =1;
        map[3][2] =1; 
        System.out.println("当前地图~~~~");
        for(int i=0;i<8;i++){
            for(int j =0;j<7;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        List<Integer> path = new ArrayList<>();
        // 模拟迷宫
        setWay(map,1,1,path);
        System.out.println(path.size());
        System.out.println("迷宫走完~~~~");
        for(int i=0;i<8;i++){
            for(int j =0;j<7;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
    /**
     * 1 表示墙  2 表示可以走 3表示已经走过
     * 求出最短路径
     */
    public static boolean setWay(int[][] map, int i, int j, List<Integer> path){
        if(map[6][5]==2){
            // 已经找到出路
            return true;
        }else{
            // 当前位置是0 可以继续走
            if(map[i][j]==0){
                // 制定策略 //上下左右走
                map[i][j] =2;
                if(setWay(map,i+1,j,path)){
                    path.add(map[i][j]);
                    // 向下走
                    return true;
                } else if (setWay(map,i,j+1,path)) {
                    path.add(map[i][j]);
                    // 向右走
                    return true;
                }else if(setWay(map,i-1,j,path)){
                    path.add(map[i][j]);
                    // 向上走
                    return true;
                }else if(setWay(map,i,j-1,path)){
                    path.add(map[i][j]);
                    // 向左走
                    return true;
                }else{
                    map[i][j] = 3;
                    return false;
                }
            }else{
                return false;
            }
        }
    }
}
