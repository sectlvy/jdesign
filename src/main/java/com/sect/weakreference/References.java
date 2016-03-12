package com.sect.weakreference;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;
 
class Grocery {  
   private static final int SIZE = 10000;  
   // ����dʹ��ÿ��Grocery����ռ�ý϶��ڴ棬��80K����  
    private double[] d = new double[SIZE];  
    private String id;  
  
    public Grocery(String id) {  
       this.id = id;  
    }  
 
    public String toString() {  
       return id;  
   }  

   public void finalize() {  
       System.out.println("Finalizing " + id);  
    }  
}  
  
public class References {  
    private static ReferenceQueue rq = new ReferenceQueue();  
 
   public static void checkQueue() {  
       Reference inq = rq.poll();  
        // �Ӷ�����ȡ��һ������  
       if (inq != null)  
           System.out.println("In queue: " + inq + " : " + inq.get());  
   }  
  
    public static void main(String[] args) {  
        final int size = 10;  
        // ����10��Grocery�����Լ�10��������  
        Set sa = new HashSet();  
       for (int i = 0; i < size; i++) {  
            SoftReference ref = new SoftReference(new Grocery("soft" + i), rq);  
            System.out.println("Just created soft: " + ref.get());  
            sa.add(ref);  
        }  
      System.gc();  
      checkQueue();  
       System.out.println("---------------------------------------------------");  
        // ����10��Grocery�����Լ�10��������  
       Set wa = new HashSet();  
        for (int i = 0; i < size; i++) {  
          WeakReference ref = new WeakReference(new Grocery ("weak " + i), rq);  
          System.out.println("Just created weak: " + ref.get());  
            wa.add(ref);  
        }  
        System.gc();  
        checkQueue();  
       System.out.println("---------------------------------------------------");  
       // ����10��Grocery�����Լ�10��������  
        Set pa = new HashSet();  
      for (int i = 0; i < size; i++) {  
           PhantomReference ref =new PhantomReference(new Grocery("Phantom " + i), rq);  
            System.out.println("Just created Phantom: " + ref.get());  
            pa.add(ref);  
        }  
        System.gc();  
        checkQueue();  
    }  
}  
