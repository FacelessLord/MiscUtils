package Utilities;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;
import java.util.Set;

import Math.Functions.EFunction;
import Math.Vec.Vec2;

public class Utils
{
	public static Random r = new Random();

	public static void arraycopy(char[] src, char[] target, int start, int end)
	{
		for (int i = start; i < end; i++)
		{
			target[i] = src[i];
		}
	}

	public static double floorMod(double x, double y)
	{
		return x - floorDiv(x, y);
	}

	public static double floorDiv(double x, double y)
	{
		return Math.floor(x / y);
	}

	public static float floorMod(float x, float y)
	{
		return x - floorDiv(x, y);
	}

	public static float floorDiv(float x, float y)
	{
		return (float) Math.floor(x / y);
	}

	public static Vec2 getCOM(Vec2[] vs, double[] ms)
	{
		Vec2 com = new Vec2();
		double mass = 0;
		for (int i = 0; i < vs.length; i++)
		{
			com = com.add(vs[i].mult(ms[i]));
			mass += ms[i];
		}
		return com.div(mass);
	}

	public static <T> List<T> reverseList(List<T> l)
	{
		List<T> rev = new ArrayList<T>();
		for (int i = 0; i < l.size(); i++)
		{
			rev.add(l.get(l.size() - i - 1));
		}
		return rev;
	}

	public static List<String> unpact(String s)
	{
		List<String> l = new ArrayList<String>();

		while (s.indexOf(d) > -1)
		{
			String ds = s.substring(0, s.indexOf(d));
			l.add(ds);
			s = s.substring(s.indexOf(d) + 1);
		}
		l.add(s);

		return l;
	}

	public static String toString(Object o)
	{
		return o != null ? o.toString() + "" : "null";
	}

	public static String d = "|";

	public static String compact(Object... ss)
	{
		String s = "";
		for (int i = 0; i < ss.length; i++)
		{
			s += toString(ss[i]);
			if (i != ss.length - 1)
				s += d;
		}

		return s;
	}

	// public static String compact(String d, Object... ss)
	// {
	// String s = "";
	// for (int i = 0; i < ss.length; i++)
	// {
	// s += toString(ss[i]);
	// if (i != ss.length - 1)
	// s += d;
	// }
	//
	// return s;
	// }

	/**
	 * @param value
	 * @param max
	 * @return if value is bigger then half of max it will return max-value else
	 *         return value
	 */
	public static double getSawValue(double value, double max)
	{
		return value > (max / 2) ? max - value : value;
	}

	public static double getTimedColorValue(double speed)
	{
		return ((System.currentTimeMillis() % (255 * speed)) / speed);
	}

	/**
	 * @param speed
	 * @return Value changing in time. Usable in things like bobbing
	 */
	public static double getTimedValue(double speed)
	{
		return ((System.currentTimeMillis() % speed) / speed);
	}

	/**
	 * @param speed
	 * @return deg angle changing in time
	 */
	public static double getTimedAngle(double speed)
	{
		return ((System.currentTimeMillis() % (360 * speed)) / speed);
	}

	/**
	 * @param l
	 * @return mixed list
	 */
	public static <T> List<T> randomize(List<T> l)
	{
		List<T> ret = new ArrayList<T>();
		for (int i = 0; i < l.size(); i++)
		{
			ret.add(l.get(r.nextInt(l.size())));
		}
		return ret;
	}

	public static double distance(double x, double y, double z)
	{
		return Math.sqrt(sqr(x) + sqr(y) + sqr(z));
	}

	public static double distance(double x, double y, double z, double i, double j, double k)
	{
		return Math.sqrt(sqr(x - i) + sqr(y - j) + sqr(z - k));
	}

	public static double distance(double x, double y)
	{
		return Math.sqrt(sqr(x) + sqr(y));
	}

	public static double distance(double x, double y, double i, double j)
	{
		return Math.sqrt(sqr(x - i) + sqr(y - j));
	}

	public static double sqr(double x)
	{
		return x * x;
	}

	public static HashMap<String, String> sim = new HashMap<String, String>();

	@SuppressWarnings("unchecked")
	public static <T1> List<T1> lst(T1... val)
	{
		List<T1> lst = new ArrayList<T1>();
		if (val != null)
		{
			for (int i = 0; i < val.length; i++)
			{
				lst.add(val[i]);
			}
		}
		return lst;
	}

