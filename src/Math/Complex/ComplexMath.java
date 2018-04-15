package Math.Complex;

public final class ComplexMath
{

	public static final Complex i = Complex.i;
	public static final Complex oneOhalf = new Complex(1 / 2d);
	public static final Complex one = new Complex(1);
	public static final Complex Pi = new Complex(Math.PI);
	public static final Complex IPi = new Complex(0, Math.PI);
	public static final Complex e = new Complex(Math.E);

	public static Complex exp(Complex c)
	{
		// double sgn = Math.signum(c.real * c.imag);
		double r = Math.exp(c.real);// sign
		double real = Math.cos(c.imag) * r;
		double imag = Math.sin(c.imag) * r;

		return new Complex(real, imag);
	}

	public static Complex pow(Complex z, Complex c)
	{
		return exp(c.mult(ln(z)));
	}

	/**
	 * @param c
	 * @return TODO
	 */
	public static Complex ln(Complex c)
	{
		double a = Math.log(c.abs());
		double b = c.arg();
		return new Complex(a, b);
	}

	// Trigonometric
	public static Complex sin(Complex c)
	{
		return new Complex(Math.sin(c.real) * Math.cosh(c.imag), Math.cos(c.real) * Math.sinh(c.imag));
	}

	public static Complex cos(Complex c)
	{
		return new Complex(Math.cos(c.real) * Math.cosh(c.imag), Math.sin(c.real) * Math.sinh(c.imag));
	}

	public static Complex tan(Complex c)
	{
		return sin(c).div(cos(c));
	}

	public static Complex cot(Complex c)
	{
		return cos(c).div(sin(c));
	}

	// ArcTrigonometric
	public static Complex arcsin(Complex c)
	{
		return arccos(sqrt(one.sub(c.sqr())));
	}

	public static Complex arccos(Complex c)
	{
		return Pi.div(2).add(i.mult(ln(i.mult(c).add(sqrt(one.sub(c.sqr()))))));
	}

	public static Complex arctan(Complex c)
	{
		return i.sub(2).mult(ln(one.sub(i.mult(c)).sub(ln(one.add(i.mult(c))))));
	}

	// Hyperbolic Trigonometric
	public static Complex sinh(Complex c)
	{
		return sin(c.mult(i)).mult(i.inv());
	}

	public static Complex cosh(Complex c)
	{
		return cos(c.mult(i));
	}

	public static Complex tanh(Complex c)
	{
		return tan(c.mult(i)).mult(i.inv());
	}

	public static Complex coth(Complex c)
	{
		return cosh(c).div(sinh(c));
	}

	// Hyperbolic ArcTrigonometric
	public static Complex arcsinh(Complex c)
	{
		return ln(c.add(sqrt(c.sqr().add(1))));
	}

	public static Complex arccosh(Complex c)
	{
		return ln(c.add(sqrt(c.sqr().sub(1))));
	}

	public static Complex arctanh(Complex c)
	{
		return ln(one.add(c).div(one.sub(c)));
	}

	public static Complex sqrt(Complex a)
	{
		return pow(a, oneOhalf);
	}

}
