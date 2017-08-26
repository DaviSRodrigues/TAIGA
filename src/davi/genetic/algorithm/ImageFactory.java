package davi.genetic.algorithm;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileFilter;
import java.util.Random;

import org.uncommons.watchmaker.framework.factories.AbstractCandidateFactory;

public class ImageFactory extends AbstractCandidateFactory<Image> {
	private File pastaImagens = null;
	private File[] images = null;
	private int counter = -1;
	private static final FileFilter filterFile = new FileFilter() {
		public boolean accept(File arg0) {
			return arg0.isFile();
		}
	};
	
	public ImageFactory(String imagesFolder) {
		this.pastaImagens = new File(imagesFolder);
		
		if(!pastaImagens.isDirectory())
			throw new IllegalArgumentException("Informe o caminho de uma pasta.");
		
		this.images = pastaImagens.listFiles(filterFile);
	}
	
	public Image generateRandomCandidate(Random rng) {	
		return new Image(images[++counter % images.length].getPath(), BufferedImage.TYPE_BYTE_GRAY);
	}
}
