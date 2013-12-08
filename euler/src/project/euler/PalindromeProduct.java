package project.euler;

public class PalindromeProduct
{

	private static boolean isPalindrome(int number)
	{
		if (number < 10)
		{
			return true;
		}
		int temp = number;
		int division = 1;
		while (temp >= 10)
		{
			division *= 10;
			temp /= 10;
		}
		int left, right;
		while (number >= 10)
		{
			left = number / division;
			right = number - (number / 10) * 10;
			if (left != right)
			{
				return false;
			}
			number = (number - left * division) / 10;
			division /= 100;
		}
		return true;
	}

	public static void main(String[] args)
	{
		int max = 0;
		for (int i = 100; i < 1000; ++i)
		{
			for (int j = i; j < 1000; ++j)
			{
				int multiple = i * j;
				if (isPalindrome(multiple))
				{
					max = Math.max(max, multiple);
				}
			}
		}
		System.out.println(max);
	}
}
