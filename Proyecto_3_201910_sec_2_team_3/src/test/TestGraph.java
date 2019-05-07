package test;

import junit.framework.TestCase;
import model.data_structures.Graph;

public class TestGraph extends TestCase
{
	private Graph <Integer, String, String> prueba;

	public void setUp()
	{
		prueba=new Graph<Integer,String,String>();

		for(int i=0;i<1000;i+=2)
		{
			prueba.addVertex(i, "a"+i);
			prueba.addVertex(i, "a"+(i+1));
//			prueba.addEdge(prueba, prueba.V(), prueba.in);
		}
	}

	public void testE()
	{
		assertEquals(10000,prueba.E());
	}

	public void testV()
	{
		assertEquals(2,prueba.V());
	}

	public void testGetInfoVertex()
	{
		assertEquals("a5",prueba.getInfoVertex(5));
	}

	public void testGetInfoArc()
	{
		assertEquals("a5",prueba.getInfoArc(2, 3));
	}

	public void testIterator()
	{
		assertNotNull("Hola");
	}
}
