import java.util.List;
import java.util.ArrayList;

class SeedProduct
{
    public static void main(String[] args)
    {
        try 
        {
            int num = Integer.parseInt(args[0]);

            System.out.println("Number: " + num);
            System.out.print("Seed factors: ");

            int increment = 1;

            // evens can't be factors of odd numbers, so only need to 
            // check every other number if num is odd
            if (num % 2 == 1)
                increment = 2;

            // list to hold all factors
            List<Integer> factors = new ArrayList<Integer>();

            // check each number from 1 to num / 2
            for (int i = 1; i <= num / 2; i += increment)
            {
                if (num % i == 0)
                    factors.add(i);
            }
            factors.add(num);

            // factors ahs all factors, now test each one
            List<Integer> digits;
            int result, temp;
            for (int i: factors)
            {
                result = 1;
                temp = i;

                // list to hold each digit in the factor
                digits = new ArrayList<Integer>();
                // modulus to get the rightmost digit, 
                // integer division to chop it off
                while (temp > 0)
                {
                    digits.add(temp % 10);
                    temp = temp / 10;
                }

                // multiply each digit together and 
                // multiply that by the full factor
                for (int j: digits)
                {
                    result = result * j;
                }
                result = result * i;

                // check if this is equal to the original number
                if (result == num)
                    System.out.print(i + " ");
            }
            System.out.println();
        } catch (NumberFormatException e) {
            System.err.println("Must enter an integer");
        }
    }
}
            
