package davi.test.esqueletizacao;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
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

public class TesteThinning {
	private static final SUT programa = SUT.Esqueletizacao;
	private static ImageEvaluator imageEvaluator = new ImageEvaluator(programa);
	public static int POP_SIZE = 26;
	public static double VERTICAL_CROSSOVER = 0.15d;
	public static double HORIZONTAL_CROSSOVER = 0.15d;
	public static double MUTATION = 0.3d;
	public static int ELITISM = 1;
	public static int MUTATION_PARTS = 2;
	public static SelectionStrategy<? super Image> SELECTION = new RouletteWheelSelection();
	private static int counter = 0;
	
	public static void main(String[] args) throws Exception {
		Instant inicio = Instant.now();
		
		//****************************************************************************************************
		
		System.out.println("SUT: Thinning.java\n");
		
		//****************************************************************************************************
		
//		POP_SIZE = 5;
//		
//		System.out.println("Algoritmo Genético - Imagem Geométrica - População: " + POP_SIZE + "\n");
//
//		ELITISM = 1; //diversidade x qualidade
//		HORIZONTAL_CROSSOVER = 0.3d; //ótimos resultados no início, no final faz o MS parar em ~86%
//		VERTICAL_CROSSOVER = 0.3d; //por isso, tem prob menor que a mutação
//		MUTATION = 0.4d; //principal responsável pelos resultados
//		MUTATION_PARTS = 3;
//		SELECTION = new RouletteWheelSelection();
//		testeAlgoritmoGenetico("Teste1", 20);
//		
//		System.out.println("Algoritmo Genético - Imagem Nível de Cinza - População: " + POP_SIZE + "\n");
//		testeAlgoritmoGenetico("Teste2", 20);
//		
//		System.out.println("Algoritmo Genético - Imagem Fundo - População: " + POP_SIZE + "\n");
//		testeAlgoritmoGenetico("Teste3", 20);
//		
//		System.out.println("Algoritmo Genético - Imagem Fingerprint - População: " + POP_SIZE + "\n");
//		testeAlgoritmoGenetico("Teste4", 20);
//		
//		mostraMutantesVivos();
		
		//****************************************************************************************************

//		//Uma única execução do programa de esqueletização
//		Image oracle = new Image("Internet\\img22.png"); //imagem toda preta
//
//		double mutationScore = new ImageEvaluator(SUT.Esqueletizacao).getFitness(oracle.clone(), null);
//
//		System.out.println("Mutation score = " + mutationScore + "%");

		//****************************************************************************************************

//		prepararFontesGeradosPeloMuJava();
		
		//****************************************************************************************************
		
		testeSelecaoTradicional();
//		mostraMutantesVivos();

		//****************************************************************************************************
		
//		testeImagensMS("Imagens");

		//***************************************************************************************************
		
//		testeMutantes();
		
		//****************************************************************************************************

//		apagarMutantesEquivalentes();

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

	private static void prepararFontesGeradosPeloMuJava() throws Exception {
		File directory = new File("Mutants\\Esqueletizacao");

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
				File destino = new File("src\\davi\\mutation\\esqueletizacao\\" + f.getName() + "\\Thinning.java");
				
				if(!destino.exists())
					destino.getParentFile().mkdirs();
				
				br = new BufferedReader(new FileReader(m));
				bw = new BufferedWriter(new FileWriter(destino));

				Iterator<String> i = br.lines().iterator();

				for(int j = 1; j <= 3; j++)
					bw.write(i.next() + "\n");

				i.next();
				bw.write("package davi.mutation.esqueletizacao." + f.getName() + ";\n");

				while(i.hasNext())
					bw.write(i.next() + "\n");
				
				br.close();
				bw.close();
			}
		}
		
