package model.logic;

import model.data_structures.*;;

public class Vertex <K extends Comparable<K>,V ,I extends Comparable<I>> implements Comparable<Vertex<K,V,I>>
{
	private K id;
	private V info;
	private I infoEdge;
	private ArregloDinamico<Edge<I>> adjEdges;

	public Vertex(K pId,V pInfo)
	{
		adjEdges=new  ArregloDinamico<Edge<I>>(10);
		id=pId;
		info=pInfo;
	}	

	public ArregloDinamico<Edge<I>> getAdjEdges()
	{
		return adjEdges;
	}

	public void addEdge(Edge<I> pArco)
	{
		adjEdges.agregar(pArco);
	}

	public I getInfoEdge()
	{
		return infoEdge;
	}

	public K getId()
	{
		return id;
	}

	public V getInfo()
	{
		return info;
	}

	public void update( V infoVertex)
	{
		info = infoVertex;
	}

	@Override
	public int compareTo(Vertex<K,V,I> o) 
	{
		return this.getId().compareTo(o.getId());
	}

}
