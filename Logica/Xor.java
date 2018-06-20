public class Xor extends ElementoLogico
{
	//2 XOR INPUTS
	private Boolean input1;
	private Boolean input2;
	//1 XOR OUTPUT
	private Boolean output;

	//SET INPUT(WHERE) VALUE
	public void setInput(Boolean value, int where)
	{
		if(where == 1)
			input1 = value;
		else
			input2 = value;
	}

	//GET OUTPUT BY XOR LOGIC OPERATION
	public Boolean getOutput()
	{
		output = input1 ^ input2;
		return output;
	}
}