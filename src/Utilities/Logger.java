package Utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Utilities.Constants;

public class Logger
{
	public static List<String> WorldLog = new ArrayList<String>();

	public static void outputLog(String name, List<String> log)
	{
		outputFile(name, "logs", log);
	}

	public static void addToLog(String s)
	{
		WorldLog.add(s);
	}

	public static void addToLog(Throwable e)
	{
		addToLog(e.toString());
		StackTraceElement[] log = e.getStackTrace();
		for (int i = 0; i < log.length; i++)
			addToLog("	" + log[i].toString());
	}

	public static void outputLog(String name)
	{
		if (name.equals("World"))
			outputFile(name + ".log", "logs", WorldLog);
	}

	/**
	 * Creates file with given name, at given path and fills it with given text
	 * 
	 * @param name
	 * @param path
	 * @param txt
	 */
	public static void outputFile(String name, String path, List<String> txt)
	{
		String pathb = Constants.path + "/" + path;

		File folder = new File(pathb);
		if (!folder.exists())
		{
			folder.mkdirs();
		}
		try
		{
			File bin = new File(pathb, "bin.inf");

			boolean binex = false;
			boolean recount = false;
			int count = -1;
			if (!bin.exists())
			{
				bin.createNewFile();
			}
			else
			{
				binex = true;
				FileReader fr = new FileReader(bin);
				BufferedReader br = new BufferedReader(fr);

				count = Integer.parseInt(br.readLine());
				br.close();
			}

			for (int i = count; i >= -1; i--)
			{
				File file = new File(pathb, addBefoPnt(name, "_" + i));
				if (file.exists())
				{
					file.renameTo(new File(pathb, addBefoPnt(name, "_" + (i + 1))));

				}
				else
					if (i == -1)
					{
						file = new File(pathb, addBefoPnt(name, "_latest"));
						if (file.exists())
						{
							file.renameTo(new File(pathb, addBefoPnt(name, "_" + (i + 1))));
						}
					}
					else
						recount = true;
			}

			File file = new File(pathb, addBefoPnt(name, "_" + (count + 1)));

			if (file.exists())
			{
				recount = true;
			}

			file = new File(pathb, addBefoPnt(name, "_latest"));
			file.createNewFile();

			FileWriter ffr = new FileWriter(file);
			BufferedWriter fbr = new BufferedWriter(ffr);

			for (String s : txt)
			{
				fbr.write(s + "\n");
			}

			fbr.flush();
			fbr.close();
			if (!binex)
			{
				// -1 for latest
				int cnt = -1;
				File f = new File(pathb, name + "_" + 0);
				while (f.exists())
				{
					cnt += 1;
					f = new File(pathb, addBefoPnt(name, "_" + (cnt + 1)));
				}
				FileWriter fr = new FileWriter(bin);
				BufferedWriter br = new BufferedWriter(fr);

				br.write(cnt + "");
				br.flush();
				br.close();
			}
			else
			{
				FileWriter fr = new FileWriter(bin);
				BufferedWriter br = new BufferedWriter(fr);

				bin.delete();
				bin.createNewFile();

				if (!recount)
					br.write(count + 1 + "");
				else
				{
					count = -1;
					File f = new File(pathb, addBefoPnt(name, "_" + 0));
					while (f.exists())
					{
						count += 1;
						f = new File(pathb, addBefoPnt(name, "_" + (count + 1)));
					}
					br.write(count + "");
				}

				br.flush();
				br.close();
			}

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Creates file with given name, at given path and fills it with given text
	 * 
	 * @param name
	 * @param path
	 * @param txt
	 */
	public static void rewriteFile(String name, String path, List<String> txt)
	{
		String pathb = Constants.path + "/" + path;

		File folder = new File(pathb);
		if (!folder.exists())
		{
			folder.mkdirs();
		}
		try
		{
			File file = new File(pathb, name);
			if (!file.exists())
				file.createNewFile();

			FileWriter ffr = new FileWriter(file);
			BufferedWriter fbr = new BufferedWriter(ffr);

			for (String s : txt)
			{
				fbr.write(s + "\n");
			}

			fbr.flush();
			fbr.close();

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static String addBefoPnt(String name, String text)
	{
		return name.substring(0, name.indexOf(".")) + text + name.substring(name.indexOf("."));
	}

	public static void out(Object s)
	{
		String out = Utils.compact(s);
		System.out.println("[Out]" + out);
		addToLog("[Out]" + s.toString());
	}

	public static void info(Object s)
	{
		String out = Utils.compact(s);
		System.out.println("[Info]" + out);
		addToLog("[Info]" + out);
	}

	public static void info(Object s, boolean prefix)
	{
		String out = Utils.compact(s);
		System.out.println((prefix ? "[Info]" : "") + out);
		addToLog((prefix ? "[Info]" : "") + out);
	}

	public static void minfo(Object... s)
	{
		String out = Utils.compact(s);
		System.out.println("[Info]" + out);
		addToLog("[Info]" + out);
	}

	public static void warn(Object s)
	{
		String out = Utils.compact(s);
		System.out.println("[Warning]" + out);
		addToLog("[Warning]" + out);
	}

	public static void err(Object s)
	{
		String out = Utils.compact(s);
		System.err.println("[Error]" + out);
		addToLog("[Error]" + out);
	}

	public static void fatal(Object s)
	{
		String out = Utils.compact(s);
		System.err.println("[Fatal]" + out);
		addToLog("[Fatal]" + out);
	}

}
