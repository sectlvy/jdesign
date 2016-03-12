package com.sect.luoxuan;
/**
 * �������㷨
 * 2010-10-5
 * @author jinliang
 *
 */
public class RollNum {
    static int num = 5;
    static int X;
    static int Y;
    static int pianli;
    static int[][] array;
    static int[][] add = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };// ��������
    public static void main(String arg[]) {
        array = new int[num][num];
        X = num - 1;// ���x
        Y = 0;// ���y
        int MAX = num * num;
        array[X][Y] = MAX;
        int fornum = num - 1;//�ݼӣ�����ѭ������
       
        for (int i = 1; i <= num * 2 - 1; i++) {// ת��ѭ���ı����   
            //�˴�ѭ������
            int x = add[(i-1) % 4][0];
            int y = add[(i-1) % 4][1];
            if (i < 4) {//ͷ���β����ݼӣ�����ѭ������           
                for (int j = fornum; j > 0; j--) {
                    array[X + x][Y + y] = MAX - 1;
                    X = X + x;
                    Y = Y + y;
                    MAX = MAX - 1;
                }
            }else{
                if(i%2==0){
                    fornum=fornum-1;//�������λ�һ�εݼӣ�����ѭ������������һ��
                }               
                for (int j = fornum; j > 0; j--) {
                    array[X + x][Y + y] = MAX - 1;
                    X = X + x;
                    Y = Y + y;
                    MAX = MAX - 1;
                }
            }
        }
        //ѭ���������
        for(int i=0;i<num;i++){
            for(int j=0;j<num;j++){
                System.out.print(" "+array[i][j]);           
            }
            System.out.println("");
        }
    }
}
