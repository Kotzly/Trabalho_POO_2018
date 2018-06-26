public class IO extends ElementoLogico
{
	//OUTPUT
	private Boolean output;

	public IO(String nome)
	{
		super(nome);
	}

	//SET OUTPUT AS THE SAME VALUE OF INPUT
	public void setInput(Boolean value, int i)
	{
		output = value;
	}

	//RETURN OUTPUT VALUE AS HIMSELF
	public Boolean getOutput()
	{
		return output;
	}

}