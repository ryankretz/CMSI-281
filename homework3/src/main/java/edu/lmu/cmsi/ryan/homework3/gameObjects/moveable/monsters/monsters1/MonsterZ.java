package edu.lmu.cmsi.ryan.homework3.gameObjects.moveable.monsters.monsters1;

import edu.lmu.cmsi.ryan.homework3.core.Coordinate;
import edu.lmu.cmsi.ryan.homework3.core.Displacement;
import edu.lmu.cmsi.ryan.homework3.gameObjects.GameObject;
import edu.lmu.cmsi.ryan.homework3.gameObjects.Moveable;

import edu.lmu.cmsi.ryan.homework3.gameObjects.moveable.monsters.monsters1.Monster1;

public class MonsterZ extends Monster1 {

	public MonsterZ(int x, int y, int dx, int dy) {
		super(x, y, dx, dy);
	}

	@Override
	public char getRenderedCharacter() {
		return 'z';
	}
}