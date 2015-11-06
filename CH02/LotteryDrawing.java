import java.util.*;

public class LotteryDrawing
{
  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);

    System.out.print("How many nubmers do you need to draw? ");
    int k = in.nextInt();

    System.out.print("What is the highest number you can draw? ");
    int n = in.nextInt();

    //  Fill in an array with numbers 1 - n
    int [] numbers = new int[n];
    for (int i = 0; i < numbers.length; i++)
      numbers[i] = i + 1;

    //  Draw k numbers and put them in a second array
    int[] result = new int[k];
    for (int i = 0; i < result.length; i++)
    {
      //  make random index between 0 and n - 1
      int r = (int) (Math.random() * n);

      //  Pick the elemnt at random location
      result[i] = numbers[r];

      //  Move last element into random location
      numbers[r] = numbers[n - 1];
      n--;
    }

    //  Print sorted array
    Arrays.sort(result);
    System.out.println("Bet the following combination.  It'll make you rich!!!");
    for (int r : result)
      System.out.println(r);
  }
}
