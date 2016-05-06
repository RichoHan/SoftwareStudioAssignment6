package main.java;

import java.util.ArrayList;

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
	
	private JSONObject data;
	private JSONArray nodes, links;
	private ArrayList<Character> characters;
	private ArrayList<ArrayList> episodes;
	private boolean isChoose;
	private Character tmp;
	
	private final static int width = 1200, height = 650;
	
	public void setup() {
		size(width, height);
		smooth();
		loadData();
		isChoose = false;
	}

	public void draw() {
		background(255);
		for(Character c : characters){
			c.display();
		}
		if(this.isChoose == false){
			for(Character s : characters){
				if(mouseX<s.getX()+60 && mouseX>s.getX()-60 && mouseY<s.getY()+60 && mouseY>s.getY()-60){
					tmp = s;
					s.changeWidth(70);
					break;
				}
			}
		}
	}
	public void mousePressed(){
		
	}
	
	public void keyPressed() {
		
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
			
			int chX = 50;
			int chY = 50;
			
			// read name, color, location for each character
			for (int i = 0; i < nodes.size(); i++) {
				JSONObject node = nodes.getJSONObject(i);
				String name = node.getString("name");
				String color = node.getString("colour");
				if (characters.size() % 10 != 0) {
					characters.add(new Character(this, name, color, chX, chY));
					chY += 40;
				} else {
					characters.add(new Character(this, name, color, chX, chY));
					chX += 30;
					chY = 50;
				}
			}
			
			// read relation for each character
			for (int i = 0; i < links.size(); i++) {
				JSONObject link = links.getJSONObject(i);
				int source = link.getInt("source");
				int terget = link.getInt("target");
				/**WTF**/
			}
			
			// add characters to each episode
			episodes.add(characters);
		}
	}

}
