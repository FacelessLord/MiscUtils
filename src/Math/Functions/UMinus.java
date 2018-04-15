package Math.Functions;

public class UMinus extends Expression
{
	public Expression e;

	public UMinus(Expression e)
	{
		this.e = e;
		this.vars = e.vars;
	}

	@Override
	public double count()
	{
		return -e.count();
	}

	@Override
	public String toString()
	{
		return "-" + EMath.asArg(this.e) + "";
	}

	@Override
	public Expression copy()
	{
		return new UMinus(e);
	}

	@Override
	public Expression derive(String var)
	{
		return EMath.not(EMath.derive(this.e, var));
	}

}
