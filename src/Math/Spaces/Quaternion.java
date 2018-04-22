package Math.Spaces;

import Utilities.Utils;

/**
 * Do not use!!
 * @author lord_faceless 
 */
@Deprecated
public class Quaternion extends Number
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3392323865851915010L;

	public double real = 0;
	public double fI = 0;
	public double fJ = 0;
	public double fK = 0;

	public Quaternion(double real)
	{
		this.real = real;
	}

	public Quaternion(Quaternion c)
	{
		this.real = c.real;
		this.fI = c.fI;
		this.fJ = c.fJ;
		this.fK = c.fK;
	}

	public Quaternion(double real, double fI)
	{
		this.real = real;
		this.fI = fI;
	}

	public Quaternion(double real, double fI, double fJ)
	{
		this.real = real;
		this.fI = fI;
		this.fJ = fJ;
	}

	public Quaternion(double real, double fI, double fJ, double fK)
	{
		this.real = real;
		this.fI = fI;
		this.fJ = fJ;
		this.fK = fK;
	}

	public Quaternion add(Quaternion c)
	{
		return new Quaternion(this.real + c.real, this.fI + c.fI, this.fJ + c.fJ, this.fK + c.fK);
	}

	public Quaternion sub(Quaternion c)
	{
		return new Quaternion(this.real - c.real, this.fI - c.fI, this.fJ - c.fJ, this.fK - c.fK);
	}

	// public Complex mult(Complex c)
	// {
	// return new Complex(this.real * c.real - this.imag * c.imag, this.real *
	// c.imag + this.imag * c.real);
	// }
	//
	// public Complex div(Complex c)
	// {
	// return new Complex((this.real * c.real + this.imag * c.imag) / (c.real *
	// c.real + c.imag * c.imag), (this.imag * c.real - this.real * c.imag) /
	// (c.real * c.real + c.imag * c.imag));
	// }

	public Quaternion add(Number c)
	{
		return new Quaternion(this.real + c.doubleValue(), this.fI, this.fJ, this.fK);
	}

	public Quaternion sub(Number c)
	{
		return new Quaternion(this.real - c.doubleValue(), this.fI, this.fJ, this.fK);
	}

	// public Quaternion mult(Number c)
	// {
	// return new Quaternion(this.real * c.doubleValue(), this.fI *
	// c.doubleValue(), this.fJ * c.doubleValue(), this.fK * c.doubleValue());
	// }
	//
	// public Quaternion div(Number c)
	// {
	// return new Quaternion(this.real / c.doubleValue(), this.fI /
	// c.doubleValue(), this.fJ * c.doubleValue(), this.fK * c.doubleValue());
	// }

	@Override
	public String toString()
	{
		String rr = Utils.roundStr(Utils.round(this.real, 4), 4);
		rr = !rr.equals("0") ? (rr + " ") : "";

		String ri = Utils.roundStr(Math.abs(Utils.round(this.fI, 4)), 4);
		ri = !ri.equals("1") ? (ri + "i") : "i";
		ri = !ri.equals("0i") ? (ri + " ") : "";

		String sri = this.fI < 0 ? "- " : (!ri.equals("") ? (!rr.equals("") ? "+ " : "") : "");

		String rj = Utils.roundStr(Math.abs(Utils.round(this.fJ, 4)), 4);
		rj = !rj.equals("1") ? (rj + "j") : "j";
		rj = !rj.equals("0j") ? (rj + " ") : "";

		String sij = this.fJ < 0 ? "- " : (!rj.equals("") ? "+ " : "");

		String rk = Utils.roundStr(Math.abs(Utils.round(this.fK, 4)), 4);
		rk = !rk.equals("1") ? (rk + "k") : "k";
		rk = !rk.equals("0k") ? (rk + " ") : "";

		String sjk = this.fK < 0 ? "- " : (!rk.equals("") ? "+ " : "");

		String pstr = rr + sri + ri + sij + rj + sjk + rk;

		return pstr.equals("") ? "0" : pstr.trim();
	}

	@Override
	public double doubleValue()
	{
		return this.real;
	}

	@Override
	public float floatValue()
	{
		return (float) this.real;
	}

	@Override
	public int intValue()
	{
		return (int) this.real;
	}

	@Override
	public long longValue()
	{
		return (long) this.real;
	}
}