	public static int boolToNum(boolean b)
	{
		if (b)
			return 1;
		else
			return -1;
	}

	public static int boolToNum(boolean b, int tr, int fl)
	{
		if (b)
			return tr;
		else
			return fl;
	}

	public static double boolToNum(boolean b, double tr, double fl)
	{
		if (b)
			return tr;
		else
			return fl;
	}

	public static double boolToNum(double tr, double fl)
	{
		if (r.nextBoolean())
			return tr;
		else
			return fl;
	}

	public static int boolToNum(int tr, int fl)
	{
		if (r.nextBoolean())
			return tr;
		else
			return fl;
	}

	public static int boolToNum()
	{
		boolean b = r.nextBoolean();
		if (b)
			return 1;
		else
			return -1;
	}

	public static double getNormDbl()
	{
		return r.nextDouble() * boolToNum();
	}

	public static int getIntInRange(int a, int b)
	{
		if (b > a)
		{
			int raw = r.nextInt(b - a);
			return a + raw;
		}
		else
			if (a > b)
			{
				int raw = r.nextInt(a - b);
				return b + raw;
			}
			else
				return a;
	}

	public static boolean randWPercent(double percent)
	{
		double ret = r.nextDouble();
		return ret <= percent / 100d;
	}

	public static Vec2 getPosByAngle(double angle, double dist)
	{
		double rY = Math.sin(angle) * dist;

		double rX = Math.cos(angle) * dist;

		return new Vec2(rX, rY);
	}

	// public static Pos getPosBy3DAngle(Angle3D angle, double dist)
	// {
	// double rY = Math.sin(angle.pitch) * dist;
	// double mod = Math.cos(angle.pitch) * dist;
	//
	// double rX = Math.cos(angle.yaw) * mod;
	// double rZ = Math.sin(angle.yaw) * mod;
	//
	// return new Pos(rX, rY, rZ);
	// }

	// public static Angle3D get3DAngleByPos(Pos p)
	// {
	// double mod = Math.sqrt(p.x * p.x + p.z * p.z);
	// double pitch = 0, yaw = 0;
	//
	// pitch = Math.atan2(p.y, mod);
	//
	// yaw = Math.atan2(p.z, p.x);
	//
	// return new Angle3D(yaw, pitch);
	// }
	//
	// public static Angle3D get3DAngleByPos(double x, double y, double z)
	// {
	// double mod = Math.sqrt(x * x + z * z);
	// double pitch = 0, yaw = 0;
	//
	// pitch = Math.atan2(y, mod);
	// yaw = Math.asin(z / mod);
	//
	// return new Angle3D(yaw, pitch);
	// }

	public static ArrayList<Double> resolveQuadricEquation(double a, double b, double c)
	{
		ArrayList<Double> ret = new ArrayList<Double>();

		double D = b * b - 4 * a * c;

		ret.add((-b - Math.sqrt(D)) / a);
		ret.add((-b + Math.sqrt(D)) / a);

		return ret;
	}

	public static double round(double a, double precis)
	{
		return ((int) (a * Math.pow(10, precis))) / Math.pow(10, precis);
	}

	public static double derivPart(EFunction f, double... ds)
	{
		if (ds.length == 1)
		{
			double d = 0.0000001;
			return (f.count("dx", ds[0] + d) - f.count("dx", ds[0])) / d;
		}
		if (ds.length == 2)
		{
			double d = 0.0000001;
			return (f.count("dx", ds[0] + d, "dy", ds[1] + d) - f.count("dx", ds[0], "dy", ds[1])) / (d * d);
		}
		return 0;
	}

	public static double integral(double a, double b, EFunction f)
	{
		// How many times
		double type = (b - a) * 1000;
		double min = (b - a) / type;

		double sum = 0;

		for (int i = 0; i < type; i++)
		{
			sum += f.count("dx", a + min * i + min / 2) * min;
		}
		return round(sum, 5);
	}

	public static double integral2(double a, double b, double c, double d, EFunction f)
	{
		// How many times
		double type1 = (b - a) * 1000;
		double type2 = (d - c) * 1000;

		double min = 1 / 1000d;

		double sum = 0;

		for (int i = 0; i < type1; i++)
		{
			for (int j = 0; j < type2; j++)
			{
				sum += f.count("dx", a + min * i + min / 2, "dy", c + min * i + min / 2) * min * min;
			}
		}
		return round(sum, 5);
	}

