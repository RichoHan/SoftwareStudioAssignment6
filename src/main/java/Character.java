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
	private ArrayList<Character> links;
	private int r,g,b;

	public Character(MainApplet parent,String name,String color,float x,float y){

		this.parent = parent;
		this.name = name;
		this.color = color;
		this.x = x;
		this.y = y;
		this.initial_color();
	}
	
	public void initial_color(){
		
		this.r = Integer.parseInt(color.substring(3, 5), 16);
		this.g = Integer.parseInt(color.substring(5, 7), 16);
		this.b = Integer.parseInt(color.substring(7, 9), 16);
	}
	
	public void display(){
		this.parent.fill(r,g,b);
		this.parent.ellipse(this.x, this.y, (float)60.0, (float)60.0);
		
	}
	
	
	
	public void addLink(Character link){
		this.links.add(link);
	}
	
	public ArrayList<Character> getLinks(){
		return this.links;
	}
	
	
	
}
