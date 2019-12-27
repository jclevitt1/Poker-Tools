public class PotOddsBet {
  //show pot odds MAX call range/bet range.
  public static void main(String[] args) {
    int pot = Integer.parseInt(args[0]);
    //true if just after the flop,false if just after the turn.
    int flopTurnOrDependent = Integer.parseInt(args[1]);
    int outs1 = Integer.parseInt(args[2]);
    double out1 = (double) outs1;
    double odds = 0;

    int numCalled = Integer.parseInt(args[3]);
    if (flopTurnOrDependent == 0) {
      odds = FlopToRiver.calculateOdds(out1);
      System.out.println(odds);
    } else if (flopTurnOrDependent == 1) {
      odds = TurnToRiver.calculateOdds(out1);
    } else if (flopTurnOrDependent == 2) {
      int outs2 = Integer.parseInt(args[4]);
      double out2 = (double) outs2;
      odds = DoubleOuts.calculateOdds(out1, out2);
    }
    double potDouble = (double) pot;
    //see UBS notebook for this math.
    double maxBet = (pot * odds) / (numCalled - numCalled * odds - odds);

    System.out.println("The POT ODDS max bet you should call, with " + numCalled + " people calling is " + maxBet + "\n");

    /**
      Fifth argument will represent a bet on the table that you elect to call.
      this will tell you what IMPLIED pot size you must win for this call to be profitable.

      THEORY BEHIND THIS: if you make a call that is not "correct" by pot-odds theory standards,
                          then, IF you make your draw, you need to make the pot a certain amount larger
                          to actually be profitable in the long run. If you make this call and
                          do not end up increasing the pot size if you win, this call is NOT profitable in
                          the long run.

      This will therefore print out the pot you must win (on the chance you hit your draw) to make this call
      profitable.
      **/
    if (args.length == 6) {
      double bet = (double) Integer.parseInt(args[5]);

      //int newPot = pot + numCalled * bet;
      double almostTotalPot = ((1 - odds) * numCalled * bet)/odds;
      double totalPot = almostTotalPot + numCalled * bet;
      double diff = totalPot - (numCalled + 1) * bet;
      System.out.println("IMPLIED ODDS\n\nThe total pot, if an initial pot of " + pot + " is called with a:");
      System.out.println(odds + "% equity\t" + bet + " bet");
      System.out.println("The total pot should be: " + totalPot);
      System.out.println("Meaning, the amount you have to add to the pot before showdown is: " + diff + " (if you make your draw)\n");

    }
  }
}
