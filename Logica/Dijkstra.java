import java.util.*;

public class Dijkstra 
{
	
	public Boolean dijkstra(int [][] grafo, int source, int destiny)
	{
		ArrayList<Boolean> verticesVerificados = new ArrayList<Boolean>();
		ArrayList<Integer> distanciaRelativa = new ArrayList<Integer>();
		ArrayList<Integer> nosVizinhos = new ArrayList<Integer>();
		
		for(int i = 0; i < grafo[0].length; i++)
		{
			verticesVerificados.add(false);
			nosVizinhos.add(0);
			distanciaRelativa.add(Integer.MAX_VALUE);
		}
		
		distanciaRelativa.set(0, new Integer(0));
		
		int pontoAvaliado = source;
		
		for(int contadorPontosAvaliados = 0; contadorPontosAvaliados < grafo[0].length; contadorPontosAvaliados++)
		{
			for(int contadorVizinhos = 0; contadorVizinhos < grafo[0].length; contadorVizinhos++)
			{

				if((verticesVerificados.get(contadorVizinhos)) || (contadorVizinhos == pontoAvaliado))
				{
					continue;
				}
				
				if((grafo[pontoAvaliado][contadorVizinhos] > 0) && ((grafo[pontoAvaliado][contadorVizinhos] + distanciaRelativa.get(pontoAvaliado) < distanciaRelativa.get(contadorVizinhos))))
				{
					distanciaRelativa.set(contadorVizinhos, grafo[pontoAvaliado][contadorVizinhos] + distanciaRelativa.get(pontoAvaliado));
					nosVizinhos.set(contadorVizinhos, pontoAvaliado);	
				}
			}
			
			verticesVerificados.set(pontoAvaliado, true);
			
			pontoAvaliado = new Integer(0);
			Integer distanciaComparada = new Integer(Integer.MAX_VALUE);

			for(int i = 1; i < verticesVerificados.size(); i++)
			{
				
				if(verticesVerificados.get(i))
				{
					continue;
				}
				
				if(distanciaRelativa.get(i) < distanciaComparada)
				{
					distanciaComparada = distanciaRelativa.get(i);
					pontoAvaliado = i;
				}
				
			}
			
		}
		
		int [][] resultado = new int [grafo[0].length][grafo[0].length];
		

		for(int i = 0; i < nosVizinhos.size(); i++)
		{
			resultado[i][nosVizinhos.get(i)] = grafo[i][nosVizinhos.get(i)];
			resultado[nosVizinhos.get(i)][i] = resultado[i][nosVizinhos.get(i)];
		}
		
		if(resultado[source][destiny] != Integer.MAX_VALUE && resultado[source][destiny] != 0)
			return true;
		else 
			return false;
	}
}