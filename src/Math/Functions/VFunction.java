package Math.Functions;

/**
 * Value Function
 * 
 * @author user
 * 
 * @param <T>
 */
public abstract class VFunction<T>
{
	public T count(T x)
	{
		return null;
	}

	public T count(T x, T y)
	{
		return null;
	}

	public T count(T x, T y, T z)
	{
		return null;
	}

	public T count(T... ds)
	{
		if (ds.length == 1)
			return count(ds[0]);

		if (ds.length == 2)
			return count(ds[0], ds[1]);

		if (ds.length == 3)
			return count(ds[0], ds[1], ds[1]);
		return null;
	}

	public double sqrt(double v)
	{
		return Math.sqrt(v);
	}

	public double sqr(double v)
	{
		return v * v;
	}

	public double exp(double v)
	{
		return Math.exp(v);
	}

	public double abs(double v)
	{
		return Math.abs(v);
	}

	public double pow(double v, double p)
	{
		return Math.pow(v, p);
	}
}
