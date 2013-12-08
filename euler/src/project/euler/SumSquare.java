package project.euler;

public class SumSquare
{

	private static long getSumSquareDifference(int number)
	{
		if (number <= 0)
		{
			return 0;
		}
		long squareSum = 0;
		for (int i = 1; i <= number; ++i)
		{
			squareSum += i * i;
		}
		long sum = number * (number + 1) / 2;
		return sum * sum - squareSum;
	}

	public static void main(String[] args)
	{
		System.out.println(getSumSquareDifference(100));
	}
}
