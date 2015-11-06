public class CompoundInterest
{
  public static void main(String[] args)
  {
    final double STARTRATE = 10;
    final int NRATES = 6;
    final int NYEARS = 10;

    //  Set interest rates to 10 -- 15%
    double [] interestRate = new double[NRATES];
    for (int j = 0; j < interestRate.length; j++)
      interestRate[j] = (STARTRATE + j) / 100.00;

    double[][] balances = new double[NYEARS][NRATES];

    //  Set initial balances to 10000
    for (int j = 0; j < balances[0].length; j++)
      balances[0][j] = 10000;

    //  Compute interest for future years
    for (int i = 1; i < balances.length; i++)
    {
      for (int j = 0; j < balances[i].length; j++)
      {
        //  Get last years balance from previous row
        double oldBalance = balances[i - 1][j];

        //  Compute interest
        double interest = oldBalance * interestRate[j];

        //  Compute this years balance
        balances[i][j] = oldBalance + interest;
      }
    }

    //  Print one row of interest rates
    for (int j = 0; j < interestRate.length; j++)
      System.out.printf("%9.0f%%", 100 * interestRate[j]);

    System.out.println();

    //  Print balance table
    for (double[] row : balances)
    {
      //  Print table row
      for (double b : row)
        System.out.printf("%10.2f", b);

      System.out.println();
    }
  }
}
