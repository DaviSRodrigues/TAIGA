package davi.test.esqueletizacao;

import static org.junit.Assert.*;

import org.junit.Test;

import davi.genetic.algorithm.Image;

public class ThinningTest {
	@Test
	public void testThinningA()
	{
		Image image = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Imagens\\a.png");
		Image oracleResult = null, testResult = null;
		
		try {
			oracleResult = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Esqueletizacao\\a.png");
			testResult = Thinning.esqueletizar(image.clone());
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
		int width = oracleResult.getWidth(), height = oracleResult.getHeight();
		int[] oracle = new int[width * height], test = new int[width * height];
		
		oracleResult.getBufferedImage().getRGB(0, 0, width, height, oracle, 0, width);
		testResult.getBufferedImage().getRGB(0, 0, width, height, test, 0, width);
		
		assertArrayEquals(oracle, test);
	}

	@Test
	public void testThinningB()
	{
		Image image = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Imagens\\b.png");
		Image oracleResult = null, testResult = null;
		
		try {
			oracleResult = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Esqueletizacao\\b.png");
			testResult = Thinning.esqueletizar(image.clone());
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
		int width = oracleResult.getWidth(), height = oracleResult.getHeight();
		int[] oracle = new int[width * height], test = new int[width * height];
		
		oracleResult.getBufferedImage().getRGB(0, 0, width, height, oracle, 0, width);
		testResult.getBufferedImage().getRGB(0, 0, width, height, test, 0, width);
		
		assertArrayEquals(oracle, test);
	}

	@Test
	public void testThinningC()
	{
		Image image = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Imagens\\c.png");
		Image oracleResult = null, testResult = null;
		
		try {
			oracleResult = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Esqueletizacao\\c.png");
			testResult = Thinning.esqueletizar(image.clone());
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
		int width = oracleResult.getWidth(), height = oracleResult.getHeight();
		int[] oracle = new int[width * height], test = new int[width * height];
		
		oracleResult.getBufferedImage().getRGB(0, 0, width, height, oracle, 0, width);
		testResult.getBufferedImage().getRGB(0, 0, width, height, test, 0, width);
		
		assertArrayEquals(oracle, test);
	}

	@Test
	public void testThinningD()
	{
		Image image = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Imagens\\d.png");
		Image oracleResult = null, testResult = null;
		
		try {
			oracleResult = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Esqueletizacao\\d.png");
			testResult = Thinning.esqueletizar(image.clone());
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
		int width = oracleResult.getWidth(), height = oracleResult.getHeight();
		int[] oracle = new int[width * height], test = new int[width * height];
		
		oracleResult.getBufferedImage().getRGB(0, 0, width, height, oracle, 0, width);
		testResult.getBufferedImage().getRGB(0, 0, width, height, test, 0, width);
		
		assertArrayEquals(oracle, test);
	}

	@Test
	public void testThinningE()
	{
		Image image = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Imagens\\e.png");
		Image oracleResult = null, testResult = null;
		
		try {
			oracleResult = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Esqueletizacao\\e.png");
			testResult = Thinning.esqueletizar(image.clone());
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
		int width = oracleResult.getWidth(), height = oracleResult.getHeight();
		int[] oracle = new int[width * height], test = new int[width * height];
		
		oracleResult.getBufferedImage().getRGB(0, 0, width, height, oracle, 0, width);
		testResult.getBufferedImage().getRGB(0, 0, width, height, test, 0, width);
		
		assertArrayEquals(oracle, test);
	}

	@Test
	public void testThinningF()
	{
		Image image = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Imagens\\f.png");
		Image oracleResult = null, testResult = null;
		
		try {
			oracleResult = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Esqueletizacao\\f.png");
			testResult = Thinning.esqueletizar(image.clone());
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
		int width = oracleResult.getWidth(), height = oracleResult.getHeight();
		int[] oracle = new int[width * height], test = new int[width * height];
		
		oracleResult.getBufferedImage().getRGB(0, 0, width, height, oracle, 0, width);
		testResult.getBufferedImage().getRGB(0, 0, width, height, test, 0, width);
		
		assertArrayEquals(oracle, test);
	}

	@Test
	public void testThinningG()
	{
		Image image = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Imagens\\g.png");
		Image oracleResult = null, testResult = null;
		
		try {
			oracleResult = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Esqueletizacao\\g.png");
			testResult = Thinning.esqueletizar(image.clone());
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
		int width = oracleResult.getWidth(), height = oracleResult.getHeight();
		int[] oracle = new int[width * height], test = new int[width * height];
		
		oracleResult.getBufferedImage().getRGB(0, 0, width, height, oracle, 0, width);
		testResult.getBufferedImage().getRGB(0, 0, width, height, test, 0, width);
		
		assertArrayEquals(oracle, test);
	}

	@Test
	public void testThinningH()
	{
		Image image = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Imagens\\h.png");
		Image oracleResult = null, testResult = null;
		
		try {
			oracleResult = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Esqueletizacao\\h.png");
			testResult = Thinning.esqueletizar(image.clone());
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
		int width = oracleResult.getWidth(), height = oracleResult.getHeight();
		int[] oracle = new int[width * height], test = new int[width * height];
		
		oracleResult.getBufferedImage().getRGB(0, 0, width, height, oracle, 0, width);
		testResult.getBufferedImage().getRGB(0, 0, width, height, test, 0, width);
		
		assertArrayEquals(oracle, test);
	}

	@Test
	public void testThinningI()
	{
		Image image = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Imagens\\i.png");
		Image oracleResult = null, testResult = null;
		
		try {
			oracleResult = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Esqueletizacao\\i.png");
			testResult = Thinning.esqueletizar(image.clone());
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
		int width = oracleResult.getWidth(), height = oracleResult.getHeight();
		int[] oracle = new int[width * height], test = new int[width * height];
		
		oracleResult.getBufferedImage().getRGB(0, 0, width, height, oracle, 0, width);
		testResult.getBufferedImage().getRGB(0, 0, width, height, test, 0, width);
		
		assertArrayEquals(oracle, test);
	}

	@Test
	public void testThinningJ()
	{
		Image image = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Imagens\\j.png");
		Image oracleResult = null, testResult = null;
		
		try {
			oracleResult = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Esqueletizacao\\j.png");
			testResult = Thinning.esqueletizar(image.clone());
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
		int width = oracleResult.getWidth(), height = oracleResult.getHeight();
		int[] oracle = new int[width * height], test = new int[width * height];
		
		oracleResult.getBufferedImage().getRGB(0, 0, width, height, oracle, 0, width);
		testResult.getBufferedImage().getRGB(0, 0, width, height, test, 0, width);
		
		assertArrayEquals(oracle, test);
	}

	@Test
	public void testThinningK()
	{
		Image image = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Imagens\\k.png");
		Image oracleResult = null, testResult = null;
		
		try {
			oracleResult = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Esqueletizacao\\k.png");
			testResult = Thinning.esqueletizar(image.clone());
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
		int width = oracleResult.getWidth(), height = oracleResult.getHeight();
		int[] oracle = new int[width * height], test = new int[width * height];
		
		oracleResult.getBufferedImage().getRGB(0, 0, width, height, oracle, 0, width);
		testResult.getBufferedImage().getRGB(0, 0, width, height, test, 0, width);
		
		assertArrayEquals(oracle, test);
	}

	@Test
	public void testThinningL()
	{
		Image image = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Imagens\\l.png");
		Image oracleResult = null, testResult = null;
		
		try {
			oracleResult = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Esqueletizacao\\l.png");
			testResult = Thinning.esqueletizar(image.clone());
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
		int width = oracleResult.getWidth(), height = oracleResult.getHeight();
		int[] oracle = new int[width * height], test = new int[width * height];
		
		oracleResult.getBufferedImage().getRGB(0, 0, width, height, oracle, 0, width);
		testResult.getBufferedImage().getRGB(0, 0, width, height, test, 0, width);
		
		assertArrayEquals(oracle, test);
	}

	@Test
	public void testThinningM()
	{
		Image image = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Imagens\\m.png");
		Image oracleResult = null, testResult = null;
		
		try {
			oracleResult = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Esqueletizacao\\m.png");
			testResult = Thinning.esqueletizar(image.clone());
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
		int width = oracleResult.getWidth(), height = oracleResult.getHeight();
		int[] oracle = new int[width * height], test = new int[width * height];
		
		oracleResult.getBufferedImage().getRGB(0, 0, width, height, oracle, 0, width);
		testResult.getBufferedImage().getRGB(0, 0, width, height, test, 0, width);
		
		assertArrayEquals(oracle, test);
	}

	@Test
	public void testThinningN()
	{
		Image image = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Imagens\\n.png");
		Image oracleResult = null, testResult = null;
		
		try {
			oracleResult = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Esqueletizacao\\n.png");
			testResult = Thinning.esqueletizar(image.clone());
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
		int width = oracleResult.getWidth(), height = oracleResult.getHeight();
		int[] oracle = new int[width * height], test = new int[width * height];
		
		oracleResult.getBufferedImage().getRGB(0, 0, width, height, oracle, 0, width);
		testResult.getBufferedImage().getRGB(0, 0, width, height, test, 0, width);
		
		assertArrayEquals(oracle, test);
	}

	@Test
	public void testThinningO()
	{
		Image image = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Imagens\\o.png");
		Image oracleResult = null, testResult = null;
		
		try {
			oracleResult = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Esqueletizacao\\o.png");
			testResult = Thinning.esqueletizar(image.clone());
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
		int width = oracleResult.getWidth(), height = oracleResult.getHeight();
		int[] oracle = new int[width * height], test = new int[width * height];
		
		oracleResult.getBufferedImage().getRGB(0, 0, width, height, oracle, 0, width);
		testResult.getBufferedImage().getRGB(0, 0, width, height, test, 0, width);
		
		assertArrayEquals(oracle, test);
	}

	@Test
	public void testThinningP()
	{
		Image image = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Imagens\\p.png");
		Image oracleResult = null, testResult = null;
		
		try {
			oracleResult = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Esqueletizacao\\p.png");
			testResult = Thinning.esqueletizar(image.clone());
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
		int width = oracleResult.getWidth(), height = oracleResult.getHeight();
		int[] oracle = new int[width * height], test = new int[width * height];
		
		oracleResult.getBufferedImage().getRGB(0, 0, width, height, oracle, 0, width);
		testResult.getBufferedImage().getRGB(0, 0, width, height, test, 0, width);
		
		assertArrayEquals(oracle, test);
	}

	@Test
	public void testThinningQ()
	{
		Image image = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Imagens\\q.png");
		Image oracleResult = null, testResult = null;
		
		try {
			oracleResult = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Esqueletizacao\\q.png");
			testResult = Thinning.esqueletizar(image.clone());
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
		int width = oracleResult.getWidth(), height = oracleResult.getHeight();
		int[] oracle = new int[width * height], test = new int[width * height];
		
		oracleResult.getBufferedImage().getRGB(0, 0, width, height, oracle, 0, width);
		testResult.getBufferedImage().getRGB(0, 0, width, height, test, 0, width);
		
		assertArrayEquals(oracle, test);
	}

	@Test
	public void testThinningR()
	{
		Image image = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Imagens\\r.png");
		Image oracleResult = null, testResult = null;
		
		try {
			oracleResult = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Esqueletizacao\\r.png");
			testResult = Thinning.esqueletizar(image.clone());
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
		int width = oracleResult.getWidth(), height = oracleResult.getHeight();
		int[] oracle = new int[width * height], test = new int[width * height];
		
		oracleResult.getBufferedImage().getRGB(0, 0, width, height, oracle, 0, width);
		testResult.getBufferedImage().getRGB(0, 0, width, height, test, 0, width);
		
		assertArrayEquals(oracle, test);
	}

	@Test
	public void testThinningS()
	{
		Image image = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Imagens\\s.png");
		Image oracleResult = null, testResult = null;
		
		try {
			oracleResult = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Esqueletizacao\\s.png");
			testResult = Thinning.esqueletizar(image.clone());
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
		int width = oracleResult.getWidth(), height = oracleResult.getHeight();
		int[] oracle = new int[width * height], test = new int[width * height];
		
		oracleResult.getBufferedImage().getRGB(0, 0, width, height, oracle, 0, width);
		testResult.getBufferedImage().getRGB(0, 0, width, height, test, 0, width);
		
		assertArrayEquals(oracle, test);
	}

	@Test
	public void testThinningT()
	{
		Image image = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Imagens\\t.png");
		Image oracleResult = null, testResult = null;
		
		try {
			oracleResult = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Esqueletizacao\\t.png");
			testResult = Thinning.esqueletizar(image.clone());
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
		int width = oracleResult.getWidth(), height = oracleResult.getHeight();
		int[] oracle = new int[width * height], test = new int[width * height];
		
		oracleResult.getBufferedImage().getRGB(0, 0, width, height, oracle, 0, width);
		testResult.getBufferedImage().getRGB(0, 0, width, height, test, 0, width);
		
		assertArrayEquals(oracle, test);
	}

	@Test
	public void testThinningU()
	{
		Image image = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Imagens\\u.png");
		Image oracleResult = null, testResult = null;
		
		try {
			oracleResult = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Esqueletizacao\\u.png");
			testResult = Thinning.esqueletizar(image.clone());
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
		int width = oracleResult.getWidth(), height = oracleResult.getHeight();
		int[] oracle = new int[width * height], test = new int[width * height];
		
		oracleResult.getBufferedImage().getRGB(0, 0, width, height, oracle, 0, width);
		testResult.getBufferedImage().getRGB(0, 0, width, height, test, 0, width);
		
		assertArrayEquals(oracle, test);
	}

	@Test
	public void testThinningV()
	{
		Image image = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Imagens\\v.png");
		Image oracleResult = null, testResult = null;
		
		try {
			oracleResult = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Esqueletizacao\\v.png");
			testResult = Thinning.esqueletizar(image.clone());
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
		int width = oracleResult.getWidth(), height = oracleResult.getHeight();
		int[] oracle = new int[width * height], test = new int[width * height];
		
		oracleResult.getBufferedImage().getRGB(0, 0, width, height, oracle, 0, width);
		testResult.getBufferedImage().getRGB(0, 0, width, height, test, 0, width);
		
		assertArrayEquals(oracle, test);
	}

	@Test
	public void testThinningW()
	{
		Image image = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Imagens\\w.png");
		Image oracleResult = null, testResult = null;
		
		try {
			oracleResult = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Esqueletizacao\\w.png");
			testResult = Thinning.esqueletizar(image.clone());
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
		int width = oracleResult.getWidth(), height = oracleResult.getHeight();
		int[] oracle = new int[width * height], test = new int[width * height];
		
		oracleResult.getBufferedImage().getRGB(0, 0, width, height, oracle, 0, width);
		testResult.getBufferedImage().getRGB(0, 0, width, height, test, 0, width);
		
		assertArrayEquals(oracle, test);
	}

	@Test
	public void testThinningX()
	{
		Image image = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Imagens\\x.png");
		Image oracleResult = null, testResult = null;
		
		try {
			oracleResult = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Esqueletizacao\\x.png");
			testResult = Thinning.esqueletizar(image.clone());
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
		int width = oracleResult.getWidth(), height = oracleResult.getHeight();
		int[] oracle = new int[width * height], test = new int[width * height];
		
		oracleResult.getBufferedImage().getRGB(0, 0, width, height, oracle, 0, width);
		testResult.getBufferedImage().getRGB(0, 0, width, height, test, 0, width);
		
		assertArrayEquals(oracle, test);
	}

	@Test
	public void testThinningY()
	{
		Image image = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Imagens\\y.png");
		Image oracleResult = null, testResult = null;
		
		try {
			oracleResult = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Esqueletizacao\\y.png");
			testResult = Thinning.esqueletizar(image.clone());
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
		int width = oracleResult.getWidth(), height = oracleResult.getHeight();
		int[] oracle = new int[width * height], test = new int[width * height];
		
		oracleResult.getBufferedImage().getRGB(0, 0, width, height, oracle, 0, width);
		testResult.getBufferedImage().getRGB(0, 0, width, height, test, 0, width);
		
		assertArrayEquals(oracle, test);
	}

	@Test
	public void testThinningZ()
	{
		Image image = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Imagens\\z.png");
		Image oracleResult = null, testResult = null;
		
		try {
			oracleResult = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Esqueletizacao\\z.png");
			testResult = Thinning.esqueletizar(image.clone());
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
		int width = oracleResult.getWidth(), height = oracleResult.getHeight();
		int[] oracle = new int[width * height], test = new int[width * height];
		
		oracleResult.getBufferedImage().getRGB(0, 0, width, height, oracle, 0, width);
		testResult.getBufferedImage().getRGB(0, 0, width, height, test, 0, width);
		
		assertArrayEquals(oracle, test);
	}
}
