package Math.Spaces;

import Math.Spaces.Maths.ComplexMath;
import Math.Spaces.Maths.RealMath;
import Math.Spaces.Maths.WholeMath;

public class Spaces
{
	public static SpaceMath<Integer, Integer> ZMath = new WholeMath();
	public static SpaceMath<Double, Double> RMath = new RealMath();
	public static SpaceMath<Complex, Complex> CMath = new ComplexMath();

	public static Space<Integer, Integer> Z = new WholeSpace(ZMath);
	public static Space<Double, Double> R = new RealSpace(RMath);
	public static Space<Complex, Complex> C = new ComplexSpace(CMath);

}
