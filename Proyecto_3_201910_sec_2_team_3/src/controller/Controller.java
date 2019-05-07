package controller;

import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import com.opencsv.CSVReader;

import model.data_structures.*;
import model.logic.*;
import model.utils.*;
import view.MovingViolationsManagerView;

public class Controller {
	private enum Meses
	{
		February(0), March(0), Abril(0),May(0),June(0),July(0),August(0),September(0),October(0),November(0),December(0);

		private int infracciones;

		private Meses(int cantidad)
		{ 
			this.infracciones = cantidad;
		}

		private void contar()
		{ 
			this.infracciones++; 
		}

		private int darInfracciones()
		{ 
			return infracciones; 
		}
	}
	private MovingViolationsManagerView view;
	private ArregloDinamico<VOMovingViolations> datos;
	public static Graph<Long,Intersection,Way> grafo;
	public Controller() 
	{
		view = new MovingViolationsManagerView();
		datos=new ArregloDinamico<VOMovingViolations>(500000);
		grafo=new Graph<Long,Intersection,Way>();
	}

	public void run() 
	{
		Scanner sc = new Scanner(System.in);
		boolean fin=false;
		Controller controller = new Controller();
		while(!fin)
		{
			view.printMenu();
			int option = sc.nextInt();

			switch(option)
			{
			case 0: 
				this.loadJSON();

			case 1:
				this.loadMovingViolations();
				break;
			case 2: 
				break; 
			case 3: 
				break; 
			case 4: 
				break; 
			case 5:
				break; 
			case 6: 
				break; 
			case 7: 
				break; 
			case 8: 
				break; 
			case 9: 
				break;
			case 10:
				sc.close();
				fin=true;
			}
		}
	}
	public void loadJSON()
	{

	}

	public void loadMovingViolations() 
	{
		
		CSVReader reader;
		String[] nextLine;
		int contadorEnero = 0;

		try
		{
			reader = new CSVReader(new FileReader("./data/"+"January"+"_wgs84.csv"),';');
			nextLine=reader.readNext(); 
			while ((nextLine = reader.readNext()) != null) 
			{				
				datos.agregar(new VOMovingViolations(Integer.parseInt(nextLine[0]),Double.parseDouble(nextLine[17].replace(",", ".")),Double.parseDouble(nextLine[18].replace(",", "."))));
				contadorEnero++;
			}
			view.printMessage("Numero de infracciones en el mes de " + "Enero fueron: " + contadorEnero);
			
			for(Meses meses : Meses.values())
			{
				if(meses.ordinal()<8)
				{
				reader = new CSVReader(new FileReader("./data/"+meses+"_wgs84.csv"),';');
				nextLine=reader.readNext(); 
				while ((nextLine = reader.readNext()) != null) 
				{				
					datos.agregar(new VOMovingViolations(Integer.parseInt(nextLine[1]),Double.parseDouble(nextLine[18].replace(",", ".")),Double.parseDouble(nextLine[19].replace(",", "."))));
					meses.contar();
				}
				view.printMessage("Numero de infracciones en el mes de " + (meses.name()) + ": " + meses.darInfracciones());
				}
				else
				{
					reader = new CSVReader(new FileReader("./data/"+meses+"_wgs84.csv"),';');
					nextLine=reader.readNext(); 
					while ((nextLine = reader.readNext()) != null) 
					{				
						datos.agregar(new VOMovingViolations(Integer.parseInt(nextLine[1]),Double.parseDouble(nextLine[19].replace(",", ".")),Double.parseDouble(nextLine[20].replace(",", "."))));
						meses.contar();
					}
					view.printMessage("Numero de infracciones en el mes de " + (meses.name()) + ": " + meses.darInfracciones());
				}
			}	
		}

		catch(Exception e)
		{ 
			e.printStackTrace(); 
		}
	}
	// 1A 
	public void darRutaMenorCostoDosPuntos()
	{

	}
	//2A
	public void darVerticesMayorInfracciones(int N )
	{
		
	}

	//1B
	public void encontrarCaminoMasCorto()
	{

	}

	//2B
	public void definircuadriculaRegular(double lonMin, double latMin, double lonMax, double latMax)
	{

	}	
}


