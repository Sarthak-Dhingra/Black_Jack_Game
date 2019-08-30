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
public enum Rank {

    ACE("ace", 1),
    TWO("2", 2),
    THREE("3", 3),
    FOUR("4", 4),
    FIVE("5", 5),
    SIX("6", 6),
    SEVEN("7", 7),
    EIGHT("8", 8),
    NINE("9", 9),
    TEN("10", 10),
    JACK("jack", 10),
    QUEEN("queen", 10),
    KING("king", 10);

    private final String rankText;
    private final int rankValue;

    private Rank(String s, int value) {
        this.rankText = s;
        this.rankValue = value;

    }

    public String getRankText() {
        return rankText;
    }

    public int getRankValue() {
        return rankValue;
    }

}
