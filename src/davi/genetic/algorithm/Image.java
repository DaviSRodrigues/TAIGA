package davi.genetic.algorithm;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class Image implements Cloneable {
	private BufferedImage bfImage = null;
	private String imagePath = null;
	
	public Image(String imagePath) {
        this(imagePath, BufferedImage.TYPE_INT_RGB);
	}
	
	public Image(String imagePath, int type) {
        try {
			BufferedImage bf = ImageIO.read(new File(imagePath));
			
			this.bfImage = new BufferedImage(bf.getWidth(), bf.getHeight(), type);
			Graphics g = bfImage.getGraphics();
            g.drawImage(bf, 0, 0, null);
            g.dispose();
        	
			this.imagePath = imagePath;
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public Image(BufferedImage bfImage) {
		this.bfImage = bfImage;
	}
	
	public Image(int width, int height, int type) {
		this.bfImage = new BufferedImage(width, height, type);
	}
	
	public BufferedImage getBufferedImage() {
		return bfImage;
	}
	
	@Override
	public Image clone() {
		BufferedImage bi = new BufferedImage(this.getWidth(), this.getHeight(), this.bfImage.getType());
		Graphics g = bi.getGraphics();
		g.drawImage(this.bfImage, 0, 0, null);
		g.dispose();
		
		Image img = new Image(bi);
		img.imagePath = this.getPath();
		
		return img;
	}
	
	public int getWidth() {
		return bfImage.getWidth();
	}
	
	public int getHeight() {
		return bfImage.getHeight();
	}
	
	public int getType() {
		return bfImage.getType();
	}
	
	public void save(String path) {
		File image = new File(path);
		
		if(!image.exists())
			image.getParentFile().mkdirs();
		
        try {
        	ImageIO.write(bfImage, path.split("\\.")[1], new FileOutputStream(path));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
	}

	public String getPath() {
		return imagePath;
	}
	
	public int[][] toBinaryMatrix() {
		return toBinaryMatrix(0);
	}
	
	public int[][] toBinaryMatrix(int fundo) {
		int height = getHeight(), width = getWidth(), color = 0;
		int[][] binaryImage = new int[height][width];
		Raster raster = getBufferedImage().getRaster();
		
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				color = raster.getSample(j, i, 0);
				
				if(fundo == 0)
					binaryImage[i][j] = color / 255;
				else
					binaryImage[i][j] = 1 - (color / 255);
			}
		}
		
		return binaryImage;
	}
	
	public static Image toImage(int[][] binaryImage) {
		return toImage(binaryImage, 0, BufferedImage.TYPE_INT_RGB);
	}
	
	public static Image toImage(int[][] binaryImage, int fundo) {
		return toImage(binaryImage, fundo, BufferedImage.TYPE_INT_RGB);
	}
	
	public static Image toImage(int[][] binaryImage, int fundo, int type) {
		int height = binaryImage.length, width = binaryImage[0].length, color;
		BufferedImage bfImage = new BufferedImage(width, height, type);
		WritableRaster raster = bfImage.getRaster();
		int b = 0, bandas = raster.getNumBands();
		
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				if(fundo == 0)
					color = binaryImage[i][j] * 255;
				else
					color = 255 - binaryImage[i][j] * 255;
				
				b = 0;
				while(b < bandas)
					raster.setSample(j, i, b++, color);
			}
		}
		
		return new Image(bfImage);
	}
	
	public boolean equals(Image another) {
		if(bfImage == null || another == null)
    		return false;
    	
    	BufferedImage anotherBf = another.getBufferedImage();
    	
    	int width = getWidth(), height = getHeight();
    	int[] thisImage = new int[width * height], anotherImage = new int[width * height];

    	bfImage.getRGB(0, 0, width, height, thisImage, 0, width);
    	anotherBf.getRGB(0, 0, width, height, anotherImage, 0, width);

    	return Arrays.equals(thisImage, anotherImage);
	}
	
//	public boolean equals(Image another) {
//		if(bfImage == null || another == null)
//    		return false;
//    	
//    	BufferedImage anotherBf = another.getBufferedImage();
//    	
//    	int width = getWidth(), height = getHeight();
//    	int[] thisImage = new int[width * height], anotherImage = new int[width * height];
//
//    	bfImage.getRGB(0, 0, width, height, thisImage, 0, width);
//    	anotherBf.getRGB(0, 0, width, height, anotherImage, 0, width);
//
//    	double diferencas = 0;
//    	
//    	for(int i = 0; i < thisImage.length; i++) {
//    		if(thisImage[i] != anotherImage[i]) {
//    			diferencas++;
////    			int a = (thisImage[i] >> 24) & 0xff;
////    			int r = (thisImage[i] >> 16) & 0xff;
////    			int g = (thisImage[i] >> 8) & 0xff;
////    			int b = thisImage[i] & 0xff;
////    			thisImage[i] = a << 24 | -r << 16 | -g << 8 | -b;
//    		}
//    	}
//    		
////    	bfImage.setRGB(0, 0, width, height, thisImage, 0, width);
//    	
////    	System.out.println("diferencas / total = " + ((diferencas / (double) thisImage.length) * 100) + "%");
//    	
//    	if(diferencas / (double) thisImage.length <= 0.0)
//    		return true;
//
//    	return false;
//	}
	
	public Image converter(int type) {
		BufferedImage bi = new BufferedImage(this.getWidth(), this.getHeight(), type);
		Graphics g = bi.getGraphics();
		g.drawImage(this.bfImage, 0, 0, null);
		g.dispose();
		
		Image img = new Image(bi);
		img.imagePath = this.getPath();
		
		return img;
	}
}
