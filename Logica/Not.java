public class Not extends ElementoLogico
{	
	//NOT INPUT
	private Boolean input;
	//NOT OUTPUT
	private Boolean output;

	public Not(String nome)
	{
		super(nome);
	}

	//SET INPUT VALUE
	@Override
	public void setInput(Boolean value, int where)
	{
		input = value;
	}

	//GET OUTPUT BY NOT LOGIC OPERATION
	@Override
	public Boolean getOutput()
	{
		output = !input;
		return output;
	}
}