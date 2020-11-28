package model;
import java.util.LinkedList;

import processing.core.PApplet;
import processing.core.PImage;

public class Alien implements Runnable{
	
	protected PImage alien;
	protected int posX;
	protected int posY;
	protected int speed;
	
	protected PApplet app;
	
	public Alien(int posX, int posY, int speed, PApplet app) {
		this.posX = posX;
		this.posY = posY;
		this.speed = speed;
		this.app = app;
		this.alien = app.loadImage("./data/alien.png");
	}
	
	public void run() {
		move();
	}
	
	public void draw() {
		app.image(alien, posX, posY);
	}
	
	public void move() {
		this.posX+=speed;
		if(this.posX > app.width-this.alien.width || this.posX<0) {
			this.speed = this.speed*-1;
			this.posY += 50;
		}
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public void SortBy(char key) {
		// TODO Auto-generated method stub
		
	}

	public LinkedList<Alien> getAlien() {
		// TODO Auto-generated method stub
		return null;
	}

	public void countItem() {
		// TODO Auto-generated method stub
		
	}

}
