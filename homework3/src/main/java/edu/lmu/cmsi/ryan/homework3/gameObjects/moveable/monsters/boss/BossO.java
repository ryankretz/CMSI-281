package edu.lmu.cmsi.ryan.homework3.gameObjects.moveable.monsters.boss;

import edu.lmu.cmsi.ryan.homework3.gameObjects.*;
import edu.lmu.cmsi.ryan.homework3.gameObjects.moveable.*;
import edu.lmu.cmsi.ryan.homework3.gameObjects.things.*;

import edu.lmu.cmsi.ryan.homework3.gameObjects.moveable.monsters.boss.Boss;

public class BossO extends Boss {

	public BossO(int x, int y, int dx, int dy) {
		super(x, y, dx, dy);
	}

	@Override
	public char getRenderedCharacter() {
		return 'o';
	}
}