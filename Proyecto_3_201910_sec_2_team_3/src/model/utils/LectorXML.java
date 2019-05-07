package model.utils;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import controller.Controller;

import model.data_structures.*;
import model.logic.*;

public class LectorXML extends DefaultHandler 
{
	boolean isHighway = false;
	ArregloDinamico <Long> adj=new ArregloDinamico<Long>(45000);
	Long idWay=null;

	public void startElement(String uri, String localName, String qName, Attributes attr) throws SAXException 
	{
		if(qName.equalsIgnoreCase("node"))
		{
			Long id=Long.parseLong(attr.getValue("id"));
			double lon=Double.parseDouble(attr.getValue("lon"));
			double lat=Double.parseDouble(attr.getValue("lat"));
			Controller.grafo.addVertex(id,new Intersection(id,lat,lon));
		}
		
		if(qName.equalsIgnoreCase("way"))
		{
			idWay=Long.parseLong(attr.getValue("id"));
		}
		
		if (qName.equalsIgnoreCase("nd"))
		{
			adj.agregar(Long.parseLong(attr.getValue("ref")));
		}
		
		if (qName.equalsIgnoreCase("tag"))
		{
			if(attr.getValue("k").equalsIgnoreCase("highway"))
			{
				isHighway=true;
			}
		}
	}

	public void endElement(String uri, String localName, String qName) throws SAXException 
	{
		if (qName.equalsIgnoreCase("way") && isHighway) 
		{
			for (int i=0;i<adj.darTamanio()-1;i++) 
			{
				Intersection I1=Controller.grafo.getInfoVertex(adj.darElemento(i));
				Intersection I2=Controller.grafo.getInfoVertex(adj.darElemento(i+1));
				Controller.grafo.addEdge(adj.darElemento(i),adj.darElemento(i+1),new Way(Haversine.distance(I1.getLat(),I1.getLon(),I2.getLat(),I2.getLon()),idWay));
			}   
			adj=new ArregloDinamico<Long>(45000);
			isHighway=false;
		}
	}
}