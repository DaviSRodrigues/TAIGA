// This is a mutant program.
// Author : ysma

package davi.mutation.esqueletizacao.AOIU_3;


import davi.genetic.algorithm.Image;


public class Thinning
{

    public static  void main( java.lang.String[] args )
        throws java.lang.Exception
    {
    }

    public static  davi.genetic.algorithm.Image esqueletizar( davi.genetic.algorithm.Image img )
    {
        int[][] binaryImage = null;
        try {
            int p2;
            int p3;
            int p4;
            int p5;
            int p6;
            int p7;
            int p8;
            int p9;
            int contador;
            binaryImage = img.toBinaryMatrix();
            boolean apagaPixel = false;
            int[][] deletePixel = null;
            int altura = img.getHeight();
            int largura = img.getWidth();
            do {
                apagaPixel = false;
                deletePixel = new int[altura][largura];
                for (int i = 1; -i <= altura - 2; i++) {
                    for (int j = 1; j <= largura - 2; j++) {
                        if (binaryImage[i][j] == 0) {
                            verificaTimeout();
                            continue;
                        }
                        p2 = binaryImage[i - 1][j];
                        p3 = binaryImage[i - 1][j + 1];
                        p4 = binaryImage[i][j + 1];
                        p5 = binaryImage[i + 1][j + 1];
                        p6 = binaryImage[i + 1][j];
                        p7 = binaryImage[i + 1][j - 1];
                        p8 = binaryImage[i][j - 1];
                        p9 = binaryImage[i - 1][j - 1];
                        contador = 0;
                        int B = p2 + p3 + p4 + p5 + p6 + p7 + p8 + p9;
                        if (B < 2 || B > 6) {
                            verificaTimeout();
                            continue;
                        }
                        contador = 0;
                        if (p2 == 0 && p3 == 1) {
                            contador++;
                        }
                        if (p3 == 0 && p4 == 1) {
                            contador++;
                        }
                        if (p4 == 0 && p5 == 1) {
                            contador++;
                        }
                        if (p5 == 0 && p6 == 1) {
                            contador++;
                        }
                        if (p6 == 0 && p7 == 1) {
                            contador++;
                        }
                        if (p7 == 0 && p8 == 1) {
                            contador++;
                        }
                        if (p8 == 0 && p9 == 1) {
                            contador++;
                        }
                        if (p9 == 0 && p2 == 1) {
                            contador++;
                        }
                        if (contador != 1) {
                            verificaTimeout();
                            continue;
                        }
                        if (p2 * p4 * p6 != 0) {
                            verificaTimeout();
                            continue;
                        }
                        if (p4 * p6 * p8 != 0) {
                            verificaTimeout();
                            continue;
                        }
                        apagaPixel = true;
                        deletePixel[i][j] = 1;
                        verificaTimeout();
                    }
                    verificaTimeout();
                }
                if (apagaPixel) {
                    for (int i = 0; i < altura; i++) {
                        for (int j = 0; j < largura; j++) {
                            if (deletePixel[i][j] == 1) {
                                binaryImage[i][j] = 0;
                            }
                            verificaTimeout();
                        }
                        verificaTimeout();
                    }
                }
                apagaPixel = false;
                deletePixel = new int[altura][largura];
                for (int i = 1; i <= altura - 2; i++) {
                    for (int j = 1; j <= largura - 2; j++) {
                        if (binaryImage[i][j] == 0) {
                            verificaTimeout();
                            continue;
                        }
                        p2 = binaryImage[i - 1][j];
                        p3 = binaryImage[i - 1][j + 1];
                        p4 = binaryImage[i][j + 1];
                        p5 = binaryImage[i + 1][j + 1];
                        p6 = binaryImage[i + 1][j];
                        p7 = binaryImage[i + 1][j - 1];
                        p8 = binaryImage[i][j - 1];
                        p9 = binaryImage[i - 1][j - 1];
                        contador = 0;
                        int B = p2 + p3 + p4 + p5 + p6 + p7 + p8 + p9;
                        if (B < 2 || B > 6) {
                            verificaTimeout();
                            continue;
                        }
                        contador = 0;
                        if (p2 == 0 && p3 == 1) {
                            contador++;
                        }
                        if (p3 == 0 && p4 == 1) {
                            contador++;
                        }
                        if (p4 == 0 && p5 == 1) {
                            contador++;
                        }
                        if (p5 == 0 && p6 == 1) {
                            contador++;
                        }
                        if (p6 == 0 && p7 == 1) {
                            contador++;
                        }
                        if (p7 == 0 && p8 == 1) {
                            contador++;
                        }
                        if (p8 == 0 && p9 == 1) {
                            contador++;
                        }
                        if (p9 == 0 && p2 == 1) {
                            contador++;
                        }
                        if (contador != 1) {
                            verificaTimeout();
                            continue;
                        }
                        if (p2 * p4 * p8 != 0) {
                            verificaTimeout();
                            continue;
                        }
                        if (p2 * p6 * p8 != 0) {
                            verificaTimeout();
                            continue;
                        }
                        apagaPixel = true;
                        deletePixel[i][j] = 1;
                        verificaTimeout();
                    }
                    verificaTimeout();
                }
                if (apagaPixel) {
                    for (int i = 0; i < altura; i++) {
                        for (int j = 0; j < largura; j++) {
                            if (deletePixel[i][j] == 1) {
                                binaryImage[i][j] = 0;
                            }
                            verificaTimeout();
                        }
                        verificaTimeout();
                    }
                }
                verificaTimeout();
            } while (apagaPixel);
        } catch ( java.lang.Exception e ) {
            return null;
        }
        return Image.toImage( binaryImage );
    }

    public static  void verificaTimeout()
        throws java.lang.InterruptedException
    {
        if (Thread.currentThread().isInterrupted()) {
            throw new java.lang.InterruptedException();
        }
    }

}
