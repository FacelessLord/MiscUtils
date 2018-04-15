package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class TagLoader
{
	public static void writeTag(Tag tag, String path)
	{
		try
		{
			// TODO with Paths
			String file = System.getProperty("user.dir") + "\\" + path;
			File f = new File(file);
			if (!new File(file.substring(0, file.lastIndexOf("\\"))).exists())
			{
				f.mkdir();
			}
			if (!f.exists())
			{
				f.createNewFile();
			}
			FileOutputStream fs = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fs);
			oos.writeObject((HashMap<String, Object>) tag.hash);
			oos.flush();
			oos.close();
			fs.flush();
			fs.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public static Tag readTag(String file)
	{
		try
		{
			File f = new File(file);
			if (!f.exists())
			{
				f.createNewFile();
			}
			FileInputStream fs = new FileInputStream(f);
			ObjectInputStream oos = new ObjectInputStream(fs);
			HashMap<String, Object> hsh = (HashMap<String, Object>) oos.readObject();
			oos.close();
			fs.close();
			return new Tag(hsh);
		}
		catch (IOException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
