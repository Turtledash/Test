package model;

public class Player {

	public double stack;
	public Double bet;
	public boolean isHero;
	
	public Player(double stack, Double bet, boolean isHero) {
		this.stack = stack;
		this.bet = bet;
		this.isHero = isHero;
	}
	
	public String toString() {
		return "Stack: " + stack + " Bet: " + bet; 
	}
}
