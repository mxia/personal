package leetcode;

public class WordSearch
{

	private static boolean exists(char[][] board, String word)
	{
		int row = board.length;
		int col = board[0].length;
		for (int i = 0; i < row; ++i)
		{
			for (int j = 0; j < col; ++j)
			{
				if (exists(board, i, j, word, 0))
				{
					return true;
				}
			}
		}
		return false;
	}

	private static boolean exists(char[][] board, int i, int j, String word, int index)
	{
		if (index == word.length())
		{
			return true;
		}
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
		{
			return false;
		}
		char ch = word.charAt(index);
		if (ch != board[i][j])
		{
			return false;
		}

		board[i][j] = '\0';
		if (exists(board, i - 1, j, word, index + 1) || exists(board, i + 1, j, word, index + 1)
				|| exists(board, i, j - 1, word, index + 1) || exists(board, i, j + 1, word, index + 1))
		{
			return true;
		}
		board[i][j] = ch;
		return false;
	}

	@SuppressWarnings("nls")
	public static void main(String[] args)
	{
		char[][] board = new char[][] { "ABCE".toCharArray(), //
				"SFCS".toCharArray(), //
				"ADEE".toCharArray() };
		System.out.println(exists(board, "SEEA"));
	}
}
