package project.euler;

public class Fibonacci
{

	private static long getEvenFibonacciSum(long number)
	{
		long total = 0;
		long previous = 1;
		long current = 2;
		long next;
		while (current <= number)
		{
			if (current % 2 == 0)
			{
				total += current;
			}
			next = previous + current;
			previous = current;
			current = next;
		}

		return total;
	}

	public static void main(String[] args)
	{
		System.out.println(getEvenFibonacciSum(4000000));
	}
}
