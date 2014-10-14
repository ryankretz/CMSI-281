package edu.lmu.cmsi.ryan.homework3;

import edu.lmu.cmsi.ryan.homework3.*;

import edu.lmu.cmsi.ryan.homework3.gameObjects.*;
import edu.lmu.cmsi.ryan.homework3.core.*;
import edu.lmu.cmsi.ryan.homework3.engine.*;
import edu.lmu.cmsi.ryan.homework3.gameObjects.things.*;
import edu.lmu.cmsi.ryan.homework3.Iface.*;
import edu.lmu.cmsi.ryan.homework3.gameObjects.moveable.*;
import edu.lmu.cmsi.ryan.homework3.gameObjects.moveable.monsters.boss.*;
import edu.lmu.cmsi.ryan.homework3.gameObjects.moveable.monsters.monsters1.*;
import edu.lmu.cmsi.ryan.homework3.gameObjects.moveable.monsters.monsters2.*;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class GameTest {

	//test to make sure if constructor Engine takes in invalid parameter
	//then an argument is thrown
	@Test (expected = IllegalArgumentException.class)
	public void testGameEngine() {
		Engine engine = new Engine(-1);
	}

	//tests to make sure that the player moves properly
	@Test
	public void testPlayerMovement() {
		Engine engine = new Engine(20);
		int x = engine.getMoveableObject(0).getX() + engine.getMoveableObject(0).getDisplacement().getXDisplacement();
		int y = engine.getMoveableObject(0).getY() + engine.getMoveableObject(0).getDisplacement().getYDisplacement();
		engine.update();
		assertEquals("failure - player's next x coordinate is not correct", x, engine.getMoveableObject(0).getX(), 0.0);
		assertEquals("failure - player's next y coordinate is not correct", y, engine.getMoveableObject(0).getY(), 0.0);
	}

	//test to make sure player inverts when it hits wall
	@Test
	public void testPlayerAndWallCollision() {
		Engine engine = new Engine(20);
		int x = engine.getMoveableObject(0).getX() + 14;
		int y = engine.getMoveableObject(0).getY();
		for (int i = 0; i < 18; i++) {
			engine.update();
		}
		assertEquals("failure - player did not invert from wall correctly (x coord incorrect)", x, engine.getMoveableObject(0).getX(), 0.0);
		assertEquals("failure - player did not invert from wall correctly (y coord incorrect)", y, engine.getMoveableObject(0).getY(), 0.0);
	}

	//tests to make sure boss moves properly
	@Test
	public void testBossMovement() {
		Engine engine = new Engine(20);
		int x = engine.getMoveableObject(5).getX() + engine.getMoveableObject(5).getDisplacement().getXDisplacement();
		int y = engine.getMoveableObject(5).getY() + engine.getMoveableObject(5).getDisplacement().getYDisplacement();
		engine.update();
		assertEquals("failure - boss's next x coordinate is not correct", x, engine.getMoveableObject(5).getX(), 0.0);
		assertEquals("failure - boss's next y coordinate is not correct", y, engine.getMoveableObject(5).getY(), 0.0);
	}

	//tests to make sure monster inverts when it hits wall
	@Test
	public void testMonsterAndWallCollision() {
		Engine engine = new Engine(20);
		int x = engine.getMoveableObject(3).getX();
		int y = engine.getMoveableObject(3).getY() - 1;
		for (int i = 0; i < 3; i ++) {
			engine.update();
		}
		assertEquals("failure - monster did not invert from wall correctly (x coord incorrect)", x, engine.getMoveableObject(3).getX(), 0.0);
		assertEquals("failure - monster did not invert from wall correctly (y coord incorrect)", y, engine.getMoveableObject(3).getY(), 0.0);
	}

	//tests to make sure player's hp gets incremented when hits tree
	@Test
	public void testPlayerHPwithTree() {
	Engine engine = new Engine(20);
		int shouldHit = 1;
		for (int i = 0; i < 3; i++ ) {
			engine.update();
		}
		assertEquals("failure - player's hp is not functioning properly", shouldHit, engine.getMoveableObject(0).getHP(), 0.0);	
	}

	//tests to make sure player's hp gets incremented when hits rock (after hitting tree)
	@Test
	public void testPlayerHPwithRock() {
	Engine engine = new Engine(20);
		int shouldHit = 2;
		for (int i = 0; i < 9; i++ ) {
			engine.update();
		}
		assertEquals("failure - player's hp is not functioning properly", shouldHit, engine.getMoveableObject(0).getHP(), 0.0);	
	}

	//tests to make sure monster's hp gets incremented after hitting rock
	@Test
	public void testMonsterHPwithRock() {
		Engine engine = new Engine(20);
		int shouldHit = 1;
		engine.update();
		assertEquals("failure - monsterX's hp is not functioning properly", shouldHit, engine.getMoveableObject(1).getHP(), 0.0);
	}

	//tests various getters of the game
	@Test
	public void testGetters() {
		Engine engine = new Engine(20);
		Coordinate point = new Coordinate(5,5);
		Coordinate playerLocation = engine.getMoveableObject(0).getLocation();
		int playerX = playerLocation.getX();
		int playerY = playerLocation.getY();
		assertEquals("failure - didn't create coordinate x-val", 5, point.getX(), 0.0);
		assertEquals("failure - didn't create coordinate y-val", 5, point.getY(), 0.0);
		assertEquals("failure - didn't get player's x coordinate correctly", 3, playerX, 0.0);
		assertEquals("failure - didn't get player's y coordinate correctly", 3, playerY, 0.0);
		}
	
}