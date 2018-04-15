package Utilities;

import java.util.ArrayList;
import java.util.List;

public class Color
{
	public int red;
	public int green;
	public int blue;
	public int alpha = 255;

	public String code = "";

	public static List<String> codes = new ArrayList<String>();
	public static List<Color> colors = new ArrayList<Color>();

	public Color(int r, int g, int b)
	{
		this.red = r;
		this.green = g;
		this.blue = b;
	}

	public Color(int r, int g, int b, int a)
	{
		this.red = r;
		this.green = g;
		this.blue = b;
		this.alpha = a;
	}

	public Color(double r, double g, double b)
	{
		this.red = (int) (r * 255);
		this.green = (int) (g * 255);
		this.blue = (int) (b * 255);
	}

	public Color(double r, double g, double b, double a)
	{
		this.red = (int) r * 255;
		this.green = (int) g * 255;
		this.blue = (int) b * 255;
		this.alpha = (int) a * 255;
	}

	public Color(int r, int g, int b, String code)
	{
		this.red = r;
		this.green = g;
		this.blue = b;
		this.code = code;
		codes.add(code);
		colors.add(this);
	}

	public Color(int r, int g, int b, int a, String code)
	{
		this.red = r;
		this.green = g;
		this.blue = b;
		this.alpha = a;
		codes.add(code);
		colors.add(this);
	}

	public Color(double r, double g, double b, String code)
	{
		this.red = (int) (r * 255);
		this.green = (int) (g * 255);
		this.blue = (int) (b * 255);
		codes.add(code);
		colors.add(this);
	}

	public Color(double r, double g, double b, double a, String code)
	{
		this.red = (int) r * 255;
		this.green = (int) g * 255;
		this.blue = (int) b * 255;
		this.alpha = (int) a * 255;
		codes.add(code);
		colors.add(this);
	}

	public Color getOpposite()
	{
		return new Color(255 - this.red, 255 - this.green, 255 - this.blue);
	}

	public Color add(Color c)
	{
		int red = Utils.limit((c.red + this.red) / 2, 0, 255);
		int green = Utils.limit((c.green + this.green) / 2, 0, 255);
		int blue = Utils.limit((c.blue + this.blue) / 2, 0, 255);
		int alpha = Utils.limit((c.alpha + this.alpha) / 2, 0, 255);

		return new Color(red, green, blue, alpha);
	}

	@Override
	public String toString()
	{
		return this.red + "|" + this.green + "|" + this.blue;
	}

	public String getColorCode()
	{
		if (colors.contains(this))
		{
			return "Þ" + codes.get(colors.indexOf(this));
		}
		return "Þw";
	}

	public static Color getColor(String code)
	{
		if (codes.contains(code))
		{
			return colors.get(codes.indexOf(code));
		}
		return White;
	}

	public static final Color White = new Color(255, 255, 255, "w");
	public static final Color Black = new Color(0, 0, 0, "b");
	public static final Color Gray = new Color(127, 127, 127, "j");
	public static final Color Cobalt = new Color(40, 60, 255, "c");
	public static final Color Mithril = new Color(95, 207, 215, "m");
	public static final Color Red = new Color(194, 0, 0, "r");
	public static final Color Yellow = new Color(247, 215, 0, "y");
	public static final Color Green = new Color(0, 200, 0, "g");
	public static final Color Cyan = new Color(0, 186, 255, "s");
	public static final Color Blue = new Color(0, 68, 198, "a");
	public static final Color LightBlue = new Color(88, 171, 255, "l");
	public static final Color Purple = new Color(133, 0, 255, "p");
	public static final Color Void = new Color(68, 57, 193, "v");
	public static final Color Gold = new Color(255, 199, 62, "G");
	public static final Color Orange = new Color(255, 186, 0, "o");
	public static final Color Brown = new Color(147, 107, 0, "B");
	public static final Color Pink =  new Color(0, 186, 255, "P").getOpposite();

	public Color withAlpha(int d)
	{
		return new Color(this.red, this.green, this.blue, d);
	}

}
