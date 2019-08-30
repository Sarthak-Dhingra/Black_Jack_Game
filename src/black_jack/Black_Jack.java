/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package black_jack;

import static java.lang.System.exit;
import java.util.Scanner;

/**
 *
 * @author sarth
 */
/*
RULES OF BLACKJACK


7-


 */
public class Black_Jack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

//    1-CREATE A DECK
        Deck d1 = new Deck();
        d1.initDeck();
        d1.shuffle();
        //Creating an object of gamefuntions
        gameFunctions func = new gameFunctions();

        boolean fish = false;

        Hand h1, dealer;
        h1 = new Hand();

        dealer = new Hand();

        double balance;
        double var;
        Hand[] hands = {h1, dealer};
        Scanner in = new Scanner(System.in);
        System.out.println("WELCOME TO BLACKJACK");
        System.out.println("Please enter the players name:");
        String name = in.next();
        System.out.println(name + ",What amount have you brought in today?");
        double totalAmt = balance = in.nextDouble();
        System.out.println("Okay,sounds great!");
        do {
            boolean flag = false;

            System.out.println("What is your initial bid");
            var = in.nextDouble();
            do {
                if (balance < var) {
                    System.out.println("Sorry your bid cannot exceed the total amount you have,Please enter your revised bid!");
                    var = in.nextDouble();
                }
            } while (balance < var);
            double bidAmt = var;
            balance = balance - bidAmt;
            System.out.println("Okay,wish you best of luck ,here the game begins!");
            gameFunctions.margin();

//3-INITIALLY DEAL 2 CARDS TO OUR HAND AND THE DEALER
            d1.deal(hands, 2);

            dealer.cards.get(1).flipCardDown();

            func.printCards(dealer, h1, name);

            do {

                gameFunctions.margin();
                System.out.println("Choose your option number\n1.Hit\n2.Stand\n3.double down\n4.Surrender");
                int choice = in.nextInt();
                switch (choice) {
                    case 1:
                        d1.deal(hands, 1);

                        dealer.cards.get(dealer.cards.size() - 1).flipCardDown();
                        //-----------------------

                        func.printCards(dealer, h1, name);

                        if (h1.getTotal() > 21) {
                            System.out.println("You are busted ,dealer wins");
                            balance = func.money(bidAmt, balance, 0);
                            flag = true;
                        }

                        if (h1.getTotal() == 21) {
                            System.out.println(name + " wins the game");
                            balance = func.money(bidAmt, balance, 1);
                            flag = true;
                            break;
                        }
                        break;
                    case 2:
                        dealer.flipAllCardsUp();

                        System.out.println(name + "'s cards");
                        h1.showHand();
                        gameFunctions.margin();
                        System.out.println("Dealers cards");
                        dealer.showHand();

                        int winner = func.checkWinner(dealer, h1);

                        switch (winner) {
                            case 0:
                                System.out.println("Dealer wins the game");
                                balance = func.money(bidAmt, balance, 0);
                                flag = true;
                                break;
                            case 1:
                                System.out.println(name + " wins the game");
                                balance = func.money(bidAmt, balance, 1);
                                flag = true;
                                break;
                            case 2:
                                System.out.println("Draw");
                                balance = func.money(bidAmt, balance, 2);
                                flag = true;
                                break;
                        }

                        break;
                    case 3:
                        if (balance >= bidAmt) {
                            balance -= bidAmt;
                            bidAmt *= 2;
                            System.out.println("Bid on current bet:$" + bidAmt);
                        } else {
                            System.out.println("Sorry you dont have enough money to double down your bet");
                            System.out.println("So,you are till betting with:$" + bidAmt);
                        }
                        break;
                    case 4:
                        System.out.println("Okay as you wish,so according to the rules of the game,you lose half amount of your bid.");
                        balance = func.money(bidAmt, balance, 3);
                        flag = true;
                        break;
                }

            } while (!flag);
            if (balance == 0) {
                System.out.println("Sorry,you lost all your money!\nBETTER LUCK NEXT TIME");
                fish = false;
            } else {
                boolean endGame = true;
                do {
                    System.out.println("Would you like to play another round of the game?(yes/no)");
                    String num = in.next();
                    if (num.equalsIgnoreCase("yes")) {
                        fish = true;
                        dealer.clear();
                        h1.clear();
                        d1.clear();
                        d1.initDeck();
                        d1.shuffle();

                    } else if (num.equalsIgnoreCase("no")) {
                        exit(0);
                    } else {
                        System.out.println("Invalid input,please enter again");
                        endGame = false;
                    }
                } while (!endGame);
            }
        } while (fish);

    }

}
