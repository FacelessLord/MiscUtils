package Math.Functions;

public class Arccos extends EFunction
{

	public Arccos(Expression e)
	{
		super(e);
	}

	@Override
	public double count(double... ds)
	{
		return Math.acos(ds[0]);
	}

	@Override
	public String toString()
	{
		return "arcCos" + EMath.asArg(this.exps[0]);
	}

	@Override
	public Expression copy()
	{
		return new Arccos(this.exps[0]);
	}

}
