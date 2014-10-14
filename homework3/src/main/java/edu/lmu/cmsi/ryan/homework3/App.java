package edu.lmu.cmsi.ryan.homework3;

import java.util.Scanner;
import edu.lmu.cmsi.ryan.homework3.engine.Engine;

public class App {

  private Scanner keyboard = null;
  private Engine engine;

  public App() {
    System.out.println("Welcome to SuperSweetGame");
    System.out.println("Commands are: [N]ext frame or [Q]uit");
    this.keyboard = new Scanner(System.in);
    this.engine = new Engine(20);
  }

  /*
   Returns the lower case String of the keyboard input
   */
  private String getInput() {
    return this.keyboard.next().toLowerCase();
  }

  public static void main(String[] args) {
    App theApp = new App();
    String input = theApp.getInput();

    while (!input.equals("q")) {
      if (input.equals("n")) {
        theApp.engine.update();
      }

      input = theApp.getInput();
    }
  }
}