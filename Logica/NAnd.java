public class NAnd extends ElementoLogico
{	
	//NAND AS AND + NOT
	private And in1 =  new And("nome");
	private Not in2 = new Not("nome");

	public NAnd(String nome)
	{
		super(nome);
	}

	//SET AND INPUT AS VALUE AT WHERE, AND SET NOT INPUT AS AND OUTPUT
	public void setInput(Boolean value, int where)
	{
		in1.setInput(value, where);
		in2.setInput(in1.getOutput());
	}

	//RETURN AS NAND OUTPUT THE NOT(AND) OUTPUT
	public Boolean getOutput()
	{
		return in2.getOutput();
	}
}