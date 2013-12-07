package project.euler;

public class Multiples
{
	private static int getMultiplesSum(int number)
	{
		int total = 0;
		for (int i = 0; i < number; i += 3)
		{
			total += i;
		}
		for (int i = 0; i < number; i += 5)
		{
			total += i;
		}
		for (int i = 0; i < number; i += 15)
		{
			total -= i;
		}
		return total;
	}

	public static void main(String[] args)
	{
		System.out.println(getMultiplesSum(1000));
	}
}
