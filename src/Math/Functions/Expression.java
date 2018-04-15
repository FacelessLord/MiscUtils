package Math.Functions;

import java.util.ArrayList;
import java.util.List;

public abstract class Expression<T>
{
	public List<String> vars;

	public Expression()
	{
		this.vars = new ArrayList<String>();
	}

	public static final Expression EZ = new Expression()
	{
		@Override
		public double count()
		{
			return 0;
		}

		@Override
		public Expression copy()
		{
			return ENumb.I(0);
		}
	};

	public abstract double count();

	public double count(Object... vars)
	{
		for (int i = 0; i < Math.floorDiv(vars.length, 2); i++)
		{
			if (vars[2 * i] instanceof String)
			{
				if (vars[2 * i + 1] instanceof Double)
				{
					EMath.varior.put((String) vars[2 * i], (Double) vars[2 * i + 1]);
				}
				else
				{
					if (vars[2 * i + 1] instanceof Number)
					{
						EMath.varior.put((String) vars[2 * i], ((Number) vars[2 * i + 1]).doubleValue());
					}
				}
			}
		}
		return this.count();
	}

	public static Expression express(Object o)
	{
		try
		{
			if (o instanceof java.lang.Number)
			{
				return new ENumb(((java.lang.Number) o).doubleValue());
			}

			if (o instanceof java.lang.String)
			{
				return parse(((String) o));
				// return new ENumb(Double.parseDouble((String) o));// number as
				// string
			}
		}
		catch (Exception e)
		{
		}

		return EZ;
	}

	public static Expression parse(String e)
	{
		if (checkBrackets(e))
		{

		}
		return Expression.EZ;
	}

	public static boolean checkBrackets(String e)
	{
		boolean able = true;

		int orbrac = 0;
		int crbrac = 0;

		int osbrac = 0;
		int csbrac = 0;

		// int ofbrac = 0;
		// int cfbrac = 0;

		for (int i = 0; i < e.length(); i++)
		{
			if (e.charAt(i) == '(')
				orbrac++;
			if (e.charAt(i) == ')')
				crbrac++;

			if (e.charAt(i) == '[')
				osbrac++;
			if (e.charAt(i) == ']')
				csbrac++;
			//
			// if (e.charAt(i) == '{')
			// orbrac++;
			// if (e.charAt(i) == '}')
			// crbrac++;
		}

		able = able && (orbrac == crbrac) && (osbrac == csbrac);

		return able;
	}

	public Expression derive(String var)
	{
		return ENumb.Zero;
	}

	public abstract Expression copy();
}
