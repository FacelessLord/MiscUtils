package Math.Matrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Math.Spaces.MatrixSpace;
import Utilities.Logger;

public class VMatrix<T>
{
	public MatrixSpace space;

	public int n;
	public int m;
	/**
	 * upper left corner is (0,0)
	 */
	public List<List<T>> arr;

	public VMatrix(int m, int n, MatrixSpace ms)
	{
		this.n = n;
		this.m = m;
		this.arr = Collections.nCopies(m, new ArrayList<T>(n));
	}

	public VMatrix(int m, int n, List<List<T>> arr, MatrixSpace ms)
	{
		this.n = n;
		this.m = m;
		if (arr.size() == m && arr.get(0).size() == n)
		{
			this.arr = arr;
		}
		else
		{
			Logger.err("Couldn't create Matrix. Array doesn't fit");
		}
	}

	public T get(int i, int j)
	{
		return arr.get(i).get(j);
	}

	public T set(int i, int j, T val)
	{
		return arr.get(i).set(j, val);
	}

	public String toString()
	{
		String ret = "";

		for (int i = 0; i < m; i++)
		{
			String s = "[";

			for (int j = 0; j < n; j++)
			{
				s += this.arr.get(i).get(j).toString();
				if (j != n - 1)
				{
					s += "  ";
				}
			}
			s += "]\n";
			ret += s;
		}
		return ret;
	}

	public VMatrix transp()
	{
		// TODO
		return new VMatrix<T>(n, m, space);
	}

	public VMatrix add(VMatrix a, VMatrix b)
	{
		VMatrix sum = new VMatrix<T>(m, n, space);
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				sum.set(i, j, space.tspace.add(a.get(i, j), b.get(i, j)));
			}
		}
		return sum;
	}

	public VMatrix sub(VMatrix a, VMatrix b)
	{
		VMatrix sum = new VMatrix<T>(m, n, space);
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				sum.set(i, j, space.tspace.sub(a.get(i, j), b.get(i, j)));
			}
		}
		return sum;
	}
	
	//mult
}
