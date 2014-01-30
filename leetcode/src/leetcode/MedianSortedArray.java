package leetcode;

public class MedianSortedArray
{

	public static double findMedian(int[] A, int[] B)
	{
		int sizeA = A.length, sizeB = B.length;
		if (sizeA <= sizeB)
		{
			return findMedian(A, B, 0, sizeA - 1);
		}
		return findMedian(B, A, 0, sizeB - 1);
	}

	private static double findMedian(int[] A, int[] B, int left, int right)
	{
		int m = A.length, n = B.length;
		int mid = (m + n) / 2;
		if (left > right)
		{
			return findMedian(B, A, Math.max(0, mid - m), Math.min(n - 1, mid));
		}

		int i = (left + right) / 2;
		int j = mid - i - 1;
		if (j >= 0 && A[i] < B[j]) // A[i] < median
		{
			return findMedian(A, B, i + 1, right);
		}
		if (j < n - 1 && A[i] > B[j + 1]) // A[i] > median
		{
			return findMedian(A, B, left, i - 1);
		}
		// found median
		if (((m + n) & 0x1) > 0 || (i <= 0 && (j < 0 || j >= n)))
		{
			// m+n is odd
			return A[i];
		}
		// m+n is even
		if (j < 0 || j >= n)
		{
			return (A[i] + A[i - 1]) / 2.0;
		}
		if (i <= 0)
		{
			return (A[i] + B[j]) / 2.0;
		}
		return (A[i] + Math.max(B[j], A[i - 1])) / 2.0;
	}

	public static void main(String[] args)
	{
		int[] arrayA = new int[] { 2, 3, 5, 7, 10, 15 };
		int[] arrayB = new int[] { 4, 6, 7, 9, 12, 17, 20, 25 };
		System.out.println(findMedian(arrayA, arrayB));
	}
}
