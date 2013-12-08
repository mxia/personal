package paper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution
{

	private static class Paper
	{
		private final String id;
		private List<String> authors;
		private List<Paper> refs;

		public Paper(String id)
		{
			this.id = id;
		}

		@Override
		public int hashCode()
		{
			return id.hashCode();
		}

		@Override
		public boolean equals(Object other)
		{
			return other instanceof Paper && ((Paper) other).id.equals(id);
		}

		@Override
		public String toString()
		{
			return id;
		}
	}

	private static List<List<Paper>> findPaths(String fromAuthor, String toAuthor, Set<Paper> data)
	{
		List<Paper> fromPapers = new ArrayList<Paper>();
		for (Paper paper : data)
		{
			if (paper.authors.contains(fromAuthor))
			{
				fromPapers.add(paper);
			}
		}

		List<List<Paper>> allPaths = new ArrayList<List<Paper>>();
		for (Paper paper : fromPapers)
		{
			Queue<Paper> q = new LinkedList<Paper>();
			Set<Paper> visited = new HashSet<Paper>();
			q.add(paper);
			visited.add(paper);
			List<Paper> possiblePath = new ArrayList<Paper>();

			while (!q.isEmpty())
			{
				Paper p = q.remove();
				possiblePath.add(p);
				if (p.authors.contains(toAuthor))
				{
					allPaths.add(new ArrayList<Paper>(possiblePath));
				}

				if (p.refs.size() == 0)
				{
					possiblePath.remove(p);
				}
				for (Paper ref : p.refs)
				{
					if (!visited.contains(ref))
					{
						q.add(ref);
						visited.add(ref);
					}
				}
			}
		}
		return allPaths;
	}

	@SuppressWarnings("nls")
	public static void main(String[] args)
	{
		String test = "paper1:jim,jill:paper2,paper3\n" + //
				"paper2:john:\n" + //
				"paper3:michael,jim:paper4\n" + //
				"paper4:jill:paper2,paper5\n" + //
				"paper5:michael,boki:paper1";

		String[] lines = test.split("\n");
		Set<Paper> papers = new HashSet<Paper>();
		Map<String, Paper> idMap = new HashMap<String, Paper>();
		for (String line : lines)
		{
			String[] data = line.split(":");
			Paper paper = idMap.get(data[0]);
			if (paper == null)
			{
				paper = new Paper(data[0]);
				idMap.put(data[0], paper);
				papers.add(paper);
			}

			paper.authors = Arrays.asList(data[1].split(","));
			List<String> refIds = data.length > 2 ? Arrays.asList(data[2].split(",")) : new ArrayList<String>();
			paper.refs = new ArrayList<Paper>();
			for (String id : refIds)
			{
				Paper reference = idMap.get(id);
				if (reference == null)
				{
					reference = new Paper(id);
					idMap.put(id, reference);
					papers.add(reference);
				}
				paper.refs.add(reference);
			}
		}

		System.out.println(findPaths("jim", "michael", papers));
	}
}
