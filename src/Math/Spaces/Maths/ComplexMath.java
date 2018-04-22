package Math.Spaces.Maths;

import Math.Spaces.Complex;
import Math.Spaces.SpaceMath;

public final class ComplexMath extends SpaceMath<Complex, Complex>
{

	public static final Complex i = Complex.i;
	public static final Complex oneOhalf = new Complex(1 / 2d);
	public static final Complex one = new Complex(1);
	public static final Complex Pi = new Complex(Math.PI);
	public static final Complex IPi = new Complex(0, Math.PI);
	public static final Complex e = new Complex(Math.E);

	@Override
	public Complex exp(Complex c)
	{
		// double sgn = Math.signum(c.real * c.imag);
		double r = Math.exp(c.real);// sign
		double real = Math.cos(c.imag) * r;
		double imag = Math.sin(c.imag) * r;

		return new Complex(real, imag);
	}

	@Override
	public Complex pow(Complex z, Complex c)
	{
		return exp(c.mult(ln(z)));
	}

	/**
	 * @param c
	 * @return Natural logarithm of c
	 */
	@Override
	public Complex ln(Complex c)
	{
		double a = Math.log(c.abs());
		double b = c.arg();
		return new Complex(a, b);
	}

	// Trigonometric
	@Override
	public Complex sin(Complex c)
	{
		return new Complex(Math.sin(c.real) * Math.cosh(c.imag), Math.cos(c.real) * Math.sinh(c.imag));
	}

	@Override
	public Complex cos(Complex c)
	{
		return new Complex(Math.cos(c.real) * Math.cosh(c.imag), Math.sin(c.real) * Math.sinh(c.imag));
	}

	public Complex tan(Complex c)
	{
		return sin(c).div(cos(c));
	}

	public Complex cot(Complex c)
	{
		return cos(c).div(sin(c));
	}

	// ArcTrigonometric
	public Complex arcsin(Complex c)
	{
		return arccos(sqrt(one.sub(c.sqr())));
	}

	public Complex arccos(Complex c)
	{
		return Pi.div(2).add(i.mult(ln(i.mult(c).add(sqrt(one.sub(c.sqr()))))));
	}

	public Complex arctan(Complex c)
	{
		return i.sub(2).mult(ln(one.sub(i.mult(c)).sub(ln(one.add(i.mult(c))))));
	}

	// Hyperbolic Trigonometric
	public Complex sinh(Complex c)
	{
		return sin(c.mult(i)).mult(i.inv());
	}

	public Complex cosh(Complex c)
	{
		return cos(c.mult(i));
	}

	public Complex tanh(Complex c)
	{
		return tan(c.mult(i)).mult(i.inv());
	}

	public Complex coth(Complex c)
	{
		return cosh(c).div(sinh(c));
	}

	// Hyperbolic ArcTrigonometric
	public Complex arcsinh(Complex c)
	{
		return ln(c.add(sqrt(c.sqr().add(1))));
	}

	public Complex arccosh(Complex c)
	{
		return ln(c.add(sqrt(c.sqr().sub(1))));
	}

	public Complex arctanh(Complex c)
	{
		return ln(one.add(c).div(one.sub(c)));
	}

	public Complex sqrt(Complex a)
	{
		return pow(a, oneOhalf);
	}

}
