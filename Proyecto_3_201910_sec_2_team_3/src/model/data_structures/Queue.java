package model.data_structures;

import java.util.Iterator;

public class Queue<T> implements IQueue<T> 

{
	// Nodo anterior 
	Nodo<T> nodoAnterior;

	// Nodo siguiente
	Nodo <T> nodoSiguiente;

	// Primer nodo
	Nodo<T> primero;

	// �ltimo nodo
	Nodo<T> ultimo;

	private int tama�o;



	public Queue() 
	{
		// TODO Auto-generated constructor stub
		tama�o = 0;
		primero = null;
		ultimo = null;
	}

	@Override
	public Iterator <T> iterator() 
	{
		// TODO Auto-generated method stub
		Iterator <T> i = null;

		Nodo<T> act = primero;

		while (act != null){
			act = (Nodo<T>) primero.darSiguiente();
			i = (  (Iterator<T>) act );
		}
		return i;
	}

	@Override
	public boolean isEmpty() 
	{
		// TODO Auto-generated method stub
		return primero == null;
	}


	public int size() 
	{
		return tama�o;
	}



	public void enqueue(T t)
	{
		if(primero == null)
		{
			primero = new Nodo<T>(t);
			ultimo = primero;

		}
		else
		{
			ultimo.cambiarSiguiente(new Nodo<T>(t)); 
			ultimo = ultimo.darSiguiente();
		}
		tama�o++;
	
	}

	public T darUltimo()
	{
		return ultimo.darElemento();
	}


	public T dequeue()
	{
		Nodo<T> sacada = primero;

		primero = primero.darSiguiente();
		tama�o--;
		return  sacada.darElemento();
	}
}
