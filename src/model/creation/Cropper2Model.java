package model.creation;

import java.util.List;

import extraction.ScreenCropper;
import model.Card;
import model.Player;
import model.Spot;
import transcription.BetTranscriptor;
import transcription.ButtonTranscriptor;
import transcription.CardTranscriptor;
import transcription.PlayerActiveTranscriptor;
import transcription.PotTranscriptor;
import transcription.StackTranscriptor;

public class Cropper2Model {

	private BetTranscriptor betTranscriptor;
	private ButtonTranscriptor buttonTranscriptor;
	private CardTranscriptor cardTranscriptor;
	private PlayerActiveTranscriptor activeTranscriptor;
	private PotTranscriptor potTranscriptor;
	private StackTranscriptor stackTranscriptor;
	
	
	public Cropper2Model(ScreenCropper cropper) {
		betTranscriptor = new BetTranscriptor(cropper);
		buttonTranscriptor = new ButtonTranscriptor(cropper);
		cardTranscriptor = new CardTranscriptor(cropper);
		activeTranscriptor = new PlayerActiveTranscriptor(cropper);
		stackTranscriptor = new StackTranscriptor(cropper);
		potTranscriptor = new PotTranscriptor(cropper);
	}
	
	public Spot createModel() {
		Spot spot = new Spot();
		spot.potSize = potTranscriptor.getPotSize();
		spot.heroCard1 = cardTranscriptor.getLeftPlayerCard();
		spot.heroCard2 = cardTranscriptor.getRightPlayerCard();
		addBoardCards(spot.board);
		addPlayers(spot.players);
		System.out.println("HeroPos: " + spot.getHeroPosition());
		return spot;
 	}

	private void addPlayers(List<Player> players) {
		int button = getButton();
		System.out.println("Buttonposition: " + button);
		int bigblind = getBigBlindFromButton(button);
		System.out.println("Bigblindposition: " + bigblind);
		int position = bigblind;
		do {
			position = position % 9;
			position++;
			if (isActive(position))
				players.add(createPlayer(position));
		} while (position != bigblind);
		
	}

	private Player createPlayer(int position) {
		return new Player(getStacksize(position), getBet(position), position == 9);
	}

	private Double getBet(int position) {
		switch (position) {
		case 1:
			return betTranscriptor.getBetEnemy1();
		case 2:
			return betTranscriptor.getBetEnemy2();
		case 3:
			return betTranscriptor.getBetEnemy3();
		case 4:
			return betTranscriptor.getBetEnemy4();
		case 5:
			return betTranscriptor.getBetEnemy5();
		case 6:
			return betTranscriptor.getBetEnemy6();
		case 7:
			return betTranscriptor.getBetEnemy7();
		case 8:
			return betTranscriptor.getBetEnemy8();
		case 9:
			return betTranscriptor.getBetPlayer();
		}
		return null;
	}

	private double getStacksize(int position) {
		switch (position) {
		case 1:
			return stackTranscriptor.getStackSizeEnemy1();
		case 2:
			return stackTranscriptor.getStackSizeEnemy2();
		case 3:
			return stackTranscriptor.getStackSizeEnemy3();
		case 4:
			return stackTranscriptor.getStackSizeEnemy4();
		case 5:
			return stackTranscriptor.getStackSizeEnemy5();
		case 6:
			return stackTranscriptor.getStackSizeEnemy6();
		case 7:
			return stackTranscriptor.getStackSizeEnemy7();
		case 8:
			return stackTranscriptor.getStackSizeEnemy8();
		case 9:
			return stackTranscriptor.getStackSizePlayer();
		}
		throw new IllegalStateException();
	}

	private int getBigBlindFromButton(int position) {
		do {
			position = position % 9;
			position++;
		} while (!isActive(position));
		do {
			position = position % 9;
			position++;
		} while (!isActive(position));
		return position;
	}

	private boolean isActive(int position) {
		switch (position) {
		case 1:
			return activeTranscriptor.isEnemy1Active();
		case 2:
			return activeTranscriptor.isEnemy2Active();
		case 3:
			return activeTranscriptor.isEnemy3Active();
		case 4:
			return activeTranscriptor.isEnemy4Active();
		case 5:
			return activeTranscriptor.isEnemy5Active();
		case 6:
			return activeTranscriptor.isEnemy6Active();
		case 7:
			return activeTranscriptor.isEnemy7Active();
		case 8:
			return activeTranscriptor.isEnemy8Active();
		case 9:
			return true;
		}
		throw new IllegalStateException();
	}

	private int getButton() {
		if (buttonTranscriptor.isEnemy1Button())
			return 1;
		if (buttonTranscriptor.isEnemy2Button())
			return 2;
		if (buttonTranscriptor.isEnemy3Button())
			return 3;
		if (buttonTranscriptor.isEnemy4Button())
			return 4;
		if (buttonTranscriptor.isEnemy5Button())
			return 5;
		if (buttonTranscriptor.isEnemy6Button())
			return 6;
		if (buttonTranscriptor.isEnemy7Button())
			return 7;
		if (buttonTranscriptor.isEnemy8Button())
			return 8;
		if (buttonTranscriptor.isPlayerButton())
			return 9;
		throw new IllegalStateException();
	}

	private void addBoardCards(List<Card> board) {
		addCard(board, cardTranscriptor.getMiddle1Card());
		addCard(board, cardTranscriptor.getMiddle2Card());
		addCard(board, cardTranscriptor.getMiddle3Card());
		addCard(board, cardTranscriptor.getMiddle4Card());
		addCard(board, cardTranscriptor.getMiddle5Card());
	}

	private void addCard(List<Card> board, Card card) {
		if (card != null)
			board.add(card);
	}
	
}
