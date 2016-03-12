package com.sect.groupexp;
/* 
 * To change this template, choose Tools | Templates 
 * and open the template in the editor. 
 */  
/** 
 *����Ⱥ�� 
 * @author FashionXu 
 */  
public class PSO {  
    /** 
     * ����Ⱥ 
     */  
    Particle[] pars;  
    double global_best;//ȫ�����Ž�   
    int pcount;//���ӵ�����   
    /** 
     * ����Ⱥ��ʼ�� 
     * @param n ���ӵ����� 
     */  
    public void init(int n) {  
        pcount = n;  
        global_best = -1e6;  
        int index = -1;  
        pars = new Particle[pcount];  
        //��ľ�̬��Ա�ĳ�ʼ��   
        Particle.c1 = 2;  
        Particle.c2 = 2;  
        Particle.w = 0.8;  
        Particle.dims = 3;  
        for (int i = 0; i < pcount; ++i) {  
            pars[i] = new Particle();  
            pars[i].initial(3);  
            pars[i].evaluate();  
            if (global_best < pars[i].fitness) {  
                global_best = pars[i].fitness;  
                index = i;  
            }  
        }  
        Particle.gbest = new double[Particle.dims];  
        for (int i = 0; i < 3; ++i) {  
            Particle.gbest[i] = pars[index].pos[i];  
        }  
    }  
    /** 
     * ����Ⱥ������ 
     */  
    public void run() {  
        int runtimes = 500;  
        int index;  
        while (runtimes > 0) {  
            index = -1;  
            //ÿ�����Ӹ���λ�ú���Ӧֵ   
            for (int i = 0; i < pcount; ++i) {  
                pars[i].updatev();  
                pars[i].evaluate();  
                if (global_best < pars[i].fitness) {  
                    global_best = pars[i].fitness;  
                    index = i;  
                }  
            }  
            //���ָ��õĽ�   
            if (index != -1) {  
                for (int i = 0; i < 3; ++i) {  
                    Particle.gbest[i] = pars[index].pos[i];  
                }  
            }  
            --runtimes;  
        }  
    }  
    /** 
     * ��ʾ��������� 
     */  
    public void showresult() {  
        System.out.println("������õ����Ž���" + global_best);  
        System.out.println("ÿһά��ֵ��");  
        for (int i = 0; i < Particle.dims; ++i) {  
            System.out.println(Particle.gbest[i]);  
        }  
    }  
}  
