package model.logic;

public class Intersection implements Comparable<Intersection>
{
	private Long id;
	private double lat;
	private double lon;

	public Intersection(Long pId, double pLat, double pLon)
	{
		id=pId;
		lat=pLat;
		lon=pLon;
	}

	public Long getId()
	{
		return id;
	}

	public double getLat()
	{
		return lat;
	}

	public double getLon()
	{
		return lon;
	}

	public int compareTo(Intersection o) 
	{
		return (int) (id-o.getId());
	}
}