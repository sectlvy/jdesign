package Util;

import java.util.ArrayList;

public class Graph {
    //有向带权图。-1表示无路可通。自己到自己也是-1。其它表示权值。
    public static int[][] graph = new int [DijkstraForth.lengthd][DijkstraForth.lengthd];
    public static boolean[] hasFlag=new boolean[graph.length];
    //true-表示该结点已访问过。false-表示还没有访问过。
    
    public static ArrayList<String> res=new ArrayList<String>();
    //最后的所有的路径的结果。每一条路径的格式是如：0->2->1->3:7
    
    //求在图graph上源点s到目标点d之间所有的简单路径，并求出路径的和。    
    public static void getPaths(int s,int d,String path)
    {
        hasFlag[s]=true;//源点已访问过. 
     for(int i=0;i<graph.length;i++)
     {
        if (graph[s][i]==-1 || hasFlag[i])
        {
        	continue;
        }
        //若无路可通或已访问过，则找下一个结点。

        if(i==d)//若已找到一条路径
        { 
            res.add(path+"->"+d);//加入结果。
            continue;
        }
        getPaths(i, d, path+"->"+i);//继续找
        hasFlag[i]=false;        
     }
    }
}