// This is a mutant program.
// Author : ysma

package davi.mutation.media.ODL_41;


import java.awt.image.WritableRaster;
import davi.genetic.algorithm.Image;


public class Media
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
            int media;
            int altura = img.getHeight();
            int largura = img.getWidth();
            java.awt.image.WritableRaster raster = img.getBufferedImage().getRaster();
            for (int i = 1; i <= altura - 2; i++) {
                for (int j = 1; j <= largura - 2; j++) {
                    p1 = raster.getSample( j, i, 0 );
                    p2 = raster.getSample( j, i - 1, 0 );
                    p3 = raster.getSample( j + 1, i - 1, 0 );
                    p4 = raster.getSample( j + 1, i, 0 );
                    p5 = raster.getSample( j + 1, i + 1, 0 );
                    p6 = raster.getSample( j, i + 1, 0 );
                    p7 = raster.getSample( j - 1, i + 1, 0 );
                    p8 = raster.getSample( j - 1, i, 0 );
                    p9 = raster.getSample( j - 1, i - 1, 0 );
                    media = (p1 + p2 + p3 + p4 + p6 + p7 + p8 + p9) / 9;
                    raster.setSample( j, i, 0, media );
                    verificaTimeout();
                }
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
