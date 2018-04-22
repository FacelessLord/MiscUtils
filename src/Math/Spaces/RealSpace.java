package Math.Spaces;

public class RealSpace extends Space<Double, Double>
{

	public RealSpace(SpaceMath smath)
	{
		super(smath);
	}

	@Override
	public Double getIdentity()
	{
		return 1d;
	}

	@Override
	public Double getZero()
	{
		return 0d;
	}

	@Override
	public Double add(Double t1, Double t2)
	{
		return t1 + t2;
	}

	@Override
	public Double sub(Double t1, Double t2)
	{
		return t1 - t2;
	}

	@Override
	public Double usub(Double t)
	{
		return -t;
	}

	@Override
	public Double mult(Double t1, Double t2)
	{
		return t1 * t2;
	}

	@Override
	public Double div(Double t1, Double t2)
	{
		return t1 / t2;
	}

}
