package org.me;

public class CellTable {

	private Cell[][] cellTable;
	private int length;

	public int getLength() {
		return length;
	}

	public CellTable(boolean[][] lifes) {

		length = lifes.length;

		this.cellTable = new Cell[length][length];

		for (int i = 0; i < length; i++) {

			for (int j = 0; j < length; j++) {
				cellTable[i][j] = new Cell(lifes[i][j]);
			}

		}

	}

	 int countNainbers(int i, int j) {

		int counted = 0;

		for (int k = i - 1; k <= i + 1; k++) {

			for (int l = j - 1; l <= j + 1; l++) {

				if (k >= 0 && k < length && l >= 0 && l < length) {
					if ( (k != i || l != j ) &&  cellTable[k][l].isLife()) {
						counted++;
					}
				}
			}
		}
		return counted;
	}

	public void nextCicle() {
		for(int i = 0; i < length; i++){
			for(int j = 0; j < length; j++){
				int countNainbers = countNainbers(i, j);
				if(countNainbers < 2  || countNainbers > 3) {
					cellTable[i][j].setNextAction(NextAction.DEAD);
				}else if(countNainbers == 3){ 
					
					cellTable[i][j].setNextAction(NextAction.BORN);
				} else {
					cellTable[i][j].setNextAction(NextAction.SURVIARIUR);
				}
			}
		}
		
		//
		for(int i = 0; i < length; i++){
			for(int j = 0; j < length; j++){
				Cell cell = get(i, j);
				if(NextAction.DEAD == cell.getNextAction()){
					cell.setLife(false);
				} else if(NextAction.BORN == cell.getNextAction()){
					cell.setLife(true);
				}
			}
		}
	}

	public Cell get(int i, int j) {
		return cellTable[i][j];
	}
}
