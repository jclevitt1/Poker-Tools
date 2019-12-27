public class TurnToRiver {
  public static void main(String[] args) {
    int out = Integer.parseInt(args[0]);
    double outs = (double) out;
    double prob = calculateOdds(outs);
    System.out.println(prob);
  }

  public static double calculateOdds(double outs) {
    return outs / 46;
  }
}
