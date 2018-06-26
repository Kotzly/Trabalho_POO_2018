public class NOr extends ElementoLogico
{
	//NOR AS OR + NOT
	private Or in1 =  new Or("nome");
	private Not in2 = new Not("nome");

	public NOr(String nome)
	{
		super(nome);
	}

	//SET OR INPUT AS VALUE AT WHERE, AND SET NOT INPUT AS Or OUTPUT
	@Override
	public void setInput(Boolean value, int where)
	{
		in1.setInput(value, where);
		in2.setInput(in1.getOutput(), 0);
	}

	//RETURN AS NOr OUTPUT THE NOT(OR) OUTPUT
	@Override
	public Boolean getOutput()
	{
		return in2.getOutput();
	}
}