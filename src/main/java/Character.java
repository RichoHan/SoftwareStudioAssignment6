package main.java;

import java.awt.Font;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PFont;

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
		
		this.links = new ArrayList<Character>();
		this.ini_x = x;
		this.ini_y = y;
		this.r = Integer.parseInt(color.substring(3, 5), 16);
		this.g = Integer.parseInt(color.substring(5, 7), 16);
		this.b = Integer.parseInt(color.substring(7, 9), 16);
	}
	
	public void display(){
		this.parent.fill(r,g,b);
		this.parent.ellipse(this.x, this.y, this.width, this.width);
		if (this.inNetwork) {
			this.showLink();
		}
	}
	
	public void showName() {
		this.parent.fill(0, 255, 0);
		this.parent.rect(this.x, this.y, this.width*2, this.width);
		this.parent.fill(0);
		this.parent.text(this.name, this.x+20, this.y+20);
	}
	
	public void showLink() {
		for (Character t : links) {
			if (t.inNetwork) {
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
	
	public void initPlace(){
		this.x = this.ini_x;
		this.y = this.ini_y;
	}
	
	public void addLink(Character link){
		this.links.add(link);
	}
	
	public ArrayList<Character> getLinks(){
		return this.links;
	}
	
	
	
}
