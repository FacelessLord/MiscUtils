package Math.Spaces;

import java.util.List;

import Math.Matrix.VMatrix;

public class MatrixSpace<T> extends Space<VMatrix, VMatrix>
{
	public int m;
	public int n;
	public Space tspace;

	public MatrixSpace(int m, int n, Space tSpace, SpaceMath smath)
	{
		super(smath);
		this.n = n;
		this.m = m;
		this.tspace = tSpace;
	}

	public VMatrix newMatrix(int m, int n)
	{
		return new VMatrix<T>(n, m, this);
	}

	public VMatrix newMatrix(int m, int n, List<List<T>> arr)
	{
		return new VMatrix<T>(n, m, this);
	}

	@Override
	public VMatrix getIdentity()
	{
		VMatrix I = new VMatrix<T>(m, n, this);
		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < n; j++)
			{
				I.set(i, j, tspace.getZero());
			}
		}
		return I;
	}

	@Override
	public VMatrix getZero()
	{
		VMatrix z = new VMatrix<T>(m, n, this);
		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < n; j++)
			{
				z.set(i, j, tspace.getZero());
			}
		}
		return z;
	}

	@Override
	public VMatrix add(VMatrix t1, VMatrix t2)
	{

		return null;
	}

	@Override
	public VMatrix sub(VMatrix t1, VMatrix t2)
	{

		return null;
	}

	@Override
	public VMatrix usub(VMatrix t)
	{

		return null;
	}

	@Override
	public VMatrix mult(VMatrix t1, VMatrix t2)
	{

		return null;
	}

	@Override
	public VMatrix div(VMatrix t1, VMatrix t2)
	{

		return null;
	}

}
