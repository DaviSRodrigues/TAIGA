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

public class RandomWebTest {
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
		
		images = new File("Internet").listFiles(filterFile); 
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
	
//	static class ImageEvaluator
//	{
//		private HashMap<String, Integer> mutants = new HashMap<String, Integer>();
//		private File[] folders = null;
//		private static final Integer live = 1;
//		private static final Integer dead = -1;
//		
//		public ImageEvaluator() {
//			FileFilter filterFolder = new FileFilter() {
//				public boolean accept(File arg0) {
//					return arg0.isDirectory();
//				}
//			};
//			
//			File folder = new File("src\\davi\\mutation\\testing");
//			folders = folder.listFiles(filterFolder);
//			
//			for(File f : folders)
//				mutants.put(f.getName(), live);
//			
//			mutants.put("Killed", 0);
//		}
//		
//		public double evaluateImage(Image candidate)
//	    {
//	    	double totalM = folders.length, deadM = 0;
//	    	boolean erro = false;
//	    	String className;
//			Class<?> clazz = null;
//			Object mutant;
//			Method metodoGradiente;
//			Image oracleResult = null, testResult = null;
//			
//			for(File f : folders) {
//				try {
//					//oracle execution
//					oracleResult = davi.test.BorderDetection.metodoGradiente(candidate.clone());
//					
//					//mutant execution
//					className = "davi.mutation.testing." + f.getName() + ".BorderDetection";
//					clazz = Class.forName(className);
//
//					mutant = clazz.newInstance();
//
//					metodoGradiente = mutant.getClass().getMethod("metodoGradiente", Image.class);
//					testResult = (Image) metodoGradiente.invoke(mutant, candidate.clone());
//				}
//				catch(Exception e) {
//					erro = true;
//					System.err.println("Erro -> " + e);
//				}
//				
//				if(erro || !validateOutput(oracleResult, testResult)) {
//					deadM++;
//					mutants.put(f.getName(), dead);
//					erro = false;
//				}
//			}
//			
//			mutants.put("Killed", (int) deadM);
//			
//			double mutationScore = (deadM / totalM) * 100;
//			
//			//getTestResults(mutationScore, candidate.getPath());
//			
//			for(File f : folders)
//				mutants.put(f.getName(), live);
//			
//			return mutationScore;
//	    }
//
//	    private boolean validateOutput(Image oracleResult, Image testResult) {
//	    	if(oracleResult == null || testResult == null)
//	    		return false;
//	    	
//	    	BufferedImage oracleBf = oracleResult.getBufferedImage();
//	    	BufferedImage testBf = testResult.getBufferedImage();
//	    	
//	    	int width = oracleResult.getWidth(), height = oracleResult.getHeight();
//	    	int[] oracle = new int[width * height], test = new int[width * height];
//
//	    	oracleBf.getRGB(0, 0, width, height, oracle, 0, width);
//	    	testBf.getRGB(0, 0, width, height, test, 0, width);
//
//	    	return Arrays.equals(oracle, test);
//		}
//
//	    public int getNumberMutants() {
//	    	return folders.length;
//	    }
//	    
//	    public int getKilledMutants() {
//	    	return mutants.get("Killed");
//	    }
//	    
//	    public void getTestResults(Double mutationScore, String imagePath) {
//	    	StringBuffer output = new StringBuffer();
//	    	
//	    	output.append("Image: " + imagePath + "\nMutation score: " + mutationScore + "%\n" +
//	    			"Killed: " + getKilledMutants() + "  Live: " + 
//	    			(getNumberMutants() - getKilledMutants()) + "  Total: " + getNumberMutants() + "\n");
//
////			output.append("\n" + padRight("Mutant", 11) + "\t" + padRight("Status", 11) + "\n");
////	    	
////	    	mutants.entrySet().forEach(entry -> {
////	    		if(entry.getKey().equals("Killed") || entry.getKey().equals("Candidates"))
////	    			output.append(padRight(entry.getKey(), 11) + "\t" + 
////	    					padRight(entry.getValue().toString(), 11) + "\n");
////	    		else
////	    			output.append(padRight(entry.getKey(), 11) + "\t" + 
////	    				(entry.getValue() == dead ? padRight("Killed", 11) : padRight("Live", 11)) + "\n");
////			});
//	    	
//	    	output.append("\n" + String.join("", Collections.nCopies(120, "=")) + "\n");
//	    	
//	    	System.out.println(output);
//	    }
//	    
////	    private String padRight(String s, int n) {
////	        return String.format("%1$-" + n + "s", s);  
////	    }
//	}
}


