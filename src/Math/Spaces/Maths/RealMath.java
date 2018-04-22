package Math.Spaces.Maths;

import Math.Spaces.SpaceMath;

public class RealMath extends SpaceMath<Double, Double>
{

	@Override
	public Double exp(Double t)
	{
		return Math.exp(t);
	}

	@Override
	public Double ln(Double t)
	{
		return Math.log(t);
	}

	@Override
	public Double cos(Double t)
	{
		return Math.cos(t);
	}

	@Override
	public Double sin(Double t)
	{
		return Math.sin(t);
	}

	@Override
	public Double sqrt(Double t)
	{
		return Math.sqrt(t);
	}

	@Override
	public Double pow(Double t1, Double t2)
	{
		return Math.pow(t1, t2);
	}

}