		System.out.println(folders.length + " mutantes processados");
	}
	
	private static void testeGeracaoAleatoria(String testClass, int qtdeTestes) throws Exception {
			Instant inicioGeral = Instant.now();
			Instant inicio = null, fim = null;
			
			Class<?> clazz = Class.forName("davi.test.esqueletizacao." + testClass);
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
			
//			if(stats[6] < statsGerais[6])
//				statsGerais[6] = stats[6];
//
//			if(stats[6] > statsGerais[7])
//				statsGerais[7] = stats[6];
//			
//			statsGerais[8] += stats[6];
			
			//**********************************************
			//Para a base de imagens da internet, que têm casos de MS 100% na população inicial
			//**********************************************
			
			if(stats[6] < statsGerais[6])
				statsGerais[6] = stats[6] - 1;

			if(stats[6] > statsGerais[7])
				statsGerais[7] = stats[6] - 1;
			
			statsGerais[8] += stats[6] - 1;
			
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
		System.out.println("\n" + String.join("", Collections.nCopies(120, "=")) + "\n\n");
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
		
		for(File f : images) {
			try {
				Image img = new Image(f.getPath(), BufferedImage.TYPE_BYTE_GRAY);
				double mutationScore = new ImageEvaluator(programa).getFitness(img, null);
				System.out.println("Mutation score: " + mutationScore + "%\tImage: " + f.getPath());
				msMedio += mutationScore;
			}
			catch(Exception e) {
				System.err.println("Erro --> Img: " + f.getPath());
				e.printStackTrace();
				continue;
			}
		}
		
		System.out.println("\n\nMS médio: " + msMedio / (double) images.length + "%");
	}
	
	private static void testeMutantes() {
		String[] mutantes = "COR_2,ROR_18,ROR_17,ROR_39,COR_20,ROR_21,AOIU_30,AOIU_27,AOIU_28,AOIU_29".split(",");

		Image img = new Image("Imagens\\d.png");
		
    	boolean erro = false;
    	String className;
		Class<?> clazz = null;
		Object mutant;
		Method metodoEsqueletizar;
		Image oracleResult = null, testResult = null;
		int i = 0;
		double mortos = 0, vivos = 0;

		for(String mutante : mutantes) {
			try {
				//oracle execution
				oracleResult = davi.test.esqueletizacao.Thinning.esqueletizar(img.clone());
				
				if(oracleResult == null)
					throw new Exception("Mutante: " + mutante + " | oracleResult está null!!");
				
				oracleResult.save("Esqueletizacao//Equivalentes//" + ++i + ".png");
				
				//mutant execution
				className = "davi.mutation.thinning." + mutante + ".Thinning";
				clazz = Class.forName(className);

				mutant = clazz.newInstance();

				metodoEsqueletizar = mutant.getClass().getMethod("esqueletizar", Image.class);
				testResult = (Image) metodoEsqueletizar.invoke(mutant, img.clone());
				
				if(testResult == null)
					throw new Exception("Mutante: " + mutante + " | testResult está null!!");
				
				testResult.save("Esqueletizacao//Equivalentes//" + ++i + ".png");
			}
			catch(Exception e) {
				erro = true;
				System.err.println("Erro -> " + e);
			}
			
			if(erro || !testResult.equals(oracleResult)) {
				System.out.println("Mutante " + mutante + " MORTO");
				erro = false;
				mortos++;
			}
			else {
				System.err.println("Mutante " + mutante + " VIVO");
				vivos++;
			}
		}
		
		System.out.println("\nMutantes: " + mutantes.length + 
				" Mortos: " + mortos + " Vivos: " + vivos +
				"\nMutation score: " + ((mortos / (double) mutantes.length) * 100) + "%");
	}
	
	private static void gerarTabelaMutationScore() throws Exception {
		File[] imagens = new File("Internet").listFiles(new FileFilter() {
			@Override
			public boolean accept(File arg0) {
				return arg0.isFile() && (arg0.getName().contains("img21") || arg0.getName().contains("img22"));
			}
		});
	
		File[] mutantes = new File("src\\davi\\mutation\\thinning").listFiles(new FileFilter() {
			@Override
			public boolean accept(File arg0) {
				return arg0.isDirectory();
			}
		});
	
		//Image oracleResult, testResult;
		Class<?> clazz;
		String className;
		Object mutant;
		Method metodo;
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
				className = "davi.mutation.thinning." + mutante.getName() + ".Thinning";
				clazz = Class.forName(className);
	
				mutant = clazz.newInstance();
	
				metodo = mutant.getClass().getMethod("esqueletizar", Image.class);
				testResult = (Image) metodo.invoke(mutant, dadoDeTeste.clone());
	
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

	private static void apagarMutantesEquivalentes() {
		String[] mutantes = "AOIU_63,AOIU_64,AOIU_65,AOIU_66,ROR_184,ROR_369,ROR_373".split(",");
		
		int deletados = 0;
		
		for(String mutante : mutantes) {
			File pasta = new File("Mutants\\Esqueletizacao\\" + mutante);
			
			for(File arq : pasta.listFiles())
				arq.delete();
			
			pasta.delete();
			
			deletados++;
		}
		
		System.out.println(deletados + " mutante(s) deletado(s)");
	}

	public static double[] evolveImages(String imagesPath) {
		ImageFactory factory = new ImageFactory(imagesPath);

		List<EvolutionaryOperator<Image>> operators = new ArrayList<EvolutionaryOperator<Image>>(1);
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
//		result.toPNG("Resultados\\Skeleton\\Result" + date.get(Calendar.YEAR) + 
//				(date.get(Calendar.MONTH) + 1) + date.get(Calendar.DAY_OF_MONTH) + "_" + date.get(Calendar.HOUR_OF_DAY) + 
//				date.get(Calendar.MINUTE) + date.get(Calendar.SECOND) + ".png");
		
		//para retornar toda a população
		List<EvaluatedCandidate<Image>> resultado = engine.evolvePopulation(POP_SIZE, ELITISM, new Stagnation(3, true), new TargetFitness(100, true));

		Iterator<EvaluatedCandidate<Image>> i = resultado.iterator();
		EvaluatedCandidate<Image> candidate = null;
		Calendar date = Calendar.getInstance();
		int j = 0;
		String pasta = String.valueOf(date.get(Calendar.YEAR)) + (date.get(Calendar.MONTH) + 1) + 
				date.get(Calendar.DAY_OF_MONTH) + "_" + date.get(Calendar.HOUR_OF_DAY) + 
				date.get(Calendar.MINUTE) + date.get(Calendar.SECOND);
		
		System.out.println("\nPopulação final\n");
		
		while(i.hasNext()) {
			candidate = i.next();
			System.out.println(++j + " | Mutation score (fitness): " + candidate.getFitness() + "%");
			candidate.getCandidate().save("Resultados\\Esqueletizacao\\" + pasta + "\\" + j + ".png");
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
        			data.getBestCandidateFitness() + "%\nForam necessárias " + 
        			imageEvaluator.getNumberCandidates() + " imagens para matar " +
        			data.getBestCandidateFitness() + "% dos mutantes.\n" +
        			"Num. de Mutantes: " + imageEvaluator.getNumberMutants() + "\n");

        	//if(data.getGenerationNumber() > 0)
        	if(true) { //Para base de imagens da internet, que pode ter MS máximo na população inicial
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

