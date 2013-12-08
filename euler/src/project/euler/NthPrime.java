package project.euler;

public class NthPrime
{

	private static long getNthPrime(int number)
	{
		if (number <= 0)
		{
			return 0;
		}
		if (number == 1)
		{
			return 2;
		}

		long[] primes = new long[number];
		int index = 0;
		primes[index] = 2;
		index++;
		long i = 3;
		while (true)
		{
			if (isPrime(i, primes))
			{
				primes[index] = i;
				index++;
				if (index == number)
				{
					return primes[index - 1];
				}
			}
			i++;
		}
	}

	private static boolean isPrime(long number, long[] primes)
	{
		int limit = (int) Math.sqrt(number);
		for (long prime : primes)
		{
			if (prime > limit)
			{
				break;
			}
			if (number % prime == 0)
			{
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args)
	{
		System.out.println(getNthPrime(10001));
	}
}
