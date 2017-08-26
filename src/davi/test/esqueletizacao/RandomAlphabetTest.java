package davi.test.esqueletizacao;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileFilter;
import java.util.Collections;
import java.util.Random;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import davi.genetic.algorithm.Image;
import davi.genetic.algorithm.ImageEvaluator;
import davi.genetic.algorithm.SUT;

public class RandomAlphabetTest {
	private static int nImages = 0;
	private static File[] images = null;
	private static Random rng = null;
	private static ImageEvaluator evaluator = null;
	private static double[] mutationScores = null;
	private static int counter = -1;
	
	@BeforeClass
	public static void initialize() {
		FileFilter filterFile = new FileFilter() {
			public boolean accept(File arg0) {
				return arg0.isFile();
			}
		};
		
		images = new File("Imagens").listFiles(filterFile); 
		nImages = images.length;
		rng = new Random();
		evaluator = new ImageEvaluator(SUT.Esqueletizacao);
		mutationScores = new double[TesteThinning.POP_SIZE]; //Mudar para nImages*******************
	}
	
	@AfterClass
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
		evaluator = new ImageEvaluator(SUT.Esqueletizacao);
		mutationScores = new double[TesteThinning.POP_SIZE]; //Mudar para nImages*******************
		counter = -1;
		
