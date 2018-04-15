package Math.Functions;

public abstract class EFunction extends Expression
{
	public Expression[] exps;

	public EFunction(Expression... exps)
	{
		this.exps = exps;
		for (int i = 0; i < exps.length; i++)
		{
			if (!exps[i].vars.isEmpty())
			{
				exps[i].vars.stream().filter(k -> !this.vars.contains(k)).forEach(k -> this.vars.add(k));
			}
		}
	}

	public static EFunction fromExpression(Expression e)
	{
		return new EFunction(e)
		{
			@Override
			public double count(double... ds)
			{
				return this.exps[0].count();
			}

			@Override
			public String toString()
			{
				return this.exps[0].toString();
			}

			@Override
			public Expression copy()
			{
				return EFunction.fromExpression(this.exps[0]);
			}

		};
	}

	public abstract double count(double... ds);

	public String toFormalString()
	{
		return "f(" + getVarString() + ") = " + this.toString();
	}

	public String toFormalString(String f)
	{
		return f + "(" + getVarString() + ") = " + this.toString();
	}

	public String getVarString()
	{
		String variables = "";
		for (int i = 0; i < vars.size(); i++)
		{
			variables += vars.get(i);
			if (i != vars.size() - 1)
			{
				variables += ", ";
			}
		}
		return variables;
	}

	@Override
	public double count()
	{
		// Logger.info(this.getClass().getName());
		double[] dbs = new double[this.exps.length];
		for (int i = 0; i < exps.length; i++)
		{
			dbs[i] = exps[i].count();
		}
		return this.count(dbs);
	}

	public static double sqrt(double v)
	{
		return Math.sqrt(v);
	}

	public static double sqr(double v)
	{
		return v * v;
	}

	public static double exp(double v)
	{
		return Math.exp(v);
	}

	public static double abs(double v)
	{
		return Math.abs(v);
	}

	public static double pow(double v, double p)
	{
		return Math.pow(v, p);
	}
}
