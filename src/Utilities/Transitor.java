 package Utilities;

import Math.Complex.Complex;
import Math.Matrix.Matrix2;
import Math.Vec.Vec2;

public class Transitor
{
	// public TODO

	public static Vec2 toVec2(Complex c)
	{
		return new Vec2(c.real, c.imag);
	}

	public static Complex toComplex(Vec2 c)
	{
		return new Complex(c.x, c.y);
	}

	public static Matrix2 toMatrix(Complex c)
	{
		return new Matrix2(c.real, c.imag, -c.imag, c.real);
	}
}
