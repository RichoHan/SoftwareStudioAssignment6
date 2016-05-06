package main.java;

import processing.core.PApplet;

/**
* This class is used for the visualization of the network.
* Depending on your implementation, you might not need to use this class or create a class on your own.
* I used the class to draw the circle and re-arrange nodes and links.
* You will need to declare other variables.
**/
public class Network {
	
	private PApplet parent;

	public Network(PApplet parent){

		this.parent = parent;
		
	}

	public void display(){
		this.parent.fill(123,16,98);
		this.parent.ellipse(600, 350, 600, 600);
		this.parent.fill(255);
		this.parent.ellipse(600, 350, 590, 590);
	}
	
}
