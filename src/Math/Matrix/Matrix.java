package Math.Matrix;

import Utilities.Logger;
import Utilities.Utils;

public class Matrix
{
	public int n;
	public int m;
	// TODO
	/**
	 * left corner is (0,0)
	 */
	public double[][] arr;

	public Matrix(int m, int n)
	{
		this.n = n;
		this.m = m;
		this.arr = new double[m][n];
	}

	public Matrix(int m, int n, double[][] arr)
	{
		this.n = n;
		this.m = m;
		if (arr.length == m && arr[0].length == n)
		{
			this.arr = new double[m][n];
		}
		else
		{
			Logger.err("Couldn't create Matrix. Array doesn't fit");
		}
	}

	public static Matrix Zero(int nm)
	{
		return new Matrix(nm, nm);
	}

	public static Matrix E(int nm)
	{
		if (nm == 2)
		{
			return Matrix2.E;
		}
		if (nm == 3)
		{
			return Matrix3.E;
		}
		Matrix m = new Matrix(nm, nm);
		for (int i = 0; i < nm; i++)
		{
			m.arr[i][i] = 1;
		}
		return m;
	}

	public String toString()
	{
		String ret = "";

		for (int i = 0; i < m; i++)
		{
			String s = "[";

			for (int j = 0; j < n; j++)
			{
				s += Utils.roundStr(this.arr[i][j], 2);
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
}