//package davi.test;
//
//import java.awt.image.BufferedImage;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.net.URLConnection;
//import java.util.ArrayList;
//import java.util.Iterator;
//import javax.imageio.ImageIO;
//import javax.swing.ImageIcon;
//import javax.swing.JOptionPane;
//
//import davi.genetic.algorithm.Image;
//
//public class RandomWebTest {
//	private final static String API_KEY = "AIzaSyDwheysfDYFvbJlX22iHfBwuiVSWCet6j0";
//	private final static String CSE_ID = "002477366664012424149%3Axaerhsseuby";
//	private final static String QUERY = "black+and+white";
//	private static ArrayList<String> images = new ArrayList<String>();
//	private static ArrayList<String> titles = new ArrayList<String>();
//	private static int counter = 0;
//	private static int START = 41;
//
//	public static void main(String[] args) {
//		try {
//			buscarImagens();
//			
//			Iterator<String> i = images.iterator();
//			Iterator<String> t = titles.iterator();
//
//			while(i.hasNext() && t.hasNext()) {
//				counter++;
//				
//				String text = t.next(), address = i.next();
//				BufferedImage image = ImageIO.read(new URL(address));
//				
//				Object[] options = {"Sim", "Parar", "Próxima"};
//				
//				int resposta = JOptionPane.showOptionDialog(null, 
//						"Gravar imagem " + counter + " no disco?\n" + address, 
//						text, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
//						new ImageIcon(image), options, options[0]);
//				
//				if(resposta == JOptionPane.YES_OPTION) {
//					Image img = new Image(image);
//					String[] quebra = address.split("\\.");
//					String extensao = quebra[quebra.length - 1];
//					img.toPNG("Internet\\img" + counter + "." + extensao);
//				}
//				else if(resposta == JOptionPane.NO_OPTION)
//					break;
//			}
//			
//			Object[] options = {"Sim", "Não"};
//			
//			int resposta = JOptionPane.showOptionDialog(null, 
//					"Buscar mais imagens?", "Busca de imagens", JOptionPane.YES_NO_OPTION, 
//					JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
//			
//			if(resposta == JOptionPane.YES_OPTION) {
//				START  = counter + 1;
//				images.clear();
//				titles.clear();
//				main(null);
//			}				
//		} catch(MalformedURLException e) {
//			e.printStackTrace();
//		} catch(IOException e) {
//			e.printStackTrace();
//			START  = counter + 1;
//			images.clear();
//			titles.clear();
//			main(null);
//		}
//	}
//	
//	private static void buscarImagens() {
//		try{
//			URL url = new URL("https://www.googleapis.com/customsearch/v1?q=" + QUERY + "&cx=" + CSE_ID + "&imgColorType=mono&imgSize=small&num=10&safe=off&searchType=image&key=" + API_KEY + "&exactTerms=fractal&start=" + START);
//			URLConnection connection = url.openConnection();
//
//			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//			String line;
//			boolean ler = false;
//			
//			while((line = reader.readLine()) != null) {
//				System.out.println(line);
//				
//				if(line.contains("\"link\": \"")) {                             
//					images.add(
//							line.substring(line.indexOf("\"link\": \"") + ("\"link\": \"").length(), 
//										   line.indexOf("\","))
//							);             
//				}
//				
//				if(line.contains("formattedTotalResults"))
//					ler = true;
//				
//				if(ler && line.contains("\"title\": \"")) {                             
//					titles.add(
//							line.substring(line.indexOf("\"title\": \"") + ("\"title\": \"").length(), 
//										   line.indexOf("\","))
//							);             
//				}  
//			}
//		} catch(Exception e){
//			JOptionPane.showMessageDialog(null, e.getMessage(), "Failure", JOptionPane.ERROR_MESSAGE);
//			e.printStackTrace();
//		}
//	}
//}
