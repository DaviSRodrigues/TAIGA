package davi.test.bordas;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;
import org.uncommons.maths.random.MersenneTwisterRNG;
import org.uncommons.maths.random.Probability;
import org.uncommons.watchmaker.framework.EvaluatedCandidate;
import org.uncommons.watchmaker.framework.EvolutionEngine;
import org.uncommons.watchmaker.framework.EvolutionObserver;
import org.uncommons.watchmaker.framework.EvolutionaryOperator;
import org.uncommons.watchmaker.framework.GenerationalEvolutionEngine;
import org.uncommons.watchmaker.framework.PopulationData;
import org.uncommons.watchmaker.framework.SelectionStrategy;
import org.uncommons.watchmaker.framework.operators.EvolutionPipeline;
import org.uncommons.watchmaker.framework.selection.RouletteWheelSelection;
import org.uncommons.watchmaker.framework.termination.Stagnation;
import org.uncommons.watchmaker.framework.termination.TargetFitness;

import davi.genetic.algorithm.Image;
import davi.genetic.algorithm.ImageEvaluator;
import davi.genetic.algorithm.ImageFactory;
import davi.genetic.algorithm.ImageHorizontalCrossover;
import davi.genetic.algorithm.ImageMutation;
import davi.genetic.algorithm.ImageVerticalCrossover;
import davi.genetic.algorithm.SUT;

public class TesteBorda {
	private static final SUT programa = SUT.Borda;
	private static ImageEvaluator imageEvaluator = new ImageEvaluator(programa);
	public static int POP_SIZE = 26;
	public static double VERTICAL_CROSSOVER = 0.15d;
	public static double HORIZONTAL_CROSSOVER = 0.15d;
	public static double MUTATION = 0.3d;
	public static int ELITISM = 3;
	public static int MUTATION_PARTS = 2;
	public static SelectionStrategy<? super Image> SELECTION = new RouletteWheelSelection();
	private static int counter = 0;
	
	public static void main(String[] args) throws Exception {
		Instant inicio = Instant.now();
		
		//****************************************************************************************************
		
//		testeOperadoresGeneticos();
        
		//****************************************************************************************************
		
		System.out.println("SUT: BorderDetection.java\n");
		
		//****************************************************************************************************
		
//		POP_SIZE = 5;
//		ELITISM = 1;
//		
//		System.out.println("Algoritmo Gen�tico - Imagem Geom�trica - Popula��o: " + POP_SIZE + "\n");
//		
//		HORIZONTAL_CROSSOVER = 0.3d;
//		VERTICAL_CROSSOVER = 0.3d;
//		MUTATION = 0.4d;
//		MUTATION_PARTS = 3;
//		SELECTION = new RouletteWheelSelection();
//		testeAlgoritmoGenetico("Teste1", 20);
//		
//		System.out.println("Algoritmo Gen�tico - Imagem N�vel de Cinza - Popula��o: " + POP_SIZE + "\n");
//		testeAlgoritmoGenetico("Teste2", 20);
//		
//		System.out.println("Algoritmo Gen�tico - Imagem Fundo - Popula��o: " + POP_SIZE + "\n");
//		testeAlgoritmoGenetico("Teste3", 20);
//		
//		System.out.println("Algoritmo Gen�tico - Imagem Fingerprint - Popula��o: " + POP_SIZE + "\n");
//		testeAlgoritmoGenetico("Teste4", 20);
//		
//		mostraMutantesVivos();
		
		//****************************************************************************************************
		
		//Uma �nica execu��o do programa de borda
//		Image oracle = new Image("Geometricas\\Quadrado.png");
//		
//		double mutationScore = new ImageEvaluator(SUT.Borda).getFitness(oracle.clone(), null);
//		
//		System.out.println("Mutation score = " + mutationScore + "%");
		
		//****************************************************************************************************
		
//		prepararFontesGeradosPeloMuJava();
		
		//****************************************************************************************************
		
		testeSelecaoTradicional();
//		mostraMutantesVivos();
		
		//****************************************************************************************************
		
//		testeMutantes();
		
		//****************************************************************************************************
		
//		apagarMutantesEquivalentes();

		//****************************************************************************************************

//		gerarTabelaMutationScore();

		//****************************************************************************************************

		Instant fim = Instant.now();
		Duration d = Duration.between(inicio, fim);

		long horas, minutos, segundos;

		horas = d.toHours();
		minutos = ((d.toMillis() / (long) 1000) / (long) 60) - (horas * (long) 60);
		segundos = (d.toMillis() / (long) 1000) - (minutos * (long) 60) - (horas * (long) 60 * (long) 60);

		System.out.println("\nTotal time: " + horas + " h " + minutos + " min " + segundos + " sec");
	}
	
