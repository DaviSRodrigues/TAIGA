package davi.test.fingerprint;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileFilter;
import java.util.Collections;

import org.junit.Test;

import davi.genetic.algorithm.Image;
import davi.genetic.algorithm.ImageEvaluator;
import davi.genetic.algorithm.SUT;

public class FingerprintTest {
//	private static int nImages = 0;
	private static File[] images = null;
	private static ImageEvaluator evaluator = null;
	private static double[] mutationScores = null;
	private static int counter = -1;
	
	public static void initialize() {
		FileFilter filterFile = new FileFilter() {
			public boolean accept(File arg0) {
				return arg0.isFile();
			}
		};
		
		images = new File("Fingerprint").listFiles(filterFile); 
//		nImages = images.length;
		evaluator = new ImageEvaluator(SUT.Fingerprint);
		mutationScores = new double[TesteFingerprint.POP_SIZE]; //Mudar para nImages*******************
	}
	
	public static void showStatistics() {
		double[] stats = getStatistics();
		
		System.out.println((counter + 1) + " tests performed.\nMinimum mutation score = " + stats[0] +
				"%\nMaximum mutation score = " + stats[1] + "%\nAverage mutation score = " + 
				stats[2] + "%\n\n" + String.join("", Collections.nCopies(120, "=")) + "\n");
	}
	
	public static double[] getStatistics() {
		double min = Double.MAX_VALUE, max = 0d, avg = 0d;
		
		for(int i = 0; i < mutationScores.length; i++) {
			if(mutationScores[i] < min)
				min = mutationScores[i];
			
			if(mutationScores[i] > max)
				max = mutationScores[i];
			
			avg += mutationScores[i];
		}
		
		double[] stats = {min, max, (avg / mutationScores.length)};
		
		//for when JUnit is not used
		evaluator = new ImageEvaluator(SUT.Fingerprint);
		mutationScores = new double[TesteFingerprint.POP_SIZE]; //Mudar para nImages*******************
		counter = -1;
		
		return stats;
	}
	
	@Test
	public void testJUnit()
	{
		Image image = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Fingerprint\\teste.gif", BufferedImage.TYPE_BYTE_GRAY);
		Image oracleResult = null, testResult = null;
		
		try {
			oracleResult = new Image("C:\\Users\\Davi\\Dropbox\\workspace\\mestrado\\Fingerprint\\tudo\\resultado1.gif", BufferedImage.TYPE_BYTE_GRAY);
			testResult = Fingerprint.preProcessa(image.clone());
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
		assertTrue(testResult.equals(oracleResult));
	}
	
	public void test1()
	{
		Image image = new Image(images[0].getPath(), BufferedImage.TYPE_BYTE_GRAY);
		
		mutationScores[++counter] = evaluator.getFitness(image, null);
		
		assertEquals(100d, mutationScores[counter], 0d);
	}
}