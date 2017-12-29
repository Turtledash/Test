package decision;
import action.Actor;
import model.Spot;

public class DecisionEngine {

	public void makeDecsion(Spot spot, Actor actor) {
		if (spot.board.isEmpty())
			new PreflopDecisionEngine().makeDecsion(spot, actor);
		else
			new PostflopDecsionEngine().makeDecsion(spot, actor);
	}
}
