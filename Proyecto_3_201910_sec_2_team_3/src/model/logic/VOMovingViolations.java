package model.logic;

import java.util.Comparator;


public class VOMovingViolations implements Comparable<VOMovingViolations> 
{

	private int objectId;
	private double latitud; 
	private double longitud;

	public VOMovingViolations(int pId,double pLatitud,double pLongiutd)
	{
		objectId=pId;
		latitud = pLatitud; 
		longitud = pLongiutd;
	}

	public int getId()
	{
		return objectId;
	}
	public double getLatitud()
	{
		return latitud;
	}

	public double getLongitud()
	{
		return longitud;
	}

	public int compareTo(VOMovingViolations cmp) 
	{
		return 0;
	}

	public String toString()
	{
		return "Object ID: "+ objectId+" Latitud: "+latitud+" Longitud: "+longitud;
	}
}

