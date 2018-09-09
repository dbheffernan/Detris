/**
 * CIS 120 Game HW
 * (c) University of Pennsylvania
 * @version 2.0, Mar 2013
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.Random;

/**
 * GameCourt
 * 
 * This class holds the primary game logic for how different objects interact
 * with one another. Take time to understand how the timer interacts with the
 * different methods and how it repaints the GUI on every tick().
 * 
 */
@SuppressWarnings("serial")
public class GameCourt extends JPanel {


	public Tetromino T;
	public boolean playing = false; // whether the game is running
	private JLabel status; // Current status text (i.e. Running...)
	private JLabel scoreNum= new JLabel();
	public JLabel levelNum = new JLabel();
	private JLabel levelPic= new JLabel();

	
	public static final int COURT_WIDTH = 200;
	public static final int COURT_HEIGHT = 400;
	public static final int SQUARE_VELOCITY = 4;

	
	public static final int INTERVAL = 35;
	public int[][] courtGrid = new int[10][24];

	public int counter = 25;
	boolean move = false;
	public Level l = new Level();
	public Score s = new Score();
	public Pic p = new Pic();
	public GameCourt(JLabel status, JLabel scoreNum, JLabel levelNum, JLabel levelPic) {	    
	    // creates border around the court area, JComponent method
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		setup();
		
		Timer timer = new Timer(INTERVAL, new ActionListener() {		    
			public void actionPerformed(ActionEvent e) {
		        
		        //System.out.println(l.getLevel(0));
			    tick();
			    }
		});
		timer.start(); // MAKE SURE TO START THE TIMER!

		// Enable keyboard focus on the court area.
		// When this component has the keyboard focus, key
		// events will be handled by its key listener.
		setFocusable(true);

		// This key listener allows the square to move as long
		// as an arrow key is pressed, by changing the square's
		// velocity accordingly. (The tick method below actually
		// moves the square.)
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_LEFT && isValidMove(-1, courtGrid, T))
					T.pos_x-=1;
				else if (e.getKeyCode() == KeyEvent.VK_RIGHT && isValidMove(1, courtGrid, T))
				    T.pos_x+=1;
				else if (e.getKeyCode() == KeyEvent.VK_DOWN && !fallingColDetect(courtGrid, T))
				    T.pos_y+=1;
				else if (e.getKeyCode() == KeyEvent.VK_UP && isValidMove(0, courtGrid, T)){
				    T.rotate();
				}
			}
		});

		this.status = status;
		this.scoreNum = scoreNum;
		this.levelNum = levelNum;
		this.levelPic = levelPic;
	}

	/**
	 * (Re-)set the game to its initial state.
	 */
	public void go() {
	    create();
	    playing = true;
		status.setText("Running...");

		// Make sure that this component has the keyboard focus
		requestFocusInWindow();
	}
	
	public void reset(){
	    setup();
	    go(); 
}
    /**
	 * This method is called every time the timer defined in the constructor
	 * triggers.
	 */

    void tick() {
		if (playing) {
		    counter--;
		    if(counter==0){
	              if(fallingColDetect(courtGrid, T))    
	                    courtUpdater();
		        T.move();
		        System.out.println(s.score);
		        System.out.println(l.getLevel(s.score));
		        counter=28-l.getLevel(s.score)*3;
		    }
		lines();
		lossChecker();
		repaint();
		}
	}
	
	public static boolean fallingColDetect(int[][] courtGrid, Tetromino T){
	       for(int y = 0; y<4; y++){
	            for(int x = 0; x<4; x++){
	                if(T.shape_grid[T.rotateStep][x][y]==1){
	                    if(courtGrid[T.pos_x + x][T.pos_y + y+1]>0)
	                        return true;
	                }
	            }
	       }
	       return false;
	}
	
	private void courtUpdater(){
	    for(int y = 0; y<4; y++){
            for(int x = 0; x<4; x++){
                if(T.shape_grid[T.rotateStep][x][y]==1)
                    courtGrid[T.pos_x + x][T.pos_y + y] = T.color;
            }
	    }
	    go();
	}
	   
	private void lines(){
	    for(int y = 0; y<23; y++){
            if(lineChecker(y))
                lineClearer(y);
            }
	}
	private boolean lineChecker(int line){
	    for(int x = 0; x<10; x++){
	        if(courtGrid[x][line]==0)
	            return false;
	    }
	    return true;
	}
	
	private void lineClearer(int line){
	    while(line > 1){
	        for(int x=0;x<10;x++)
	            courtGrid[x][line]=courtGrid[x][line-1];
	        line--;
	    }
	    s.incrScore();
	    scoreNum.setText("Score: " + String.valueOf(s.score));
	    levelNum.setText("Level: " + String.valueOf(l.getLevel(s.score)));
	    p.setPic(l.getLevel(s.score));
	    levelPic.setIcon(p.getPic());
	}
