public class Not extends ElementoLogico
{	
	//NOT INPUT
	private Boolean input;
	//NOT OUTPUT
	private Boolean output;

	//SET INPUT VALUE
	public void setInput(Boolean value)
	{
		input = value;
	}

	//GET OUTPUT BY NOT LOGIC OPERATION
	public Boolean getOutput()
	{
		output = !input;
		return output;
	}
}