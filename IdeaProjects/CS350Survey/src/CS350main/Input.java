package CS350main;
import java.util.Scanner;

public class Input {
	public static Integer checkInputInt(int min, int max)
    {
        Scanner in = new Scanner(System.in);
        int num = min;
        boolean done = false;
        while (!done)
        {
            String numStr = in.nextLine();

            try
            {
                num = Integer.parseInt(numStr);
                if (num >= min && num <= max)
                {
                    done = true;
                }
                else
                {
                    System.out.println("Please input a number in the correct range.");
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("Please input a number.");
            }
        }

        return num;
	}
}
