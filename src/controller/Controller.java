package controller;

import java.util.LinkedList;

import model.Alien;
import processing.core.PApplet;

public class Controller {
	
	private PApplet app;
	private Alien alien;
	
	public Controller(PApplet app) {
		this.app = app;
		alien = new Alien(0, 0, 0, app);
	}
	
	public void SortBy(char key){
		
		alien.SortBy(key);
		
	}
	
	public LinkedList<Alien> AlienList() {
		return alien.getAlien();
	
	}
	
	public void count() {
		
		alien.countItem();
	}
	
}
