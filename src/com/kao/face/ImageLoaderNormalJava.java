package com.kao.face;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

class ImageLoaderNormalJava implements ImageLoader {
    private static final ImageLoader _this = new ImageLoaderNormalJava();

    public static ImageLoader getLoader() {
        return _this;
    }

    public AnImage[] loadImage(String filename) {
        AnImage[] ans = null;
        try {
            final BufferedImage img = ImageIO.read(new File(filename));
            final int width = img.getWidth();
            final int height = width;
            int cnt = img.getHeight() / height;

            ans = new AnImage[cnt];
            for (int i=0; i<cnt; i++) {
                final int ii = i;
                ans[i] = new AnImage(width, height);
                ans[i].willBeLoadedWith(new AnImage.HowToLoad() {
                    @Override
                    public void loadPixelsTo(int[] pixels, byte[] grayScale_pixels) {
                        for (int x=0; x<width; x++) {
                            for (int y=0; y<height; y++) {
                                int color = img.getRGB(x, (y + (ii*height)));
                                pixels[x+y*width] = color;
                                int  red =   ((color & 0x00ff0000) >> 16);
                                int  green = ((color & 0x0000ff00) >> 8);
                                int  blue =  (color & 0x000000ff);
                                int avg = (red+green+blue)/3;
                                grayScale_pixels[x+y*width] = (byte)avg;
                            }
                        }
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ans;
    }
}
