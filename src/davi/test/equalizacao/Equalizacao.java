package davi.test.equalizacao;

import davi.genetic.algorithm.Image;

public class Equalizacao {
	public static void main(String[] args) throws Exception {

	}
	
	public static Image equaliza(Image img) {
		try {
			int altura = img.getHeight(), largura = img.getWidth();
			int[] histograma = new int[256], histogramaIdeal = new int[256];
		    int[] pixels = img.getBufferedImage().getRaster().getPixels(0, 0, largura, altura, (int[]) null);
		    int[] histogramaEq = pixels.clone();
			
			for(int i = 0; i < pixels.length; i++) {
		    	histograma[pixels[i]] += 1;
		    	verificaTimeout();
			}
			
			int ideal = (largura * altura) / 256, acumulado = 0, temp = 0;
			
			for(int i = 0; i <= 255; i++)
			{
				acumulado += histograma[i];
				temp = (int) (acumulado / ideal) - 1;
				histogramaIdeal[i] = (temp > 0 ? temp : 0);
				verificaTimeout();
	    	}
			
			for(int i = 0; i < pixels.length; i++) {
				histogramaEq[i] = histogramaIdeal[pixels[i]];
				verificaTimeout();
			}
			
			img.getBufferedImage().getRaster().setPixels(0, 0, largura, altura, histogramaEq);
		}
		catch(Exception e) {
			return null;
		}
		
		return img;
	}
	
	public static void verificaTimeout() throws InterruptedException {
    	if(Thread.currentThread().isInterrupted())
    		throw new InterruptedException();
    }
}
