package Math.Spaces;

public class ComplexSpace extends Space<Complex, Complex>
{

	public ComplexSpace(SpaceMath smath)
	{
		super(smath);
	}

	@Override
	public Complex getIdentity()
	{
		return Complex.one;
	}

	@Override
	public Complex getZero()
	{
		return Complex.zero;
	}

	@Override
	public Complex add(Complex t1, Complex t2)
	{
		return t1.add(t2);
	}

	@Override
	public Complex sub(Complex t1, Complex t2)
	{
		return t1.sub(t2);
	}

	@Override
	public Complex usub(Complex t)
	{
		return t.inv();
	}

	@Override
	public Complex mult(Complex t1, Complex t2)
	{
		return t1.mult(t2);
	}

	@Override
	public Complex div(Complex t1, Complex t2)
	{
		return t1.div(t2);
	}

}
