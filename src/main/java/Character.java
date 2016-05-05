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
	private float r,g,b;

	public Character(MainApplet parent,String name,String color,float x,float y){

		this.parent = parent;
		this.name = name;
		this.color = color;
		this.x = x;
		this.y = y;
		this.initial();
	}
	
	public void initial(){
		Integer Int_tmp = new Integer(new String(color.substring(1, 2))); 
		this.r = (float)Int_tmp;
		Int_tmp = new Integer(new String(color.substring(3, 4))); 
		this.g = (float)Int_tmp;
		Int_tmp = new Integer(new String(color.substring(5, 6))); 
		this.b = (float)Int_tmp;
		
	}
	
	public void display(){
		this.parent.fill(r, g, b);
		this.parent.rect(this.x, this.y, (float)100.0, (float)50.0);
		this.parent.fill(3);
		this.parent.text(name, x+(float)20, y+(float)25);
	}
	
	
	
	public void addLink(Character link){
		this.links.add(link);
	}
	
	public ArrayList<Character> getLinks(){
		return this.links;
	}
	
	
	
}
