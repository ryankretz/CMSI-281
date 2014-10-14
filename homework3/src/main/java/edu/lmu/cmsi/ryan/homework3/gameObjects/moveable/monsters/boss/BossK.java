package edu.lmu.cmsi.ryan.homework3.gameObjects.moveable.monsters.boss;

import edu.lmu.cmsi.ryan.homework3.gameObjects.*;
import edu.lmu.cmsi.ryan.homework3.gameObjects.moveable.*;
import edu.lmu.cmsi.ryan.homework3.gameObjects.things.*;

import edu.lmu.cmsi.ryan.homework3.gameObjects.moveable.monsters.boss.Boss;

public class BossK extends Boss {

	//bossk constructor
	public BossK(int x, int y, int dx, int dy) {
		super(x, y, dx, dy);
	}

	//renders character for bossk
	@Override
	public char getRenderedCharacter() {
		return 'k';
	}
}