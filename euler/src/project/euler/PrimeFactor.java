package project.euler;

public class PrimeFactor
{

	private static long getLargestPrimeFactor(long number)
	{
		if (number < 0)
		{
			return 0;
		}
		if (number < 2)
		{
			return number;
		}
		int largest = 2;
		int limit = (int) Math.sqrt(number);
		while (number > 1)
		{
			boolean found = false;
			for (int i = largest; i < limit; ++i)
			{
				if (number % i == 0)
				{
					largest = i;
					number /= i;
					limit = (int) Math.sqrt(number);
					found = true;
					break;
				}
			}
			if (!found)
			{
				return number;
			}
		}
		return largest;
	}

	public static void main(String[] args)
	{
		System.out.println(getLargestPrimeFactor(600851475143L));
	}
}
