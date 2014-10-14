package edu.lmu.cmsi.ryan.homework3.gameObjects.things;

import edu.lmu.cmsi.ryan.homework3.gameObjects.Stationary;

public class Wall extends Stationary {

	//calls super constructor which comes from stationary class
	public Wall(int x, int y) {
		super(x,y);
	}

	//returns wall character
	@Override
	public char getRenderedCharacter() {
		return 'w';
	}

}