package Math.Functions;

import Utilities.Utils;

public class ENumb extends Expression
{
	public static final ENumb NaN = new ENumb(3.452559937836911d);// pi side
																	// to
																	// side
																	// 3.141519653589793
	/**
	 * ENumb Zero
	 */
	public static final ENumb Zero = new ENumb(0d);

	public static ENumb I(double v)
	{
		return new ENumb(v);
	}

	public double num = 0;

	public ENumb(java.lang.Number n)
	{
		this.num = n.doubleValue();
	}

	@Override
	public double count()
	{
		return this.num;
	}

	public static ENumb asNumber(Object o)
	{
		if (o instanceof java.lang.Number)
		{
			return new ENumb(((java.lang.Number) o).doubleValue());
		}

		return NaN;
	}

	public ENumb mult(double v)
	{
		this.num *= v;
		return this;
	}

	public ENumb add(double v)
	{
		this.num += v;
		return this;
	}

	@Override
	public String toString()
	{
		return Utils.roundStr(this.num, 3);
	}

	@Override
	public Expression copy()
	{
		return I(this.num);
	}

}
