package Util;

public class GraphNode {
	
	private int S;//结点个数
	private int D;//边的个数	
	private int r; //起点
	private int t; //终点
	
	
	public int getS() {
		return S;
	}
	
	public void setS(int s) {
		if (s >= 1&&s < 10) {
			S = s;
			//System.out.println("--节点数目设置成功！     ");
		}else {
			//System.out.println("--节点个数用满足1<=S<10！");
		}

	}
	public int getD() {
		return D;
	}
	public void setD(int d) {
		if (d >=1 && d <= S*(S-1)/2) {
			D = d;
			//System.out.println("边数设置成功！！");
		}else {
			//System.out.println("边个数应满足条件！");
		}
	}
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}
	public int getT() {
		return t;
	}
	public void setT(int t) {
		this.t = t;
	}
}
