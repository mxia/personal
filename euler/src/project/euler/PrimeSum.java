package project.euler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrimeSum
{

	private static List<Integer> findAllPrimesBelow(int number)
	{
		if (number <= 0)
		{
			return Collections.emptyList();
		}

		boolean[] isPrimes = new boolean[number];
		for (int i = 0; i < number; ++i)
		{
			isPrimes[i] = (i >= 2);
		}
		for (int i = 2; i < number; ++i)
		{
			if (isPrimes[i] && i < Math.sqrt(number))
			{
				for (int j = i * i; j < number; j += i)
				{
					isPrimes[j] = false;
				}
			}
		}

		List<Integer> primes = new ArrayList<Integer>();
		for (int i = 2; i < number; ++i)
		{
			if (isPrimes[i])
			{
				primes.add(i);
			}
		}
		return primes;
	}

	public static void main(String[] args)
	{
		List<Integer> primes = findAllPrimesBelow(2000000);
		long sum = 0;
		for (int prime : primes)
		{
			sum += prime;
		}
		System.out.println(sum);
	}
}
