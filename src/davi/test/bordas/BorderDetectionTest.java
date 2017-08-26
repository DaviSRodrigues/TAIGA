package davi.test.bordas;

import static org.junit.Assert.*;

import org.junit.Test;

import davi.genetic.algorithm.Image;

public class BorderDetectionTest {
	@Test
	public void testBorderDetectionA()
	{
		Image image = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Imagens\\a.png");
		Image oracleResult = null, testResult = null;
		
		try {
			oracleResult = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Bordas\\a_bordas.png");
			testResult = BorderDetection.metodoGradiente(image.clone());
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
	public void testBorderDetectionB()
	{
		Image image = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Imagens\\b.png");
		Image oracleResult = null, testResult = null;
		
		try {
			oracleResult = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Bordas\\b_bordas.png");
			testResult = BorderDetection.metodoGradiente(image.clone());
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
	public void testBorderDetectionC()
	{
		Image image = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Imagens\\c.png");
		Image oracleResult = null, testResult = null;
		
		try {
			oracleResult = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Bordas\\c_bordas.png");
			testResult = BorderDetection.metodoGradiente(image.clone());
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
	public void testBorderDetectionD()
	{
		Image image = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Imagens\\d.png");
		Image oracleResult = null, testResult = null;
		
		try {
			oracleResult = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Bordas\\d_bordas.png");
			testResult = BorderDetection.metodoGradiente(image.clone());
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
	public void testBorderDetectionE()
	{
		Image image = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Imagens\\e.png");
		Image oracleResult = null, testResult = null;
		
		try {
			oracleResult = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Bordas\\e_bordas.png");
			testResult = BorderDetection.metodoGradiente(image.clone());
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
	public void testBorderDetectionF()
	{
		Image image = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Imagens\\f.png");
		Image oracleResult = null, testResult = null;
		
		try {
			oracleResult = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Bordas\\f_bordas.png");
			testResult = BorderDetection.metodoGradiente(image.clone());
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
	public void testBorderDetectionG()
	{
		Image image = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Imagens\\g.png");
		Image oracleResult = null, testResult = null;
		
		try {
			oracleResult = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Bordas\\g_bordas.png");
			testResult = BorderDetection.metodoGradiente(image.clone());
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
	public void testBorderDetectionH()
	{
		Image image = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Imagens\\h.png");
		Image oracleResult = null, testResult = null;
		
		try {
			oracleResult = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Bordas\\h_bordas.png");
			testResult = BorderDetection.metodoGradiente(image.clone());
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
	public void testBorderDetectionI()
	{
		Image image = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Imagens\\i.png");
		Image oracleResult = null, testResult = null;
		
		try {
			oracleResult = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Bordas\\i_bordas.png");
			testResult = BorderDetection.metodoGradiente(image.clone());
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
	public void testBorderDetectionJ()
	{
		Image image = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Imagens\\j.png");
		Image oracleResult = null, testResult = null;
		
		try {
			oracleResult = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Bordas\\j_bordas.png");
			testResult = BorderDetection.metodoGradiente(image.clone());
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
	public void testBorderDetectionK()
	{
		Image image = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Imagens\\k.png");
		Image oracleResult = null, testResult = null;
		
		try {
			oracleResult = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Bordas\\k_bordas.png");
			testResult = BorderDetection.metodoGradiente(image.clone());
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
	public void testBorderDetectionL()
	{
		Image image = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Imagens\\l.png");
		Image oracleResult = null, testResult = null;
		
		try {
			oracleResult = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Bordas\\l_bordas.png");
			testResult = BorderDetection.metodoGradiente(image.clone());
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
	public void testBorderDetectionM()
	{
		Image image = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Imagens\\m.png");
		Image oracleResult = null, testResult = null;
		
		try {
			oracleResult = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Bordas\\m_bordas.png");
			testResult = BorderDetection.metodoGradiente(image.clone());
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
	public void testBorderDetectionN()
	{
		Image image = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Imagens\\n.png");
		Image oracleResult = null, testResult = null;
		
		try {
			oracleResult = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Bordas\\n_bordas.png");
			testResult = BorderDetection.metodoGradiente(image.clone());
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
	public void testBorderDetectionO()
	{
		Image image = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Imagens\\o.png");
		Image oracleResult = null, testResult = null;
		
		try {
			oracleResult = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Bordas\\o_bordas.png");
			testResult = BorderDetection.metodoGradiente(image.clone());
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
	public void testBorderDetectionP()
	{
		Image image = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Imagens\\p.png");
		Image oracleResult = null, testResult = null;
		
		try {
			oracleResult = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Bordas\\p_bordas.png");
			testResult = BorderDetection.metodoGradiente(image.clone());
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
	public void testBorderDetectionQ()
	{
		Image image = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Imagens\\q.png");
		Image oracleResult = null, testResult = null;
		
		try {
			oracleResult = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Bordas\\q_bordas.png");
			testResult = BorderDetection.metodoGradiente(image.clone());
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
	public void testBorderDetectionR()
	{
		Image image = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Imagens\\r.png");
		Image oracleResult = null, testResult = null;
		
		try {
			oracleResult = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Bordas\\r_bordas.png");
			testResult = BorderDetection.metodoGradiente(image.clone());
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
	public void testBorderDetectionS()
	{
		Image image = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Imagens\\s.png");
		Image oracleResult = null, testResult = null;
		
		try {
			oracleResult = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Bordas\\s_bordas.png");
			testResult = BorderDetection.metodoGradiente(image.clone());
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
	public void testBorderDetectionT()
	{
		Image image = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Imagens\\t.png");
		Image oracleResult = null, testResult = null;
		
		try {
			oracleResult = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Bordas\\t_bordas.png");
			testResult = BorderDetection.metodoGradiente(image.clone());
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
	public void testBorderDetectionU()
	{
		Image image = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Imagens\\u.png");
		Image oracleResult = null, testResult = null;
		
		try {
			oracleResult = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Bordas\\u_bordas.png");
			testResult = BorderDetection.metodoGradiente(image.clone());
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
	public void testBorderDetectionV()
	{
		Image image = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Imagens\\v.png");
		Image oracleResult = null, testResult = null;
		
		try {
			oracleResult = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Bordas\\v_bordas.png");
			testResult = BorderDetection.metodoGradiente(image.clone());
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
	public void testBorderDetectionW()
	{
		Image image = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Imagens\\w.png");
		Image oracleResult = null, testResult = null;
		
		try {
			oracleResult = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Bordas\\w_bordas.png");
			testResult = BorderDetection.metodoGradiente(image.clone());
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
	public void testBorderDetectionX()
	{
		Image image = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Imagens\\x.png");
		Image oracleResult = null, testResult = null;
		
		try {
			oracleResult = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Bordas\\x_bordas.png");
			testResult = BorderDetection.metodoGradiente(image.clone());
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
	public void testBorderDetectionY()
	{
		Image image = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Imagens\\y.png");
		Image oracleResult = null, testResult = null;
		
		try {
			oracleResult = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Bordas\\y_bordas.png");
			testResult = BorderDetection.metodoGradiente(image.clone());
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
	public void testBorderDetectionZ()
	{
		Image image = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Imagens\\z.png");
		Image oracleResult = null, testResult = null;
		
		try {
			oracleResult = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Bordas\\z_bordas.png");
			testResult = BorderDetection.metodoGradiente(image.clone());
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
