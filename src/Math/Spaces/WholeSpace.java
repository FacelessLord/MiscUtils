package Math.Spaces;

public class WholeSpace extends Space<Integer, Integer>
{

	public WholeSpace(SpaceMath smath)
	{
		super(smath);
	}

	@Override
	public Integer getIdentity()
	{
		return 1;
	}

	@Override
	public Integer getZero()
	{
		return 0;
	}

	@Override
	public Integer add(Integer t1, Integer t2)
	{
		return t1 + t2;
	}

	@Override
	public Integer sub(Integer t1, Integer t2)
	{
		return t1 - t2;
	}

	@Override
	public Integer usub(Integer t)
	{
		return -t;
	}

	@Override
	public Integer mult(Integer t1, Integer t2)
	{
		return t1 * t2;
	}

	@Override
	public Integer div(Integer t1, Integer t2)
	{
		return t1 / t2;
	}

}
