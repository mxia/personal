package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum
{

	private static List<List<Integer>> findCombinationSum(int[] data, int target)
	{
		Arrays.sort(data);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> entry = new ArrayList<Integer>();
		findSum(data, target, result, entry, 0);

		return result;
	}

	private static void findSum(int[] data, int target, List<List<Integer>> result, List<Integer> entry, int start)
	{
		if (target == 0)
		{
			// found one set
			result.add(new ArrayList<Integer>(entry));
		}
		else
		{
			for (int i = start; i < data.length; ++i)
			{
				if (target < data[i])
				{
					return;
				}
				entry.add(data[i]);
				findSum(data, target - data[i], result, entry, i);
				entry.remove(entry.size() - 1);
			}
		}
	}

	public static void main(String[] args)
	{
		int[] data = new int[] { 2, 3, 5, 7 };
		System.out.println(findCombinationSum(data, 7));
	}
}
