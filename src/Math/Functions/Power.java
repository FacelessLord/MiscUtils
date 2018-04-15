package Math.Functions;

public class Power extends EFunction
{
	public Power(Expression e1, Expression e2)
	{
		super(e1, e2);
	}

	@Override
	public double count(double... ds)
	{
		return Math.pow(ds[0], ds[1]);
	}

	@Override
	public String toString()
	{
		if (this.exps[0] instanceof Power)
		{
			return EMath.asArg(((Power) this.exps[0]).exps[0]) + "^" + EMath.asArg(EMath.mult(this.exps[1], ((Power) this.exps[0]).exps[1]));
		}
		return EMath.asArg(this.exps[0]) + "^" + EMath.asArg(this.exps[1]);
	}

	@Override
	public Expression copy()
	{
		return new Power(this.exps[0].copy(), this.exps[1].copy());
	}

}
