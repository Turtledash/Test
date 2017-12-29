package model;

import java.util.LinkedList;
import java.util.List;

public class Spot {

	public Card heroCard1;
	public Card heroCard2;
	public List<Card> board = new LinkedList<Card>();
	public List<Player> players = new LinkedList<Player>(); //last player is BB
	public double potSize;
	
	public void printDebug() {
		System.out.println("Player cards: " + heroCard1.toString() + heroCard2.toString());
		System.out.println("Board: ");
		for (Card c: board)
			System.out.print(c.toString());
		System.out.println("Players:");
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).isHero) {
				System.out.println((players.size() - i - 1) + " left to act");
				break;
			}
			System.out.println(players.get(i).toString());
		}
	}
}
