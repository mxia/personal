package project.euler;


public class SmallestMultiple
{

	private static long getSmallestMultiple(int number)
	{
		if (number < 0)
		{
			return 0;
		}
		if (number <= 2)
		{
			return number;
		}

		boolean[] isPrimes = new boolean[number];
		for (int i = 0; i < number; ++i)
		{
			isPrimes[i] = true;
		}
		for (int i = 2; i < number; ++i)
		{
			if (isPrimes[i])
			{
				for (int j = i * i; j < number; j += i)
				{
					isPrimes[j] = false;
				}
			}
		}

		long result = 1;
		for (int i = 2; i < number; ++i)
		{
			if (isPrimes[i])
			{
				int max = (int) (Math.log(number) / Math.log(i));
				for (int j = 0; j < max; ++j)
				{
					result *= i;
				}
			}
		}
		return result;
	}

	public static void main(String[] args)
	{
		System.out.println(getSmallestMultiple(20));
	}
}
