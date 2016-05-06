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
	private ArrayList<Character> nodes;
	
	public Network(PApplet parent){

		this.nodes = new ArrayList<Character>();
		this.parent = parent;
		this.nodeNum = 0;
		
	}

	public void display(){
		this.parent.fill(123,65,98);
		this.parent.ellipse(600, 350, 600, 600);
		this.parent.fill(255);
		this.parent.ellipse(600, 350, 590, 590);
	}
	public void resetNetwork(){
		nodes.clear();
		nodeNum = 0;
	}
	
	public void addNode(Character c){
		nodes.add(c);
		nodeNum += 1;
		int x = 0;
		for(Character node : nodes){
			node.setY(350+(float)Math.sin(Math.toRadians(360/nodeNum)*x)*300);
			node.setX(600+(float)Math.cos(Math.toRadians(360/nodeNum)*x)*300);
			x+=1;
		}
	}
	
	// getter 
	public float getX() { return 600; }
	public float getY() { return 350; }
	public float getRadius() { return 300; }
	
}
