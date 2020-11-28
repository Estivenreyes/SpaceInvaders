package model;
import processing.core.PApplet;

public class Bullet {

	private PApplet app;
	private float posX;
	private float posY;
	
	
	public Bullet(float posX, float posY, PApplet app) {
		this.posX = posX;
		this.posY = posY;
		this.app = app;
	}
	
	public void draw() {
		app.rect(posX, posY, 10, 30);
		this.posY-=3;
	}
	
	public boolean validatePos() {
		if(this.posY < -30) {
			return true;
		}else {
			return false;
		}
	}

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

}
