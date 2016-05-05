package main.java;

import de.looksgood.ani.Ani;
import processing.core.PApplet;

/**
* This class is for sketching outcome using Processing
* You can do major UI control and some visualization in this class.  
*/
@SuppressWarnings("serial")
public class MainApplet extends PApplet{
	private String path = "main/resources/";
	private String file = "starwars-episode-1-interactions.json";
	
	private final static int width = 1200, height = 650;
	private int x,y;
	public void setup() {

		size(width, height);
		smooth();
		loadData();
		Ani.init(this);
		x = 50;
		y = 50;
		
	}
	
	
	public void draw() {
		background(255);
		fill(0);
		ellipse(x,y,100,100);
		
	}

	public void mousePressed(){ 
		test();
	}
	public void test(){
		Ani.to(this, (float) 0.5, "x", mouseX); 
		Ani.to(this, (float) 0.5, "y", mouseY); 
	}
	private void loadData(){

	}

}
