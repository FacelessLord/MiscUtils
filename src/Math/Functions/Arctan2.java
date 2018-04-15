package Math.Functions;

public class Arctan2 extends EFunction
{

	public Arctan2(Expression e1, Expression e2)
	{
		super(e1, e2);
	}

	@Override
	public double count(double... ds)
	{
		return Math.atan2(ds[0], ds[1]);
	}

	@Override
	public String toString()
	{
		return "Arctan2(" + this.exps[0] + ", " + this.exps[1] + ")";
	}

	@Override
	public Expression copy()
	{
		return new Arctan2(this.exps[0], this.exps[1]);
	}

}
