package Utilities;

import Math.Vec.Vec2;

public class AABB2
{
	public double ox;
	public double oy;
	public double tx;
	public double ty;
	public String tag = "";

	public AABB2(double ox, double oy, double tx, double ty)
	{
		this.ox = ox;
		this.oy = oy;
		this.tx = tx;
		this.ty = ty;
		arrange();
	}

	public AABB2(Vec2 o, Vec2 t)
	{
		this.ox = o.x;
		this.oy = o.y;
		this.tx = t.x;
		this.ty = t.y;
		arrange();
	}

	public void arrange()
	{
		if (ox > tx)
		{
			double dx = ox;
			ox = tx;
			tx = dx;
		}
		if (oy > ty)
		{
			double dy = oy;
			oy = ty;
			ty = dy;
		}
	}

	public boolean intersects(AABB2 aabb)
	{
		return (Utils.isInLimit(aabb.ox, this.ox, this.tx) && Utils.isInLimit(aabb.oy, this.oy, this.ty)) || (Utils.isInLimit(aabb.tx, this.ox, this.tx) && Utils.isInLimit(aabb.oy, this.oy, this.ty))
				|| (Utils.isInLimit(aabb.tx, this.ox, this.tx) && Utils.isInLimit(aabb.ty, this.oy, this.ty)) || (Utils.isInLimit(aabb.ty, this.oy, this.ty) && Utils.isInLimit(aabb.ox, this.ox, this.tx));
	}

	public Vec2 getOrigin()
	{
		return new Vec2(this.ox, this.oy);
	}

	public Vec2 getTarget()
	{
		return new Vec2(this.tx, this.ty);
	}

	public AABB2 multiply(double scale)
	{
		double ox = this.ox * scale;
		double oy = this.oy * scale;
		double tx = this.tx * scale;
		double ty = this.ty * scale;

		return new AABB2(ox, oy, tx, ty).setTag(this.tag);
	}

	@Override
	public String toString()
	{
		return "[" + this.ox + ";" + this.oy + ";" + this.tx + ";" + this.ty + ";" + "]";
	}

	public AABB2 extend(int scale)
	{
		AABB2 aabb = new AABB2(this.ox, this.oy, this.tx + scale, this.ty + scale).setTag(this.tag);
		return aabb;
	}

	public AABB2 extendBoth(int scale)
	{
		AABB2 aabb = new AABB2(this.ox - scale, this.oy - scale, this.tx + scale, this.ty + scale).setTag(this.tag);
		return aabb;
	}

	public AABB2 cut(int dx, int dy, int i, int j)
	{
		return new AABB2(this.ox + dx, this.oy + dy, this.tx - i, this.ty - j).setTag(this.tag);
	}

	public AABB2 setTag(String tag)
	{
		this.tag = tag;
		return this;
	}

	public AABB2 move(Vec2 v)
	{
		return new AABB2(this.ox + v.x, this.oy + v.y, this.tx + v.x, this.ty + v.y).setTag(this.tag);
	}

	public AABB2 multiply(float f, float g)
	{
		double ox = this.ox * f;
		double oy = this.oy * f;
		double tx = this.tx * g;
		double ty = this.ty * g;

		return new AABB2(ox, oy, tx, ty).setTag(this.tag);
	}
}
