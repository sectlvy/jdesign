package com.sect.luoxuan;
/**
 * ��������
 * 20    21    22    23    24    

 * 19    6    7    8    9    

 * 18    5    0    1    10    

 * 17    4    3    2    11    

 * 16    15    14    13    12    
 * @author Administrator
 *
 */
public class ModelInsideRoll {

	private int n;//n��
	private int m;//mȦ
	
	private int[][] arrayNum;
	public ModelInsideRoll(int n){
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
		int k = n*n;
		arrayNum = new int[n][n];
		for(int i=0;i<m;i++){
			//����
			if(i==0 && n/2==0){
				
			}else{
				for(int j=n-i-1;j>=i;j--){
					k--;
					arrayNum[i][j]=k;
				}
				//�������
				for(int j=i+1;j<n-i;j++){
					k--;
					arrayNum[j][i]=k;
				}
			}
			//����
			for(int j=i+1;j<=n-i-1;j++){
				k--;
				arrayNum[n-i-1][j]=k;
			}
			//�Ҳ�����
			for(int j=n-i-2;j>i;j--){
				k--;
				arrayNum[j][n-i-1]=k;
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
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ModelInsideRoll modelOutsideRoll = new ModelInsideRoll(4);
		modelOutsideRoll.print();
	}

}
