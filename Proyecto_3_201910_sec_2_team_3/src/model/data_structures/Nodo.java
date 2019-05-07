package model.data_structures;

public class Nodo<T> 
{
	/**
	 * Constante de serializaci�n
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Nodo anterior.
	 */
	//TODO Declarar el nodo anterior.
	
	private Nodo<T> anterior; 
	
	private Nodo<T> siguiente;
	
	private T elemento;
	
	/**
	 * M�todo constructor del nodo doblemente encadenado
	 * @param elemento elemento que se almacenar� en el nodo.
	 */
	public Nodo(T pElemento) 
	{
		elemento = pElemento;
		siguiente = null;
		anterior=null;
	}
	
	/**
	 * M�todo que retorna el nodo anterior.
	 * @return Nodo anterior.
	 */
	public Nodo<T> darAnterior()
	{
		//TODO Completar el m�todo de acuerdo a la documentaci�n.
		return anterior;
	}
	
	/**
	 * M�todo que cambia el nodo anterior por el que llega como par�metro.
	 * @param anterior Nuevo nodo anterior.
	 */
	public void cambiarAnterior(Nodo<T> pAnterior)
	{
		//TODO Completar el m�todo de acuerdo a la documentaci�n.
	
		anterior = pAnterior;
	}

	
	/**
	 * M�todo que retorna el siguiente nodo.
	 * @return Siguiente nodo
	 */
	public Nodo<T> darSiguiente()
	{
		//TODO Completar el m�todo de acuerdo a la documentaci�n.
		return siguiente;
	}

	/**
	 * M�todo que cambia el siguiente nodo.
	 * <b>post: </b> Se ha cambiado el siguiente nodo
	 * @param siguiente El nuevo siguiente nodo
	 */
	public void cambiarSiguiente(Nodo<T> pSiguiente)
	{
		//TODO Completar el m�todo de acuerdo a la documentaci�n.
		siguiente = pSiguiente;
	}
	
	/**
	 * M�todo que retorna el elemento almacenado en el nodo.
	 * @return El elemento almacenado en el nodo.
	 */
	public T darElemento()
	{
		//TODO Completar el m�todo de acuerdo a la documentaci�n.
		return elemento;
	}
	
	/**
	 * Cambia el elemento almacenado en el nodo.
	 * @param elemento El nuevo elemento que se almacenar� en el nodo.
	 */
	public void cambiarElemento(T pElemento)
	{
		//TODO Completar el m�todo de acuerdo a la documentaci�n.
		elemento = pElemento;
	}
}