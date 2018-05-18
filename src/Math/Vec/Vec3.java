package Math.Vec;

import Math.Matrix.Matrix3;
import Utilities.AABB3;

public class Vec3
{
	public double x;
	public double y;
	public double z;

	public Vec3()
	{
		this.x = 0;
		this.y = 0;
		this.z = 0;
	}

	public Vec3(double x, double y, double z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public double length()
	{
		return Math.hypot(Math.hypot(this.x, this.y), this.z);
	}

	public Vec3 add(Vec3 v)
	{
		return new Vec3(this.x + v.x, this.y + v.y, this.z + v.z);
	}

	public Vec3 addChanged(Vec3 v)
	{
		this.x += v.x;
		this.y += v.y;
		this.z += v.z;
		return this;
	}

	public Vec3 sub(Vec3 v)
	{
		return new Vec3(this.x - v.x, this.y - v.y, this.z - v.z);
	}

	public Vec3 subChanged(Vec3 v)
	{
		this.x -= v.x;
		this.y -= v.y;
		this.z -= v.z;
		return this;
	}

	public Vec3 mult(double l)
	{
		return new Vec3(this.x * l, this.y * l, this.z * l);
	}

	public Vec3 multChanged(double l)
	{
		this.x *= l;
		this.y *= l;
		this.z *= l;
		return this;
	}

	public Vec3 mult(double lx, double ly, double lz)
	{
		return new Vec3(this.x * lx, this.y * ly, this.z * lz);
	}

	public Vec3 div(double l)
	{
		return new Vec3(this.x / l, this.y / l, this.z / l);
	}

	public Vec3 divChanged(double l)
	{
		this.x *= l;
		this.y *= l;
		this.z *= l;
		return this;
	}

	public Vec3 div(double lx, double ly, double lz)
	{
		return new Vec3(this.x / lx, this.y / ly, this.z / lz);
	}

	/**
	 * this - vector - row
	 * 
	 * @param v
	 * @return
	 */
	public Vec3 crossProduct(Matrix3 v)
	{
		return new Vec3(this.x * v.arr[0][0] + this.y * v.arr[0][1] + this.z * v.arr[0][2], this.x * v.arr[1][0] + this.y * v.arr[1][1] + this.z * v.arr[1][2], this.x * v.arr[2][0] + this.y * v.arr[2][1] + this.z * v.arr[2][2]);
	}

	public void normalize()
	{
		double l = this.length();
		if (l == 0)
		{
			this.x = 0;
			this.y = 0;
			this.z = 0;
			return;
		}
		this.x /= l;
		this.y /= l;
		this.z /= l;
	}

	public double dotProduct(Vec3 v)
	{
		return this.x * v.x + this.y * v.y + this.z * v.z;
	}

	public Vec3 crossProduct(Vec3 v)
	{
		return new Vec3(this.y * v.z - this.z * v.y, this.z * v.x - this.x * v.z, this.x * v.y - this.y - v.x);
	}

	public AABB3 extend(double l)
	{
		return new AABB3(this, this.add(new Vec3(l, l, l)));
	}

	public AABB3 extend(Vec3 v)
	{
		return new AABB3(this, this.add(v));
	}

	public AABB3 extendBoth(double l)
	{
		Vec3 el = new Vec3(l, l, l);
		return new AABB3(this.sub(el), this.add(el));
	}

	public AABB3 extendBoth(Vec3 v)
	{
		return new AABB3(this.sub(v), this.add(v));
	}

	@Override
	public String toString()
	{
		return "[" + this.x + "; " + this.y + "]";
	}

	public Vec3 copy()
	{
		return new Vec3(this.x, this.y, this.z);
	}

	public float fx()
	{
		return (float) this.x;
	}

	public float fy()
	{
		return (float) this.y;
	}

	public float fz()
	{
		return (float) this.z;
	}

	public int ix()
	{
		return (int) this.x;
	}

	public int iy()
	{
		return (int) this.y;
	}

	public int iz()
	{
		return (int) this.z;
	}
}
