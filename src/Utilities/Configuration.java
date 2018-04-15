package Utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class Configuration
{
	public HashMap<String, HashMap<String, java.lang.Object>> config = new HashMap<String, HashMap<String, java.lang.Object>>();

	public String name = "config";
	public File cfg = new File(Constants.path + "/cfg", name + ".cfg");
	public File dir = new File(Constants.path + "/cfg");

	public Configuration()
	{
	}

	public Configuration(String name)
	{
		this.setName(name);
	}

	public void setName(String name)
	{
		this.name = name;
		this.cfg = new File(Constants.path + "/cfg", name + ".cfg");
	}

	/**
	 * @param category
	 *            : category of value
	 * @param key
	 *            : keyname of value
	 * @return Raw value from config file
	 */
	public java.lang.Object get(String category, String key)
	{
		java.lang.Object ret = null;
		try
		{
			ret = config.get(category).get(key);
		}
		catch (Exception e)
		{
			if (getBoolean("System", "debugMode", false))
			{
				System.err.println("There is no category or key with so name " + category + " : " + key);
				e.printStackTrace();
			}
		}
		return ret;
	}

	/**
	 * @param category
	 *            : category of value
	 * @param key
	 *            : keyname of value
	 * @return Value from config file in String format
	 */
	public String getString(String category, String key, String base)
	{
		try
		{
			return get(category, key).toString();
		}
		catch (Exception e)
		{
			config.get(category).put(key, base);
			return base;
		}
	}

	/**
	 * @param category
	 *            : category of value
	 * @param key
	 *            : keyname of value
	 * @return Value from config file in Integer format
	 */
	public Integer getInt(String category, String key, Integer base)
	{
		try
		{
			return Integer.parseInt(get(category, key).toString());
		}
		catch (Exception e)
		{
			config.get(category).put(key, base);
			return base;
		}
	}

	/**
	 * @param category
	 *            : category of value
	 * @param key
	 *            : keyname of value
	 * @return Value from config file in Double format
	 */
	public Double getDouble(String category, String key, Double base)
	{
		try
		{
			return Double.parseDouble(get(category, key).toString());
		}
		catch (Exception e)
		{
			config.get(category).put(key, base);
			return base;
		}
	}

	/**
	 * @param category
	 *            : category of value
	 * @param key
	 *            : keyname of value
	 * @return Value from config file in Float format
	 */
	public Float getFloat(String category, String key, Float base)
	{
		try
		{
			return Float.parseFloat(get(category, key).toString());
		}
		catch (Exception e)
		{
			config.get(category).put(key, base);
			return base;
		}

	}

	/**
	 * @param category
	 *            : category of value
	 * @param key
	 *            : keyname of value
	 * @return Value from config file in Boolean format
	 */
	public Boolean getBoolean(String category, String key, Boolean base)
	{
		try
		{
			return Boolean.parseBoolean(get(category, key).toString());
		}
		catch (Exception e)
		{
			config.get(category).put(key, base);
			return base;
		}
	}

	public void setupConfig()
	{
		try
		{
			if (!dir.exists())
			{
				dir.mkdir();
			}
			if (!cfg.exists())
			{
				cfg.createNewFile();
			}
			// Hashtable<String, java.lang.Object> entry = new Hashtable<String,
			// java.lang.Object>();
			// entry.put("Number", 2);
			// config.put("Core", entry);
			//
			// entry = new Hashtable<String, java.lang.Object>();
			// entry.put("String", "Nyah!");
			// entry.put("Double", 3.14159265357989D);
			// config.put("Math", entry);

			FileWriter fw = new FileWriter(cfg);
			BufferedWriter bw = new BufferedWriter(fw);

			Set<String> en = config.keySet();

			en.stream().forEach(s -> this.outCategory(s, bw));

			bw.flush();
			bw.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void outCategory(String cat, BufferedWriter bw)
	{
		try
		{
			bw.write("|" + cat);
			bw.newLine();

			HashMap<String, Object> ent = config.get(cat);
			Set<String> en = ent.keySet();

			en.stream().forEach(key ->
			{
				if (ent.get(key) != null)
					try
					{
						bw.write("	" + key + "=" + ent.get(key).toString() + "\n");
					}
					catch (IOException e)
					{
						e.printStackTrace();
					}
			});
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public boolean warn = true;

	public void setWarn(boolean dwarn)
	{
		warn = dwarn;
	}

	public void addProperty(String category, String key, String base)
	{
		if (config.containsKey(category))
		{
			if (config.get(category).containsKey(key))
			{
				if (warn)
					Logger.warn("Config property with name: " + key + " was added before");
			}
			else
			{
				config.get(category).put(key, base);
			}
		}
		else
		{
			HashMap<String, Object> hm = new HashMap<String, Object>();
			hm.put(key, base);
			config.put(category, hm);
		}
	}

	public void addProperty(String category, String key, int base)
	{
		if (config.containsKey(category))
		{
			if (config.get(category).containsKey(key))
			{
				if (warn)
					Logger.warn("Config property with name: " + key + " was added before");
			}
			{
				config.get(category).put(key, base);
			}
		}
		else
		{
			HashMap<String, Object> hm = new HashMap<String, Object>();
			hm.put(key, base);
			config.put(category, hm);
		}
	}

	public void addProperty(String category, String key, double base)
	{
		if (config.containsKey(category))
		{
			if (config.get(category).containsKey(key))
			{
				if (warn)
					Logger.warn("Config property with name: " + key + " was added before");
			}
			else
			{
				config.get(category).put(key, base);
			}
		}
		else
		{
			HashMap<String, Object> hm = new HashMap<String, Object>();
			hm.put(key, base);
			config.put(category, hm);
		}
	}

	public void addProperty(String category, String key, Boolean base)
	{
		if (config.containsKey(category))
		{
			if (config.get(category).containsKey(key))
			{
				if (warn)
					Logger.warn("Config property with name: " + key + " was added before");
			}
			else
			{
				config.get(category).put(key, base);
			}
		}
		else
		{
			HashMap<String, Object> hm = new HashMap<String, Object>();
			hm.put(key, base);
			config.put(category, hm);
		}
	}

	public void addProperty(String category, String key, Float base)
	{
		if (config.containsKey(category))
		{
			if (config.get(category).containsKey(key))
			{
				if (warn)
					Logger.warn("Config property with name: " + key + " was added before");
			}
			else
			{
				config.get(category).put(key, base);
			}
		}
		else
		{
			HashMap<String, Object> hm = new HashMap<String, Object>();
			hm.put(key, base);
			config.put(category, hm);
		}
	}

	public void readConfig()
	{
		try
		{
			if (!dir.exists())
			{
				dir.mkdirs();
			}
			if (!cfg.exists())
			{
				cfg.createNewFile();
			}
			FileReader fr = new FileReader(cfg);
			BufferedReader br = new BufferedReader(fr);
			// String comment = "";
			String category = "";
			try
			{
				for (int i = 0; i < 100; i++)
				{
					String line = br.readLine();
					if (line != null)
					{
						line = line.trim();
						if (!line.startsWith("|"))
						{
							if (!line.startsWith("#"))
							{
								int equalStart = line.indexOf("=");
								String value = line.substring(equalStart + 1);
								String key = line.substring(0, equalStart);
								if (config.containsKey(category))
								{
									config.get(category).put(key, value);
								}
								else
								{
									HashMap<String, java.lang.Object> empty = new HashMap<String, java.lang.Object>();
									empty.put(key, value);
									config.put(category, empty);
								}
							}
							else
							{
								// comment = " - " + line.substring(1);
							}
						}
						else
						{
							category = line.substring(1);
						}
					}
				}
			}
			catch (Exception e)
			{

			}
			br.close();
			HashMap<String, java.lang.Object> sysKey = new HashMap<String, java.lang.Object>();

			boolean flag = false;
			if (config.get("System") != null)
			{
				if (!config.get("System").containsKey("sysNum"))
				{
					sysKey.put("sysNum", 0);
				}
				else
				{
					sysKey.put("sysNum", config.get("System").get("sysNum"));
				}
			}
			else
				flag = true;
			if (config.get("System") != null)
			{
				if (!config.get("System").containsKey("sysStr"))
				{
					sysKey.put("sysStr", "Zero");
				}
				else
				{
					sysKey.put("sysStr", config.get("System").get("sysStr"));
				}
			}
			else
				flag = true;
			if (config.get("System") != null)
			{
				if (!config.get("System").containsKey("sysDoub"))
				{
					sysKey.put("sysDoub", 0.0D);
				}
				else
				{
					sysKey.put("sysDoub", config.get("System").get("sysDoub"));
				}
			}
			else
				flag = true;
			if (config.get("System") != null)
			{
				if (!config.get("System").containsKey("sysFloat"))
				{
					sysKey.put("sysFloat", 0.0F);
				}
				else
				{
					sysKey.put("sysFloat", config.get("System").get("sysFloat"));
				}
			}
			else
				flag = true;
			if (config.get("System") != null)
			{
				if (!config.get("System").containsKey("sysBool"))
				{
					sysKey.put("sysBool", false);
				}
				else
				{
					sysKey.put("sysBool", config.get("System").get("sysBool"));
				}
			}
			else
				flag = true;
			if (config.get("System") != null)
			{
				if (!config.get("System").containsKey("debugMode"))
				{
					sysKey.put("debugMode", false);
				}
				else
				{
					sysKey.put("debugMode", config.get("System").get("debugMode"));
				}
			}
			else
				flag = true;
			if (!flag)
				config.put("System", sysKey);
			else
			{
				sysKey.put("sysNum", 0);
				sysKey.put("sysStr", "Zero");
				sysKey.put("sysDoub", 0.0D);
				sysKey.put("sysFloat", 0.0F);
				sysKey.put("sysBool", false);
				sysKey.put("debugMode", false);

				config.put("System", sysKey);
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
