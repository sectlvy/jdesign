package com.sect.luoxuan;
/**
 * 1  2  3  4  5
 * 16 17 18 19 6
 * 15 24 25 20 7 
 * 14 23 22 21 8
 * 13 12 11 10 9
 * �������� 
 * @author Administrator
 *
 */
public class ModelOutsideRoll {
	private int n;//n��
	private int m;//mȦ
	
	private int[][] arrayNum;
	public ModelOutsideRoll(int n){
		this.n = n;
		init();
	}
	
	private void init() {
		//ȷ��Ȧ��
		if(n/2==0){
			m = n/2;
		}else{
			m = n/2+1;
		}
		int k = 0;
		arrayNum = new int[n][n];
		for(int i=0;i<m;i++){
			//����
			for(int j=i;j<n-i;j++){
				k++;
				arrayNum[i][j]=k;
			}
//			�Ҳ�����
			for(int j=i+1;j<n-i;j++){
				k++;
				arrayNum[j][n-i-1]=k;
			}
			//����
			for(int j=n-i-2;j>i-1;j--){
				k++;
				arrayNum[n-i-1][j]=k;
			}
			//�������
			for(int j=n-i-2;j>i;j--){
				k++;
				arrayNum[j][i]=k;
			}
		}
		
	}

	@Override
	public String toString() {
		if(arrayNum!=null){
			return arrayNum.toString();
		}else{
			return super.toString();
		}
	}
	public void print(){
		for(int i=0;i<this.arrayNum.length;i++){
			for(int j=0;j<this.arrayNum[i].length;j++){
				System.out.print(this.arrayNum[i][j]);
				for(int m =0 ;m<this.arrayNum.length*this.arrayNum[i].length/10;m++){
					System.out.print("  ");
				}
			}
			System.out.println("\r\n");
		}
		System.out.println(this.arrayNum);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ModelOutsideRoll modelOutsideRoll = new ModelOutsideRoll(5);
		modelOutsideRoll.print();
	}

}