	public static double integral3(double a, double b, double c, double d, double e, double g, EFunction f)
	{
		// How many times
		double type1 = (b - a) * 1000;
		double type2 = (d - c) * 1000;
		double type3 = (g - e) * 1000;

		double min = 1 / 1000d;

		double sum = 0;

		for (int i = 0; i < type1; i++)
		{
			for (int j = 0; j < type2; j++)
			{
				for (int k = 0; k < type3; k++)
				{
					sum += f.count("dx", a + min * i + min / 2, "dy", c + min * i + min / 2, "dz", e + min * i + min / 2) * min * min * min;
				}
			}
		}
		return round(sum, 5);
	}

	/**
	 * 
	 * @param a
	 * @param b
	 * @param f
	 *            : Function
	 * @param precis
	 *            : max = 19; maximal precision at 15
	 * @return
	 */
	public static double integral(double a, double b, EFunction f, int precis)
	{
		// How many times
		double type = (b - a) * 1000;
		double min = (b - a) / type;

		double sum = 0;

		for (long i = 0; i < type; i++)
		{
			double fu;
			try
			{
				fu = f.count("dx", a + min * i + min / 2);
			}
			catch (Exception e)
			{
				fu = 0;
			}
			sum += fu * min;

		}
		return round(sum, precis);
	}

	public static double arraySum(double[] arr, int lastInd)
	{
		double ret = 0;
		if (lastInd != 0)
			for (int i = 0; i < lastInd; i++)
			{
				ret += arr[i];
			}

		return ret;
	}

	public static double arraySum(double[] arr)
	{
		double ret = 0;
		for (int i = 0; i < arr.length; i++)
		{
			ret += arr[i];
		}

		return ret;
	}

	/**
	 * Puts number in the limits
	 * 
	 * @param a
	 * @param min
	 * @param max
	 * @return
	 */
	public static int limit(int a, int min, int max)
	{
		if (a > max)
		{
			a = max;
		}
		if (a < min)
		{
			a = min;
		}
		return a;
	}

	/**
	 * Puts vector in the limits of square AABB
	 * 
	 * @param a
	 * @param min
	 * @param max
	 * @return
	 */
	public static Vec2 lightlimit(Vec2 v, AABB2 lim)
	{
		Vec2 vv = v.copy();

		double mv = Math.abs(v.x) > Math.abs(v.y) ? v.x : v.y;
		double eff = mv / lim.tx;

		return vv.div(eff > 1 ? eff : 1);
	}

	/**
	 * Puts vector in the limits of AABB
	 * 
	 * @param a
	 * @param min
	 * @param max
	 * @return
	 */
	public static Vec2 limit(Vec2 v, AABB2 lim)
	{
		Vec2 vv = v.copy();

		if (vv.x > lim.tx)
		{
			vv.x = lim.tx;
		}
		if (vv.x < lim.ox)
		{
			vv.x = lim.ox;
		}

		if (vv.y > lim.ty)
		{
			vv.y = lim.ty;
		}
		if (vv.y < lim.oy)
		{
			vv.y = lim.oy;
		}

		return vv;
	}

	/**
	 * Puts number in the limits
	 * 
	 * @param a
	 * @param min
	 * @param max
	 * @return
	 */
	public static float limit(float a, float min, float max)
	{
		float v = a;

		if (a > max)
		{
			v = max;
		}
		if (a < min)
		{
			v = min;
		}
		return v;
	}

	/**
	 * Puts number in the limits
	 * 
	 * @param a
	 * @param min
	 * @param max
	 * @return
	 */
	public static double limit(double a, double min, double max)
	{
		double v = a;
		if (a > max)
		{
			v = max;
		}
		if (a < min)
		{
			v = min;
		}
		return v;
	}

	/**
	 * Checks if number lower then max and larger then min
	 * 
	 * @param a
	 * @param min
	 * @param max
	 * @return
	 */
	public static boolean isInLimit(double a, double min, double max)
	{
		if (a <= max && a >= min)
		{
			return true;
		}

		return false;
	}

	/**
	 * Puts vector in the limits of AABB
	 * 
	 * @param a
	 * @param min
	 * @param max
	 * @return
	 */
	public static boolean isInLimit(Vec2 v, AABB2 lim)
	{
		return (v.x <= lim.tx && v.x >= lim.ox) && (v.y <= lim.ty && v.y >= lim.oy);
	}

