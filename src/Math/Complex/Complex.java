package Math.Complex;

import Utilities.Logger;
import Utilities.TypeUtils;

public class Complex extends Quaternion
{

	public static final Complex i = new Complex(0, 1);
	/**
	 * Eclipse asked me for that
	 */
	private static final long serialVersionUID = 2525212334395275395L;

	public double real = 0;
	public double imag = 0;

	public Complex(double r)
	{
		super(r);
	}

	public Complex(double r, double i)
	{
		super(r, i);
	}

	public Complex(Complex c)
	{
		super(c);
	}

//	@Override
//	public String toString()
//	{
//		String rr = Utils.roundStr(Utils.round(this.real, 4), 4);
//		String ri = Utils.roundStr(Math.abs(Utils.round(this.imag, 4)), 4);
//		String pstr = (!rr.equals("0") ? (rr + " ") : "") + (!ri.equals("0") ? ((this.imag < 0 ? "- " : (rr.equals("0") ? "" : "+ ")) + (Math.abs(this.imag) != 1 ? ri : "") + "i") : "");
//
//		return pstr.equals("") ? "0" : pstr;
//	}

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

	public static Complex parseComplex(String s)
	{
		double imag = 0;
		double real = 0;
		try
		{
			if (s.contains("+") || s.contains("-"))
			{
				String str = s.trim();
				if (str.indexOf("i") < str.length() - 1)// 2i+1
				{
					if (str.indexOf("i") == 0)
					{
						imag = 0;
					}
					else
					{
						imag = Double.parseDouble(str.trim().substring(0, TypeUtils.fullIntIndex(str)));
					}
					String rstr = str.substring(TypeUtils.fullIntIndex(str) + 1).trim();
					rstr = rstr.replaceAll(" ", "").replaceAll("i", "");
					real = Double.parseDouble(rstr.trim());
				}
				else // 1+2i
				{
					int pmi = Math.max(str.substring(1, str.length()).indexOf("+"), str.substring(1, str.length()).indexOf("-"));
					String rstr = str.substring(0, pmi + 1);
					rstr = rstr.replaceAll(" ", "");
					Logger.info(s.trim());
					real = Double.parseDouble(rstr.trim());

					String istr = str.substring(pmi + 1).trim();
					if (istr.indexOf("i") == 0)
					{
						imag = 0;
					}
					else
					{
						istr = istr.replaceAll(" ", "");
						if (istr.startsWith("+"))
							istr = istr.substring(1);
						istr = istr.substring(0, istr.length() - 1);
						imag = Double.parseDouble(istr);
					}
				}
			}
			else
			{
				if (s.contains("i"))
				{
					if (TypeUtils.fullIntIndex(s.trim()) > -1)
					{
						imag = Double.parseDouble(s.trim().substring(0, s.trim().length() - 1));
					}
					else
					{
						imag = 1;
					}
				}
				else
				{
					real = Double.parseDouble(s.trim());
				}
			}
		}
		catch (Exception e)
		{
			Logger.err("String \"" + s + "\" has wrong format");
			e.printStackTrace();
		}
		return new Complex(real, imag);
	}

	public Complex add(Complex c)
	{
		return new Complex(this.real + c.real, this.imag + c.imag);
	}

	public Complex sub(Complex c)
	{
		return new Complex(this.real - c.real, this.imag - c.imag);
	}

	public Complex mult(Complex c)
	{
		return new Complex(this.real * c.real - this.imag * c.imag, this.real * c.imag + this.imag * c.real);
	}

	public Complex div(Complex c)
	{
		return new Complex((this.real * c.real + this.imag * c.imag) / (c.real * c.real + c.imag * c.imag), (this.imag * c.real - this.real * c.imag) / (c.real * c.real + c.imag * c.imag));
	}

	public Complex add(Number c)
	{
		return new Complex(this.real + c.doubleValue(), this.imag);
	}

	public Complex sub(Number c)
	{
		return new Complex(this.real - c.doubleValue(), this.imag);
	}

	public Complex mult(Number c)
	{
		return new Complex(this.real * c.doubleValue(), this.imag * c.doubleValue());
	}

	public Complex div(Number c)
	{
		return new Complex(this.real / c.doubleValue(), this.imag / c.doubleValue());
	}

	public Complex sqr()
	{
		return this.mult(this);
	}

	/**
	 * @return inverted complex value - equals this*-1;
	 */
	public Complex inv()
	{
		return new Complex(-this.real, -this.imag);
	}

	public double abs()
	{
		return Math.sqrt(this.real * this.real + this.imag * this.imag);
	}

	public double arg()
	{
		return Math.atan2(this.imag, this.real);
	}

	public Complex conj()
	{
		return new Complex(this.real, -this.imag);
	}

}
