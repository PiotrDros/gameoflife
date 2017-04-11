package org.me;

import static org.junit.Assert.*;

import org.junit.Test;


public class GameOfLifeTest {

	@Test
	public void testApp() {
		// give
		CellTable cellTable = createTable();

		assertEquals(2, cellTable.countNainbers(1, 1));

		assertEquals(1, cellTable.countNainbers(0, 0));

		assertEquals(2, cellTable.countNainbers(2, 2));

		assertEquals(3, cellTable.countNainbers(2, 1));

		assertTrue(true);
	}

	private CellTable createTable() {
		boolean[][] lifes = new boolean[][] { { false, false, false },
				{ false, true, true }, { false, false, true } };
		CellTable cellTable = new CellTable(lifes);
		return cellTable;
	}

	@Test
	public void shouldDied() {
		//given
		boolean[][] lifes = new boolean[][] { { true, false, false },
				{ false, true, true }, { false, false, true } };
		CellTable cellTable = new CellTable(lifes);		
		
		
		//when
		cellTable.nextCicle();
		
		
		assertFalse(cellTable.get(0, 0).isLife());
		
	}
	
	@Test
	public void shouldBourn() {
		//given
		boolean[][] lifes = new boolean[][] { { true, false, false },
				{ false, true, true }, { false, false, true } };
		CellTable cellTable = new CellTable(lifes);	
		
		assertFalse(cellTable.get(2, 1).isLife());
		
		
		//when
		cellTable.nextCicle();
		
		
		// then
		assertTrue(cellTable.get(1, 2).isLife());
		
	}
	@Test
	public void shouldDoNothing() {
		//given
		boolean[][] lifes = new boolean[][] { { true, false, false },
				{ false, true, true }, { false, false, true } };
		CellTable cellTable = new CellTable(lifes);	
		
		assertTrue(cellTable.get(2, 2).isLife());
		
		
		//when
		cellTable.nextCicle();
		
		
		// then
		assertTrue(cellTable.get(2, 2).isLife());
		
	}


}
