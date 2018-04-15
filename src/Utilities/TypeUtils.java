package Utilities;

import java.util.ArrayList;
import java.util.List;

public class TypeUtils
{
	// ===========================Strings==================================

	public static void initStr()
	{
		initAlphabet();
		initNum();
	}

	public static void initAlphabet()
	{
		alphUC.add("A");
		alphUC.add("B");
		alphUC.add("C");
		alphUC.add("D");
		alphUC.add("E");
		alphUC.add("F");
		alphUC.add("G");
		alphUC.add("H");
		alphUC.add("I");
		alphUC.add("J");
		alphUC.add("K");
		alphUC.add("L");
		alphUC.add("M");
		alphUC.add("N");
		alphUC.add("O");
		alphUC.add("P");
		alphUC.add("Q");
		alphUC.add("R");
		alphUC.add("S");
		alphUC.add("T");
		alphUC.add("U");
		alphUC.add("V");
		alphUC.add("W");
		alphUC.add("X");
		alphUC.add("Y");
		alphUC.add("Z");

		alphLC.add("a");
		alphLC.add("b");
		alphLC.add("c");
		alphLC.add("d");
		alphLC.add("e");
		alphLC.add("f");
		alphLC.add("g");
		alphLC.add("h");
		alphLC.add("i");
		alphLC.add("j");
		alphLC.add("k");
		alphLC.add("l");
		alphLC.add("m");
		alphLC.add("n");
		alphLC.add("o");
		alphLC.add("p");
		alphLC.add("q");
		alphLC.add("r");
		alphLC.add("s");
		alphLC.add("t");
		alphLC.add("u");
		alphLC.add("v");
		alphLC.add("w");
		alphLC.add("x");
		alphLC.add("y");
		alphLC.add("z");
	}

	public static void initNum()
	{
		num.add("0");
		num.add("1");
		num.add("2");
		num.add("3");
		num.add("4");
		num.add("5");
		num.add("6");
		num.add("7");
		num.add("8");
		num.add("9");

	}

	/**
	 * List of Strings with letters in upper case
	 */
	public static List<String> alphUC = new ArrayList<String>();
	/**
	 * List of Strings with letters in lower case
	 */
	public static List<String> alphLC = new ArrayList<String>();
	/**
	 * List of Strings with numbers
	 */
	public static List<String> num = new ArrayList<String>();

	/**
	 * @param s
	 *            String
	 * @param Case
	 *            is upper case?
	 * @return
	 */
	public static int indexOfCase(String s, boolean Case)
	{
		if (Case)
		{
			for (int i = 0; i < s.length(); i++)
			{
				String Char = s.substring(i, i + 1);
				if (alphUC.contains(Char))
					return i;
			}
		}
		else
		{
			for (int i = 0; i < s.length(); i++)
			{
				String Char = s.substring(i, i + 1);
				if (alphLC.contains(Char))
					return i;
			}
		}
		return -1;
	}

	/**
	 * @param s
	 *            String
	 * @param Case
	 *            is upper case?
	 * @param index
	 *            start index
	 * @return
	 */
	public static int indexOfCase(String s, boolean Case, int index)
	{
		if (Case)
		{
			for (int i = index; i < s.length(); i++)
			{
				String Char = s.substring(i, i + 1);
				if (alphUC.contains(Char))
					return i;
			}
		}
		else
		{
			for (int i = index; i < s.length(); i++)
			{
				String Char = s.substring(i, i + 1);
				if (alphLC.contains(Char))
					return i;
			}
		}
		return -1;
	}

	/**
	 * 
	 * @param s
	 *            String
	 * @return last index of number
	 */
	public static int fullIntIndex(String s)
	{
		int lastId = -1;
		for (int i = 0; i < s.length(); i++)
		{
			String Char = s.substring(i, i + 1);
			if (num.contains(Char) || Char.equals("-"))
				lastId = i+1;
			else
				return lastId;
		}
		return lastId;
	}

	/**
	 * 
	 * @param s
	 *            String
	 * @param index
	 *            start index
	 * @return last index of number
	 */
	public static Pair<Integer, Integer> fullIntIndex(String s, int index)
	{
		for (int i = index; i < s.length(); i++)
		{
			String Char = s.substring(i, i + 1);
			if (!num.contains(Char))
				return new Pair<Integer, Integer>(index, i);
		}
		return new Pair<Integer, Integer>(index, -1);
	}

	/**
	 * 
	 * @param s
	 *            String
	 * @param index
	 *            start index
	 * @return last index of number
	 */
	public static boolean startWithInt(String s)
	{
		for (int i = 0; i < num.size(); i++)
		{
			if (s.startsWith(num.get(i)))
				return true;
		}
		return false;
	}
}
