/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package black_jack;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author sarth
 */
public class Hand {

    ArrayList<Card> cards;

    public Hand() {
        cards = new ArrayList<Card>();
    }

    public void clear() {
        cards.clear();

    }

    public void addCard(Card c) {
        cards.add(c);
    }

    public void showHand() {
        //show card only if all cards are flipped Up
        //   boolean allFaceUp=true;
        String str = "";
        for (Card c : cards) {
            if (c.flipStatus() == false) {
                str += "Card is faced down\n";
            } else {
                str += c.toString() + "\n";
                // if(!c.flipStatus()){allFaceUp=false;}
            }
            // if(!allFaceUp){return "All cards are not faced up:total counting denied.";}

        }
        System.out.print(str);
        System.out.print("Total points= " + getTotal());

        System.out.println("");

    }

    public boolean allCardStatus() {
        boolean up = true;
        for (Card c : cards) {
            if (c.flipStatus() == false) {
                up = false;
            }
        }
        return up;
    }

    public void flipAllCardsUp() {
        for (Card c : cards) {
            c.flipCardUp();
        }
    }

    public boolean giveCard(Card card, Hand otherHand) {
        if (!cards.contains(card)) {
            return false;
        } else {
            this.cards.remove(card);
            otherHand.addCard(card);
            return true;

        }

    }

    public void shuffle() {
        Collections.shuffle(cards);

    }

    public int getTotal() {
        int total = 0;
        boolean hasAce = false;
        // boolean allFaceUp=true;
        for (int i = 0; i < cards.size(); i++) {

            total += cards.get(i).getRankValue();
            if ("ace".equals(cards.get(i).getRankText())) {
                hasAce = true;
            }
        }
        if (hasAce && total <= 11) {
            total += 10;
        }
        if (!allCardStatus()) {
            System.out.println("All cards are not faced up total denied.");
            return cards.get(0).getRankValue();
        }

        return total;
    }

}
