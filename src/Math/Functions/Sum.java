package Math.Functions;

public class Sum extends Expression
{
	public Expression[] exps;

	public Sum(Expression... exps)
	{
		this.exps = exps;
	}

	public Sum(double... exps)
	{
		this.exps = new Expression[exps.length];
		for (int i = 0; i < exps.length; i++)
		{
			this.exps[i] = new ENumb(exps[i]);
		}
	}

	public Sum(Object... exps)
	{
		this.exps = new Expression[exps.length];
		for (int i = 0; i < exps.length; i++)
		{
			ENumb n = ENumb.asNumber(exps[i]);
			if (n != ENumb.NaN)
				this.exps[i] = n;
			else
				this.exps[i] = ENumb.Zero;
		}
	}

	@Override
	public double count()
	{
		double sum = 0;
		for (int i = 0; i < exps.length; i++)
		{
			sum += exps[i].count();
		}
		return sum;
	}

	@Override
	public String toString()
	{
		if (this.exps[1] instanceof UMinus)
		{
			return this.exps[0] + "-" + ((UMinus) this.exps[1]).e;
		}
		return this.exps[0] + "+" + this.exps[1];
	}

	@Override
	public Expression copy()
	{
		return new Sum(this.exps);
	}
}
