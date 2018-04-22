package Math.Spaces.Maths;

import Math.Spaces.SpaceMath;

public class WholeMath extends SpaceMath<Integer, Integer>
{

	@Override
	public Integer exp(Integer t)
	{
		return (int) Math.exp(t);
	}

	@Override
	public Integer ln(Integer t)
	{
		return (int) Math.log(t);
	}

	@Override
	public Integer cos(Integer t)
	{
		return (int) Math.cos(t);
	}

	@Override
	public Integer sin(Integer t)
	{
		return (int) Math.sin(t);
	}

	@Override
	public Integer sqrt(Integer t)
	{
		return (int) Math.sqrt(t);
	}

	@Override
	public Integer pow(Integer t1, Integer t2)
	{
		return (int) Math.pow(t1, t2);
	}

}
