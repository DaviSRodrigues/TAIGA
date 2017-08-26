package davi.genetic.algorithm;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.uncommons.maths.number.ConstantGenerator;
import org.uncommons.maths.number.NumberGenerator;
import org.uncommons.maths.random.Probability;
import org.uncommons.watchmaker.framework.EvolutionaryOperator;

public class ImageMutation implements EvolutionaryOperator<Image>
{
    final NumberGenerator<Probability> mutationProbability;
    final int parts;
//    private static int counter = 0;

    /**
     * Creates a mutation operator that is applied with the given probability and divides an image in parts. 
     * @param mutationProbability The probability that a given image is changed.
     * @param parts The number of parts images will be divided into.
     */
    public ImageMutation(Probability mutationProbability)
    {
        this(new ConstantGenerator<Probability>(mutationProbability), 2);
    }
    
    /**
     * Creates a mutation operator that is applied with the given probability and divides an image in parts.
     * @param mutationProbability The probability that a given image is changed.
     * @param parts The number of parts images will be divided into.
     */
    public ImageMutation(Probability mutationProbability, int parts)
    {
        this(new ConstantGenerator<Probability>(mutationProbability), parts);
    }

    /**
     * Creates a mutation operator that is applied with the given probability and divides an image in parts..
     * @param mutationProbability The (possibly variable) probability that a 
     * given character is changed.
     * @param parts The number of parts images will be divided into.
     */
    public ImageMutation(NumberGenerator<Probability> mutationProbability, int parts)
    {
    	if(parts < 1)
    		throw new IllegalArgumentException("The minimal number of parts into which an image can be divided is 1.");
    	
        this.mutationProbability = mutationProbability;
        this.parts = parts;
    }

    public List<Image> apply(List<Image> selectedCandidates, Random rng)
    {
        List<Image> mutatedPopulation = new ArrayList<Image>(selectedCandidates.size());
        
        for (Image s : selectedCandidates)
        {
            mutatedPopulation.add(mutateImage(s, rng));
        }
        
        return mutatedPopulation;
    }

    /**
     * Mutate a single string.  Zero or more characters may be modified.  The
     * probability of any given character being modified is governed by the
     * probability generator configured for this mutation operator.
     * @param s The string to mutate.
     * @param rng A source of randomness.
     * @return The mutated string.
     */
    public Image mutateImage(Image img, Random rng)
    {
    	Image mutated;
//    	counter++;
    	
    	if (mutationProbability.nextValue().nextEvent(rng))
    	{    		
    		mutated = img.clone();
    		int[] rgbArray = new int[img.getWidth() * img.getHeight()];
    		
    		int partsWidth = mutated.getWidth() / parts;
    		int partsHeight = mutated.getHeight() / parts;
    		
    		Random random  = new Random();         
    		int startWidth = random.nextInt(parts) * partsWidth;
    		int startHeight = random.nextInt(parts) * partsHeight;
    		
    		if(startWidth >= mutated.getWidth())
    			startWidth = mutated.getWidth() - partsWidth;
    		
    		if(startHeight >= mutated.getHeight())
    			startHeight = mutated.getHeight() - partsHeight;
    	            
    		mutated.getBufferedImage().getRGB(startWidth, startHeight, partsWidth, partsHeight, rgbArray, 0, mutated.getWidth());
            
//            int a = 0, r = 0, g = 0, b = 0;
            
            for(int x = 0; x < rgbArray.length; x++) {
//            	a = (rgbArray[x] >> 24) & 0xff;
//            	r = (rgbArray[x] >> 16) & 0xff;
//            	g = (rgbArray[x] >> 8) & 0xff;
//            	b = rgbArray[x] & 0xff;
//            	
//            	if(r == g && g == b && b == 0)
//            		rgbArray[x] = a << 24 | 255 << 16 | 255 << 8 | 255;
//            	else
//            		rgbArray[x] = a << 24 | 0 << 16 | 0 << 8 | 0;
            	
            	if(rgbArray[x] == Color.WHITE.getRGB())
            		rgbArray[x] = Color.BLACK.getRGB();
            	else
            		rgbArray[x] = Color.WHITE.getRGB();
            }
            
            mutated.getBufferedImage().setRGB(startWidth, startHeight, partsWidth, partsHeight, rgbArray, 0, mutated.getWidth());
            
//            mutated.save("Resultados\\Mutacoes\\Mutacao_" + (counter) + ".png");
    	}
    	else
    		mutated = img;
    	
    	return mutated;
    }
}
