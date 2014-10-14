package edu.lmu.cmsi.ryan.homework3.gameObjects.things;

import edu.lmu.cmsi.ryan.homework3.gameObjects.Stationary;


public class Rock extends Stationary {

	//calls super constructor which comes from stationary class
	public Rock(int x, int y) {
		super(x,y);
	}

	//returns rock character
	@Override
	public char getRenderedCharacter() {
		return 'r';
	}

}