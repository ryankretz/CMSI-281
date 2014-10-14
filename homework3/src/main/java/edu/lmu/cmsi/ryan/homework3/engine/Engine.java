package edu.lmu.cmsi.ryan.homework3.engine;

import edu.lmu.cmsi.ryan.homework3.*;

import edu.lmu.cmsi.ryan.homework3.gameObjects.*;
import edu.lmu.cmsi.ryan.homework3.gameObjects.things.*;
import edu.lmu.cmsi.ryan.homework3.gameObjects.moveable.*;
import edu.lmu.cmsi.ryan.homework3.gameObjects.moveable.monsters.boss.*;
import edu.lmu.cmsi.ryan.homework3.gameObjects.moveable.monsters.monsters1.*;
import edu.lmu.cmsi.ryan.homework3.gameObjects.moveable.monsters.monsters2.*;

public class Engine {
	private int frame;
	private int size;

	private Stationary[] stationary;
	private Moveable[] moveable;

	public Engine(int size) {
		if (size < 1) {
			throw new IllegalArgumentException("The world should exist");
		}
		this.frame = 0;
		this.size = size;
	

	this.stationary = new Stationary[this.size * 4 -2]; 
	this.stationary[0] = new Rock(5,5);
	this.stationary[1] = new Tree(8,8);
	this.createWalls();

	this.moveable = new Moveable[] {
		new Player(3,3,1,0),
		new MonsterX(2,12,0,1),
		new MonsterZ(10,15,0,1),
		new MonsterA(18,18,0,-1),
		new MonsterS(5,16,0,1),
		new BossO(14,3,1,1),
		new BossK(18,14,1,1)
		};
	}

	private void createWalls() {
		int wallCount = 2;
		for (int x = 0; x < this.size; x++) {
      		Wall x1 = new Wall(x, 0);
      		stationary[wallCount++] = x1;
      		Wall x2 = new Wall(x, this.size - 1);
      		stationary[wallCount++] = x2;
    	}

    	for (int y = 1; y < size - 1; y++) {
	      	Wall y1 = new Wall(0, y);
	      	stationary[wallCount++] = y1;
	      	Wall y2 = new Wall(this.size - 1, y);
	      	stationary[wallCount++] = y2;
    	}
	}

	// the main upadte loop
	public void update() {
	    this.frame++;
	    this.render();
	    this.updateObjects();
	    this.checkCollisions();
	}

	private void render() {
		// Strings are a bit overkill here but easier to represent a String as a null than a character
	    String[][] renderedWorld = new String[this.size][this.size];

	    //stationary characters
	    for (int i = 0; i < stationary.length; i++) {
	      Stationary curr = stationary[i];
	      renderedWorld[curr.getY()][curr.getX()] = Character.toString(curr.getRenderedCharacter());
	    }

	    //moveable characters
	    for (int i = 0; i < moveable.length; i++) {
	      Moveable curr = moveable[i];
	      renderedWorld[curr.getY()][curr.getX()] = Character.toString(curr.getRenderedCharacter());
	      System.out.println(curr.getClass().getSimpleName() + " hitpoints: " + curr.getHP());
	    }

	    System.out.println("=========================");
	    System.out.println("Frame: " + this.frame);  // book keeping

	    for (int row = 0; row < renderedWorld.length; row++) {
	      String[] rowOfWorld = renderedWorld[row];
	      for (int col = 0; col < rowOfWorld.length; col++) {
	        String w = rowOfWorld[col];
	        // If our string is null
	        if (w == null) {
	          w = ".";
	        }
	        System.out.print(w + " ");
	      }
	      System.out.println(""); // print a new line between each scene
	    }

	    System.out.println("=========================");
	  }

	private void updateObjects() {
    	for (int i = 0; i < this.moveable.length; i++) {
      		this.moveable[i].update();
    	}
  	}  

	private void checkCollisions() {
		for (int k = 0; k < this.moveable.length; k++) {
			for (int i = 1; i < this.moveable.length - 1; i++) {
				this.moveable[k].checkCollision(this.moveable[i++]);
				this.moveable[k].update();
			}
			for (int j = 0; j < this.stationary.length; j++) {
				this.moveable[k].checkCollision(this.stationary[j]);
				this.moveable[k].update();
			}
		}    	
	}	
}