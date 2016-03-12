package com.sect.groupexp;
/* 
 * To change this template, choose Tools | Templates 
 * and open the template in the editor. 
 */  
import java.util.Random;  
/** 
 *������ 
 * ��⺯�� f(x)=x1^2+(x2-x3)^2 �����ֵ 
 * @author FashionXu 
 */  
public class Particle {  
    public double[] pos;//���ӵ�λ�ã�����������ά���������Ϊ����ά   
    public double[] v;//���ӵ��ٶȣ�ά��ͬλ��   
    public double fitness;//���ӵ���Ӧ��   
    public double[] pbest;//���ӵ���ʷ���λ��   
    public static double[] gbest;//���������ҵ������λ��   
    public static Random rnd;  
    public static int dims;  
    public static double w;  
    public static double c1;  
    public static double c2;  
    double pbest_fitness;//��ʷ���Ž�   
    /** 
     * ����low��uper֮����� 
     * @param low ���� 
     * @param uper ���� 
     * @return ����low��uper֮����� 
     */  
    double rand(double low, double uper) {  
        rnd = new Random();  
        return rnd.nextDouble() * (uper - low) + low;  
    }  
    /** 
     * ��ʼ������ 
     * @param dim ��ʾ���ӵ�ά�� 
     */  
    public void initial(int dim) {  
        pos = new double[dim];  
        v = new double[dim];  
        pbest = new double[dim];  
        fitness = -1e6;  
        pbest_fitness = -1e6;  
        dims = dim;  
        for (int i = 0; i < dim; ++i) {  
            pos[i] = rand(-10, 10);  
            pbest[i] = pos[i];  
            v[i] = rand(-20, 20);  
        }  
    }  
    /** 
     * ��������ֵ,ͬʱ��¼��ʷ����λ�� 
     */  
    public void evaluate() {  
        fitness = pos[0] * pos[0] + (pos[1] - pos[2]) * (pos[1] - pos[2]);  
        if (fitness > pbest_fitness) {  
            for (int i = 0; i < dims; ++i) {  
                pbest[i] = pos[i];  
            }  
        }  
    }  
    /** 
     * �����ٶȺ�λ�� 
     */  
    public void updatev() {  
        for (int i = 0; i < dims; ++i) {  
            v[i] = w * v[i] + c1 * rnd.nextDouble() * (pbest[i] - pos[i])  
                    + c2 * rnd.nextDouble() * (gbest[i] - pos[i]);  
            if (v[i] > 20) {  
                v[i] = 20;  
            }  
            if (v[i] < -20) {  
                v[i] = -20;  
            }  
            pos[i] = pos[i] + v[i];  
            if (pos[i] > 10) {  
                pos[i] = 10;  
            }  
            if (pos[i] < -10) {  
                pos[i] = -10;  
            }  
        }  
    }  
}  