public static boolean isValidMove(int modifier, int[][] courtGrid, Tetromino T){
    for(int y = 0; y<4; y++){
        for(int x = 0; x<4; x++){
            if(modifier == 0 && T.shape_grid[T.nextRotate()][x][y]==1) 
                if(T.pos_y + y > 22)
                    return false; //rotate causes piece to go below board
                else if(T.pos_x+x > 9 || T.pos_x+x < 0)
                    return false; //rotate causes piece to go left/right off board
                else if(courtGrid[T.pos_x + x][T.pos_y + y]>0)
                    return false; //rotate causes piece to hit existing piece
            if(T.shape_grid[T.rotateStep][x][y]==1){
                if(T.pos_x + x + modifier > 9 ||T.pos_x + x + modifier < 0)
                    return false; //move l/r causes piece to go off board
                else if (courtGrid[T.pos_x + x + modifier][T.pos_y + y]>0)
                    return false; //move l/r causes piece to hit existing piece
            }
        }
    }
    return true;
}

	private void drawGrid(Graphics g) {
	        for(int y = 0; y<23; y++){
	            for(int x = 0; x<10; x++){
	                if(courtGrid[x][y]>0){
	                    g.setColor(Color.BLACK);
	                    g.fillRect(x*20, y*20-60, 20, 20);
    	                if(courtGrid[x][y]==1)
    	                    g.setColor(Color.PINK);
    	                else if(courtGrid[x][y]==2)
                            g.setColor(Color.CYAN);
                        else if(courtGrid[x][y]==3)
                            g.setColor(Color.BLUE);	                
                        else if(courtGrid[x][y]==4)
                            g.setColor(Color.ORANGE);
                        else if(courtGrid[x][y]==5)
                            g.setColor(Color.YELLOW);	                
                        else if(courtGrid[x][y]==6)
                            g.setColor(Color.GREEN);
                        else if(courtGrid[x][y]==7)
                            g.setColor(Color.RED);
    	                g.fillRect((x*20)+1, (y*20)+1-60, 18, 18);
    	                }
	            }
	        }
	}

	
	private void lossChecker(){
	    for(int x =0;x<10;x++)
	        if(courtGrid[x][4]>0){
	            playing = false;
	            status.setText("Game Over");
	        }
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		    T.draw(g);
		drawGrid(g);
	}
	
    private void create(){
        Random random = new Random();
        int rando =random.nextInt(7);
        if(rando == 0)
            T = new ShapeT();
        else if(rando == 1)
            T = new ShapeI();
        else if(rando == 2)
            T = new ShapeJ();   
        else if(rando == 3)
            T = new ShapeL();
        else if(rando == 4)
            T = new ShapeO();
        else if(rando == 5)
            T = new ShapeS();
        else if(rando == 6)
            T = new ShapeZ();
    }
    
    private void setup(){
        for(int y = 0; y<24; y++){
            for(int x = 0; x<10; x++){
                if(y==23)
                    courtGrid[x][y]=1;
                else
                    courtGrid[x][y]=0;
            }
        }
    }
    
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(COURT_WIDTH, COURT_HEIGHT);
	}
}
