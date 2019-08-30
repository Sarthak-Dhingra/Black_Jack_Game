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
public class Deck extends Hand {

    public void initDeck() {
        for (Suit s : Suit.values()) {
            for (Rank r : Rank.values()) {
                Card c = new Card(s, r);
                this.addCard(c);

            }
        }
    }

    //deal to an array list of hands
    public void deal(Hand[] hands, int perHand) {
        for (int i = 0; i < perHand; i++) {
            for (int j = 0; j < hands.length; j++) {
                this.giveCard(cards.get(0), hands[j]);
            }

        }
    }

    //deals to just one hand
    public void deal(Hand hand, int perHand) {
        for (int i = 0; i < perHand; i++) {
            this.giveCard(cards.get(0), hand);
        }

    }

}

//            
//    public void flipCard(Card c){
//    c.flipCard();
//    
//    }

