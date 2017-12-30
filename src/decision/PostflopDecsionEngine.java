package decision;
import action.Actor;
import model.Card;
import model.Player;
import model.Spot;

public class PostflopDecsionEngine {

	private Spot spot;
	private Actor actor;
	
	public void makeDecsion(Spot spot, Actor actor) {
		this.spot = spot;
		this.actor = actor;
		if (isLimpedPot())
			actor.fold();
		else if (canContinuationBet())
			bet(spot.potSize * 0.66);
		else if (didHit())
			bet(spot.potSize * 0.66);
		else 
			actor.fold();
	}

	private void bet(double d) {
		if (d > spot.getHero().stack * 0.8)
			actor.shove();
		else
			actor.bet(d);
	}

	private boolean didHit() {
		for (Card c: spot.board)
			if (c.getCardType().equals(spot.heroCard1.getCardType()) ||
					c.getCardType().equals(spot.heroCard2.getCardType()))
				return true;
		if (isHand("AA"))
			return true;
		if (isHand("KK")) {
			for (Card c: spot.board)
				if (c.getCardType().equals("A"))
					return false;
			return true;
		} 
		if (isHand("QQ")) {
			for (Card c: spot.board)
				if (c.getCardType().equals("A") || c.getCardType().equals("K"))
					return false;
			return true;
		} 
		if (isHand("JJ")) {
			for (Card c: spot.board)
				if (c.getCardType().equals("A") || c.getCardType().equals("K") || c.getCardType().equals("QQ"))
					return false;
			return true;
		} 
		if (isHand("1010")) {
			for (Card c: spot.board)
				if (c.getCardType().equals("A") || c.getCardType().equals("K") || c.getCardType().equals("Q") || c.getCardType().equals("J"))
					return false;
			return true;
		}
		if (isHand("99")) {
			for (Card c: spot.board)
				if (c.getCardType().equals("A") || c.getCardType().equals("K") || c.getCardType().equals("Q") || c.getCardType().equals("J") || c.getCardType().equals("10"))
					return false;
			return true;
		}
		if (isHand("88")) {
			for (Card c: spot.board)
				if (c.getCardType().equals("A") || c.getCardType().equals("K") || c.getCardType().equals("Q") || c.getCardType().equals("J") || c.getCardType().equals("10") || c.getCardType().equals("9"))
					return false;
			return true;
		}
		return false;
	}

	private boolean canContinuationBet() {
		if (isFlop() && nobodyBet() && spot.players.size() == 2)
			return true;
		return false;
	}

	private boolean nobodyBet() {
		for (Player p: spot.players)
			if (p.bet != null)
				return false;
		return true;
	}

	private boolean isFlop() {
		return spot.board.size() == 3;
	}

	private boolean isLimpedPot() {
		if (isHand("AA") ||
				isHand("KK") ||
				isHand("QQ") ||
				isHand("JJ") ||
				isHand("1010") ||
				isHand("99") ||
				isHand("88") ||
				isHand("AK") ||
				isHand("AQ") ||
				isHand("AQ") ||
				isHand("AJ") ||
				isHand("AT") ||
				isHand("A9s"))
			return false;
		else
			return true;
	}

	private boolean isHand(String hand) {
		return isHand(hand, spot.heroCard1, spot.heroCard2);
	}
	
	private boolean isHand(String hand, Card card1, Card card2) {
		String type1 = card1.getCardType();
		String type2 = card2.getCardType();
		String suitedString = "";
		if (card1.getCardColor().equals(card2.getCardColor()))
			suitedString = "s";
		if ((type1+type2+suitedString).equals(hand) ||
				(type2+type1+suitedString).equals(hand) ||
				(type1+type2).equals(hand) || 
				(type2+type1).equals(hand))         
			return true;
		return false;
	}
}
