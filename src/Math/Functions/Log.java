package Math.Functions;

public class Log extends EFunction
{
	public Log(Expression e1, Expression base)
	{
		super(e1, base);
	}

	@Override
	public double count(double... ds)
	{
		return Math.log(ds[0]) / Math.log(ds[1]);
	}

	@Override
	public String toString()
	{
		return "Log(" + this.exps[0] + "," + this.exps[1] + ")";
	}
	
	@Override
	public Expression copy()
	{
		return new Log(this.exps[0],this.exps[1]);
	}

}
