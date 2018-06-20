public class IO extends ElementoLogico
{
	//OUTPUT
	private Boolean output;

	//SET OUTPUT AS THE SAME VALUE OF INPUT
	public void setInput(Boolean value)
	{
		output = value
	}

	//RETURN OUTPUT VALUE AS HIMSELF
	public Boolean getOutput()
	{
		return output;
	}

}