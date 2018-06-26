public class FlipFlop extends ElementoLogico
{
	private Boolean state;
	private Boolean clock;
	private Boolean prev_clock = false;

	public FlipFlop(String nome)
	{
		super(nome);
	}

	@Override
	public void setInput(Boolean value, int where)
	{
		if(where == 0 && (prev_clock == false && clock == true))
		{
			prev_clock = true;
			state = value;
		}
		else
		{
			prev_clock = !value;
			clock = value;
		}
	}

	@Override
	public Boolean getOutput()
	{
		return state;
	}
}