import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main(Main.class.getName());
	}
	
	int [][] matrix;
	int score;
	Character nave;
	PImage spa;
	
	ArrayList<Alien> invader = new ArrayList<Alien>();
	
	public void settings() {
		size(900,700);
	}
	
	public void setup() {
		nave = new Character (width/2-40,615,this);
		invader.add(new Alien(200,5,5,this));
		invader.add(new Alien(320,5,5,this));
		spa = loadImage("./data/space.png");
	}
	
	public void draw() {
		background (0);
		image(spa,0,0);
		validateColision(invader, nave.getBullet());
		nave.draw();	
		for(int i = 0; i < invader.size(); i++) {
			invader.get(i).draw();
			invader.get(i).run(); 
			try {
				if(invader.get(i).getPosY()+84 > nave.getPosY()) {
					throw new ExceptionLost("Perdiste Imbecil jajaja");
				}
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
		Score();
		
		try {
			if(invader.size() == 0) {
				throw new ExceptionWin("Felicidades eres trolo");
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

}
	
	public void validateColision(ArrayList<Alien> arrayi, ArrayList<Bullet> arrayb) {
		for (int i = 0; i < arrayb.size(); i++) {
			for (int j = 0; j < arrayi.size(); j++) {
				if(arrayb.get(i).getPosX()> arrayi.get(j).getPosX() && arrayb.get(i).getPosX() +10 < arrayi.get(j).getPosX()+84 &&
				arrayb.get(i).getPosY()> arrayi.get(j).getPosY() && arrayb.get(i).getPosY() +30 < arrayi.get(j).getPosY()+84 ) {
					arrayi.remove(j);            
				}
			}
		}
	}

	 public void Score() {
		fill(255);
		text("Score",822,57);
		
	
	}
	 
	 public void keyPressed() {
			nave.move(keyCode);
	}	
}
