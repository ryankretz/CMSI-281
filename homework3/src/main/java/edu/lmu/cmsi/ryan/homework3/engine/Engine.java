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

	//creates an Engine of a certain size
	public Engine(int size) {
		if (size < 1) {
			throw new IllegalArgumentException("The world should exist");
		}
		this.frame = 0;
		this.size = size;
	

	this.stationary = new Stationary[this.size * 4]; 
	this.stationary[0] = new Rock(2,13);
	this.stationary[1] = new Tree(8,8);
	this.stationary[2] = new Tree(5,3);
	this.stationary[3] = new Rock(8,3);
	this.createWalls();

	this.moveable = new Moveable[] {
		new Player(3,3,1,0),
		new MonsterX(2,12,0,1),
		new MonsterZ(10,15,0,1),
		new MonsterA(18,18,0,1),
		new MonsterS(5,16,0,1),
		new BossO(14,3,1,1),
		new BossK(18,14,1,1)
		};
	}

	//creates wall objects in stationary array
	private void createWalls() {
		int wallCount = 4;
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

	//updates game
	public void update() {
	    this.frame++;
	    this.render();
	    this.updateObjects();
	    this.checkCollisions();
	}

	private void render() {
		
	    String[][] renderedWorld = new String[this.size][this.size];

	    //render stationary characters
	    for (int i = 0; i < stationary.length; i++) {
	      Stationary curr = stationary[i];
	      renderedWorld[curr.getY()][curr.getX()] = Character.toString(curr.getRenderedCharacter());
	    }

	    //render moveable characters and print hp
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
	        if (w == null) {
	          w = ".";
	        }
	        System.out.print(w + " ");
	      }
	      System.out.println(""); 
	    }

	    System.out.println("=========================");
	  }

	//update moveable objects
	private void updateObjects() {
    	for (int i = 0; i < this.moveable.length; i++) {
      		this.moveable[i].update();
    	}
  	}  

	//check the collision between moveable objects and other moveable objects
	//also, check collision between moveable and stationary objects
	private void checkCollisions() {
		for (int k = 0; k < this.moveable.length; k++) {
			for (int i = 1; i < this.moveable.length - 1; i++) {
				this.moveable[k].checkCollision(this.moveable[i++]);
			}
			for (int j = 0; j < this.stationary.length; j++) {
				this.moveable[k].checkCollision(this.stationary[j]);
			}
		}    	
	}

	public Moveable getMoveableObject(Integer i) {
		return moveable[i];
	}	
}