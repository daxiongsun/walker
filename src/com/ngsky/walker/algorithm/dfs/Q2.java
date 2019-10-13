package com.ngsky.walker.algorithm.dfs;

import java.util.Scanner;

/**
 * <dl>
 * <dt>Q2</dt>
 * <dd>Description:</dd>
 * <dd>CreateDate: 2019/10/13 下午8:40</dd>
 * </dl>
 *
 * Problem Statement:
 * 有一个NxM的园子，园子中相同标记'W'的位置表示存在积水，在8个方向上相互连接形成一个水洼，求园子中共存在多少个水洼?
 *
 * input:
 * 5 10
 * ....WW.W..
 * ..W.W..W..
 * ..W....WW.
 * ......W.WW
 * WWWWWWWWWW
 *
 * output:
 * 3
 *
 * @author ngsky
 */
public class Q2 {
    static int N,M,res;
    static char[][] field;

    // 方法一：
    static void dfs(int x,int y){
        field[x][y]='.';
        // 8个方向(8中状态)
        for(int i=-1;i<=1;i++){
            for (int j = -1; j <= 1; j++) {
                int nx=x+i;
                int ny=y+j;
                if(nx>=0&&nx<N&&ny>=0&&ny<M&&field[nx][ny]=='W') dfs(nx,ny);
            }
        }
    }

    // 方法二:
    // 定义8个方向
    static int[][] region={
            {-1,-1},{-1,0},{-1,1},
            {0,-1},{0,0},{0,1},
            {1,-1},{1,0},{1,1},
    };
    static void dfs2(int x,int y){
        field[x][y]='.';
        for (int i = 0; i < region.length; i++) {
            int nx=x+region[i][0];
            int ny=y+region[i][1];
            if(nx>=0&&nx<N&&ny>=0&&ny<M&&field[nx][ny]=='W') dfs2(nx,ny);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();
        res=0;
        field = new char[N][M];
        for (int i = 0; i < N; i++) {
            field[i]=sc.next().toCharArray();
        }
        // 选中一块积水地进行递归
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (field[i][j] == 'W') {
//                    dfs(i, j);
                    dfs2(i, j);
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}
