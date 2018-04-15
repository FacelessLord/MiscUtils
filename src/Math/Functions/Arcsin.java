package Math.Functions;

public class Arcsin extends EFunction
{

	public Arcsin(Expression e)
	{
		super(e);
	}

	@Override
	public double count(double... ds)
	{
		return Math.asin(ds[0]);
	}

	@Override
	public String toString()
	{
		return "arcSin" + EMath.asArg(this.exps[0]);
	}

	@Override
	public Expression copy()
	{
		return new Arcsin(this.exps[0]);
	}

}