	private static void mostraMutantesVivos() {
//		counter = 0;
//
//		ImageEvaluator.liveMutants.entrySet().forEach(entry -> {
//			if(entry.getValue() == ImageEvaluator.live)
//				counter ++;
//		});
//
//		System.out.println("Live mutants: " + counter + " de " + ImageEvaluator.liveMutants.size() + 
//				"\nMS = " + ((1d - ((double) counter / ImageEvaluator.liveMutants.size())) * 100) + "%\n");
//
//		List<String> mutantesVivos = new ArrayList<String>();
//		
//		ImageEvaluator.liveMutants.entrySet().forEach(entry -> {
//			if(entry.getValue() == ImageEvaluator.live)
//				mutantesVivos.add(entry.getKey());
//		});
//		
//		mutantesVivos.sort(new Comparator<String>() {
//			@Override
//			public int compare(String arg0, String arg1) {
//				return arg0.compareTo(arg1);
//			}
//		});
//		
//		mutantesVivos.forEach(mutante -> {System.out.println(mutante);});
//
//		System.out.println("\n" + String.join("", Collections.nCopies(120, "=")) + "\n\n");
	}
	
	private static void testeOperadoresGeneticos() {
		//Muta��o
		BufferedImage bfImage1 = null;

		try {
			bfImage1 = ImageIO.read(new File("Geometricas\\Quadrado.png"));
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		int[] rgbArray = new int[bfImage1.getWidth() * bfImage1.getHeight()];
		int parts = 2;

		int partsWidth = bfImage1.getWidth() / parts;
		int partsHeight = bfImage1.getHeight() / parts;

		Random random  = new Random();         
		int startWidth = random.nextInt(parts) * partsWidth;
		int startHeight = random.nextInt(parts) * partsHeight;

		if(startWidth >= bfImage1.getWidth())
			startWidth = bfImage1.getWidth() - partsWidth;

		if(startHeight >= bfImage1.getHeight())
			startHeight = bfImage1.getHeight() - partsHeight;

		bfImage1.getRGB(startWidth, startHeight, partsWidth, partsHeight, rgbArray, 0, bfImage1.getWidth());

		int a = 0, r = 0, g = 0, b = 0;

		for(int x = 0; x < rgbArray.length; x++) {
			a = (rgbArray[x] >> 24) & 0xff;
			r = (rgbArray[x] >> 16) & 0xff;
			g = (rgbArray[x] >> 8) & 0xff;
			b = rgbArray[x] & 0xff;

			if(r == g && g == b && b == 0)
				rgbArray[x] = a << 24 | 255 << 16 | 255 << 8 | 255;
			else
				rgbArray[x] = a << 24 | 0 << 16 | 0 << 8 | 0;
		}

		bfImage1.setRGB(startWidth, startHeight, partsWidth, partsHeight, rgbArray, 0, bfImage1.getWidth());

		try {
			File image = new File("C:\\Users\\Davi\\Desktop\\Imagens\\0Mutacao.png");

			if(!image.exists())
				image.getParentFile().mkdirs();

			ImageIO.write(bfImage1, "png", new FileOutputStream(image));
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		//*******************************************************************************************************

		//Crossover Vertical
		BufferedImage bfImage2 = null;

		try {
			bfImage1 = ImageIO.read(new File("Geometricas\\Circulo.png"));
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		try {
			bfImage2 = ImageIO.read(new File("Geometricas\\Triangulo.png"));
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		BufferedImage bfImage3 = new BufferedImage(bfImage1.getWidth(), bfImage1.getHeight(), BufferedImage.TYPE_INT_ARGB);

		rgbArray = new int[bfImage1.getWidth() * bfImage1.getHeight()];

		bfImage1.getRGB(0, 0, bfImage1.getWidth() / 2, bfImage1.getHeight(), rgbArray, 0, bfImage1.getWidth());
		bfImage3.setRGB(0, 0, bfImage1.getWidth() / 2, bfImage1.getHeight(), rgbArray, 0, bfImage1.getWidth());

		bfImage2.getRGB(bfImage1.getWidth() / 2, 0, bfImage1.getWidth() / 2, bfImage1.getHeight(), rgbArray, 0, bfImage1.getWidth());
		bfImage3.setRGB(bfImage1.getWidth() / 2, 0, bfImage1.getWidth() / 2, bfImage1.getHeight(), rgbArray, 0, bfImage1.getWidth());

		try {
			File image = new File("C:\\Users\\Davi\\Desktop\\Imagens\\1CrossoverVer.png");

			if(!image.exists())
				image.getParentFile().mkdirs();

			ImageIO.write(bfImage3, "png", new FileOutputStream(image));
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		//*******************************************************************************************************

		//Crossover Horizontal
		try {
			bfImage2 = ImageIO.read(new File("Geometricas\\Triangulo.png"));
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		try {
			bfImage1 = ImageIO.read(new File("Geometricas\\Circulo.png"));
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		bfImage3 = new BufferedImage(bfImage1.getWidth(), bfImage1.getHeight(), BufferedImage.TYPE_INT_ARGB);

		rgbArray = new int[bfImage1.getWidth() * bfImage1.getHeight()];

		bfImage2.getRGB(0, 0, bfImage3.getWidth(), bfImage3.getHeight() / 2, rgbArray, 0, bfImage3.getWidth());
		bfImage3.setRGB(0, 0, bfImage3.getWidth(), bfImage3.getHeight() / 2, rgbArray, 0, bfImage3.getWidth());

		bfImage1.getRGB(0, bfImage3.getHeight() / 2, bfImage3.getWidth(), bfImage3.getHeight() / 2, rgbArray, 0, bfImage3.getWidth());
		bfImage3.setRGB(0, bfImage3.getHeight() / 2, bfImage3.getWidth(), bfImage1.getHeight() / 2, rgbArray, 0, bfImage3.getWidth());

		try {
			File image = new File("C:\\Users\\Davi\\Desktop\\Imagens\\2CrossoverHor.png");

			if(!image.exists())
				image.getParentFile().mkdirs();

			ImageIO.write(bfImage3, "png", new FileOutputStream(image));
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	private static void prepararFontesGeradosPeloMuJava() throws Exception {
		File directory = new File("Mutants\\Borda");

		FileFilter filterFolder = new FileFilter() {
			public boolean accept(File arg0) {
				return arg0.isDirectory();
			}
		};

		FileFilter filterFile = new FileFilter() {
			public boolean accept(File arg0) {
				return arg0.isFile() && arg0.getName().endsWith(".java");
			}
		};

		File[] folders = directory.listFiles(filterFolder);
		File[] mutants = null;
		BufferedReader br = null;
		BufferedWriter bw = null;

		for(File f : folders) {
			mutants = f.listFiles(filterFile);

			for(File m : mutants) {
				File destino = new File("src\\davi\\mutation\\borda\\" + f.getName() + "\\BorderDetection.java");
				
				if(!destino.exists())
					destino.getParentFile().mkdirs();
				
				br = new BufferedReader(new FileReader(m));
				bw = new BufferedWriter(new FileWriter(destino));

				Iterator<String> i = br.lines().iterator();

				for(int j = 1; j <= 3; j++)
					bw.write(i.next() + "\n");

				i.next();
				bw.write("package davi.mutation.borda." + f.getName() + ";\n");

				while(i.hasNext())
					bw.write(i.next() + "\n");
				
				br.close();
				bw.close();
			}
		}
		
		System.out.println(folders.length + " mutantes processados");
	}
	
	private static void testeAlgoritmoGenetico(String imagesPath, int qtdeTestes) {
		Instant inicio = Instant.now();
		double[] statsGerais = {Double.MAX_VALUE, 0d, 0d, Double.MAX_VALUE, 0d, 0d, Double.MAX_VALUE, 0d, 0d, Double.MAX_VALUE, 0d, 0d};
	
		for(int i = 1; i <= qtdeTestes; i++) {
			Instant inicio1 = Instant.now(); 
			double[] stats = evolveImages(imagesPath);
			Instant fim1 = Instant.now();

			if(stats[0] < statsGerais[0])
				statsGerais[0] = stats[0];

			if(stats[1] > statsGerais[1])
				statsGerais[1] = stats[1];
			
			statsGerais[2] += stats[2];
			
			if(stats[3] < statsGerais[3])
				statsGerais[3] = stats[3];

			if(stats[4] > statsGerais[4])
				statsGerais[4] = stats[4];
			
			statsGerais[5] += stats[5];
			
			if(stats[6] < statsGerais[6])
				statsGerais[6] = stats[6];

			if(stats[6] > statsGerais[7])
				statsGerais[7] = stats[6];
			
			statsGerais[8] += stats[6];
			
			Duration d1 = Duration.between(inicio1, fim1);
			
			System.out.println("Elapsed time: " + d1.toMinutes() + " min " +  
					((d1.toMillis() / 1000) - (d1.toMinutes() * 60)) + " sec");
			System.out.println("\n" + String.join("", Collections.nCopies(120, "=")) + "\n\n");
			
			long milis = d1.toMillis();
			
			if(milis < statsGerais[9])
				statsGerais[9] = milis;

			if(milis > statsGerais[10])
				statsGerais[10] = milis;
			
			statsGerais[11] += milis;
		}
		
		Instant fim = Instant.now();
		Duration d = Duration.between(inicio, fim);
		
		statsGerais[11] /= qtdeTestes;
		
		long[] minutos = new long[3], segundos = new long[3];
		int j = 9;
		
		for(int i = 0; i < minutos.length; i++) {
			minutos[i] = ((long) statsGerais[j] / 1000) / 60;
			segundos[i] = ((long) statsGerais[j] / 1000) - (minutos[i] * 60);
			j++;
		}
		
		System.out.println(qtdeTestes + " tests were performed.\n" +
				"Folder: " + imagesPath + "\n" +
				"Minimum candidates: " + statsGerais[0] + "\n" +
				"Maximum candidates: " + statsGerais[1] + "\n" +
    			"Average candidates: " + (statsGerais[2] / qtdeTestes) + "\n" +
    			"Minimum mutation score: " + statsGerais[3] + "%\n" +
    			"Maximum mutation score: " + statsGerais[4] + "%\n" +
    			"Average mutation score: " + (statsGerais[5] / qtdeTestes) + "%\n" +
				"Minimum generation count: " + statsGerais[6] + "\n" +
				"Maximum generation count: " + statsGerais[7] + "\n" +
				"Average generation count: " + (statsGerais[8] / qtdeTestes) + "\n" +
				"Minimum execution time = " + minutos[0] + "min" + segundos[0] + "seg\n" +
				"Maximum execution time = " + minutos[1] + "min" + segundos[1] + "seg\n" +
				"Average execution time = " + minutos[2] + "min" + segundos[2] + "seg\n");
		
		System.out.println("Total elapsed time: " + d.toMinutes() + " min " + ((d.toMillis() / 1000) - (d.toMinutes() * 60)) + " sec");
		System.out.println("\n" + String.join("", Collections.nCopies(120, "=")) + "\n");
	}

	private static void testeSelecaoTradicional() throws Exception {
		Instant inicio = Instant.now(), fim;
		Duration d;
	
		for(int i = 1; i <= 4; i++) {
			inicio = Instant.now();
			
			testeImagensMS("Teste" + i);
			
			fim = Instant.now();
			d = Duration.between(inicio, fim);
			
			System.out.println("Elapsed time: " + d.toMinutes() + " min " + ((d.toMillis() / 1000) - (d.toMinutes() * 60)) + " sec");
			System.out.println("\n" + String.join("", Collections.nCopies(120, "=")) + "\n");
		}
	}

	private static void testeGeracaoAleatoria(String testClass, int qtdeTestes) throws Exception {
		Instant inicioGeral = Instant.now();
		Instant inicio = null, fim = null;
		
		Class<?> clazz = Class.forName("davi.test.bordas." + testClass);
		Object testCases;
		Method method;
		double[] resultadoGeral = {Double.MAX_VALUE, 0d, 0d, Double.MAX_VALUE, 0d, 0d};
		
		for(int i = 1; i <= qtdeTestes; i++) {
			testCases = clazz.newInstance();
			inicio = Instant.now();
			
			method = testCases.getClass().getMethod("initialize");
			method.invoke(testCases);
			
			for(int j = 1; j <= POP_SIZE; j++) {
				try {
					method = testCases.getClass().getMethod("test1");
					method.invoke(testCases);
				}
				catch(InvocationTargetException ite) {
					continue;
				}
			}
			
			fim = Instant.now();
			
			method = testCases.getClass().getMethod("getStatistics");
			double[] stats = (double[]) method.invoke(testCases);
			
//			method = testCases.getClass().getMethod("showStatistics");
//			method.invoke(testCases);
			
			if(stats[0] < resultadoGeral[0])
				resultadoGeral[0] = stats[0];

			if(stats[1] > resultadoGeral[1])
				resultadoGeral[1] = stats[1];
			
			resultadoGeral[2] += stats[2];
			
			Duration d = Duration.between(inicio, fim);
			long milis = d.toMillis();
			
			if(milis < resultadoGeral[3])
				resultadoGeral[3] = milis;

			if(milis > resultadoGeral[4])
				resultadoGeral[4] = milis;
			
			resultadoGeral[5] += milis;
		}
		
		resultadoGeral[2] /= qtdeTestes;
		resultadoGeral[5] /= qtdeTestes;
		
		long[] minutos = new long[3], segundos = new long[3];
		int j = 3;
		
		for(int i = 0; i < minutos.length; i++) {
			minutos[i] = ((long) resultadoGeral[j] / 1000) / 60;
			segundos[i] = ((long) resultadoGeral[j] / 1000) - (minutos[i] * 60);
			j++;
		}
		
		Instant fimGeral = Instant.now();
		Duration dGeral = Duration.between(inicioGeral, fimGeral);
		
		System.out.println(qtdeTestes + " tests were performed.\n" +
				"Minimum mutation score = " + resultadoGeral[0] + "%\n" +
				"Maximum mutation score = " + resultadoGeral[1] + "%\n" +
				"Average mutation score = " + resultadoGeral[2] + "%\n" +
				"Minimum execution time = " + minutos[0] + "min" + segundos[0] + "seg\n" +
				"Maximum execution time = " + minutos[1] + "min" + segundos[1] + "seg\n" +
				"Average execution time = " + minutos[2] + "min" + segundos[2] + "seg\n");
		
		System.out.println("Elapsed time: " + dGeral.toMinutes() + " min " + 
				((dGeral.toMillis() / 1000) - (dGeral.toMinutes() * 60)) + " sec\n" +
				String.join("", Collections.nCopies(120, "=")) + "\n");
	}
	
	private static void testeImagensMS(String pasta) throws Exception {
		FileFilter filterFile = new FileFilter() {
			public boolean accept(File arg0) {
				return arg0.isFile() && (arg0.getName().endsWith("png") || 
						arg0.getName().endsWith("gif") || arg0.getName().endsWith("jpg"));
			}
		};
		
		File folder = new File(pasta);
		File[] images = folder.listFiles(filterFile);
		double msMedio = 0d;
		ImageEvaluator imageEvaluator = new ImageEvaluator(programa);
		
		for(File f : images) {
			try {
				Image img = new Image(f.getPath(), BufferedImage.TYPE_BYTE_GRAY);
				double mutationScore = imageEvaluator.getFitness(img, null);
				System.out.println("Mutation score: " + mutationScore + "%\tImage: " + f.getPath());
				msMedio += mutationScore;
			}
			catch(Exception e) {
				System.err.println("Erro --> Img: " + f.getPath());
				e.printStackTrace();
				continue;
			}
		}
		
		System.out.println("\n\nMS m�dio: " + msMedio / (double) images.length + "%\nMutantes: " + imageEvaluator.getNumberMutants());
	}
	
	private static void testeMutantes() {
		String[] mutantes = "AOIS_45,AOIS_46,AOIS_49,AOIS_50,AOIS_53,AOIS_54,AOIS_63,AOIS_64,AOIU_12,LOI_17,ROR_12,ROR_15,ROR_18,ROR_21,ROR_5,SDL_12,SDL_14,SDL_17,SDL_5".split(",");
		
		Image img = new Image("Geometricas\\Losango.png");
		
    	boolean erro = false;
    	String className;
		Class<?> clazz = null;
		Object mutant;
		Method metodoGradiente;
		Image oracleResult = null, testResult = null;
		int i = 0;

		for(String mutante : mutantes) {
			try {
				//oracle execution
				oracleResult = davi.test.bordas.BorderDetection.metodoGradiente(img.clone());
				
				if(oracleResult == null)
					throw new Exception("Mutante: " + mutante + " | oracleResult est� null!!");
				
				oracleResult.save("C://Users//Davi//Desktop//TesteBordaEquivalentes//oracle" + ++i + ".png");
				
				//mutant execution
				className = "davi.mutation.borderdetection." + mutante + ".BorderDetection";
				clazz = Class.forName(className);

				mutant = clazz.newInstance();

				metodoGradiente = mutant.getClass().getMethod("metodoGradiente", Image.class);
				testResult = (Image) metodoGradiente.invoke(mutant, img.clone());
				
				if(testResult == null)
					throw new Exception("Mutante: " + mutante + " | testResult est� null!!");
				
				testResult.save("C://Users//Davi//Desktop//TesteBordaEquivalentes//result" + ++i + ".png");
			}
			catch(Exception e) {
				erro = true;
				System.err.println("Erro -> " + e);
			}
			
			if(erro || !testResult.equals(oracleResult)) {
				System.out.println("Mutante " + mutante + " MORTO");
				erro = false;
			}
			else
				System.err.println("Mutante " + mutante + " VIVO");
		}
	}
	
	private static void apagarMutantesEquivalentes() {
		String[] mutantes = "AOIS_45,AOIS_46,AOIS_49,AOIS_50,AOIS_53,AOIS_54,AOIS_63,AOIS_64,ROR_12,ROR_15,ROR_5,SDL_14,SDL_5,AOIU_12,LOI_17,ROR_18,ROR_21,SDL_12,SDL_17".split(",");
		
		int deletados = 0;
		
		for(String mutante : mutantes) {
			File pasta = new File("Mutants\\Borda\\" + mutante);
			
			for(File arq : pasta.listFiles())
				arq.delete();
			
			pasta.delete();
			
			deletados++;
		}
		
		System.out.println(deletados + " mutante(s) deletado(s)");
	}
	
	private static void gerarTabelaMutationScore() throws Exception {
		File[] imagens = new File("Internet").listFiles(new FileFilter() {
			@Override
			public boolean accept(File arg0) {
				return arg0.isFile() && (arg0.getName().contains("img21") || arg0.getName().contains("img22"));
			}
		});

		File[] mutantes = new File("src\\davi\\mutation\\testing").listFiles(new FileFilter() {
			@Override
			public boolean accept(File arg0) {
				return arg0.isDirectory();
			}
		});

		//Image oracleResult, testResult;
		Class<?> clazz;
		String className;
		Object mutant;
		Method metodoGradiente;
		Image oracleResult, testResult;
		double killed = 0d, numMutantes = mutantes.length;

		for(File imagem : imagens) {
			System.out.println("\n" + imagem.getName() + "\n");
			killed = 0d;

			for(File mutante : mutantes) {
				Image dadoDeTeste = new Image(imagem.getPath());

				//oracle execution
				oracleResult = davi.test.bordas.BorderDetection.metodoGradiente(dadoDeTeste.clone());

				File destino = new File("C:\\Users\\Davi\\Desktop\\Resultados\\" + mutante.getName());

				if(!destino.exists())
					destino.getParentFile().mkdirs();

				oracleResult.save(destino.getPath() + "\\oracle_" + imagem.getName() + ".png");

				//mutant execution
				className = "davi.mutation.testing." + mutante.getName() + ".BorderDetection";
				clazz = Class.forName(className);

				mutant = clazz.newInstance();

				metodoGradiente = mutant.getClass().getMethod("metodoGradiente", Image.class);
				testResult = (Image) metodoGradiente.invoke(mutant, dadoDeTeste.clone());

				if(testResult != null) {
					if(!testResult.equals(oracleResult)) {
						System.out.print("X ");
						killed++;
					}
					else
						System.out.print("- ");
				}
				else {
					System.out.print("X ");
					killed++;
				}
			}

			System.out.println("\nMutation score = " + (killed / numMutantes) * 100 + "%\n");
		}
	}

	public static double[] evolveImages(String imagesPath) {
		ImageFactory factory = new ImageFactory(imagesPath);

		List<EvolutionaryOperator<Image>> operators = new ArrayList<EvolutionaryOperator<Image>>(3);
		operators.add(new ImageVerticalCrossover(new Probability(VERTICAL_CROSSOVER)));
		operators.add(new ImageHorizontalCrossover(new Probability(HORIZONTAL_CROSSOVER)));
		operators.add(new ImageMutation(new Probability(MUTATION), MUTATION_PARTS));

		EvolutionaryOperator<Image> pipeline = new EvolutionPipeline<Image>(operators);

		/*ImageEvaluator*/ imageEvaluator = new ImageEvaluator(programa);

		EvolutionEngine<Image> engine = new GenerationalEvolutionEngine<Image>(
				factory, 
				pipeline, 
				imageEvaluator,
				SELECTION, 
				new MersenneTwisterRNG());

		EvolutionLogger el = new EvolutionLogger();
		engine.addEvolutionObserver(el);
		
//		Image result = engine.evolve(POP_SIZE, ELITISM, new Stagnation(3, true), new TargetFitness(100, true));
//		
//		Calendar date = Calendar.getInstance();
//
//		result.toPNG("Resultados\\BorderDetection\\Result" + date.get(Calendar.YEAR) + 
//				(date.get(Calendar.MONTH) + 1) + date.get(Calendar.DAY_OF_MONTH) + "_" + date.get(Calendar.HOUR_OF_DAY) + 
//				date.get(Calendar.MINUTE) + date.get(Calendar.SECOND) + ".png");
		
		//para retornar toda a popula��o
		List<EvaluatedCandidate<Image>> resultado = engine.evolvePopulation(POP_SIZE, ELITISM, new Stagnation(3, true), new TargetFitness(100, true));

		Iterator<EvaluatedCandidate<Image>> i = resultado.iterator();
		EvaluatedCandidate<Image> candidate = null;
		Calendar date = Calendar.getInstance();
		int j = 0;
		String pasta = String.valueOf(date.get(Calendar.YEAR)) + (date.get(Calendar.MONTH) + 1) + 
				date.get(Calendar.DAY_OF_MONTH) + "_" + date.get(Calendar.HOUR_OF_DAY) + 
				date.get(Calendar.MINUTE) + date.get(Calendar.SECOND);
		
		System.out.println("\nPopula��o final\n");
		
		while(i.hasNext()) {
			candidate = i.next();
			System.out.println(++j + " | Mutation score (fitness): " + candidate.getFitness() + "%");
			candidate.getCandidate().save("Resultados\\BorderDetection\\" + pasta + "\\" + j + ".png");
		}
		
		System.out.println("\n" + String.join("", Collections.nCopies(120, "=")) + "\n");
		
		return el.getStatistics();
	}

	private static class EvolutionLogger implements EvolutionObserver<Image>
    {
		private double[] stats = {Double.MAX_VALUE, 0d, 0d, Double.MAX_VALUE, 0d, 0d, 0d};
		private int generationCount = 0;
		
        public void populationUpdate(PopulationData<? extends Image> data)
        {        		
        	System.out.println("Generation " + data.getGenerationNumber() + " (best fitness): " +
        			data.getBestCandidateFitness() + "%\nForam necess�rias " + 
        			imageEvaluator.getNumberCandidates() + " imagens para matar " +
        			data.getBestCandidateFitness() + "% dos mutantes.\n" +
        			"Num. de Mutantes: " + imageEvaluator.getNumberMutants() + "\n");

        	if(data.getGenerationNumber() > 0) {
        		generationCount++;

        		if(imageEvaluator.getNumberCandidates() < stats[0])
        			stats[0] = imageEvaluator.getNumberCandidates();

        		if(imageEvaluator.getNumberCandidates() > stats[1])
        			stats[1] = imageEvaluator.getNumberCandidates();

        		stats[2] += imageEvaluator.getNumberCandidates();
        		
        		if(data.getBestCandidateFitness() < stats[3])
        			stats[3] = data.getBestCandidateFitness();

        		if(data.getBestCandidateFitness() > stats[4])
        			stats[4] = data.getBestCandidateFitness();
        		
        		stats[5] += data.getBestCandidateFitness();
        	}

        	imageEvaluator.resetNumberCandidates();
        }
        
        public double[] getStatistics() {
        	stats[2] /= generationCount;
        	stats[5] /= generationCount;
        	stats[6] = generationCount;
        	
			System.out.println(generationCount + " generations\n" +
					"Minimum candidates: " + stats[0] + "\n" +
					"Maximum candidates: " + stats[1] + "\n" +
        			"Average candidates: " + stats[2] + "\n" +
        			"Minimum mutation score: " + stats[3] + "%\n" +
        			"Maximum mutation score: " + stats[4] + "%\n" +
					"Average mutation score: " + stats[5] + "%\n");
			
			System.out.println(String.join("", Collections.nCopies(120, "=")) + "\n");
        	return stats;
        }
    }
}
