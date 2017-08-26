package davi.test.bordas;

import java.awt.image.WritableRaster;
import davi.genetic.algorithm.Image;

public class BorderDetection {
	public static void main(String[] args) throws Exception {
		
    }

//    public static Image metodoGradiente(Image imagem) {
//    	int linha, coluna, nivelCinza, nivelCinzaVizinhoLin, nivelCinzaVizinhoCol, largura, altura, 
//    		bandas, red, green, blue;
//    	int[] vCor;
//    	
//    	try {
//    		bandas = imagem.getBufferedImage().getRaster().getNumBands();
//    		
//    		if(bandas != 3)
//    			return null;
//
//    		largura = imagem.getWidth();
//    		altura = imagem.getHeight();
//
//    		WritableRaster rasterEscrita = imagem.getBufferedImage().getRaster();
//
//    		vCor = new int[bandas];
//
//    		for(linha = 0; linha < altura - 1; linha++) {
//    			for(coluna = 0; coluna < largura - 1; coluna++) {
//    				rasterEscrita.getPixel(coluna, linha, vCor);
//    				red = vCor[0];
//    				green = vCor[1];
//    				blue = vCor[2];
//    				nivelCinza = new BigDecimal((red + green + blue) / 3).setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
//    				
//    				rasterEscrita.getPixel(coluna, linha + 1, vCor);
//    				red = vCor[0];
//    				green = vCor[1];
//    				blue = vCor[2];
//    				nivelCinzaVizinhoLin = new BigDecimal((red + green + blue) / 3).setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
//    				
//    				rasterEscrita.getPixel(coluna + 1, linha, vCor);
//    				red = vCor[0];
//    				green = vCor[1];
//    				blue = vCor[2];
//    				nivelCinzaVizinhoCol = new BigDecimal((red + green + blue) / 3).setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
//    				
//    				nivelCinza = Math.abs(nivelCinza - nivelCinzaVizinhoLin) + Math.abs(nivelCinza - nivelCinzaVizinhoCol);
//
//    				if(nivelCinza > 255)
//    					nivelCinza = 255;
//
//    				for(int i = 0; i < bandas; i++) {
//    					rasterEscrita.setSample(coluna, linha, i, nivelCinza);
//    					verificaTimeout();
//    				}
//    				
//    				verificaTimeout();
//    			}
//
//    			verificaTimeout();
//    		}
//    	}
//    	catch(Exception e) {
//    		return null;
//    	}
//    	
//    	return imagem;
//    }
	
    public static Image metodoGradiente(Image imagem) {
    	int linha, coluna, nivelCinza, nivelCinzaVizinhoLin, nivelCinzaVizinhoCol, largura, altura;
    	
    	try {
    		largura = imagem.getWidth();
    		altura = imagem.getHeight();

    		WritableRaster rasterEscrita = imagem.getBufferedImage().getRaster();

    		for(linha = 0; linha < altura - 1; linha++) {
    			for(coluna = 0; coluna < largura - 1; coluna++) {
    				nivelCinza = rasterEscrita.getSample(coluna, linha, 0);
    				nivelCinzaVizinhoLin = rasterEscrita.getSample(coluna, linha + 1, 0);
    				nivelCinzaVizinhoCol = rasterEscrita.getSample(coluna + 1, linha, 0);
    				
    				nivelCinza = Math.abs(nivelCinza - nivelCinzaVizinhoLin) + Math.abs(nivelCinza - nivelCinzaVizinhoCol);

    				if(nivelCinza > 255)
    					nivelCinza = 255;

    				rasterEscrita.setSample(coluna, linha, 0, nivelCinza);
    				
    				verificaTimeout();
    			}
    			verificaTimeout();
    		}
    	}
    	catch(Exception e) {
    		return null;
    	}
    	
    	return imagem;
    }
    
    public static void verificaTimeout() throws InterruptedException {
    	if(Thread.currentThread().isInterrupted())
    		throw new InterruptedException();
    }
}