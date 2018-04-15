package Math.Functions;

public class Ln extends EFunction
{

	public Ln(Expression e)
	{
		super(e);
	}

	@Override
	public double count(double... ds)
	{
		return Math.log(ds[0]);
	}

	@Override
	public String toString()
	{
		return "Ln" + EMath.asArg(this.exps[0]);
	}
	
	@Override
	public Expression copy()
	{
		return new Ln(this.exps[0]);
	}

}