	/**
	 * Gets first not occupied slot for the given array
	 * 
	 * @param array
	 * @return
	 */
	public static int getFNOS(Object[] array)
	{
		for (int i = 0; i < array.length; i++)
		{
			if (array[i] == null)
			{
				return i;
			}
		}
		return -1;
	}

	public static Object[] expandArray(Object[] array)
	{
		Object[] ret = new Object[array.length + 1];
		for (int i = 0; i < array.length; i++)
		{
			ret[i] = array[i];
		}
		return ret;
	}

	public static Object[] expandArray(Object[] array, int length)
	{
		Object[] ret = new Object[array.length + length];
		for (int i = 0; i < array.length; i++)
		{
			ret[i] = array[i];
		}
		return ret;
	}

	public static float[] expandArray(float[] array, int length)
	{
		float[] ret = new float[array.length + length];
		for (int i = 0; i < array.length; i++)
		{
			ret[i] = array[i];
		}
		return ret;
	}

	public static boolean[] expandArray(boolean[] array, int length)
	{
		boolean[] ret = new boolean[array.length + length];
		for (int i = 0; i < array.length; i++)
		{
			ret[i] = array[i];
		}
		return ret;
	}

	public static String[] expandArray(String[] array, int length)
	{
		String[] ret = new String[array.length + length];
		for (int i = 0; i < array.length; i++)
		{
			ret[i] = array[i];
		}
		return ret;
	}

	public static int[] expandArray(int[] array, int length)
	{
		int[] ret = new int[array.length + length];
		for (int i = 0; i < array.length; i++)
		{
			ret[i] = array[i];
		}
		return ret;
	}

	public static int rgbToHex(int i, int j, int k)
	{
		int hex = ((short) i << 16) | ((short) j << 8) | ((short) k << 0);
		return hex;
	}

	public static int rgbToHex(Color c)
	{
		int hex = (c.red << 16) | (c.green << 8) | (c.blue << 0);
		return hex;
	}

	public static Color hexToRGB(int hex)
	{
		int r = ((int) (hex >> 24));
		int g = ((int) (hex >> 16));
		int b = ((int) (hex >> 8));
		int a = ((int) (hex >> 0));
		return new Color(r, g, b, a);
	}

	public static Hashtable<String, String> cutWithNameStart(Hashtable<String, String> tag, String start)
	{
		Hashtable<String, String> nev = new Hashtable<String, String>();
		Enumeration<String> en = tag.keys();
		while (en.hasMoreElements())
		{
			String key = en.nextElement();
			if (key.startsWith(start))
			{
				nev.put(key, tag.get(key));
			}
		}

		return nev;
	}

	/**
	 * In perspective it should cut names without 'start' string
	 * 
	 * @param tag
	 * @param start
	 * @return
	 */
	public static HashMap<String, String> cutnames(HashMap<String, String> tag, String start)
	{
		HashMap<String, String> nev = new HashMap<String, String>();
		Set<String> en = tag.keySet();

		en.stream().forEach(key ->
		{
			if (key.startsWith(start))
			{
				nev.put(key.substring(start.length()), tag.get(key));
			}
		});

		return nev;
	}

	/**
	 * @param p
	 * @return WorldPos(Vector) rounded to the axis
	 */
	public static Vec2 getAxialVec2(Vec2 p)
	{
		if (Math.abs(p.x) >= Math.abs(p.y))
		{
			return new Vec2(p.x, 0);
		}
		else
		{
			if (Math.abs(p.y) > Math.abs(p.x))
				return new Vec2(0, p.y);
		}
		return p;
	}

	public static int cycle(int i, int min, int max)
	{
		if (i > max)
		{
			return min;
		}
		if (i < min)
		{
			return max;
		}
		return i;
	}

	/**
	 * @param value
	 * @param i
	 * @return String value cut to i decimal numbers
	 */
	public static String roundStr(double value, int i)
	{
		String s = (Math.round(value * Math.pow(10, i)) / Math.pow(10, i)) + "";
		if (s.length() > 1)
			while (s.length() > 1 && (s.substring(s.length() - 1, s.length()).equals("0") || s.substring(s.length() - 1, s.length()).equals(".")))
			{
				s = s.substring(0, s.length() - 1);
			}
		return s;
	}
}
