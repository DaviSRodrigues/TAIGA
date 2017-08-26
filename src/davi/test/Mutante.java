package davi.test;

import java.lang.reflect.Method;
import davi.genetic.algorithm.Image;
import davi.genetic.algorithm.SUT;

public class Mutante extends Thread {
	private String mutante;
	private Image image, testResult;
	private boolean erro = false;
	private SUT programa;
	
	public Mutante(SUT programa, String mutante, Image image) {
		this.programa = programa;
		this.mutante = mutante;
		this.image = image;
		this.testResult = null;
	}
	
	public Image getTestResult() {
		return testResult;
	}
	
	public boolean getErro() {
		return erro;
	}
	
	public SUT getPrograma() {
		return programa;
	}
	
	public String getNome() {
		return mutante;
	}
	
	@Override
	public void run() {
		Class<?> clazz = null;
		Object mutant = null;
		Method metodo = null;
		
		try {
			switch(programa) {
				case Borda:
					clazz = Class.forName("davi.mutation.borda." + mutante + ".BorderDetection");
					mutant = clazz.newInstance();
					metodo = mutant.getClass().getMethod("metodoGradiente", Image.class);
					break;
				case Esqueletizacao:
					clazz = Class.forName("davi.mutation.esqueletizacao." + mutante + ".Thinning");
					mutant = clazz.newInstance();
					metodo = mutant.getClass().getMethod("esqueletizar", Image.class);
					break;
				case Fingerprint:
					clazz = Class.forName("davi.mutation.fingerprint." + mutante + ".Fingerprint");
					mutant = clazz.newInstance();
					metodo = mutant.getClass().getMethod("preProcessa", Image.class);
					break;
				case Mediana:
					clazz = Class.forName("davi.mutation.mediana." + mutante + ".Mediana");
					mutant = clazz.newInstance();
					metodo = mutant.getClass().getMethod("aplicaFiltro", Image.class);
					break;
				case Media:
					clazz = Class.forName("davi.mutation.media." + mutante + ".Media");
					mutant = clazz.newInstance();
					metodo = mutant.getClass().getMethod("aplicaFiltro", Image.class);
					break;
				case Equalizacao:
					clazz = Class.forName("davi.mutation.equalizacao." + mutante + ".Equalizacao");
					mutant = clazz.newInstance();
					metodo = mutant.getClass().getMethod("equaliza", Image.class);
					break;
				case Dilatacao:
					clazz = Class.forName("davi.mutation.dilatacao." + mutante + ".Dilatacao");
					mutant = clazz.newInstance();
					metodo = mutant.getClass().getMethod("dilatacao", Image.class);
					break;
				case Limpeza:
					clazz = Class.forName("davi.mutation.limpeza." + mutante + ".Limpeza");
					mutant = clazz.newInstance();
					metodo = mutant.getClass().getMethod("limpeza", Image.class);
					break;
				default:
					break;
			}
			
			testResult = (Image) metodo.invoke(mutant, image);
		}
		catch(Exception e) {

		}
	}
}