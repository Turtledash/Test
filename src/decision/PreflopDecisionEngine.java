package decision;
import action.Actor;
import model.Card;
import model.Player;
import model.Spot;

public class PreflopDecisionEngine {

	private Spot spot;
	private Actor actor;
	
	public void makeDecsion(Spot spot, Actor actor) {
		this.spot = spot;
		this.actor = actor;
		if (firstRound()) {
			if (noPreviousRaise())
				raiseRangeForNoPreviousraise();
			else
				raiseReraiseRange();
		} else {
			shoveReshoveRange();
		}
		System.out.println();
		System.out.println();
	}

	private void shoveReshoveRange() {
		int pos = getPositionOfReRaise();
		switch (pos) {
		case 1:
			reshoveEPRange();
			break;
		case 2:
			reshoveEPRange();
			break;
		case 3:
			reshoveMPRange();
			break;
		case 4:
			reshoveMPRange();
			break;
		case 5:
			reshoveMPRange();
			break;
		case 6:
			reshoveLateRange();
			break;
		case 7:
			reshoveLateRange();
			break;
		case 8:
			reshoveLateRange();
			break;
		default:
			System.out.println(pos);
			throw new IllegalStateException();
		}
		
	}
	
	private void reshoveLateRange() {
		if (isHand("AA") ||
				isHand("KK") ||
				isHand("QQ") ||
				isHand("AK") ||
				isHand("JJ"))
			actor.shove();
		else
			actor.fold();
	}

	private void reshoveMPRange() {
		if (isHand("AA") ||
				isHand("KK") ||
				isHand("QQ") ||
				isHand("AK"))
			actor.shove();
		else
			actor.fold();
	}

	private void reshoveEPRange() {
		if (isHand("AA") ||
				isHand("KK") ||
				isHand("QQ"))
			actor.shove();
		else
			actor.fold();
	}

	private int getPositionOfReRaise() {
		int positionOfReRaise = -1;
		double sizeOfInitialRaise = -1.0;
		for (int i = 0; i < spot.players.size(); i++) {
			if (spot.players.get(i).bet != null)
				if (spot.players.get(i).bet > sizeOfInitialRaise) {
					positionOfReRaise = i +1;
					sizeOfInitialRaise = spot.players.get(i).bet;
				}
		}
		
		return positionOfReRaise;
	}

	private void raiseReraiseRange() {
		reraiseEPRange();
	}

	private void reraiseEPRange() {
		if (isHand("AA") ||
				isHand("KK") ||
				isHand("QQ"))
			actor.bet(calculateReraiseSize());
		else
			actor.fold();
	}

	private double calculateReraiseSize() {
		double sizeOfInitialRaise = -1.0;
		double reraiseSize = -1.0;
		for (int i = 0; i < spot.players.size(); i++) {
			if (spot.players.get(i).isHero)
				break;
			if (spot.players.get(i).bet != null) {
				if (spot.players.get(i).bet > sizeOfInitialRaise) {
					sizeOfInitialRaise = spot.players.get(i).bet;
					reraiseSize = 3 * sizeOfInitialRaise;
				}
				if (spot.players.get(i).bet == sizeOfInitialRaise) {
					sizeOfInitialRaise = spot.players.get(i).bet;
					reraiseSize += sizeOfInitialRaise;
				}
			}
		}
		
		return reraiseSize;
	}

	private void raiseRangeForNoPreviousraise() {
		int pos = spot.getHeroPosition();
		int numberOfLimpers = getNumberOfLimpers();
		//
		switch (pos) {
		case 8:
			raiseEPOpenRange(numberOfLimpers);
			break;
		case 7:
			raiseEPOpenRange(numberOfLimpers);
			break;
		case 6:
			raiseMPOpenRange(numberOfLimpers);
			break;
		case 5:
			raiseMPOpenRange(numberOfLimpers);
			break;
		case 4:
			raiseMPOpenRange(numberOfLimpers);
			break;
		case 3:
			raiseLateOpenRange(numberOfLimpers);
			break;
		case 2:
			raiseLateOpenRange(numberOfLimpers);
			break;
		case 1:
			raiseLateOpenRange(numberOfLimpers);
			break;
		case 0:
			raiseLateOpenRange(numberOfLimpers);
			break;
		default:
			System.out.println(pos);
			throw new IllegalStateException();
		}
	}
	
	private void raiseLateOpenRange(int numberOfLimpers) {
		System.out.println("Opening Late Range");
		if (isHand("AA") ||
			    isHand("KK") ||
			    isHand("QQ") ||
			    isHand("JJ") ||
			    isHand("1010") ||
			    isHand("99") ||
			    isHand("88") ||
			    isHand("77") ||
			    isHand("AK") ||
			    isHand("AQ") ||
			    isHand("AJ") ||
			    isHand("AT") ||
			    isHand("A9s")||
			    isHand("KQ"))
				actor.bet(0.06 + 0.02 * numberOfLimpers);
			else
				actor.fold();
	}

	private void raiseMPOpenRange(int numberOfLimpers) {
		if (isHand("AA") ||
			    isHand("KK") ||
			    isHand("QQ") ||
			    isHand("JJ") ||
			    isHand("1010") ||
			    isHand("99") ||
			    isHand("88") ||
			    isHand("AK") ||
			    isHand("AQ") ||
			    isHand("AJ") ||
			    isHand("ATs"))
				actor.bet(0.06 + 0.02 * numberOfLimpers);
			else
				actor.fold();
	}

	private void raiseEPOpenRange(int numberOfLimpers) {
		if (isHand("AA") ||
		    isHand("KK") ||
		    isHand("QQ") ||
		    isHand("JJ") ||
		    isHand("1010") ||
		    isHand("AK") ||
		    isHand("AQ") ||
		    isHand("AJs"))
			actor.bet(0.06 + 0.02 * numberOfLimpers);
		else
			actor.fold();
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

	private int getNumberOfLimpers() {
		int limpers = 0;
		for (Player p: spot.players)
			if (p.isHero)
				return limpers;
			else
				if (p.bet != null && p.bet == 0.02)
					limpers++;
		throw new IllegalStateException();
	}

	private boolean noPreviousRaise() {
		for (Player p: spot.players)
			if (p.isHero)
				return true;
			else 
				if (p.bet != null && p.bet != 0.02 && p.bet != 0.01)
					return false;
		return true;
	}

	private boolean firstRound() {
		return spot.getHero().bet == null || spot.getHero().bet == 0.01 || spot.getHero().bet == 0.02;
	}
}
