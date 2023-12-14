import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AreaTest {
	double length  = 20;
	double breadth = 10;
	Area area = new Area(length, breadth);
	double result = area.returnArea();
	@Test
	public void checkArea() {
		System.out.println("Inside checkArea");
		assertEquals(200, result, 0);
	}

}
