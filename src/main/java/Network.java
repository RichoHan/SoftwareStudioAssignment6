package main.java;

import java.util.ArrayList;

import de.looksgood.ani.Ani;
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
	private ArrayList<Character> nodes;
	
	public Network(PApplet parent){

		this.nodes = new ArrayList<Character>();
		this.parent = parent;
		this.nodeNum = 0;
		this.centerX = 600;
		this.centerY = 350;
	}

	public void display(){
		this.parent.fill(123,65,98);
		this.parent.ellipse(this.centerX, this.centerY, 600, 600);
		this.parent.fill(255);
		this.parent.ellipse(this.centerX, this.centerY, 590, 590);
	
		/*for(Character node : nodes){
			for(Character o_node : node.getLinks()){
				this.parent.fill(123);
				this.parent.line(node.getX(), node.getY(), o_node.getX(), o_node.getY());
			}
		}*/
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
				node.setY(this.centerY+(float)Math.sin(Math.toRadians(360/nodeNum)*x)*300);
				node.setX(this.centerX+(float)Math.cos(Math.toRadians(360/nodeNum)*x)*300);
				x+=1;
			}
		}
		else{
			int y = 0;
			for(Character node : nodes){
				node.setY(this.centerY+(float)Math.sin(Math.toRadians(360/nodeNum)*y)*300);
				node.setX(this.centerX+(float)Math.cos(Math.toRadians(360/nodeNum)*y)*300);
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
				node.setY(this.centerY+(float)Math.sin(Math.toRadians(360/nodeNum)*x)*300);
				node.setX(this.centerX+(float)Math.cos(Math.toRadians(360/nodeNum)*x)*300);
				x+=1;
			}
		}
	}
	
	// getter 
	public float getX() { return 600; }
	public float getY() { return 350; }
	public float getRadius() { return 300; }
	
}
