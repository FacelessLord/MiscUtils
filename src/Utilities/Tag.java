package Utilities;

import java.util.HashMap;
import java.util.Set;

public class Tag
{
	public HashMap<String, Object> hash;

	public Tag copy()
	{
		Tag tg = new Tag();

		Set<String> keys = hash.keySet();

		keys.stream().forEach(key -> tg.add(key, hash.get(key)));

		return tg;
	}

	public Tag()
	{
		this.hash = new HashMap<String, Object>();
	}

	public Tag(HashMap<String, Object> hash)
	{
		this.hash = hash;
	}

	public <T> void add(String key, T value)
	{
		if (this.hash.containsKey(key))
		{
			this.hash.replace(key, value);
		}
		else
			this.hash.put(key, value);
	}

	@SuppressWarnings("unchecked")
	public <T> T get(String id)
	{
		try
		{
			return (T) this.hash.get(id);
		}
		catch (Exception e)
		{
			return null;
		}
	}

	public void appendTag(String id, Tag app)
	{
		Set<String> en = app.hash.keySet();
		en.stream().forEach(key -> this.hash.put(id + key, app.hash.get(key)));
	}

	public Tag getTagAt(String id)
	{
		HashMap<String, Object> ht = new HashMap<String, Object>();

		Set<String> en = this.hash.keySet();

		en.stream().forEach(key ->
		{
			if (key.startsWith(id))
			{
				ht.put(key.replaceAll(id, ""), this.hash.get(key));
			}
		});
		return new Tag(ht);
	}

	public int getInt(String id)
	{
		try
		{
			return (int) this.hash.get(id);
		}
		catch (Exception e)
		{
			return 0;
		}
	}

	public double getDouble(String id)
	{
		try
		{
			return (double) this.hash.get(id);
		}
		catch (Exception e)
		{
			return 0.0d;
		}
	}

	public float getFloat(String id)
	{
		try
		{
			return (float) this.hash.get(id);
		}
		catch (Exception e)
		{
			return 0.0f;
		}
	}

	public String getString(String id)
	{
		try
		{
			return (String) this.hash.get(id);
		}
		catch (Exception e)
		{
			return "";
		}
	}

	public boolean getBoolean(String id)
	{
		try
		{
			return (boolean) this.hash.get(id);
		}
		catch (Exception e)
		{
			return false;
		}
	}

	public boolean containsKey(String key)
	{
		return this.hash.containsKey(key);
	}
}
