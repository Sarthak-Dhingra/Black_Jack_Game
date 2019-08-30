/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package black_jack;

/**
 *
 * @author sarth
 */
public class Card {

    private Suit suit;
    private Rank rank;
    private boolean isFaceUp;

    public Card(Suit suit, Rank rank) {
        this.rank = rank;
        this.suit = suit;
        isFaceUp = true;
    }

    public String getSuitText() {
        return suit.getSuitText();
    }

    public void flipCardDown() {
        this.isFaceUp = false;
    }

    public void flipCardUp() {
        this.isFaceUp = true;
    }

    public boolean flipStatus() {
        return this.isFaceUp == true;
    }

    public int getRankValue() {
        return rank.getRankValue();
    }

    public String getRankText() {
        return rank.getRankText();
    }

    public String toString() {
        if (isFaceUp) {
            return (rank.getRankText() + " of " + suit.getSuitText());
        }
        return "Card is facedown";
    }

}
