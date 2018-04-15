package Math.Functions;

public class Var extends Expression
{
	public String name = "x";

	public Var()
	{
		this.vars.add("x");
	}

	public Var(String name)
	{
		this.name = name;
		this.vars.add(name);
	}

	@Override
	public double count()
	{
		return EMath.varior.get(this.name);
	}

	@Override
	public String toString()
	{
		return this.name;
	}

	@Override
	public Expression copy()
	{
		return new Var(this.name);
	}
}
