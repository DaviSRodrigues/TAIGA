// This is a mutant program.
// Author : ysma

package davi.mutation.limpeza.SDL_15;


import davi.genetic.algorithm.Image;


public class Limpeza
{

    public static  void main( java.lang.String[] args )
        throws java.lang.Exception
    {
    }

    public static  davi.genetic.algorithm.Image limpeza( davi.genetic.algorithm.Image img )
    {
        try {
            int cont = 0;
            int altura = img.getHeight();
            int largura = img.getWidth();
            int[] pixels = img.getBufferedImage().getRaster().getPixels( 0, 0, largura, altura, (int[]) null );
            int[] limpeza = (int[]) pixels.clone();
            int[][] array = new int[altura][largura];
            int[][] array2 = new int[altura][largura];
            for (int lins = 0; lins < altura; lins++) {
                for (int cols = 0; cols < largura; cols++) {
                    array[lins][cols] = limpeza[cont];
                    array2[lins][cols] = limpeza[cont++];
                    verificaTimeout();
                }
                verificaTimeout();
            }
            int objeto = 0;
            int fundo = 255 - objeto;
            for (int l = 1; l < altura - 1; l++) {
                verificaTimeout();
            }
            cont = 0;
            for (int l = 0; l < altura; l++) {
                for (int c = 0; c < largura; c++) {
                    limpeza[cont] = array2[l][c];
                    cont++;
                    verificaTimeout();
                }
                verificaTimeout();
            }
            img.getBufferedImage().getRaster().setPixels( 0, 0, largura, altura, limpeza );
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