package edu.lmu.cmsi.ryan.homework3.gameObjects.things;

import edu.lmu.cmsi.ryan.homework3.gameObjects.Stationary;

public class Tree extends Stationary {

	//calls super constructor which comes from stationary class
	public Tree(int x, int y) {
		super(x,y);
	}

	//returns tree character
	@Override
	public char getRenderedCharacter() {
		return 't';
	}

}