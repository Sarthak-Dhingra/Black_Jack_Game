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
public class gameFunctions {

    //dealer wins =0,player wins=1,draw =2;
    public int checkWinner(Hand dealer, Hand player) {
        double pTotal = player.getTotal();
        double dTotal = dealer.getTotal();

        if (pTotal <= 21) {
            if (dTotal <= 21) {

                if (pTotal > dTotal) {
                    return 1;
                } else if (pTotal == dTotal) {
                    return 2;
                } else {
                    return 0;
                }

            }
            return 1;
        } else {
            return 0;
        }

    }

    public void printCards(Hand dealer, Hand player, String pName) {
        System.out.println(pName + "'s cards");
        player.showHand();
        margin();
        System.out.println("Dealers cards");
        dealer.showHand();
    }

    public static void margin() {
        System.out.println("-------------------------------------------");
    }

    //dealer wins =0
    //player wins=1
    //draw =2;
    //because we before calling t=of this method we have already taken the amount of bid out from the balance;applicable at 1,2,3,4
    public double money(double bidAmt, double balance, int state) {
        double amt = -1 * bidAmt;

        switch (state) {
            case 0:                                                                      //1

                break;

            case 1:
                balance += 2 * bidAmt;                                                    //2

                amt *= -1;

                break;

            case 2:
                balance += bidAmt;                                                        //3
                amt = 0;
                System.out.println("You both have the same number of points so you dont lose anything");
//System.out.println("The balance you are left with:"+balance);
                break;
            case 3:
                balance += bidAmt / 2;                                                     //4
                amt /= 2;

                break;

        }
        if (amt < 0) {
            System.out.println("Net loss :" + amt);
        } else if (amt == 0) {
            System.out.println("No net gain or net loss");
        } else {
            System.out.println("Net gain:" + amt);
        }
        System.out.println("");
        System.out.println("The balance you are left with:" + balance);

        return balance;
    }
}
