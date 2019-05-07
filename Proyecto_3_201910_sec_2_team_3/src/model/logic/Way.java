package model.logic;

public class Way implements Comparable<Way>
{
	private Long id;
	private double distance;
	public Way( double pDistance, Long pId )
	{
		id=pId;
		distance=pDistance;
	}

	public Long getId()
	{
		return id;
	}

	public double getDistance()
	{
		return distance;
	}

	@Override
	public int compareTo(Way arg0) {
		return (int) (this.getDistance()-arg0.getDistance());
	}
}