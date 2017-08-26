package davi.test.media;

import java.awt.image.WritableRaster;
import davi.genetic.algorithm.Image;

public class Media {
	public static void main(String[] args) throws Exception {

	}
	
	public static Image aplicaFiltro(Image img) {
		try {
			int p1, p2, p3, p4, p5, p6, p7, p8, p9, media;
			int altura = img.getHeight(), largura = img.getWidth();
			WritableRaster raster = img.getBufferedImage().getRaster();
			
			for(int i = 1; i <= altura - 2; i++) {
				for(int j = 1; j <= largura - 2; j++) {
					p1 = raster.getSample(j, i, 0);
					p2 = raster.getSample(j, i - 1, 0);
					p3 = raster.getSample(j + 1, i - 1, 0);
					p4 = raster.getSample(j + 1, i, 0);
					p5 = raster.getSample(j + 1, i + 1, 0);
					p6 = raster.getSample(j, i + 1, 0);
					p7 = raster.getSample(j - 1, i + 1, 0);
					p8 = raster.getSample(j - 1, i, 0);
					p9 = raster.getSample(j - 1, i - 1, 0);
					
					media = (p1 + p2 + p3 + p4 + p5 + p6 + p7 + p8 + p9) / 9;
					
					raster.setSample(j, i, 0, media);
					verificaTimeout();
				}
				verificaTimeout();
			}			
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
