package Math.Spaces;

public abstract class SpaceMath<T, U>
{
	public abstract U exp(T t);

	public abstract U ln(T t);

	public abstract U cos(T t);

	public abstract U sin(T t);

	public abstract U sqrt(T t);

	public abstract U pow(T t1, T t2);
}
