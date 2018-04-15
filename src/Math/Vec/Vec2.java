package Math.Vec;

import Math.Matrix.Matrix2;
import Utilities.AABB2;

public class Vec2
{
	public double x;
	public double y;
	public String tag = "";

	public Vec2()
	{
		this.x = 0;
		this.y = 0;
	}

	public Vec2(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	public double length()
	{
		return Math.hypot(this.x, this.y);
	}

	public Vec2 add(Vec2 v)
	{
		return new Vec2(this.x + v.x, this.y + v.y).setTag(this.tag);
	}

	public void addChanged(Vec2 v)
	{
		this.x += v.x;
		this.y += v.y;
	}

	public Vec2 sub(Vec2 v)
	{
		return new Vec2(this.x - v.x, this.y - v.y).setTag(this.tag);
	}

	public Vec2 mult(double l)
	{
		return new Vec2(this.x * l, this.y * l).setTag(this.tag);
	}

	public Vec2 mult(double lx, double ly)
	{
		return new Vec2(this.x * lx, this.y * ly).setTag(this.tag);
	}

	public Vec2 div(double l)
	{
		return new Vec2(this.x / l, this.y / l).setTag(this.tag);
	}

	public Vec2 divide(double lx, double ly)
	{
		return new Vec2(this.x / lx, this.y / ly).setTag(this.tag);
	}

	public void normalize()
	{
		double l = this.length();
		if (l == 0)
		{
			this.x = 0;
			this.y = 0;
			return;
		}
		this.x /= l;
		this.y /= l;
	}

	public double dotProduct(Vec2 v)
	{
		return this.x * v.x + this.y * v.y;
	}

	/**
	 * this - vector - row
	 * 
	 * @param v
	 * @return
	 */
	public Vec2 crossProduct(Matrix2 v)
	{
		return new Vec2(this.x * v.arr[0][0] + this.y * v.arr[0][1], this.x * v.arr[1][0] + this.y * v.arr[1][1]);
	}

	public AABB2 extend(double l)
	{
		return new AABB2(this, this.add(new Vec2(l, l)));
	}

	public AABB2 extend(double lx, double ly)
	{
		return new AABB2(this, this.add(new Vec2(lx, ly)));
	}

	public AABB2 extend(Vec2 v)
	{
		return new AABB2(this, this.add(v));
	}

	public AABB2 extendBoth(double l)
	{
		Vec2 el = new Vec2(l, l);
		return new AABB2(this.sub(el), this.add(el));
	}

	public AABB2 extendBoth(double lx, double ly)
	{
		Vec2 el = new Vec2(lx, ly);
		return new AABB2(this.sub(el), this.add(el));
	}

	public AABB2 extendBoth(Vec2 v)
	{
		return new AABB2(this.sub(v), this.add(v));
	}

	@Override
	public String toString()
	{
		return "[" + this.x + "; " + this.y + "]";
	}

	public Vec2 copy()
	{
		return new Vec2(this.x, this.y).setTag(this.tag);
	}

	public double sqr()
	{
		return this.dotProduct(this);
	}

	public double distanceTo(Vec2 v)
	{
		Vec2 dv = this.sub(v);
		return dv.length();
	}

	public void copyFrom(Vec2 wh)
	{
		this.x = wh.x;
		this.y = wh.y;
	}

	public Vec2 setTag(String tag)
	{
		this.tag = tag;
		return this;
	}
}
