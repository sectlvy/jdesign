package Main;
/**
 * 此题目是北京大学java高级技术的一道算法题目，输入请按照要求，程序中没有对输入进行边界测试，只关注算法本身。大家可以自行优化。请勿抄袭作业，旨在交流学习。

	题目描述：已知一个无向图G=（V，E），
	G中任意两个顶点u、v之间存在路径或者不存在路径，
	如果存在，则会有一个或者多个最短路径。
	给出两个顶点u0和v0，请用一种效率尽可能高的算法求u0和v0之间的所有的最短路径。
	输入：第1行：图的顶点数1<=N<10和边数1<=M<=N*(N-1)/2，第2...M+1行：图中的边（u，v，w）
	，其中u为边起点，v为边终点，w为边的权值
	（u、v、w均为整数，1<=u<=N，1<=v<=N，1<=w<=100），
	第M+2行：u0和v0。输出：如果u0和v0之间没有路径，输出0；
	其它情况：第1行为最短路径的条数S和最短路径的长度D，
	第2...S+1行中的每一行为最短路径的顶点序列T_i(1<=i<=S)，
	其中，T_1、T_2、...、T_S的顺序要满足T_i的反向序列的字典序小于T_i+1的反向
	序列的字典序的条件。例如，样例中T_1=<2，4>的反向序列为<4，2>，T_2=<2，3，4>
	的反向序列为<4，3，2>，则有<4，2>的字典序小于<4，3，2>的字典序。
	输入示例： 5 8 2 1 2 1 5 2 2 3 5 2 4 6 2 5 5 3 4 1 3 5 1 4 5 2 2 4 
	输出示例： 4 6 2 4 2 3 4 2 1 5 3 4 2 1 5 4
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Util.DijkstraForth;
import Util.GraphNode;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		GraphNode graphnode = new GraphNode();
		System.out.println("---Please input the graph informatiion!!!---");
//		String s = bufferedReader.readLine();
		String s="5 8 2 1 2 1 5 2 2 3 5 2 4 6 2 5 5 3 4 1 3 5 1 4 5 2 2 4";
        String [] ss1 = s.split(" ");
//        ss1 = new String[]{"8","2","1","2","1","5","2","2","3","5","2","4","6","2","5","5","3","4","1","3","5","1","4","5","2","2","4"};
        int [] num = new int [ss1.length];
        
        for (int i = 0; i < ss1.length; i++) {
			num[i] = Integer.parseInt(ss1[i]);
		}
        //graph设置结点数和变数。
        graphnode.setS(num[0]);
        graphnode.setD(num[1]);
        
        int [][] M = new int [graphnode.getS()][graphnode.getS()];
        for (int i = 0; i < M.length; i++) {
			for (int j = 0; j < M.length; j++) {
				M[i][j] = -1;
			}
		}
        for (int i = 0; i < M.length; i++) {
				M[i][i]=0;		
		}//对角线设置为0;
             
        //print(M);
        int counter = 0;
        while(counter < graphnode.getD()){
        	s=bufferedReader.readLine();
        	String [] ss2=s.split(" ");
            for (int i = 0; i < ss2.length; i++) {
    			num[i] = Integer.parseInt(ss2[i]);
    		}
            M[num[0]-1][num[1]-1] = num[2];
            M[num[1]-1][num[0]-1] = num[2];//无向图，需要设置两次权值。
            counter++;
            //System.out.println(counter);
        }       
        //print(M);
        
        s=bufferedReader.readLine();
        String [] ss3=s.split(" ");
        for (int i = 0; i < ss3.length; i++) {
			num[i] = Integer.parseInt(ss3[i]);
		}
        
        graphnode.setR(num[0]-1);
        graphnode.setT(num[1]-1);
        
        //获取数据完毕，下面等待计算。并直接输出。
        DijkstraForth.dijkstra(M,graphnode.getR(),graphnode.getT());

	}
	public static void print(int [][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}
}
