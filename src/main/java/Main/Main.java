package Main;
/**
 * ����Ŀ�Ǳ�����ѧjava�߼�������һ���㷨��Ŀ�������밴��Ҫ�󣬳�����û�ж�������б߽���ԣ�ֻ��ע�㷨������ҿ��������Ż�������Ϯ��ҵ��ּ�ڽ���ѧϰ��

	��Ŀ��������֪һ������ͼG=��V��E����
	G��������������u��v֮�����·�����߲�����·����
	������ڣ������һ�����߶�����·����
	������������u0��v0������һ��Ч�ʾ����ܸߵ��㷨��u0��v0֮������е����·����
	���룺��1�У�ͼ�Ķ�����1<=N<10�ͱ���1<=M<=N*(N-1)/2����2...M+1�У�ͼ�еıߣ�u��v��w��
	������uΪ����㣬vΪ���յ㣬wΪ�ߵ�Ȩֵ
	��u��v��w��Ϊ������1<=u<=N��1<=v<=N��1<=w<=100����
	��M+2�У�u0��v0����������u0��v0֮��û��·�������0��
	�����������1��Ϊ���·��������S�����·���ĳ���D��
	��2...S+1���е�ÿһ��Ϊ���·���Ķ�������T_i(1<=i<=S)��
	���У�T_1��T_2��...��T_S��˳��Ҫ����T_i�ķ������е��ֵ���С��T_i+1�ķ���
	���е��ֵ�������������磬������T_1=<2��4>�ķ�������Ϊ<4��2>��T_2=<2��3��4>
	�ķ�������Ϊ<4��3��2>������<4��2>���ֵ���С��<4��3��2>���ֵ���
	����ʾ���� 5 8 2 1 2 1 5 2 2 3 5 2 4 6 2 5 5 3 4 1 3 5 1 4 5 2 2 4 
	���ʾ���� 4 6 2 4 2 3 4 2 1 5 3 4 2 1 5 4
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
        //graph���ý�����ͱ�����
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
		}//�Խ�������Ϊ0;
             
        //print(M);
        int counter = 0;
        while(counter < graphnode.getD()){
        	s=bufferedReader.readLine();
        	String [] ss2=s.split(" ");
            for (int i = 0; i < ss2.length; i++) {
    			num[i] = Integer.parseInt(ss2[i]);
    		}
            M[num[0]-1][num[1]-1] = num[2];
            M[num[1]-1][num[0]-1] = num[2];//����ͼ����Ҫ��������Ȩֵ��
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
        
        //��ȡ������ϣ�����ȴ����㡣��ֱ�������
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
