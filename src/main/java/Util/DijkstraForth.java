package Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;


public class DijkstraForth {  
	//剩余工作为，为此项目添加相应的输入输出，并按照要求将结果输出。
	    public static int lengthd;
	    public static void dijkstra(int[][] A, int start, int end) {  
	    	
	    	lengthd = A[0].length;
	        boolean[] isLabel = new boolean[A[0].length];// 是否标号  
	        int[] indexs = new int[A[0].length];// 所有标号的点的下标集合，以标号的先后顺序进行存储，实际上是一个以数组表示的栈  
	        int i_count = -1;//栈的顶点  
	        int[] distance = A[start].clone();// v0到各点的最短距离的初始值  
	        int index = start;// 从初始点开始  
	        int presentShortest = 0;//当前临时最短距离  
	        indexs[++i_count] = index;// 把已经标号的下标存入下标集中 ,初始化操作
	        isLabel[index] = true;  //是否已经进行了标号，初始化操作。
	        
	        
	        //添加一个用来维护的矩阵，专门维护路径。
	        final int colume = A[0].length;
	        int rownum = colume;

	        
	        int p [][] = new int[colume][rownum];//这个数组就是P数组
            
	        int q [][] = new int[colume][rownum];
	        int q1counter = 0;
	        int q2counter = 0;
	        
	        //设置当前p，d的初始值，并初始化路径记录队列。
	        for (int i = 0; i < p.length; i++) {
				for (int j = 0; j < p.length; j++) {
					p[i][j] = -1;
					q[i][j] = -1;
				}
			}	        //将整个路径标记队列初始化为-1 

            //print(p);
	        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<ArrayList<Integer>>();
	        while (i_count < A[0].length) {  
	        	
	            // 第一步：标号v0,即为w[0][0]找到距离v0最近的点  
	 
	            int min = Integer.MAX_VALUE;
	            
	            for (int i = 0; i < distance.length; i++) {  
	                if (!isLabel[i] && distance[i] != -1 && i != index) {  
	                    // 如果到这个点有边,并且没有被标号 ，而且是最短的。
	                    if (distance[i] < min) {  
	                        min = distance[i];
	                        //D[dcounter++] = min; 
	                        index = i;// 把工作下标改为当前需要加入结点的下标  
	                    }  
	                }  
	            }  //index 是当前待加入的点。
	            //此处进行一步复制。
	            if (index == end) {//已经找到当前点了，就结束程序  
	                break;  
	                //讲end加入到当前记录队列的最后
	            }
	            
                
	            isLabel[index] = true;    //对点进行标号  ，加入集合，表示已经进入。
	            indexs[++i_count] = index;// 把已经标号的下标存入下标集中  ,存已经加入集合的下标
	            

	            if (A[indexs[i_count - 1]][index] == -1 
	                    || presentShortest + A[indexs[i_count - 1]][index] > distance[index]) {  
	                // 如果两个点没有直接相连，或者两个点之间的路径大于最短路径  ,更新到index点的路径信息。
	                presentShortest = distance[index];
	            } else {  
	                presentShortest += A[indexs[i_count - 1]][index];  
	                //反之。选择直接到达的路径为最短路径
	            }  
	 
	            // 第二步：将distance中的距离加入vi  
	            for (int i = 0; i < distance.length; i++) {  
	                // 如果vi到那个点有边，则v0到后面点的距离加  
	                if (distance[i] == -1 && A[index][i] != -1) {// 如果以前不可达，则现在可达了  
	                    distance[i] = presentShortest + A[index][i];  
	                } else if (A[index][i] != -1 
	                        && presentShortest + A[index][i] < distance[i]) {  
	                    // 如果以前可达，但现在的路径比以前更短，则更换成更短的路径  
	                    distance[i] = presentShortest + A[index][i];
	                }  
	 
	            }  
	        }  
	        //如果全部点都遍历完，则distance中存储的是开始点到各个点的最短路径长度。
/*	        for (int i = 0; i < colume; i++) {
				for (int j = 0; j < colume; j++) {
                      System.out.print(distance[j]);
				}
				System.out.println();}*/
	        for (int i = 0; i < distance.length; i++) {
				for (int j = 0; j < distance.length; j++) {
					if (A[i][j] > 0 && distance[i] != -1) {
						p[i][j] = A[i][j]+distance[i];
					}else {
						p[i][j] = A[i][j];
					}
				}
			}
	        
	        for (int i = 0; i < distance.length; i++) {
				arrayList.add(success(distance, p, i));
			}
	        
	        for (Iterator<ArrayList<Integer>> i = arrayList.iterator();i.hasNext();q1counter++) {
	        	
				ArrayList<Integer> v = i.next();
				q2counter=0;
				for (Iterator<Integer> j = v.iterator(); j.hasNext();) {
					int num = j.next();
						q[q1counter][q2counter] = num;
						q2counter++;
						//System.out.print(num+" ");								
				}
				//System.out.println();
			}
	        for (int i = 0; i < p.length; i++) {
				for (int j = 0; j < p.length; j++) {
					p[i][j] = -1;
				}
			}	        //将整个路径标记队列初始化为-1 
        
	        Changeq2p(q, p);
	        Graph.graph=p;
	        //System.out.println();
	        Graph.getPaths(start, end, ""+start);	        
	        //调用写入分析函数。  
	    	System.out.println("---This is the output!!!---");
	        System.out.println(Graph.res.size()+" "+(distance[end] - distance[start]));
            //此处调用结果处理函数，并进行标准化的输出。
	        ///System.out.println();
	        FormatOutput(Graph.res);	        
	    }  
	    /*public static void main(String[] args) {          
	    	// 建立一个权值矩阵         
	    	int[][] W1 = { //测试数据1                  
	    			{ 0, 1, 4, -1, -1, -1 },                 
	    			{ 1, 0, 2, 7, 5, -1 },                  
	    			{ 4, 2, 0, -1, 1, -1 },                  
	    			{ -1, 7, -1, 0, 3, 2 },                  
	    			{ -1, 5, 1, 3, 0, 6 },                  
	    			{ -1, -1, -1, 2, 6, 0 } };         
	    	int[][] W = { //测试数据2                  
	    			{ 0, 1, 3, 4 },                  
	    			{ 1, 0, 2, -1 },                  
	    			{ 3, 2, 0, 5 },                  
	    			{ 4, -1, 5, 0 } }; 
	    	int[][] M = {
	    			{0,2,1,-1,-1},
	    			{2,0,1,1,2},
	    			{1,1,0,2,-1},
	    			{-1,1,2,0,1},
	    			{-1,2,-1,1,0},
	    	};

	    	dijkstra(M,0,4);
	    	}
*/
	    public static void print(int [][] a) {
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a.length; j++) {
					System.out.print(a[i][j]+" ");
				}
				System.out.println();
			}
		}
	    public static ArrayList<Integer> success(int D[],int P[][],int u) {
	    	ArrayList<Integer>a = new ArrayList<Integer>();
	    	for (int w = 0; w < P.length; w++) {
	    		if (D[w] == P[u][w] && w != u) {
					a.add(w);
				}
			}
	    	return a;
		}   
	    public static void Changeq2p(int [][]q,int [][]p){
	    	for (int i = 0; i < q.length; i++) {
				for (int j = 0; j < q.length; j++) {
					if (q[i][j]!=-1) {
						p[i][q[i][j]]=1;
					}  
				}
			}
	    }
	    private static void FormatOutput(ArrayList<String>ResultList){
	    	//这个函数的作用是，将其中的数字提取并+1
	    	Iterator<String> strs = ResultList.iterator();
	    	int counter = 0;
	    	int [][] numbers = new int [ResultList.size()][DijkstraForth.lengthd];//注意这里的初始化。
			int [][] tempNumbers = new int [ResultList.size()][DijkstraForth.lengthd];// 存的是数字，已经倒序,并+1
			String flagString[]= new String [ResultList.size()];
			Stack<Integer>stack =new Stack<Integer>();
	    	while (strs.hasNext()) {
				String string = strs.next();
				String [] stringnumbers = string.split("->");
				
				//进行到此处。

				for (int i = 0; i < stringnumbers.length; i++) {
					numbers[counter][i] = Integer.parseInt(stringnumbers[i])+1;
					stack.push(numbers[counter][i]);
					//innerString += (numbers[counter][i]+" ");
					//System.out.print(numbers[counter][i]+" ");
				}
				String s =new String();
				for (int i = 0; i < stringnumbers.length; i++) {
					tempNumbers[counter][i]=stack.pop();
					s += tempNumbers[counter][i]+" ";
				}
				flagString[counter] = s;
				counter++;	
				//System.out.println();
			}
	    	//print(numbers);
	    	//System.out.println();
	    	//print(tempNumbers);
	    	//PrintStringArray(flagString);
	    	//将每一行通过栈操作已经倒序。用于临时计算的数组为temNumbers[][]。
	    	//顺序要满足T_i的反向序列的字典序小于T_i+1的反向序列的字典序
	    	//flagstring[]中存的是各个记录的字符型
	    	
	    	//下面对数组中的元素进行排序。
	    	BubbleSort(flagString);
	    	//System.out.println("----");
	    	//PrintStringArray(flagString);   	
	    	//falgString中存的是已经排好序的数组。需要将每一项倒序输出.
	    	upsidedownOutPut(flagString);
	    	PrintStringArray(flagString);
	    }
		private static void upsidedownOutPut(String[] flagString) {
			// TODO Auto-generated method stub
			//此函数的作用是将String中的每一项都倒序输出
			Stack<String> s = new Stack<String>();
			
			for (int i = 0; i < flagString.length; i++) {
				String str = flagString[i];
				String[] numinner= str.split(" ");
				String strone =new String();
				for (int j = 0; j < numinner.length; j++) {
					s.push(numinner[j]);
				}
				for (int j = 0; j < numinner.length; j++) {
					strone += s.pop()+" ";
				}
				flagString[i]=strone;
			}
		}
		private static void PrintStringArray(String[] flagString) {
			for (int i = 0; i < flagString.length; i++) {
	    		System.out.println(flagString[i]);
			}
		}
	    
	    private static void BubbleSort(String [] x) {   
	    	for (int i = 0; i < x.length; i++) {   
	    		for (int j = i + 1; j < x.length; j++) {   
	    			if (x[i].compareTo(x[j])>0) {   
	    				String temp = x[i];   
	    				x[i] = x[j];   
	    				x[j] = temp;   }   
	    			}   
	    		}     
	    	}   
}
