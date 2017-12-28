package model;

public class Player {

	public double stack;
	public Double bet;
	
	public Player(double stack, Double bet) {
		this.stack = stack;
		this.bet = bet;
	}
	
	public String toString() {
		return "Stack: " + stack + " Bet: " + bet; 
	}
}
