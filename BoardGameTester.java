package games.board;
import games.board.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class BoardGameTester extends JFrame {
	
			private Board gb;
				private int turn;
				
			private void takeTurn(Cell c) {
				Mark curMark = (turn++ %2 == 0)?
						Mark.NOUGHT: Mark.CROSS;
				gb.setCell(curMark, c.getRow(),c.getColumn());
			}
			private BoardGameTester() {
				gb = new Board(3, 3, new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						Cell c = (Cell) ae.getSource();
						takeTurn(c);
					}
				});
				this.add(gb);
				this.setDefaultCloseOperation(EXIT_ON_CLOSE);
				this.setTitle("TIC-TAC-TOE");
				this.setSize(300, 300);
				this.setVisible(true);
			}
			
	public static void main(String[] args) {
		SwingUtilities.invokeLater( new Runnable () {
			public void run() { new BoardGameTester();}
		});
        }
	
	}