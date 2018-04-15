package Math.Functions;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public final class EMath
{
	public static Hashtable<String, Double> varior = new Hashtable<String, Double>();

	public static final ENumb E = new ENumb(Math.E);
	public static final ENumb Pi = new ENumb(Math.PI);

	public static Var var()
	{
		Var v = new Var();
		varior.put("x", 0d);
		return v;
	}

	public static Var var(String name)
	{
		Var v = new Var(name);
		varior.put(name, 1d);
		return v;
	}

	public static Expression sum(Expression... exps)
	{
		if (exps.length == 2 && exps[0] instanceof ENumb && exps[1] instanceof ENumb)
		{
			return ENumb.I(((ENumb) exps[0]).num + ((ENumb) exps[1]).num);
		}
		List<Expression> l = new ArrayList<Expression>();

		for (int i = 0; i < exps.length; i++)
		{
			if (!(exps[i] instanceof ENumb) || ((ENumb) exps[i]).num != 0)
			{
				l.add(exps[i]);
			}
		}

		if (l.size() > 0)
		{
			if (l.size() == 1)
			{
				return l.get(0).copy();
			}
			Sum a = new Sum(l.toArray(new Expression[0]));
			for (int i = 0; i < exps.length; i++)
			{
				if (!exps[i].vars.isEmpty())
				{
					a.vars.addAll(exps[i].vars);
				}
			}
			return a;
		}
		else
			return ENumb.Zero;
	}

	public static Expression sub(Expression exp1, Expression exp2)
	{
		if (exp1 instanceof ENumb && exp2 instanceof ENumb)
		{
			return ENumb.I(((ENumb) exp1).num - ((ENumb) exp2).num);
		}
		Sum a = new Sum(exp1, not(exp2));
		if (!exp1.vars.isEmpty())
			a.vars.addAll(exp1.vars);
		if (!exp2.vars.isEmpty())
			a.vars.addAll(exp2.vars);
		return a;
	}

	public static Expression mult(Expression... exps)
	{
		List<Expression> l = new ArrayList<Expression>();

		for (int i = 0; i < exps.length; i++)
		{
			if (exps[i] instanceof ENumb)
			{
				if (((ENumb) exps[i]).num != 1)
				{
					if (((ENumb) exps[i]).num == 0)
						return ENumb.Zero;
					else
						l.add(exps[i]);
				}
			}
			else
			{
				l.add(exps[i]);
			}
		}

		if (l.size() > 0)
		{
			if (l.size() == 1)
			{
				return l.get(0).copy();
			}

			Mult m = new Mult(l.toArray(new Expression[0]));
			for (int i = 0; i < exps.length; i++)
			{
				if (!exps[i].vars.isEmpty())
				{
					m.vars.addAll(exps[i].vars);
				}
			}
			return m;
		}
		return ENumb.Zero;
	}

	public static Expression div(Expression exp1, Expression exp2)
	{
		if (exp2 instanceof ENumb)
		{
			if (((ENumb) exp2).num == 1)
			{
				return exp1.copy();
			}
		}
		Expression m = mult(exp1, power(exp2, ENumb.I(-1)));
		if (!exp1.vars.isEmpty())
			m.vars.addAll(exp1.vars);
		if (!exp2.vars.isEmpty())
			m.vars.addAll(exp2.vars);
		return m;
	}

	public static Expression not(Expression exp)
	{
		return new UMinus(exp);
	}

	public static Expression exp(Expression e)
	{
		return power(E, e);
	}

	public static Expression sqrt(Expression e)
	{
		return new Power(e, ENumb.I(0.5d));
	}

	public static Expression power(Expression e1, Expression e2)
	{
		if (e2 instanceof ENumb)
		{
			if (((ENumb) e2).num == 1)
			{
				return e1.copy();
			}
		}
		return new Power(e1, e2);
	}

	public static Expression sqr(Expression e)
	{
		return new Power(e, ENumb.I(2));
	}

	public static Expression ln(Expression e)
	{
		return new Ln(e);
	}

	public static Expression log(Expression e1, Expression base)
	{
		return new Log(e1, base);
	}

	public static Expression arcCos(Expression e)
	{
		return new Arccos(e);
	}

	public static Expression arcSin(Expression e)
	{
		return new Arcsin(e);
	}

	public static Expression arcTan2(Expression e1, Expression e2)
	{
		return new Arctan2(e1, e2);
	}

	public static Expression derive(Expression e)// select variable
	{
		if (e instanceof Power)
		{
			Expression a = ((Power) e).exps[0];
			Expression b = ((Power) e).exps[1];

			if (a.vars.contains("x"))
			{
				if (b.vars.contains("x"))
				{
					return mult(e, derive(mult(b, ln(a))));
				}
				else
				{
					return mult(b, power(a, sub(b, ENumb.I(1))), derive(a));
				}
			}
			else
				if (b.vars.contains("x"))
				{
					return mult(power(a, b), ln(a), derive(a));
				}
				else
					return ENumb.I(0);
		}

		if (e instanceof Var)
		{
			return ENumb.I(1);
		}
		if (e instanceof Ln)
		{
			Expression a = ((Ln) e).exps[0];
			if (a.vars.contains("x"))
			{
				return div(derive(a), a);
			}
			else
				return ENumb.I(0);
		}
		if (e instanceof Mult)
		{
			Expression a = ((Mult) e).exps[0];
			Expression b = ((Mult) e).exps[1];
			return sum(mult(derive(a), b), mult(a, derive(b)));
		}

		if (e instanceof ENumb)
		{
			return ENumb.I(0);
		}

		return e.derive("x");
	}

	public static Expression derive(Expression e, String var)// select variable
	{
		if (e instanceof Power)
		{
			Expression a = ((Power) e).exps[0];
			Expression b = ((Power) e).exps[1];

			if (a.vars.contains(var))
			{
				if (b.vars.contains(var))
				{
					return mult(e, derive(mult(b, ln(a)), var));
				}
				else
				{
					return mult(b, power(a, sub(b, ENumb.I(1))), derive(a, var));
				}
			}
			else
				if (b.vars.contains(var))
				{
					return mult(power(a, b), ln(a), derive(a, var));
				}
				else
					return ENumb.I(0);
		}

		if (e instanceof Var)
		{
			if (((Var) e).name == var)
				return ENumb.I(1);
			else
				return ENumb.Zero;
		}
		if (e instanceof Ln)
		{
			Expression a = ((Ln) e).exps[0];
			if (a.vars.contains(var))
			{
				return div(derive(a, var), a);
			}
			else
				return ENumb.I(0);
		}
		if (e instanceof Mult)
		{
			Expression a = ((Mult) e).exps[0];
			Expression b = ((Mult) e).exps[1];
			return sum(mult(derive(a, var), b), mult(a, derive(b, var)));
		}
		if (e instanceof Sum)
		{
			Expression a = ((Sum) e).exps[0];
			Expression b = ((Sum) e).exps[1];
			return sum(derive(a, var), derive(b, var));
		}

		if (e instanceof ENumb)
		{
			return ENumb.I(0);
		}

		return e.derive(var);
	}

	public static Expression deriveN(Expression e, int n, String var)// select
	{
		Expression ef = e;
		for (int i = 0; i < n; i++)
		{
			ef = derive(ef);
		}

		return ef;
	}

	public static String asArg(Expression e)
	{
		if (e instanceof Sum || e instanceof Mult || e instanceof Power)
			return "(" + e.toString() + ")";
		return e.toString();
	}

}
