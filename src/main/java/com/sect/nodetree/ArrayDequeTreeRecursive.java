package com.sect.nodetree;

import java.util.ArrayDeque;

public class ArrayDequeTreeRecursive {
	private ArrayDeque<BinaryNode> stack = new  ArrayDeque<BinaryNode>();
	private BinaryNode rootNode;
	
	public ArrayDequeTreeRecursive(BinaryNode rootNode){
		this.rootNode = rootNode;
	}
	public ArrayDequeTreeRecursive createDequeTree(){
		BinaryNode rootNode = new BinaryNode("R",'r');
		BinaryNode lenode = new BinaryNode("A",'A');
		BinaryNode rnode = new BinaryNode("B",'B');
		BinaryNode llnode = new BinaryNode("AA",'A'+'A');
		BinaryNode rrnode = new BinaryNode("BB",'B'+'B');
		
		if(this.rootNode != null){
			rootNode.setLeftNode(lenode);
			rootNode.setRightNode(rnode);
			
			lenode.setLeftNode(llnode);
			rnode.setRightNode(rrnode);
		}
		
		return new ArrayDequeTreeRecursive(rootNode);
	}
	
	public void printPath(BinaryNode node){
		while(node!=null){
			
			stack.push(node);
			
			node = node.getLeftNode();
		}
	}
}
