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
public enum Suit {
    HEARTS("hearts"),
    SPADES("spades"),
    DIAMONDS("diamonds"),
    CLUBS("clubs");

    private final String suitText;

    private Suit(String text) {
        this.suitText = text;
    }

    public String getSuitText() {
        return suitText;
    }

}