		return stats;
	}
	
	@Test
	public void test1()
	{
		Image image = new Image(images[rng.nextInt(nImages)].getPath());
		
		mutationScores[++counter] = evaluator.getFitness(image, null);
		
		assertEquals(100d, mutationScores[counter], 0d);
	}
	
	@Test
	public void test2()
	{
		Image image = new Image(images[rng.nextInt(nImages)].getPath());
		
		mutationScores[++counter] = evaluator.getFitness(image, null);
		
		assertEquals(100d, mutationScores[counter], 0d);
	}
	
	@Test
	public void test3()
	{
		Image image = new Image(images[rng.nextInt(nImages)].getPath());
		
		mutationScores[++counter] = evaluator.getFitness(image, null);
		
		assertEquals(100d, mutationScores[counter], 0d);
	}
	
	@Test
	public void test4()
	{
		Image image = new Image(images[rng.nextInt(nImages)].getPath());
		
		mutationScores[++counter] = evaluator.getFitness(image, null);
		
		assertEquals(100d, mutationScores[counter], 0d);
	}
	
	@Test
	public void test5()
	{
		Image image = new Image(images[rng.nextInt(nImages)].getPath());
		
		mutationScores[++counter] = evaluator.getFitness(image, null);
		
		assertEquals(100d, mutationScores[counter], 0d);
	}
	
	@Test
	public void test6()
	{
		Image image = new Image(images[rng.nextInt(nImages)].getPath());
		
		mutationScores[++counter] = evaluator.getFitness(image, null);
		
		assertEquals(100d, mutationScores[counter], 0d);
	}
	
	@Test
	public void test7()
	{
		Image image = new Image(images[rng.nextInt(nImages)].getPath());
		
		mutationScores[++counter] = evaluator.getFitness(image, null);
		
		assertEquals(100d, mutationScores[counter], 0d);
	}
	
	@Test
	public void test8()
	{
		Image image = new Image(images[rng.nextInt(nImages)].getPath());
		
		mutationScores[++counter] = evaluator.getFitness(image, null);
		
		assertEquals(100d, mutationScores[counter], 0d);
	}
	
	@Test
	public void test9()
	{
		Image image = new Image(images[rng.nextInt(nImages)].getPath());
		
		mutationScores[++counter] = evaluator.getFitness(image, null);
		
		assertEquals(100d, mutationScores[counter], 0d);
	}
	
	@Test
	public void test10()
	{
		Image image = new Image(images[rng.nextInt(nImages)].getPath());
		
		mutationScores[++counter] = evaluator.getFitness(image, null);
		
		assertEquals(100d, mutationScores[counter], 0d);
	}
	
	@Test
	public void test11()
	{
		Image image = new Image(images[rng.nextInt(nImages)].getPath());
		
		mutationScores[++counter] = evaluator.getFitness(image, null);
		
		assertEquals(100d, mutationScores[counter], 0d);
	}
	
	@Test
	public void test12()
	{
		Image image = new Image(images[rng.nextInt(nImages)].getPath());
		
		mutationScores[++counter] = evaluator.getFitness(image, null);
		
		assertEquals(100d, mutationScores[counter], 0d);
	}
	
	@Test
	public void test13()
	{
		Image image = new Image(images[rng.nextInt(nImages)].getPath());
		
		mutationScores[++counter] = evaluator.getFitness(image, null);
		
		assertEquals(100d, mutationScores[counter], 0d);
	}
	
	@Test
	public void test14()
	{
		Image image = new Image(images[rng.nextInt(nImages)].getPath());
		
		mutationScores[++counter] = evaluator.getFitness(image, null);
		
		assertEquals(100d, mutationScores[counter], 0d);
	}
	
	@Test
	public void test15()
	{
		Image image = new Image(images[rng.nextInt(nImages)].getPath());
		
		mutationScores[++counter] = evaluator.getFitness(image, null);
		
		assertEquals(100d, mutationScores[counter], 0d);
	}
	
	@Test
	public void test16()
	{
		Image image = new Image(images[rng.nextInt(nImages)].getPath());
		
		mutationScores[++counter] = evaluator.getFitness(image, null);
		
		assertEquals(100d, mutationScores[counter], 0d);
	}
	
	@Test
	public void test17()
	{
		Image image = new Image(images[rng.nextInt(nImages)].getPath());
		
		mutationScores[++counter] = evaluator.getFitness(image, null);
		
		assertEquals(100d, mutationScores[counter], 0d);
	}
	
	@Test
	public void test18()
	{
		Image image = new Image(images[rng.nextInt(nImages)].getPath());
		
		mutationScores[++counter] = evaluator.getFitness(image, null);
		
		assertEquals(100d, mutationScores[counter], 0d);
	}
	
	@Test
	public void test19()
	{
		Image image = new Image(images[rng.nextInt(nImages)].getPath());
		
		mutationScores[++counter] = evaluator.getFitness(image, null);
		
		assertEquals(100d, mutationScores[counter], 0d);
	}
	
	@Test
	public void test20()
	{
		Image image = new Image(images[rng.nextInt(nImages)].getPath());
		
		mutationScores[++counter] = evaluator.getFitness(image, null);
		
		assertEquals(100d, mutationScores[counter], 0d);
	}
	
	@Test
	public void test21()
	{
		Image image = new Image(images[rng.nextInt(nImages)].getPath());
		
		mutationScores[++counter] = evaluator.getFitness(image, null);
		
		assertEquals(100d, mutationScores[counter], 0d);
	}
	
	@Test
	public void test22()
	{
		Image image = new Image(images[rng.nextInt(nImages)].getPath());
		
		mutationScores[++counter] = evaluator.getFitness(image, null);
		
		assertEquals(100d, mutationScores[counter], 0d);
	}
	
	@Test
	public void test23()
	{
		Image image = new Image(images[rng.nextInt(nImages)].getPath());
		
		mutationScores[++counter] = evaluator.getFitness(image, null);
		
		assertEquals(100d, mutationScores[counter], 0d);
	}
	
	@Test
	public void test24()
	{
		Image image = new Image(images[rng.nextInt(nImages)].getPath());
		
		mutationScores[++counter] = evaluator.getFitness(image, null);
		
		assertEquals(100d, mutationScores[counter], 0d);
	}
	
	@Test
	public void test25()
	{
		Image image = new Image(images[rng.nextInt(nImages)].getPath());
		
		mutationScores[++counter] = evaluator.getFitness(image, null);
		
		assertEquals(100d, mutationScores[counter], 0d);
	}
	
	@Test
	public void test26()
	{
		Image image = new Image(images[rng.nextInt(nImages)].getPath());
		
		mutationScores[++counter] = evaluator.getFitness(image, null);
		
		assertEquals(100d, mutationScores[counter], 0d);
	}
}
