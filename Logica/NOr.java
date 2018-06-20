public class NOr extends ElementoLogico
{
	//NOR AS OR + NOT
	private Or in1 =  new Or();
	private Not in2 = new Not();

	//SET OR INPUT AS VALUE AT WHERE, AND SET NOT INPUT AS Or OUTPUT
	public void setInput(Boolean value, int where)
	{
		in1.setInput(value, where);
		in2.setInput(in1.getOutput());
	}

	//RETURN AS NOr OUTPUT THE NOT(OR) OUTPUT
	public Boolean getOutput()
	{
		return in2.getOutput();
	}
}