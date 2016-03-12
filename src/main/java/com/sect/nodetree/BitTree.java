package com.sect.nodetree;

public class BitTree {
	private BinaryNode currentNode;
	private BinaryNode rootNode;
	
	public BitTree(){
		rootNode = new BinaryNode("���ڵ�",0,true);
		
		currentNode = rootNode;
	}
	
	public void addRightNode(BinaryNode rightNode){
		if(currentNode.getRightNode()==null){
			currentNode.setParentNode(currentNode);
			currentNode.setRightNode(rightNode);
		}else{
			currentNode = currentNode.getRightNode();
			addRightNode(rightNode);
		}
	}
	
	public void addLeftNode(BinaryNode leftNode){
		if(currentNode.getLeftNode()==null){
			currentNode.setParentNode(currentNode);
			currentNode.setLeftNode(leftNode);
		}else{
			currentNode = currentNode.getLeftNode();
			addLeftNode(leftNode);
		}
	}
	
	public BinaryNode getRoot(){
		return this.rootNode;
	}
}
