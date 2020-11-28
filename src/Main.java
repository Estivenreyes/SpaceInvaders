import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main(Main.class.getName());
	}
	
	int [][] matrix;
	int screen = 0;
	Character nave;
	PImage spa;
	
	ArrayList<Alien> invader = new ArrayList<Alien>();
	
	public void settings() {
		size(900,700);
	}
	
	public void setup() {
		noStroke();
		textMode(CENTER);
		textAlign(CENTER);
		nave = new Character (width/2-40,615,this);
		invader.add(new Alien(108,5,5,this));
		invader.add(new Alien(228,5,5,this));
		invader.add(new Alien(348,5,5,this));
		invader.add(new Alien(468,5,5,this));
		invader.add(new Alien(588,5,5,this));
		invader.add(new Alien(708,5,5,this));
		
		//////////////////////
		
		invader.add(new Alien(108,105,5,this));
		invader.add(new Alien(228,105,5,this));
		invader.add(new Alien(348,105,5,this));
		invader.add(new Alien(468,105,5,this));
		invader.add(new Alien(588,105,5,this));
		invader.add(new Alien(708,105,5,this));
		
		/////////////////////
		
		invader.add(new Alien(108,205,5,this));
		invader.add(new Alien(228,205,5,this));
		invader.add(new Alien(348,205,5,this));
		invader.add(new Alien(468,205,5,this));
		invader.add(new Alien(588,205,5,this));
		invader.add(new Alien(708,205,5,this));
		
		spa = loadImage("./data/space.png");
	}
	
	public void draw() {
		background (0);
		image(spa,0,0);
		switch(screen) {
		
			case 0:
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
						screen = 2;
					}
					
				}
				
				
				try {
					if(invader.size() == 0) {
						throw new ExceptionWin("Felicidades eres trolo");
					}
				}catch(Exception e) {
					System.out.println(e.getMessage());
					screen = 1;
				}

			break;		
			
			case 1:
				fill(255,168);
				rect(0, 0, width, height);
				fill(0);
				textSize(50);
				text("Felicidades, ganaste\nhas click y vuelve a jugar",width/2,height/2);
				
			break;
			
			case 2:
				fill(255,168);
				rect(0, 0, width, height);
				fill(0);
				textSize(50);
				text("Oh no, perdiste\nhas click y vuelve a jugar", width/2,height/2);
				
			break;
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

	 
	 public void reload() {
		 for (int i = 0; i < invader.size(); i++) {
			invader.remove(i);
		}
		 nave = new Character (width/2-40,615,this);
			invader.add(new Alien(108,5,5,this));
			invader.add(new Alien(228,5,5,this));
			invader.add(new Alien(348,5,5,this));
			invader.add(new Alien(468,5,5,this));
			invader.add(new Alien(588,5,5,this));
			invader.add(new Alien(708,5,5,this));
			
			//////////////////////
			
			invader.add(new Alien(108,105,5,this));
			invader.add(new Alien(228,105,5,this));
			invader.add(new Alien(348,105,5,this));
			invader.add(new Alien(468,105,5,this));
			invader.add(new Alien(588,105,5,this));
			invader.add(new Alien(708,105,5,this));
			
			/////////////////////
			
			invader.add(new Alien(108,205,5,this));
			invader.add(new Alien(228,205,5,this));
			invader.add(new Alien(348,205,5,this));
			invader.add(new Alien(468,205,5,this));
			invader.add(new Alien(588,205,5,this));
			invader.add(new Alien(708,205,5,this));
	 }
	 
	 public void keyPressed() {
			nave.move(keyCode);
	}	
	
	public void mousePressed() {
		switch(screen) {
		case 1:
			reload();
			screen = 0;
		break;
		
		case 2:
			reload();
			screen = 0;
		break;
		}
	}
}
