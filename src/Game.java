/**
 * CIS 120 Game HW
 * (c) University of Pennsylvania
 * @version 2.0, Mar 2013
 */

// imports necessary libraries for Java swing
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Game Main class that specifies the frame and widgets of the GUI
 */
public class Game implements Runnable {
	public void run() {
		// NOTE : recall that the 'final' keyword notes inmutability
		// even for local variables.

		// Top-level frame in which game components live
		// Be sure to change "TOP LEVEL FRAME" to the name of your game
		final JFrame frame = new JFrame("TETRIS");
		frame.setLocation(300, 300);

		// Status panel
		final JPanel status_panel = new JPanel();
		frame.add(status_panel, BorderLayout.SOUTH);
		final JLabel status = new JLabel("Running...");
		status_panel.add(status);
		
		final JPanel score_panel = new JPanel();
	    frame.add(score_panel, BorderLayout.EAST);
		score_panel.setLayout(new BoxLayout(score_panel, BoxLayout.Y_AXIS));

	      final JLabel scoreNum = new JLabel("Score: 0");
	       scoreNum.setAlignmentX(Component.LEFT_ALIGNMENT);
	      score_panel.add(scoreNum);

	      final JLabel levelNum = new JLabel("Level: 1");
	      scoreNum.setAlignmentX(Component.LEFT_ALIGNMENT);
          score_panel.add(levelNum);
          
          final Pic pic = new Pic();
          JLabel levelPic = new JLabel(pic.getPic());
          score_panel.add(levelPic);
	      
          final JPanel instruct_panel = new JPanel();
          frame.add(instruct_panel, BorderLayout.WEST);
          instruct_panel.setLayout(new BoxLayout(instruct_panel, BoxLayout.Y_AXIS));

          final JLabel instruct = new JLabel("Instructions");
          final JLabel up = new JLabel("UP ARROW: rotate piece");
          final JLabel lr = new JLabel("LEFT/RIGHT ARROWS: move piece left right");
          final JLabel down = new JLabel("DOWN ARROW: move piece down quickly ");
          instruct_panel.add(instruct);
          instruct_panel.add(up);
          instruct_panel.add(lr);
          instruct_panel.add(down);


          
          
          
		// Main playing area
		final GameCourt court = new GameCourt(status, scoreNum, levelNum, levelPic);
		frame.add(court, BorderLayout.CENTER);

		// Reset button
		final JPanel control_panel = new JPanel();
		frame.add(control_panel, BorderLayout.NORTH);


		
		// Note here that when we add an action listener to the reset
		// button, we define it as an anonymous inner class that is
		// an instance of ActionListener with its actionPerformed()
		// method overridden. When the button is pressed,
		// actionPerformed() will be called.
		final JButton reset = new JButton("Start");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				court.reset();
			}
		});
		control_panel.add(reset);
		//score_panel.add(scoreNum, BorderLayout.CENTER);

		// Put the frame on the screen
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		// Start game
		court.go();
	}

	/*
	 * Main method run to start and run the game Initializes the GUI elements
	 * specified in Game and runs it IMPORTANT: Do NOT delete! You MUST include
	 * this in the final submission of your game.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Game());
	}
}
