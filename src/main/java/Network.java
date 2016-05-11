package main.java;

import java.util.ArrayList;

import processing.core.PApplet;

/**
* This class is used for the visualization of the network.
* Depending on your implementation, you might not need to use this class or create a class on your own.
* I used the class to draw the circle and re-arrange nodes and links.
* You will need to declare other variables.
**/
public class Network {
	
	private PApplet parent;
	private int nodeNum;
	private int centerX,centerY;
	private int radius;
	private ArrayList<Character> nodes;
	
	public Network(PApplet parent){

		this.nodes = new ArrayList<Character>();
		this.parent = parent;
		this.nodeNum = 0;
		this.centerX = 600;
		this.centerY = 350;
		this.radius = 250;
	}

	public void display(){
		this.parent.strokeWeight(1);
		this.parent.fill(123,65,98);
		this.parent.ellipse(this.centerX, this.centerY, this.radius*2, this.radius*2);
		this.parent.fill(255);
		this.parent.ellipse(this.centerX, this.centerY, this.radius*2-10, this.radius*2-10);
	
	}
	public void resetNetwork(){
		nodes.clear();
		nodeNum = 0;
	}
	
	//add new node in the network
	public void addNode(Character c){
		boolean issame = false;
		
		for(Character node : nodes){
			if(node.equals(c)){
				issame = true;
				break;
			}
		}
		if(issame == false){
			nodes.add(c);
			nodeNum += 1;
			int x = 0;
			for(Character node : nodes){
				
				node.setY(this.centerY+(float)Math.sin(Math.toRadians((double)360/nodeNum)*x)*this.radius);
				node.setX(this.centerX+(float)Math.cos(Math.toRadians((double)360/nodeNum)*x)*this.radius);
				x+=1;
			}
		}
		else{
			int y = 0;
			for(Character node : nodes){
				node.setY(this.centerY+(float)Math.sin(Math.toRadians((double)360/(double)nodeNum)*y)*this.radius);
				node.setX(this.centerX+(float)Math.cos(Math.toRadians((double)360/(double)nodeNum)*y)*this.radius);
				y+=1;
			}
		}
	}
	
	public void removeNode(Character c){
		nodes.remove(c);
		nodeNum -= 1;
		int x = 0;
		if(nodes!=null){
			for(Character node : nodes){
				node.setY(this.centerY+(float)Math.sin(Math.toRadians((double)360/nodeNum)*x)*this.radius);
				node.setX(this.centerX+(float)Math.cos(Math.toRadians((double)360/nodeNum)*x)*this.radius);
				x+=1;
			}
		}
	}
	
	// getter 
	public float getX() { return this.centerX; }
	public float getY() { return this.centerY; }
	public float getRadius() { return 300; }
	
}
