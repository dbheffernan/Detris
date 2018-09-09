/**
 * CIS 120 Game HW
 * (c) University of Pennsylvania
 * @version 2.0, Mar 2013
 */

import java.awt.Color;
import java.awt.Graphics;

/** An object in the game. 
 *
 *  Game objects exist in the game court. They have a position, 
 *  velocity, size and bounds. Their velocity controls how they 
 *  move; their position should always be within their bounds.
 */
public class Tetromino {

	/** Current position of the object (in terms of graphics coordinates)
	 *  
	 * Coordinates are given by the upper-left hand corner of the object.
	 * This position should always be within bounds.
	 *  0 <= pos_x <= max_x 
	 *  0 <= pos_y <= max_y 
	 */
	public int pos_x; 
	public int pos_y;
	
	/** Velocity: number of pixels to move every time move() is called */
	public int v_y;

	/** Upper bounds of the area in which the object can be positioned.  
	 *    Maximum permissible x, y positions for the upper-left 
	 *    hand corner of the object
	 */
	public int[][][] shape_grid;
	public int rotateStep;
	public int maxRotations;
	public int color;
	public Color display;
	/**
	 * Constructor
	 */
	public Tetromino(int rotateStep, int maxRotations, int[][][] grid2, int posX, int posY, int color, Color display,
	        int clear_right, int clear_left){
		this.pos_x = 4;
		this.pos_y = 0;
		this.shape_grid = grid2;
		rotateStep = 0;
		this.maxRotations = maxRotations;
		
		// take the width and height into account when setting the 
		// bounds for the upper left corner of the object.
		this.color = color;
		this.display =display;

	}
public void console_draw(int rotateStep){
    for(int y = 0; y<4; y++){
        for(int x = 0; x<4; x++){
            if(shape_grid[rotateStep][x][y]==1)
                System.out.print("X");
            else 
                System.out.print(" ");
        }
        System.out.print(y + "\n");
    }
}
public int nextRotate(){
    if(rotateStep + 1> maxRotations)
        return 0;
    else
        return rotateStep + 1;
}

public void rotate(){
    rotateStep = nextRotate();
    if(rotateStep > maxRotations)
        rotateStep = 0;
}


	/**
	 * Moves the object by its velocity.  Ensures that the object does
	 * not go outside its bounds by clipping.
	 */
	public void move(){
		pos_y += 1;
	}	


	/**
	 * Default draw method that provides how the object should be drawn 
	 * in the GUI. This method does not draw anything. Subclass should 
	 * override this method based on how their object should appear.
	 * 
	 * @param g 
	 *	The <code>Graphics</code> context used for drawing the object.
	 * 	Remember graphics contexts that we used in OCaml, it gives the 
	 *  context in which the object should be drawn (a canvas, a frame, 
	 *  etc.)
	 */
	public void draw(Graphics g) {
	    for(int y = 0; y < 4; y++){
            for(int x = 0; x<4; x++){
                if(shape_grid[rotateStep][x][y]==1){
                    g.setColor(Color.BLACK);
                    g.fillRect((pos_x+x)*20, (pos_y+y)*20-60, 20, 20);
                    g.setColor(display);
                    g.fillRect((pos_x+x)*20+1, (pos_y+y)*20-59, 18, 18);
                }
            }
        }
	}
	
}
