public class NXor extends ElementoLogico
{
	//NOR AS OR + NOT
	private Xor in1 =  new Xor();
	private Not in2 = new Not();

	//SET XOR INPUT AS VALUE AT WHERE, AND SET NOT INPUT AS XOR OUTPUT
	public void setInput(Boolean value, int where)
	{
		in1.setInput(value, where);
		in2.setInput(in1.getOutput());
	}

	//RETURN AS NXOR OUTPUT THE NOT(XOR) OUTPUT
	public Boolean getOutput()
	{
		return in2.getOutput();
	}
}