package main.java;

import java.util.ArrayList;

import controlP5.ControlP5;
import de.looksgood.ani.Ani;

import processing.core.PApplet;
import processing.data.JSONArray;
import processing.data.JSONObject;

/**
* This class is for sketching outcome using Processing
* You can do major GUI control and some visualization in this class.  
**/
@SuppressWarnings("serial")
public class MainApplet extends PApplet{
	private String path = "main/resources/";
	private String file;
	
	private int chX, chY;
	private boolean isDragged;
	
	private ControlP5 cp5;
	
	private JSONObject data;
	private JSONArray nodes, links;
	private ArrayList<Character> characters;
	private ArrayList<ArrayList> episodes;
	private Network network;
	
	private final static int width = 1200, height = 650;
	
	public void setup() {
		size(width, height);
		
		Ani.init(this);
		smooth();
		loadData();
		initButton();
		initNetwork();
	}
	
	public void initNetwork(){
		this.network = new Network(this);
	}
	
	public void draw() {
		background(255);
		
		network.display();
		
		for(Character c : characters){
			c.display();
		}
		
		// if the mouse on the character, change the character's size
		for(Character c : characters){
			if (mouseX < c.getX()+c.getRadius() && mouseX > c.getX()-c.getRadius() 
				&& mouseY < c.getY()+c.getRadius() && mouseY > c.getY()-c.getRadius()) {
				c.showName();
				c.changeWidth(60);
			} else {
				c.changeWidth(50);
			}
		}
	}
	
	public void mouseDragged() {
		// drag characters
		for (Character c : characters) {
			if (mouseX < c.getX()+c.getRadius() && mouseX > c.getX()-c.getRadius() 
					&& mouseY < c.getY()+c.getRadius() && mouseY > c.getY()-c.getRadius()) {
				// if one character is dragged, no other can be dragged
				if (!isDragged) {
					isDragged = true;
					c.setDragged(true);
				}
				if (c.getDragged()) {
					c.setX(mouseX);
					c.setY(mouseY);
				}
			}
			// if the character is dragged into the circle, add to network
			if (isDragged) {
				if (mouseX < network.getX()+network.getRadius() 
						&& mouseX > network.getX()-network.getRadius()
						&& mouseY < network.getY()+network.getRadius() 
						&& mouseY > network.getY()-network.getRadius()) {
					network.addNode(c);
				}
			}
		}
	}
	
	
	
	public void mouseReleased() {
		// reset characters' status
		isDragged = false;
		for (Character c : characters) {
			c.setDragged(false);
		}
	}
	
	public void keyPressed() {
		System.out.println(key);
	}
	
	// add all nodes
	public void buttonA() {
			
	}
		
	// clear nodes
	public void buttonB() {			
		int count = 0;
		
		chX = 50;
		chY = 50;
		
		for (Character c : characters) {
			c.setX(chX);
			c.setY(chY);
			// 10 characters for each line
			if (count % 10 != 9) {
				chY += 60;
			} else {
				chX += 60;
				chY = 50;
			}
			count++;
		}
		this.network.resetNetwork();
	}
	
	// initialize buttons
	private void initButton() {
		cp5 = new ControlP5(this);
		cp5.addButton("buttonA")
			.setLabel("Add All Nodes")
			.setPosition(950, 50)
			.setSize(200, 50);
		cp5.addButton("buttonB")
			.setLabel("Clear Nodes")
			.setPosition(950, 130)
			.setSize(200, 50);
	}

	private void loadData(){
		// initialize episode
		episodes = new ArrayList<ArrayList>();
		
		// read characters for each episode
		for (int index = 1; index <= 7; index++) {
			// initialize characters for each episode
			characters = new ArrayList<Character>();
			
			file = new String("starwars-episode-" + index + "-interactions.json");
			data = loadJSONObject(path + file);
			nodes = data.getJSONArray("nodes");
			links = data.getJSONArray("links");
			
			chX = 50;
			chY = 50;
			
			// read name, color, location for each character
			for (int i = 0; i < nodes.size(); i++) {
				JSONObject node = nodes.getJSONObject(i);
				String name = node.getString("name");
				String color = node.getString("colour");
				// 10 characters for each line
				if (characters.size() % 10 != 9) {
					characters.add(new Character(this, name, color, chX, chY));
					chY += 60;
				} else {
					characters.add(new Character(this, name, color, chX, chY));
					chX += 60;
					chY = 50;
				}
			}
			
			// read relation for each character
			for (int i = 0; i < links.size(); i++) {
				JSONObject link = links.getJSONObject(i);
				int source = link.getInt("source");
				int terget = link.getInt("target");
				Character s = characters.get(source);
				Character t = characters.get(terget);
				s.addLink(t);
			}
			
			// add characters to each episode
			episodes.add(characters);
		}
	}

}
