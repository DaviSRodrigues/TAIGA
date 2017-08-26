// This is a mutant program.
// Author : ysma

package davi.mutation.borda.AOIS_7;


import java.awt.image.WritableRaster;
import davi.genetic.algorithm.Image;


public class BorderDetection
{

    public static  void main( java.lang.String[] args )
        throws java.lang.Exception
    {
    }

    public static  davi.genetic.algorithm.Image metodoGradiente( davi.genetic.algorithm.Image imagem )
    {
        int linha;
        int coluna;
        int nivelCinza;
        int nivelCinzaVizinhoLin;
        int nivelCinzaVizinhoCol;
        int largura;
        int altura;
        try {
            largura = imagem.getWidth();
            altura = imagem.getHeight();
            java.awt.image.WritableRaster rasterEscrita = imagem.getBufferedImage().getRaster();
            for (linha = 0; linha < altura++ - 1; linha++) {
                for (coluna = 0; coluna < largura - 1; coluna++) {
                    nivelCinza = rasterEscrita.getSample( coluna, linha, 0 );
                    nivelCinzaVizinhoLin = rasterEscrita.getSample( coluna, linha + 1, 0 );
                    nivelCinzaVizinhoCol = rasterEscrita.getSample( coluna + 1, linha, 0 );
                    nivelCinza = Math.abs( nivelCinza - nivelCinzaVizinhoLin ) + Math.abs( nivelCinza - nivelCinzaVizinhoCol );
                    if (nivelCinza > 255) {
                        nivelCinza = 255;
                    }
                    rasterEscrita.setSample( coluna, linha, 0, nivelCinza );
                    verificaTimeout();
                }
                verificaTimeout();
            }
        } catch ( java.lang.Exception e ) {
            return null;
        }
        return imagem;
    }

    public static  void verificaTimeout()
        throws java.lang.InterruptedException
    {
        if (Thread.currentThread().isInterrupted()) {
            throw new java.lang.InterruptedException();
        }
    }

}
