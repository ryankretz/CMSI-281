package edu.lmu.cmsi.ryan.homework3.gameObjects.moveable.monsters.monsters1;

import edu.lmu.cmsi.ryan.homework3.gameObjects.*;
import edu.lmu.cmsi.ryan.homework3.gameObjects.moveable.*;
import edu.lmu.cmsi.ryan.homework3.gameObjects.things.*;

import edu.lmu.cmsi.ryan.homework3.gameObjects.moveable.monsters.monsters1.Monster1;

public class MonsterX extends Monster1 {

	//monsterx instructor
	public MonsterX(int x, int y, int dx, int dy) {
		super(x, y, dx, dy);
	}

	//renders character for monsterx
	@Override
	public char getRenderedCharacter() {
		return 'x';
	}
}