public class Or extends ElementoLogico
{
	//2 OR INPUTS
	private Boolean input1;
	private Boolean input2;
	//1 OR OUTPUT
	private Boolean output;

	public Or(String nome)
	{
		super(nome);
	}

	//SET INPUT(WHERE) VALUE
	@Override
	public void setInput(Boolean value, int where)
	{
		if(where == 1)
			input1 = value;
		else
			input2 = value;
	}

	//GET OUTPUT BY OR LOGIC OPERATION
	@Override
	public Boolean getOutput()
	{
		output = input1 || input2;
		return output;
	}

}