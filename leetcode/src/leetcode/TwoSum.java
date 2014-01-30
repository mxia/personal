package leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum
{

	private static int[] findSum(int[] numbers, int target)
	{
		if (numbers == null || numbers.length < 2)
		{
			return null;
		}

		Map<Integer, Integer> sumMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; ++i)
		{
			if (sumMap.containsKey(numbers[i]))
			{
				int index = sumMap.get(numbers[i]);
				int[] result = new int[2];
				result[0] = index + 1;
				result[1] = i + 1;
				return result;
			}
			else
			{
				sumMap.put(target - numbers[i], i);
			}
		}
		return null;
	}

	@SuppressWarnings("nls")
	public static void main(String[] args)
	{
		int[] result = findSum(new int[] { 2, 7, 11, 15 }, 17);
		if (result == null)
		{
			System.out.println("none");
		}
		else
		{
			System.out.println(result[0] + ", " + result[1]);
		}
	}
}
