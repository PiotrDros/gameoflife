package org.me;

public class Cell {
	
	private NextAction nextAction;
	
	boolean life;

	public NextAction getNextAction() {
		return nextAction;
	}

	public void setNextAction(NextAction nextAction) {
		this.nextAction = nextAction;
	}

	public boolean isLife() {
		return life;
	}

	public void setLife(boolean life) {
		this.life = life;
	}
	
	public Cell(boolean life) {
		this.life = life;
		
	}
	

}
