// This is a mutant program.
// Author : ysma

package davi.mutation.mediana.SDL_2;


import java.awt.image.WritableRaster;
import java.util.Arrays;
import davi.genetic.algorithm.Image;


public class Mediana
{

    public static  void main( java.lang.String[] args )
        throws java.lang.Exception
    {
    }

    public static  davi.genetic.algorithm.Image aplicaFiltro( davi.genetic.algorithm.Image img )
    {
        try {
            int p1;
            int p2;
            int p3;
            int p4;
            int p5;
            int p6;
            int p7;
            int p8;
            int p9;
            int mediana;
            int altura = img.getHeight();
            int largura = img.getWidth();
            java.awt.image.WritableRaster raster = img.getBufferedImage().getRaster();
            for (int i = 1; i <= altura - 2; i++) {
                verificaTimeout();
            }
        } catch ( java.lang.Exception e ) {
            return null;
        }
        return img;
    }

    public static  void verificaTimeout()
        throws java.lang.InterruptedException
    {
        if (Thread.currentThread().isInterrupted()) {
            throw new java.lang.InterruptedException();
        }
    }

}
