package com.sect.nodetree;

public class BinaryNode {
	
	private BinaryNode leftNode;
	private BinaryNode rightNode;
	private BinaryNode parentNode;
	
	private String nodename;
	private int nodevalue;
	
	private boolean isRoot=false;
	private boolean isReaf = true;
	
	public BinaryNode(String nodename,int nodevalue){
		this.nodename = nodename;
		this.nodevalue = nodevalue;
	}
	
	public BinaryNode(String nodename,int nodevalue,boolean isRoot){
		this.nodename = nodename;
		this.nodevalue = nodevalue;
		this.isRoot = isRoot;
	}

	public BinaryNode getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(BinaryNode leftNode) {
		isReaf = false;
		this.leftNode = leftNode;
	}

	public BinaryNode getRightNode() {
		return rightNode;
	}

	public void setRightNode(BinaryNode rightNode) {
		isReaf = false;
		this.rightNode = rightNode;
	}

	public BinaryNode getParentNode() {
		return parentNode;
	}

	public void setParentNode(BinaryNode parentNode) {
		this.parentNode = parentNode;
	}

	public String getNodename() {
		return nodename;
	}

	public void setNodename(String nodename) {
		this.nodename = nodename;
	}

	public int getNodevalue() {
		return nodevalue;
	}

	public void setNodevalue(int nodevalue) {
		this.nodevalue = nodevalue;
	}

	public boolean isRoot() {
		return isRoot;
	}

	public void setRoot(boolean isRoot) {
		this.isRoot = isRoot;
	}

	public boolean isReaf() {
		return isReaf;
	}

	public void setReaf(boolean isReaf) {
		this.isReaf = isReaf;
	}
	
}
