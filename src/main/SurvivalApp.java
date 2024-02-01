package main;

import frame.GameFrame;

public class SurvivalApp {

   public SurvivalApp() {
      init();
   }

   private void init() {
      new GameFrame();
   }
 
   public static void main(String[] args) {
      new SurvivalApp();
   }

}