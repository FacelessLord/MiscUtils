package Utilities;

import Math.Vec.Vec3;

public class AABB3
{
	public double ox;
	public double oy;
	public double oz;
	public double tx;
	public double ty;
	public double tz;

	public AABB3(double ox, double oy, double oz, double tx, double ty, double tz)
	{
		this.ox = ox;
		this.oy = oy;
		this.oz = oz;
		this.tx = tx;
		this.ty = ty;
		this.tz = tz;
		arrange();
	}

	public AABB3(Vec3 o, Vec3 t)
	{
		this.ox = o.x;
		this.oy = o.y;
		this.oz = o.z;
		this.tx = t.x;
		this.ty = t.y;
		this.tz = t.z;
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

		if (oz > tz)
		{
			double dz = oz;
			oz = tz;
			tz = dz;
		}
	}

	public boolean intersects(AABB3 aabb)
	{
		return (Utils.isInLimit(aabb.ox, this.ox, this.tx) && Utils.isInLimit(aabb.oy, this.oy, this.ty) && Utils.isInLimit(aabb.oz, this.oz, this.tz))
				|| (Utils.isInLimit(aabb.tx, this.ox, this.tx) && Utils.isInLimit(aabb.oy, this.oy, this.ty) && Utils.isInLimit(aabb.oz, this.oz, this.tz))
				|| (Utils.isInLimit(aabb.tx, this.ox, this.tx) && Utils.isInLimit(aabb.ty, this.oy, this.ty) && Utils.isInLimit(aabb.oz, this.oz, this.tz))
				|| Utils.isInLimit(aabb.ox, this.ox, this.tx) && (Utils.isInLimit(aabb.ty, this.oy, this.ty) && Utils.isInLimit(aabb.oz, this.oz, this.tz))
				|| (Utils.isInLimit(aabb.ox, this.ox, this.tx) && Utils.isInLimit(aabb.oy, this.oy, this.ty) && Utils.isInLimit(aabb.tz, this.oz, this.tz))
				|| (Utils.isInLimit(aabb.tx, this.ox, this.tx) && Utils.isInLimit(aabb.oy, this.oy, this.ty) && Utils.isInLimit(aabb.tz, this.oz, this.tz))
				|| (Utils.isInLimit(aabb.tx, this.ox, this.tx) && Utils.isInLimit(aabb.ty, this.oy, this.ty) && Utils.isInLimit(aabb.tz, this.oz, this.tz))
				|| Utils.isInLimit(aabb.ox, this.ox, this.tx) && (Utils.isInLimit(aabb.ty, this.oy, this.ty) && Utils.isInLimit(aabb.tz, this.oz, this.tz));
	}

	public Vec3 getOrigin()
	{
		return new Vec3(this.ox, this.oy, this.oz);
	}

	public Vec3 getTarget()
	{
		return new Vec3(this.tx, this.ty, this.tz);
	}

	@Override
	public String toString()
	{
		return "[" + this.ox + ";" + this.oy + ";" + this.oz + ";" + this.tx + ";" + this.ty + ";" + this.tz + ";" + "]";
	}
}
