package com.sect.nodetree;
/**
 * 
 * @author Administrator
 *
 */
public class PrintTreePath {
	public static void main(String[] args){
		BitTree bitTree = new BitTree();
		
		for(int i=0;i<20;i++){
			BinaryNode leftNode = new BinaryNode("��0"+i,i);
			bitTree.addLeftNode(leftNode);
			BinaryNode rightNode = new BinaryNode("��1"+i,i);
			bitTree.addLeftNode(rightNode);
		}
		
		(new PrintTreePath()).printPath(bitTree);
	}
	
	public void printPath(BitTree bitTree){
		BinaryNode rootNode = bitTree.getRoot();
		print(rootNode);
	}
	
	public void print(BinaryNode rootNode){
		if(rootNode!=null && !rootNode.isReaf()){
			System.out.println(rootNode.getNodename()+"@@@"+rootNode.getNodevalue());
			print(rootNode.getLeftNode());
			print(rootNode.getRightNode());
		}
	}
}
