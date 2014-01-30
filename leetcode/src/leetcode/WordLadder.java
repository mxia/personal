package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder
{

	private static List<List<String>> getLadder(String startWord, String endWord, Set<String> dictionary)
	{
		if (dictionary == null || dictionary.isEmpty() || startWord == null || endWord == null)
		{
			return null;
		}

		dictionary.add(startWord);
		dictionary.add(endWord);

		List<List<String>> result = new ArrayList<List<String>>();
		List<String> possibleLadder = new ArrayList<String>();
		Queue<List<String>> sequences = new LinkedList<List<String>>();
		sequences.add(possibleLadder);
		Queue<String> q = new LinkedList<String>();
		Set<String> visited = new HashSet<String>();
		q.add(startWord);

		while (!q.isEmpty())
		{
			String currentWord = q.remove();
			visited.add(currentWord);
			List<String> currentLadder = sequences.remove();
			currentLadder.add(currentWord);

			if (currentWord.equals(endWord))
			{
				result.add(new ArrayList<String>(currentLadder));
			}

			boolean hasCandidate = false;
			for (int i = 0; i < currentWord.length(); ++i)
			{
				StringBuilder sb = new StringBuilder(currentWord);
				for (int j = 0; j < 26; ++j)
				{
					sb.setCharAt(i, (char) ('a' + j));
					String candidate = sb.toString();
					if (!visited.contains(candidate) && dictionary.contains(candidate))
					{
						q.add(candidate);
						sequences.add(new ArrayList<String>(currentLadder));
					}
				}
			}
			if (!hasCandidate)
			{
				currentLadder.remove(currentWord);
			}
		}
		return result;
	}

	@SuppressWarnings("nls")
	public static void main(String[] args)
	{
		Set<String> dictionary = new HashSet<String>();
		dictionary.addAll(Arrays.asList("hot", "dot", "dog", "lot", "log"));
		System.out.println(getLadder("hit", "cog", dictionary));
	}
}
