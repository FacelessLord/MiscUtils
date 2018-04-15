package UCS;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EventBus
{
	public List<Class<? extends Object>> ehs = new ArrayList<Class<? extends Object>>();
	public HashMap<Class<? extends Object>, List<String>> map = new HashMap<Class<? extends Object>, List<String>>();

	public void addHandler(Class<? extends Object> eh)
	{
		if (eh.isAnnotationPresent(EventHandler.class))
			this.ehs.add(eh);
		Class<?> clazz = eh;
		Method[] methods = clazz.getDeclaredMethods();
		List<String> l = new ArrayList<String>();
		for (int i = 0; i < methods.length; i++)
		{
			Method m = methods[i];
			if (m.isAnnotationPresent(SubscribeEvent.class))
			{
				Type par = m.getParameterTypes()[0];
				// Logger.info(par.toString().substring(par.toString().indexOf("$")
				// + 1));
				l.add(par.toString().substring(par.toString().indexOf("$") + 1));
			}
		}
		// Logger.info(l);
		map.put(eh, l);
	}

	public void raiseEvent(Event e)
	{
		for (Class<? extends Object> eh : this.ehs)
		{
			if (map.get(eh).contains(e.getClass().getSimpleName()))
			{
				Class<?> clazz = eh;
				Method[] methods = clazz.getDeclaredMethods();

				for (int i = 0; i < methods.length; i++)
				{
					if (!e.canceled)
					{
						Method m = methods[i];
						if (m.isAnnotationPresent(SubscribeEvent.class))
						{
							Class<?> par = m.getParameterTypes()[0];
							// Logger.info(par.isInstance(e));
							try
							{
								// m.invoke(eh, par.cast(e));
							}
							catch (Exception e1)
							{
								e1.printStackTrace();
							}
						}
					}
				}
			}
		}
	}

}
