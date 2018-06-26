public class NXor extends ElementoLogico
{
	//NOR AS OR + NOT
	private Xor in1 =  new Xor("nome");
	private Not in2 = new Not("nome");

	public NXor(String nome)
	{
		super(nome);
	}

	//SET XOR INPUT AS VALUE AT WHERE, AND SET NOT INPUT AS XOR OUTPUT
	@Override
	public void setInput(Boolean value, int where)
	{
		in1.setInput(value, where);
		in2.setInput(in1.getOutput(), 0);
	}

	//RETURN AS NXOR OUTPUT THE NOT(XOR) OUTPUT
	@Override
	public Boolean getOutput()
	{
		return in2.getOutput();
	}
}