package Math.Functions;

public class Mult extends Expression
{
	public Expression[] exps;

	public Mult(Expression... exps)
	{
		this.exps = exps;
	}

	public Mult(double... exps)
	{
		this.exps = new Expression[exps.length];
		for (int i = 0; i < exps.length; i++)
		{
			this.exps[i] = new ENumb(exps[i]);
		}
	}

	public Mult(Object... exps)
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
		double prod = 1;
		for (int i = 0; i < exps.length; i++)
		{
			prod *= exps[i].count();
		}
		return prod;
	}

	@Override
	public String toString()
	{
		if (this.exps[0] instanceof ENumb && this.exps[1] instanceof ENumb && this.exps.length == 2)
		{
			return "" + (this.exps[0].count() * this.exps[1].count());
		}
		if (this.exps[0] instanceof ENumb && !(this.exps[1] instanceof ENumb))
			return EMath.asArg(this.exps[0]) + EMath.asArg(this.exps[1]);
		return EMath.asArg(this.exps[0]) + "*" + EMath.asArg(this.exps[1]);
	}

	@Override
	public Expression copy()
	{
		return new Mult(this.exps);
	}
}
