public class And extends ElementoLogico
{
	private Boolean input1;
	private Boolean input2;
	private Boolean output;

	public void setInput(Boolean value, int where)
	{
		if(where == 1)
			input1 = value;
		else
			input2 = value;
	}

	public Boolean getOutput()
	{
		output = input1 && input2;
		return output;
	}

}