package Math.Matrix;

import Math.Vec.Vec3;

public class Matrix3 extends Matrix
{
	public static final Matrix3 E = new Matrix3(1, 0, 0, 0, 1, 0, 0, 0, 1);

	public Matrix3(double a, double b, double c, double d, double e, double f, double g, double h, double i)
	{
		super(3, 3);
		this.arr[0][0] = a;
		this.arr[1][0] = d;
		this.arr[2][0] = g;

		this.arr[0][1] = b;
		this.arr[1][1] = e;
		this.arr[2][1] = h;

		this.arr[0][2] = c;
		this.arr[1][2] = f;
		this.arr[2][2] = i;

	}

	public Matrix3()
	{
		super(3, 3);
	}

	public Matrix3(double[][] matr)
	{
		super(3, 3);

		this.arr = matr;
	}

	/**
	 * vectors - columns
	 */
	public Matrix3(Vec3 abc, Vec3 def, Vec3 ghi)
	{
		super(3, 3);

		this.arr[0][0] = abc.x;
		this.arr[1][0] = abc.y;
		this.arr[2][0] = abc.z;

		this.arr[0][1] = def.x;
		this.arr[1][1] = def.y;
		this.arr[2][1] = def.z;

		this.arr[0][2] = ghi.x;
		this.arr[1][2] = ghi.y;
		this.arr[2][2] = ghi.z;
	}

	public Matrix3 crossProduct(Matrix3 m)
	{
		Matrix3 ret = new Matrix3();

		ret.arr[0][0] = this.arr[0][0] * m.arr[0][0] + this.arr[0][1] * m.arr[0][1] + this.arr[2][0] * m.arr[0][2];//
		ret.arr[1][0] = this.arr[1][0] * m.arr[0][0] + this.arr[1][1] * m.arr[0][1] + this.arr[2][0] * m.arr[1][2];
		ret.arr[2][0] = this.arr[2][0] * m.arr[0][0] + this.arr[2][1] * m.arr[0][1] + this.arr[2][0] * m.arr[2][2];
		ret.arr[0][1] = this.arr[0][0] * m.arr[1][0] + this.arr[0][1] * m.arr[1][1] + this.arr[2][1] * m.arr[0][2];//
		ret.arr[1][1] = this.arr[1][0] * m.arr[1][0] + this.arr[1][1] * m.arr[1][1] + this.arr[2][1] * m.arr[1][2];
		ret.arr[2][1] = this.arr[2][0] * m.arr[1][0] + this.arr[2][1] * m.arr[1][1] + this.arr[2][1] * m.arr[2][2];
		ret.arr[0][2] = this.arr[0][0] * m.arr[2][0] + this.arr[0][1] * m.arr[2][1] + this.arr[2][2] * m.arr[0][2];//
		ret.arr[1][2] = this.arr[1][0] * m.arr[2][0] + this.arr[1][1] * m.arr[2][1] + this.arr[2][2] * m.arr[1][2];
		ret.arr[2][2] = this.arr[2][0] * m.arr[2][0] + this.arr[2][1] * m.arr[2][1] + this.arr[2][2] * m.arr[2][2];

		return ret;
	}

	public Matrix3 transp()
	{
		return new Matrix3(this.arr[0][0], this.arr[1][0], this.arr[2][0], this.arr[0][1], this.arr[1][1], this.arr[2][1], this.arr[2][0], this.arr[2][1], this.arr[2][2]);
	}

	public double det()
	{
		return this.arr[0][0] * (this.arr[1][1] * this.arr[2][2] - this.arr[1][2] * this.arr[2][1]) - this.arr[1][0] * (this.arr[0][1] * this.arr[2][2] - this.arr[0][2] * this.arr[2][1]) + this.arr[2][0] * (this.arr[0][1] * this.arr[1][2]
				- this.arr[0][2] * this.arr[1][1]);
	}

	public Vec3 crossProduct(Vec3 m)
	{
		return new Vec3(this.arr[0][0] * m.x + this.arr[1][0] * m.y + this.arr[2][0] * m.z, this.arr[0][1] * m.x + this.arr[1][1] * m.y + this.arr[2][1] * m.z, this.arr[0][2] * m.x + this.arr[1][2] * m.y + this.arr[2][2] * m.z);
	}

	public Matrix3 dotProduct(Matrix3 m)
	{
		Matrix3 ret = new Matrix3();

		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				ret.arr[i][j] = this.arr[i][j] * m.arr[i][j];
			}
		}

		return ret;
	}

	public Matrix3 add(Matrix3 m)
	{
		Matrix3 ret = new Matrix3();

		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				ret.arr[i][j] = this.arr[i][j] + m.arr[i][j];
			}
		}

		return ret;
	}

	public Matrix3 multiply(double m)
	{
		Matrix3 ret = new Matrix3();

		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				ret.arr[i][j] = this.arr[i][j] * m;
			}
		}
		return ret;
	}

	public String toString()
	{
		return "[ " + this.arr[0][0] + "  " + this.arr[0][1] + "  " + this.arr[0][2] + " ]" + "\n" + "[ " + this.arr[1][0] + "  " + this.arr[1][1] + "  " + this.arr[1][2] + " ]" + "\n" + "[ " + this.arr[2][0] + "  " + this.arr[2][1] + "  "
				+ this.arr[2][2] + " ]";
	}
}
