package model;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class Character {

	private PImage nave;
	private float posX;
	private float posY;
	private boolean been;
	private boolean shot = true;
	
	private PApplet app;
	
	ArrayList<Bullet> bullet = new ArrayList<Bullet>();
	
	public float getPosX() {
		return posX;
	}

	public void setPosX(float posX) {
		this.posX = posX;
	}

	public float getPosY() {
		return posY;
	}

	public void setPosY(float posY) {
		this.posY = posY;
	}

	public Character(float posX, float posY, PApplet app) {
		this.posX = posX;
		this.posY = posY;
		this.been = false;
		this.app = app;
		this.nave = app.loadImage("./data/nave.png");
	}
	
	public void draw() {
		app.image(nave, posX, posY);
		
		for (int i = 0; i < bullet.size(); i++) {
			bullet.get(i).draw();
			if(bullet.get(i).validatePos()) {
				bullet.remove(i);
			}
		}
				
		if(app.frameCount%60==0) {
			shot = true;	
		
		}
		
	}
	
	public ArrayList<Bullet> getBullet() {
		return bullet;
	}

	public void setBullet(ArrayList<Bullet> bullet) {
		this.bullet = bullet;
	}

	//Been is a shot 
	public boolean isBeen() {
		return been;
	}

	public void setBeen(boolean been) {
		this.been = been;
	}
	
	public void move (int keyCode) {
		switch(keyCode) {
		
		case 39:
			if(this.posX+100 < app.width-this.nave.width) {
				posX += 100;
			}
			
		break;
		case 37:
			if(this.posX-100 > 0) {
				posX -= 100;
				
			}
			
		case 32:
			if(shot) {
				Bullet been = new Bullet(posX+30, posY-40, app);
				bullet.add(been);
				shot = false;
			}
			
		}
		
		
	}

}

