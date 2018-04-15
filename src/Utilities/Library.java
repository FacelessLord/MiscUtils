package Utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Library
{
	public Library(String book)
	{
		this.book = book;
	}

	public Library(String book, String ext)
	{
		this.book = book;
		this.custExt = ext;
	}

	public String book = "common";
	public String path = "library";
	public static final String ext = ".lib";
	public String custExt = ".lib";
	public boolean stopRewriting = false;

	public HashMap<String, String> knowlege = new HashMap<String, String>();

	public void write(HashMap<String, String> tag)
	{
		knowlege.putAll(tag);
		if (!this.stopRewriting)
			callRewrite();
	}

	public void write(String exp, String value)
	{
		knowlege.put(exp, value);
		if (!this.stopRewriting)
			callRewrite();
	}

	public void callRewrite()
	{
		String name = book + (custExt.equals(ext) ? ext : custExt);
		List<String> lst = new ArrayList<String>();

		Set<String> en = knowlege.keySet();
		en.stream().forEach(key ->
		{
			Object value = knowlege.get(key);
			lst.add(Utils.compact((Object) key, value));
		});
		Logger.rewriteFile(name, path, lst);
	}

	public void read() throws IOException
	{
		File lib = this.getFile();

		FileReader fr = new FileReader(lib);
		BufferedReader br = new BufferedReader(fr);

		String line = br.readLine();
		if (line != null)
			while (!line.startsWith("}"))
			{
				if (!line.startsWith("{") && line.indexOf("=") != -1)
				{
					knowlege.put(line.substring(0, line.indexOf("=")), line.substring(line.indexOf("=") + 1));
				}
				line = br.readLine();
				if (line != null)
				{
					line = line.trim();
				}
				else
					line = "";
			}

		br.close();
	}

	public String get(String key)
	{
		return knowlege.get(key);
	}

	public void output() throws IOException
	{
		File lib = this.getFile();
		FileWriter fw = new FileWriter(lib);
		BufferedWriter bw = new BufferedWriter(fw);

		bw.write("{");
		bw.newLine();

		Set<String> en = knowlege.keySet();
		en.stream().forEach(key ->
		{
			try
			{
				bw.write(key + "=" + knowlege.get(key) + "\n");
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		});
		bw.write("}");
		bw.flush();
		bw.close();
	}

	public void setStopRewriting(boolean stopRewriting)
	{
		this.stopRewriting = stopRewriting;
	}

	public File getFile()
	{
		String pathb = Constants.path + "/" + this.path;

		File folder = new File(pathb);
		if (!folder.exists())
		{
			folder.mkdirs();
		}
		try
		{
			File file = new File(pathb, this.book);
			if (!file.exists())
				file.createNewFile();
			return file;
		}
		catch (Exception e)
		{

		}
		return null;
	}
}
