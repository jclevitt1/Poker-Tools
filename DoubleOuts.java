public class DoubleOuts {
  public static void main(String[] args) {
    int out1 = Integer.parseInt(args[0]);
    //out2 should be passed in assuming out1 is made on the turn.
    int out2 = Integer.parseInt(args[1]);
    double outs1 = (double) out1;
    double outs2 = (double) out2;
    double odds = calculateOdds(outs1, outs2);
    System.out.println(odds);
  }

  public static double calculateOdds(double out1, double out2) {
    return out1 / 47 * out2 / 46;
  }
}
