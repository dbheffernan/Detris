import static org.junit.Assert.*;
import java.util.Random;
import org.junit.Test;

public class Tests {

    int[][] testGrid =                 {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,1,1,1},
                                       {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1},
                                       {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1},
                                       {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                                       {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                                       {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                       {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                                       {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,1,1},
                                       {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,1,1,1,1},
                                       {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1}};
  
  @Test(timeout=500) public void testT() {
    ShapeT T = new ShapeT();
    for(int rot = 0; rot <= ShapeT.rotationStepMax; rot++){
        T.console_draw(rot);
        System.out.print(rot + "\n \n");
    }  
  }

  @Test(timeout=500) public void testI() {
      ShapeI T = new ShapeI();
      for(int rot = 0; rot <= ShapeI.rotationStepMax; rot++){
          T.console_draw(rot);
          System.out.print(rot + "\n \n");
      }  
    }
  @Test(timeout=500) public void testJ() {
      ShapeJ T = new ShapeJ();
      for(int rot = 0; rot <= ShapeJ.rotationStepMax; rot++){
          T.console_draw(rot);
          System.out.print(rot + "\n \n");
      }  
    }
  @Test(timeout=500) public void testL() {
      ShapeL T = new ShapeL();
      for(int rot = 0; rot <= ShapeL.rotationStepMax; rot++){
          T.console_draw(rot);
          System.out.print(rot + "\n \n");
      }  
    }
  @Test(timeout=500) public void testO() {
      ShapeO T = new ShapeO();
      for(int rot = 0; rot <= ShapeO.rotationStepMax; rot++){
          T.console_draw(rot);
          System.out.print(rot + "\n \n");
      }  
    }
  @Test(timeout=500) public void testS() {
      ShapeS T = new ShapeS();
      for(int rot = 0; rot <= ShapeS.rotationStepMax; rot++){
          T.console_draw(rot);
          System.out.print(rot + "\n \n");
      }  
    }
  @Test(timeout=500) public void testZ() {
      ShapeZ T = new ShapeZ();
      for(int rot = 0; rot <= ShapeZ.rotationStepMax; rot++){
          T.console_draw(rot);
          System.out.print(rot + "\n \n");
      }  
    }
  
  /*@Test public void rotateTest() {
      ShapeT T = new ShapeT();
      Scanner sc = new Scanner(System.in);
      int rotator = 1;
      int marker = 0;
      while(rotator == 1){
          T.rotate();
          T.console_draw(T.nextRotate());
          rotator = Integer.parseInt(sc.next());
      }
    }*/
  @Test public void rand(){
      Random random = new Random();
      int[] keeper = {0,0,0,0,0,0,0};
      for(int i=0;i<70000;i++){
          int rando =random.nextInt(7);
          keeper[rando]++;
          }
      for(int x =0; x<7; x++)
          System.out.println(x + " " + keeper[x]);
  }
  
  @Test public void fallTrue(){
      ShapeT T = new ShapeT();
      int[][] courtGrid= testGrid;
     T.pos_x=7;
     T.pos_y=15;
     assertTrue(GameCourt.fallingColDetect(courtGrid, T));
  }
  
  @Test public void fallFalse(){
      ShapeT T = new ShapeT();
      int[][] courtGrid= testGrid;
     T.pos_x= 5;
     T.pos_y= 5;
     assertFalse(GameCourt.fallingColDetect(courtGrid, T));
  }
  
  @Test public void rotateAgainstBottomTrue(){
      ShapeT T = new ShapeT();
      int[][] courtGrid= testGrid;
     T.pos_x= 3;
     T.pos_y= 19;
     assertTrue(GameCourt.isValidMove(0,courtGrid, T));
  }
  
  @Test public void rotateAgainstBottomFalse(){
      ShapeZ T = new ShapeZ();
      int[][] courtGrid= testGrid;
     T.pos_x= 4;
     T.pos_y= 20;
     assertFalse(GameCourt.isValidMove(0,courtGrid, T));
  }
  
  @Test public void rotateAgainstRightWallTrue(){
      ShapeZ T = new ShapeZ();
      int[][] courtGrid= testGrid;
     T.pos_x= 7;
     T.pos_y= 7;
     assertTrue(GameCourt.isValidMove(0,courtGrid, T));
  }
  
  @Test public void rotateAgainstRightWallFalse(){
      ShapeI T = new ShapeI();
      int[][] courtGrid= testGrid;
     T.pos_x= 9;
     T.pos_y= 5;
     assertFalse(GameCourt.isValidMove(0,courtGrid, T));
  }
  
  @Test public void rotateAgainstLeftWallTrue(){
      ShapeI T = new ShapeI();
      int[][] courtGrid= testGrid;
     T.pos_x= 0;
     T.pos_y= 7;
     assertTrue(GameCourt.isValidMove(0,courtGrid, T));
  }
  
  @Test public void rotateAgainstLeftWallFalse(){
      ShapeJ T = new ShapeJ();
      int[][] courtGrid= testGrid;
     T.pos_x= -1;
     T.pos_y= 5;
     assertFalse(GameCourt.isValidMove(0,courtGrid, T));
  }
  
  @Test public void rotatationBlockedByPiece(){
      ShapeI T = new ShapeI();
      int[][] courtGrid= testGrid;
     T.pos_x= 6;
     T.pos_y= 18;
     assertFalse(GameCourt.isValidMove(0,courtGrid, T));
  }
  
  @Test public void rotatationNotBlockedByPiece(){
      ShapeI T = new ShapeI();
      int[][] courtGrid= testGrid;
     T.pos_x= 6;
     T.pos_y= 13;
     assertTrue(GameCourt.isValidMove(0,courtGrid, T));
  }
  
  @Test public void moveLeftRightOffBoardFail(){
      ShapeI T = new ShapeI();
      int[][] courtGrid= testGrid;
     T.pos_x= 9;
     T.pos_y= 13;
     assertFalse(GameCourt.isValidMove(1,courtGrid, T));
  }  
  @Test public void moveLeftRightIntoPieceFail(){
      ShapeI T = new ShapeI();
      int[][] courtGrid= testGrid;
     T.pos_x= 6;
     T.pos_y= 18;
     assertFalse(GameCourt.isValidMove(1,courtGrid, T));
  }  
  @Test public void moveLeftRightNoFail(){
      ShapeI T = new ShapeI();
      int[][] courtGrid= testGrid;
     T.pos_x= 9;
     T.pos_y= 9;
     assertFalse(GameCourt.isValidMove(1,courtGrid, T));
  }  
  
}