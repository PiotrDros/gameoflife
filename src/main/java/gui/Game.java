package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.me.Cell;
import org.me.CellTable;
import org.me.NextAction;

public class Game extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	class CellButton extends JButton {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		int i;
		int j;

		public int getI() {
			return i;
		}

		public int getJ() {
			return j;
		}

		CellButton(int i, int j) {
			super();
			this.i = i;
			this.j = j;

		}

	}

	private CellButton[][] buttonsArray;
	private CellTable cellTable;

	public Game(int rows, int columns) {

		buttonsArray = new CellButton[rows][columns];

		GridLayout v = new GridLayout(rows, columns);

		for (int i = 0; i < rows; i++) {

			for (int j = 0; j < columns; j++) {

				CellButton button = new CellButton(i, j);

				Dimension dimension = new Dimension(15, 15);
				button.setSize(dimension);
				button.setMaximumSize(dimension);
				button.setMinimumSize(dimension);
				button.setPreferredSize(dimension);
				
				button.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						CellButton source = (CellButton) e.getSource();
						Cell cell = cellTable.get(source.getI(), source.getJ());
						
						cell.setLife(true);
						cell.setNextAction(NextAction.SURVIARIUR);
						source.setBackground(Color.RED);
						
					}
				});

				add(button);
				buttonsArray[i][j] = button;

			}

		}

		setLayout(v);

		pack();

		setLocationRelativeTo(null);

		pack();
		setVisible(true);

		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		int size = 60;
		Game game = new Game(size, size);

		// boolean[][] lifes = new boolean[][] { { true, false, false },
		// { false, true, true }, { false, false, true } };

		Random random = new Random();
		boolean[][] lifes = new boolean[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				lifes[i][j] = random.nextBoolean();
			}
		}

		CellTable cellTable = new CellTable(lifes);

		game.setCellTable(cellTable);

		for (int i = 0; i < 100000; i++) {

			cellTable.nextCicle();

			try {
				Thread.sleep(500L);
			} catch (InterruptedException e) {
			}
			game.setCellTable(cellTable);
			System.out.println(i+1);

		}

	}

	private void setCellTable(CellTable cellTable) {
		this.cellTable = cellTable;
		
		int size = cellTable.getLength();

		for (int i = 0; i < size; i++) {

			for (int j = 0; j < size; j++) {
				JButton button = buttonsArray[i][j];

				if (cellTable.get(i, j).isLife()) {
					button.setBackground(Color.RED);
				} else {
					button.setBackground(Color.BLACK);
				}

			}

		}

	}
}
