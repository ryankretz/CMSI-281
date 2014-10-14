package edu.lmu.cmsi.ryan.homework3.gameObjects.moveable.monsters.monsters2;

import edu.lmu.cmsi.ryan.homework3.core.Coordinate;
import edu.lmu.cmsi.ryan.homework3.core.Displacement;
import edu.lmu.cmsi.ryan.homework3.gameObjects.GameObject;
import edu.lmu.cmsi.ryan.homework3.gameObjects.Moveable;

import edu.lmu.cmsi.ryan.homework3.gameObjects.moveable.monsters.monsters2.Monster2;

public class MonsterS extends Monster2 {

	//monsters constructor
	public MonsterS(int x, int y, int dx, int dy) {
		super(x, y, dx, dy);
	}

	//renders character for monsters
	@Override
	public char getRenderedCharacter() {
		return 's';
	}
}