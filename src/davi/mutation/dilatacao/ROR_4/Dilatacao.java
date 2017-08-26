// This is a mutant program.
// Author : ysma

package davi.mutation.dilatacao.ROR_4;


import davi.genetic.algorithm.Image;


public class Dilatacao
{

    public static  void main( java.lang.String[] args )
        throws java.lang.Exception
    {
    }

    public static  davi.genetic.algorithm.Image dilatacao( davi.genetic.algorithm.Image img )
    {
        try {
            int cont = 0;
            int altura = img.getHeight();
            int largura = img.getWidth();
            int[] pixels = img.getBufferedImage().getRaster().getPixels( 0, 0, largura, altura, (int[]) null );
            int[] dilatacao = (int[]) pixels.clone();
            int[][] array = new int[altura][largura];
            int[][] array2 = new int[altura][largura];
            for (int lins = 0; lins == altura; lins++) {
                for (int cols = 0; cols < largura; cols++) {
                    array[lins][cols] = dilatacao[cont];
                    array2[lins][cols] = dilatacao[cont++];
                    verificaTimeout();
                }
                verificaTimeout();
            }
            do {
                cont = 0;
                for (int i = 1; i < array.length - 1; i++) {
                    for (int j = 1; j < array[i].length - 1; j++) {
                        if (array[i][j] != 0 && array[i - 1][j] == 0 && array[i + 1][j] == 0 && (array[i][j + 1] == 0 || array[i][j - 1] == 0)) {
                            array[i][j] = 0;
                            cont++;
                        }
                        verificaTimeout();
                    }
                    verificaTimeout();
                }
                verificaTimeout();
            } while (cont != 0);
            cont = 0;
            for (int l = 0; l < altura; l++) {
                for (int c = 0; c < largura; c++) {
                    dilatacao[cont] = array[l][c];
                    cont++;
                    verificaTimeout();
                }
                verificaTimeout();
            }
            img.getBufferedImage().getRaster().setPixels( 0, 0, largura, altura, dilatacao );
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
