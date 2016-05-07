package main.java;

import java.util.ArrayList;
import java.util.HashMap;


/**
* This class is used to store states of the characters in the program.
* You will need to declare other variables depending on your implementation.
*/
public class Character {
	
	private MainApplet parent;
	private String name;
	private String color;
	private float x,y;
	private float ini_x,ini_y;
	private float width;
	private HashMap<Character, Integer> links;
	private int r,g,b;
	private boolean isDragged;
	private boolean inNetwork;

	public Character(MainApplet parent,String name,String color,float x,float y){
		
		this.parent = parent;
		this.name = name;
		this.color = color;
		this.x = x;
		this.y = y;
		this.width = 50;
		this.isDragged = false;
		this.inNetwork = false;
		this.initial_color();
	}
	
	public void initial_color(){
		
		this.links = new HashMap<Character, Integer>();
		this.ini_x = x;
		this.ini_y = y;
		this.r = Integer.parseInt(color.substring(3, 5), 16);
		this.g = Integer.parseInt(color.substring(5, 7), 16);
		this.b = Integer.parseInt(color.substring(7, 9), 16);
	}
	
	public void display(){
		this.parent.strokeWeight(1);
		this.parent.fill(r,g,b);
		this.parent.ellipse(this.x, this.y, this.width, this.width);
		if (this.inNetwork) {
			this.showLink();
		}
	}
	
	public void showName() {
		this.parent.strokeWeight(1);
		this.parent.fill(0, 255, 0);
		this.parent.rect(this.x, this.y-40, 200, 30);
		this.parent.fill(0);
		this.parent.textSize(13);
		this.parent.text(this.name, this.x+20, this.y-20);
	}
	
	public void showLink() {
		for (Character t : links.keySet()) {
			if (t.inNetwork) {
				// the more interaction, the line has the more weight
				this.parent.strokeWeight(links.get(t)/2);
				this.parent.line(this.x, this.y, t.x, t.y);
			}
		}
	}
	
	public void changeWidth(float x){
		this.width = x;
	}

	public float getRadius() {
		return this.width/2;
	}
	public float getX(){
		return this.x;
	}
	public float getY(){
		return this.y;
	}
	
	public void setX(float x) {
		this.x = x;
	}
	public void setY(float y) {
		this.y = y;
	}
	
	public boolean getDragged() {
		return this.isDragged;
	}
	public void setDragged(boolean t) {
		this.isDragged = t;
	}
	public void setInNetwork(boolean t) {
		this.inNetwork = t;
	}
	public boolean getInNetwork(){
		return this.inNetwork;
	}
	
	public void initPlace(){
		this.x = this.ini_x;
		this.y = this.ini_y;
	}
	
	public void addLink(Character link, int interaction){
		this.links.put(link, interaction);
	}
	
	public HashMap<Character, Integer> getLinks(){
		return this.links;
	}
	
	
	
}
