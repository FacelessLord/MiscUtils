package Math.Spaces;

public abstract class Space<T,U>
{
	public Space(SpaceMath smath)
	{
		this.math = smath;
	}

	public SpaceMath math;

	/**
	 * @return Identity object I, such that A*I=A and I*A=A
	 */
	public abstract T getIdentity();

	/**
	 * @return Zero object O, such that A*O=O and O*A=O
	 */
	public abstract T getZero();

	/**
	 * @return Sum of two objects
	 */
	public abstract U add(T t1, T t2);

	/**
	 * @return Subtruct of two objects
	 */
	public abstract U sub(T t1, T t2);

	/**
	 * @return Object -A, such that -(-A)=A
	 */
	public abstract U usub(T t);

	public abstract U mult(T t1, T t2);

	public abstract U div(T t1, T t2);

}
