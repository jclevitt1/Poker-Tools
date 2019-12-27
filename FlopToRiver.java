public class FlopToRiver {
  public static void main(String[] args){
    int out = Integer.parseInt(args[0]);
    double outs = (double) out;
    double odds = calculateOdds(outs);
    System.out.println(odds);
  }

  public static double calculateOdds(double outs) {
    double sum = 0;
    int x = 47;
    for (double j = 0; j < outs; j++) {
      sum += 2*x - 2;
      x--;
    }
    return sum/(47*46);
  }
}
