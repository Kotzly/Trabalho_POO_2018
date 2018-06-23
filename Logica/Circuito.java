import java.util.*;
public class Circuito
{
	//CIRCUIT REPRESENTED AS A GRAPH IN ADJACENCE MATRIX
	public int circuito[][] = new int[1000][1000];
	private Map<Integer,ElementoLogico> mapa = new HashMap<Integer,ElementoLogico>();
	private Map<String,Integer> indice = new HashMap<String,Integer>();
	private int circuitSize = 0;
	private String nome;

	//ADD 
	public void add(int elemento, String nome)
	{	
		ElementoLogico novo;
		if(elemento == 1)
		{
			novo = new Not(nome);
			indice.put(novo.getNome(), circuitSize);
			mapa.put(circuitSize++, novo);
		}
		else if(elemento == 2)
		{
			novo = new IO(nome);
			indice.put(novo.getNome(), circuitSize);
			mapa.put(circuitSize++, novo);
		}
		else if(elemento == 3)
		{
			novo = new And(nome);
			indice.put(novo.getNome(), circuitSize);
			mapa.put(circuitSize++, novo);
		}
		else if(elemento == 4)
		{
			novo = new Or(nome);
			indice.put(novo.getNome(), circuitSize);
			mapa.put(circuitSize++, novo);
		}
		else if(elemento == 5)
		{
			novo = new Xor(nome);
			indice.put(novo.getNome(), circuitSize);
			mapa.put(circuitSize++, novo);
		}
		else if(elemento == 6)
		{
			novo = new NAnd(nome);
			indice.put(novo.getNome(), circuitSize);
			mapa.put(circuitSize++, novo);
		}
		else if(elemento == 7)
		{
			novo = new NXor(nome);
			indice.put(novo.getNome(), circuitSize);
			mapa.put(circuitSize++, novo);
		}
		else if(elemento == 8)
		{
			novo = new NOr(nome);
			indice.put(novo.getNome(), circuitSize);
			mapa.put(circuitSize++, novo);
		}
	}

	//REMOVE
	public void remove(ElementoLogico removido)
	{
		int key = indice.get(removido.getNome());

		indice.remove(removido.getNome());
		mapa.remove(key);

		for (int i = 0; i < circuitSize; i++)
		{
			circuito[key][i] = 0;
			circuito[i][key] = 0;	
		}
	}

	//LINK
	public void link(ElementoLogico source, ElementoLogico destiny)
	{
		int keyS = indice.get(source.getNome());
		int keyD = indice.get(destiny.getNome());

		circuito[keyS][keyD] = 1; 
		circuito[keyD][keyS] = -1;
	}

	Not not = new Not("Joao");
}