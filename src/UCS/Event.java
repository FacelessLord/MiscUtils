package UCS;

public class Event
{
	boolean isCancelable = false;
	boolean canceled = false;

	public void setCanceled(boolean cancel)
	{
		this.canceled = cancel;
	}

	public boolean isCanceled()
	{
		return this.canceled;
	}
}
