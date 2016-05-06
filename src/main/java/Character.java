package main.java;

import java.util.ArrayList;

import processing.core.PApplet;

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
	private ArrayList<Character> links;
	private int r,g,b;

	public Character(MainApplet parent,String name,String color,float x,float y){
		
		this.parent = parent;
		this.name = name;
		this.color = color;
		this.x = x;
		this.y = y;
		this.width = 50;
		this.initial_color();
	}
	
	public void initial_color(){
		
		this.links = new ArrayList<Character>();
		this.r = Integer.parseInt(color.substring(3, 5), 16);
		this.g = Integer.parseInt(color.substring(5, 7), 16);
		this.b = Integer.parseInt(color.substring(7, 9), 16);
	}
	
	public void display(){
		this.parent.fill(r,g,b);
		this.parent.ellipse(this.x, this.y, this.width, this.width);
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
	
	public void addLink(Character link){
		this.links.add(link);
	}
	
	public ArrayList<Character> getLinks(){
		return this.links;
	}
	
	
	
}
