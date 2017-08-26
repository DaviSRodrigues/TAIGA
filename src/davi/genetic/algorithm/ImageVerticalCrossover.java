package davi.genetic.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.uncommons.maths.random.Probability;
import org.uncommons.watchmaker.framework.operators.AbstractCrossover;

public class ImageVerticalCrossover extends AbstractCrossover<Image>{
//	private static int counter = 0;

	/**
     * Single-point cross-over, which may or may not happen 
     * depending on {@code crossoverProbability}.
     * @param crossoverProbability The probability that, once selected,
     * a pair of parents will be subjected to cross-over rather than
     * being copied, unchanged, into the output population.
     */
    public ImageVerticalCrossover(Probability crossoverProbability)
    {
        super(1, crossoverProbability);
    }
    
	/**
     * Cross-over with a variable number of cross-over points, which may
     * or may not happen depending on {@code crossoverProbability}.
     * @param crossoverPoints An integer variable that provides a number
     * of cross-over points for each cross-over operation.
     * @param crossoverProbability The probability that, once selected,
     * a pair of parents will be subjected to cross-over rather than
     * being copied, unchanged, into the output population.
     */
    public ImageVerticalCrossover(int crossoverPoints, Probability crossoverProbability)
    {
        super(crossoverPoints, crossoverProbability);
    }

	@Override
	protected List<Image> mate(Image parent1, Image parent2, int numberOfCrossoverPoints, Random rng) {
		if (parent1.getWidth() != parent2.getWidth() || parent1.getHeight() != parent2.getHeight())
        {
            throw new IllegalArgumentException("Cannot perform cross-over with different length parents.");
        }
		
		Image offspring1 = new Image(parent1.getWidth(), parent1.getHeight(), parent1.getType());
		Image offspring2 = new Image(parent2.getWidth(), parent2.getHeight(), parent2.getType());
				
		int[] rgbArray = new int[parent1.getWidth() * parent1.getHeight()];
		
		parent1.getBufferedImage().getRGB(0, 0, offspring1.getWidth() / 2, offspring1.getHeight(), rgbArray, 0, offspring1.getWidth());
		offspring1.getBufferedImage().setRGB(0, 0, offspring1.getWidth() / 2, offspring1.getHeight(), rgbArray, 0, offspring1.getWidth());
        
		parent2.getBufferedImage().getRGB(offspring1.getWidth() / 2, 0, offspring1.getWidth() / 2, offspring1.getHeight(), rgbArray, 0, offspring1.getWidth());
		offspring1.getBufferedImage().setRGB(offspring1.getWidth() / 2, 0, offspring1.getWidth() / 2, offspring1.getHeight(), rgbArray, 0, offspring1.getWidth());
        
		parent2.getBufferedImage().getRGB(0, 0, offspring1.getWidth() / 2, offspring1.getHeight(), rgbArray, 0, offspring1.getWidth());
		offspring2.getBufferedImage().setRGB(0, 0, offspring1.getWidth() / 2, offspring1.getHeight(), rgbArray, 0, offspring1.getWidth());
		
		parent1.getBufferedImage().getRGB(offspring1.getWidth() / 2, 0, offspring1.getWidth() / 2, offspring1.getHeight(), rgbArray, 0, offspring1.getWidth());
		offspring2.getBufferedImage().setRGB(offspring1.getWidth() / 2, 0, offspring1.getWidth() / 2, offspring1.getHeight(), rgbArray, 0, offspring1.getWidth());
		
        List<Image> result = new ArrayList<Image>(2);
        result.add(offspring1);
        result.add(offspring2);
        
//        counter++;
//        
//        parent1.save("Resultados\\Crossovers\\Pais\\Pai_V_" + counter + "_A.png");
//        parent2.save("Resultados\\Crossovers\\Pais\\Pai_V_" + counter + "_B.png");
//        offspring1.save("Resultados\\Crossovers\\Filhos\\Filho_V_" + counter + "_A.png");
//        offspring2.save("Resultados\\Crossovers\\Filhos\\Filho_V_" + counter + "_B.png");
        
        return result;
	}
}
