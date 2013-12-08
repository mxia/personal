package project.euler;

public class Triplet
{

	private static int[] findPythagoreanTriplet(int sum)
	{
		int[] triplet = new int[3];
		int maxA = (sum - 3) / 3;
		int maxB = (sum - 2) / 2;
		for (int i = 1; i <= maxA; ++i)
		{
			for (int j = i; j <= maxB; ++j)
			{
				int c = sum - i - j;
				if (i * i + j * j == c * c)
				{
					triplet[0] = i;
					triplet[1] = j;
					triplet[2] = c;
					return triplet;
				}
			}
		}
		return triplet;
	}

	public static void main(String[] args)
	{
		int[] triplet = findPythagoreanTriplet(1000);
		System.out.println(triplet[0] * triplet[1] * triplet[2]);
	}
}
