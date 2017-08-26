package davi.genetic.algorithm;

import java.io.File;
import java.io.FileFilter;
import java.util.Collections;
import java.util.List;
import org.uncommons.watchmaker.framework.FitnessEvaluator;

import davi.test.Mutante;

public class ImageEvaluator implements FitnessEvaluator<Image>
{
	private SUT programa;
//	private HashMap<String, Integer> mutants = new HashMap<String, Integer>();
//	public static HashMap<String, Integer> liveMutants = new HashMap<String, Integer>();
	private File[] folders = null;
	private int candidates = 0;
	private boolean stop = false;
//	public static final Integer live = 1;
//	public static final Integer dead = -1;
	
	public ImageEvaluator(SUT programa) {
		FileFilter filterFolder = new FileFilter() {
			public boolean accept(File arg0) {
				return arg0.isDirectory();
			}
		};
		
		if(programa == SUT.Borda)
			folders = new File("src\\davi\\mutation\\borda").listFiles(filterFolder);
		else if(programa == SUT.Esqueletizacao)
			folders = new File("src\\davi\\mutation\\esqueletizacao").listFiles(filterFolder);
		else if(programa == SUT.Fingerprint)
			folders = new File("src\\davi\\mutation\\fingerprint").listFiles(filterFolder);
		else if(programa == SUT.Mediana)
			folders = new File("src\\davi\\mutation\\mediana").listFiles(filterFolder);
		else if(programa == SUT.Media)
			folders = new File("src\\davi\\mutation\\media").listFiles(filterFolder);
		else if(programa == SUT.Equalizacao)
			folders = new File("src\\davi\\mutation\\equalizacao").listFiles(filterFolder);
		else if(programa == SUT.Dilatacao)
			folders = new File("src\\davi\\mutation\\dilatacao").listFiles(filterFolder);
		else if(programa == SUT.Limpeza)
			folders = new File("src\\davi\\mutation\\limpeza").listFiles(filterFolder);
		
//		if(folders != null && liveMutants.isEmpty()) {
//			for(File f : folders)
//				liveMutants.put(f.getName(), live);
//		}
		
		this.programa = programa;
	}
	
	public /*synchronized*/ double getFitness(Image candidate, List<? extends Image> population)
    {
    	double totalM = folders.length, mortos = 0;
    	boolean erro = false;
		Image oracleResult = null, testResult = null;
		Mutante thread = null;
		
		//oracle execution
		if(programa == SUT.Borda)
			oracleResult = davi.test.bordas.BorderDetection.metodoGradiente(candidate.clone());
		else if(programa == SUT.Esqueletizacao)
			oracleResult = davi.test.esqueletizacao.Thinning.esqueletizar(candidate.clone());
		else if(programa == SUT.Fingerprint)
			oracleResult = davi.test.fingerprint.Fingerprint.preProcessa(candidate.clone());
		else if(programa == SUT.Mediana)
			oracleResult = davi.test.mediana.Mediana.aplicaFiltro(candidate.clone());
		else if(programa == SUT.Media)
			oracleResult = davi.test.media.Media.aplicaFiltro(candidate.clone());
		else if(programa == SUT.Equalizacao)
			oracleResult = davi.test.equalizacao.Equalizacao.equaliza(candidate.clone());
		else if(programa == SUT.Dilatacao)
			oracleResult = davi.test.dilatacao.Dilatacao.dilatacao(candidate.clone());
		else if(programa == SUT.Limpeza)
			oracleResult = davi.test.limpeza.Limpeza.limpeza(candidate.clone());
		
		//mutant execution
		for(File f : folders) {
			try {
				thread = new Mutante(programa, f.getName(), candidate.clone());
				thread.start();
				thread.join(1500);

				if(thread.isAlive())
					erro = true;
				else
					testResult = thread.getTestResult();
				
				thread.interrupt();
			}
			catch(Exception e) {
				erro = true;
				System.err.println(f.getName() + " -> " + e);
			}
			
			if(erro || testResult == null || !oracleResult.equals(testResult)) {
				mortos++;
//				mutants.put(f.getName(), dead);
				erro = false;
			}
		}
		
//		mutants.put("Killed", (int) mortos);

		if(mortos == totalM) {
			stop = true;
			candidates++;
		}
		
		if(!stop && mortos < totalM) {
			candidates++;
//			mutants.put("Candidates", candidates);
		}		
		
//		getTestResults();
//		updateStaticHashMap();

//		for(File f : folders)
//			mutants.put(f.getName(), live);
		
		return (mortos / totalM) * 100;
    }

	public boolean isNatural()
    {
        return true;
    }
    
    public int getNumberCandidates() {
    	return candidates;
    }
    
    public int getNumberMutants() {
    	return folders.length;
    }
    
    public void resetNumberCandidates() {
    	candidates = 0;
    	stop = false;
    	
    	System.out.println(String.join("", Collections.nCopies(120, "=")));
    }

//    public void updateStaticHashMap() {
//    	mutants.keySet().stream().forEach(m -> {
//    		if(!m.equals("Killed") && !m.equals("Candidates"))
//    			if(mutants.get(m) == live && liveMutants.get(m) != dead)
//    				liveMutants.put(m, live);
//    			else
//    				liveMutants.put(m, dead);
//    	});
//    }
    
//    public void getTestResults() {
//    	System.out.println(padRight("Mutant", 11) + "\t" + padRight("Status", 11) + "\n");
//    	
//    	mutants.entrySet().forEach(entry -> {
//    		if(entry.getKey().equals("Killed") || entry.getKey().equals("Candidates"))
//    			System.out.print(padRight(entry.getKey(), 11) + "\t" + 
//    					padRight(entry.getValue().toString(), 11) + "\n");
//    		else
//    			System.out.print(padRight(entry.getKey(), 11) + "\t" + 
//    				(entry.getValue() == dead ? padRight("Killed", 11) : padRight("Live", 11)) + "\n");
//		});
//    	
//    	System.out.println();
//    }
//    
//    private static String padRight(String s, int n) {
//        return String.format("%1$-" + n + "s", s);  
//    }
}   