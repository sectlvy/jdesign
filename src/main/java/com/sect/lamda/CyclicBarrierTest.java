package com.sect.lamda;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierTest {
	public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
		final CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
			System.out.println("汇总开始。。。。。。。。。。。。。。。");
		});
		
		ExecutorService es = Executors.newFixedThreadPool(20);
		final int x = 0;
		for(int i=0;i<7;i++){
			Runnable r = ()->{
				System.out.println(x+"R");
				try {
					cyclicBarrier.await();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				System.out.println("等待结束 开始向下执行 开始第二次cyclic ");
				try {
					cyclicBarrier.await();
				} catch (Exception e) {
					e.printStackTrace();
				}
			};
			
			es.execute(r);
		}
	}
	
	
	public class R2 implements Runnable{
		private String name;
		private CyclicBarrier cyclicBarrier;
		public R2(String name,CyclicBarrier cyclicBarrier){
			this.name=name;
			this.cyclicBarrier = cyclicBarrier;
		}
		@Override
		public void run() {
			for(int i=0;i<10;i++){
				System.out.print(name+"	"+i);
			}
			try {
				cyclicBarrier.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
		}
	}
}
