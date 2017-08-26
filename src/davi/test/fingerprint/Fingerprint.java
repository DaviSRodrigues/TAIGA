package davi.test.fingerprint;

import java.awt.image.BufferedImage;
import davi.genetic.algorithm.Image;

public class Fingerprint {
	public static void main(String[] args) throws Exception {
		
	}
	
	public static Image preProcessa(Image img) {
		try {
			int altura = img.getHeight(), largura = img.getWidth();
			
			//Equaliza��o
			int[] histograma = new int[256]; 
			int[] histogramaIdeal = new int[256];
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
			
			//Thresholding - m�scara 11x11
			pixels = img.getBufferedImage().getRaster().getPixels(0, 0, largura, altura, (int[]) null);
			int[] binarizada = (int[]) pixels.clone();
			int aux[][] = new int[altura][largura];
			int cont = 0;

			for(int lins = 0; lins < altura; lins++) {
				for(int cols = 0; cols < largura; cols++) {
					aux[lins][cols] = binarizada[cont++];
					verificaTimeout();
				}
			}

			int mascara = 11, inc = mascara / 2, media = 0, soma = 0, div = 0;
			cont = 0;

			for(int lins = 0; lins < altura; lins++) {
				for(int cols = 0; cols < largura; cols++) {
					soma = 0;
					div = mascara * mascara;

					for(int ml = lins - inc; ml <= lins + inc; ml++) {
						for(int mc = cols - inc; mc <= cols + inc; mc++) {
							if(mc < 0 || mc >= largura || ml < 0 || ml >= altura)
								div--;
							else
								soma += aux[ml][mc];
							
							verificaTimeout();
						}
						verificaTimeout();
					}

					media = soma / div;

					if(aux[lins][cols] == media) {
						if(media == 255)
							binarizada[cont++] = 255;
						else
							binarizada[cont++] = 0;
					}
					else {
						if(aux[lins][cols] > media)
							binarizada[cont++] = 255;
						else
							binarizada[cont++] = 0;
					}
					
					verificaTimeout();
				}
				verificaTimeout();
			}
			
			img.getBufferedImage().getRaster().setPixels(0, 0, largura, altura, binarizada);
			
			//Dilata��o
			pixels = img.getBufferedImage().getRaster().getPixels(0, 0, largura, altura, (int[]) null);
			int[] dilatacao = (int[]) pixels.clone();
			int array[][] = new int[altura][largura];
			int array2[][] = new int[altura][largura];
			cont = 0;

			for(int lins = 0; lins < altura; lins++) {
				for(int cols = 0; cols < largura; cols++) {
					array[lins][cols] = dilatacao[cont];
					array2[lins][cols] = dilatacao[cont++];
					verificaTimeout();
				}
				verificaTimeout();
			}

			do
			{
				cont = 0;
				
		        for(int i = 1; i < array.length - 1; i++)
		        {
		        	for(int j = 1; j < array[i].length - 1; j++)
		        	{
		        		if(array[i][j] != 0 && array[i - 1][j] == 0 && array[i + 1][j] == 0 &&
		        		   (array[i][j + 1] == 0 || array[i][j - 1] == 0))
		        		{
		        			array[i][j] = 0;
		        			cont++;
		        		}
		        		verificaTimeout();
		        	}
		        	verificaTimeout();
		        }
		        verificaTimeout();
		 	}
			while(cont != 0);
		 	
			cont = 0;
			
			for(int l = 0; l < altura; l++) {
				for(int c = 0; c < largura; c++) {
					{
						dilatacao[cont] = array[l][c];
						cont++;
					}
					verificaTimeout();
				}
				verificaTimeout();
			}
			
			img.getBufferedImage().getRaster().setPixels(0, 0, largura, altura, dilatacao);
			
			//Esqueletiza��o
			int p2, p3, p4, p5, p6, p7, p8, p9;
			int[][] binaryImage = null, deletePixel = null;
			int contador;
			binaryImage = img.toBinaryMatrix(255);
			boolean apagaPixel = false;

			do {
				apagaPixel = false;
				deletePixel = new int[altura][largura];
	
				for(int i = 1; i <= altura - 2; i++) {
					for(int j = 1; j <= largura - 2; j++) {
						if(binaryImage[i][j] == 0) {
							verificaTimeout();
							continue;
						}
						
						p2 = binaryImage[i - 1][j];
		                p3 = binaryImage[i - 1][j + 1];
		                p4 = binaryImage[i][j + 1];
		                p5 = binaryImage[i + 1][j + 1];
		                p6 = binaryImage[i + 1][j];
		                p7 = binaryImage[i + 1][j - 1];
		                p8 = binaryImage[i][j - 1];
		                p9 = binaryImage[i - 1][j - 1];
	
						contador = 0;
	
						int B = p2 + p3 + p4 + p5 + p6 + p7 + p8 + p9;
						
						if(B < 2 || B > 6) {
							verificaTimeout();
							continue;
						}
	
						contador = 0;
						
						if(p2 == 0 && p3 == 1) contador++;
						if(p3 == 0 && p4 == 1) contador++;
						if(p4 == 0 && p5 == 1) contador++;
						if(p5 == 0 && p6 == 1) contador++;
						if(p6 == 0 && p7 == 1) contador++;
						if(p7 == 0 && p8 == 1) contador++;
						if(p8 == 0 && p9 == 1) contador++;
						if(p9 == 0 && p2 == 1) contador++;
						
						if(contador != 1) {
							verificaTimeout();
							continue;
						}
	
						if(p2 * p4 * p6 != 0) {
							verificaTimeout();
							continue;
						}
						
						if(p4 * p6 * p8 != 0) {
							verificaTimeout();
							continue;
						}
	
						apagaPixel = true;
						
						deletePixel[i][j] = 1;
						verificaTimeout();
					}
					verificaTimeout();
				}
	
				if(apagaPixel) {
					for(int i = 0; i < altura; i++) {
						for(int j = 0; j < largura; j++) {
							if(deletePixel[i][j] == 1)
								binaryImage[i][j] = 0;
							verificaTimeout();
						}
						verificaTimeout();
					}
				}
				
				apagaPixel = false;
				deletePixel = new int[altura][largura];
	
				for(int i = 1; i <= altura - 2; i++) {
					for(int j = 1; j <= largura - 2; j++) {
						if(binaryImage[i][j] == 0) {
							verificaTimeout();
							continue;
						}
						
						p2 = binaryImage[i - 1][j];
		                p3 = binaryImage[i - 1][j + 1];
		                p4 = binaryImage[i][j + 1];
		                p5 = binaryImage[i + 1][j + 1];
		                p6 = binaryImage[i + 1][j];
		                p7 = binaryImage[i + 1][j - 1];
		                p8 = binaryImage[i][j - 1];
		                p9 = binaryImage[i - 1][j - 1];
	
						contador = 0;
	
						int B = p2 + p3 + p4 + p5 + p6 + p7 + p8 + p9;
						
						if(B < 2 || B > 6) {
							verificaTimeout();
							continue;
						}
	
						contador = 0;
						
						if(p2 == 0 && p3 == 1) contador++;
						if(p3 == 0 && p4 == 1) contador++;
						if(p4 == 0 && p5 == 1) contador++;
						if(p5 == 0 && p6 == 1) contador++;
						if(p6 == 0 && p7 == 1) contador++;
						if(p7 == 0 && p8 == 1) contador++;
						if(p8 == 0 && p9 == 1) contador++;
						if(p9 == 0 && p2 == 1) contador++;
						
						if(contador != 1) {
							verificaTimeout();
							continue;
						}
	
						if(p2 * p4 * p8 != 0) {
							verificaTimeout();
							continue;
						}
						
						if(p2 * p6 * p8 != 0) {
							verificaTimeout();
							continue;
						}
	
						apagaPixel = true;
						
						deletePixel[i][j] = 1;
						
						verificaTimeout();
					}					
					verificaTimeout();
				}
	
				if(apagaPixel) {
					for(int i = 0; i < altura; i++) {
						for(int j = 0; j < largura; j++) {
							if(deletePixel[i][j] == 1)
								binaryImage[i][j] = 0;
							verificaTimeout();
						}
						verificaTimeout();
					}
				}
				
				verificaTimeout();
			}
			while(apagaPixel);
			
			img = Image.toImage(binaryImage, 255).converter(BufferedImage.TYPE_BYTE_GRAY);
			
			//Limpeza
			pixels = img.getBufferedImage().getRaster().getPixels(0, 0, largura, altura, (int[]) null);
			int[] limpeza = (int[]) pixels.clone();
			array = new int[altura][largura];
			array2 = new int[altura][largura];
			cont = 0;

			for(int lins = 0; lins < altura; lins++) {
				for(int cols = 0; cols < largura; cols++) {
					array[lins][cols] = limpeza[cont];
					array2[lins][cols] = limpeza[cont++];
					verificaTimeout();
				}
				verificaTimeout();
			}

			int objeto = 0, fundo = 255 - objeto;

			for(int l = 1; l < altura-1; l++) {
				for(int c = 1; c < largura-1; c++) {
					if(array[l][c] != objeto) {
						verificaTimeout();
						continue;
					}
						
					if(array[l-1][c+1] == objeto && array[l+1][c+1] == objeto) {
						array2[l-1][c] = fundo;
						array2[l+1][c] = fundo;
						array2[l][c+1] = fundo;
					}
					verificaTimeout();
				}
				verificaTimeout();
			}
	        
			cont = 0;
			
			for(int l = 0; l < altura; l++) {
				for(int c = 0; c < largura; c++) {
					limpeza[cont] = array2[l][c];
					cont++;
					verificaTimeout();
				}
				verificaTimeout();
			}
			
			img.getBufferedImage().getRaster().setPixels(0, 0, largura, altura, limpeza);
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
