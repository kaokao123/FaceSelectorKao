package com.kao.face;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FaceSelectorKao {
    public static void main(String[] args) {
        AnImage[] imgs = ImageLoaderNormalJava.getLoader().loadImage("faces.jpg");
        int numImgs = 6;

        System.out.println("=== JNI tiny_cnn connection test ===");
        String ret = TinyCnnJni.testTinyCnnJni(
                new byte[]{10, 0, 0, 0,  0, 10, 0, 0,  0, 0, 10, 0,  0, 0, 0, 10,  0, 0, 0, 0},
                5,
                4,
                new byte[]{1, 2, 3, 4, 5},
                5,
                new byte[]{1, 3, 2, 7},
                3,
                2000
        );
        System.out.println("" + ret);

        System.out.println("=== Face image classification test ===");
        List<Integer> indices = new ArrayList<Integer>();
        for (int i=0; i<numImgs; i++) {
            indices.add((new Random()).nextInt(imgs.length));
        }
        List<Integer> labels = new ArrayList<Integer>();
        for (int i=0; i<numImgs; i++) {
            labels.add((new Random()).nextInt(2));
        }
        System.out.print("Indices: [");
        for (int i=0; i<numImgs; i++) {
            System.out.print("" + indices.get(i) + ", ");
        }
        System.out.println("]");
        System.out.print("Like: [");
        for (int i=0; i<numImgs; i++) {
            System.out.print("" + labels.get(i) + ", ");
        }
        System.out.println("]");
        FavoriteFaceSelector selecotor = new FavoriteFaceSelector();
        System.out.println("Start Training...");
        selecotor.trainWith(imgs, indices, labels);
        System.out.println("Training done!! :)");
        List<FavoriteFaceSelector.ClassificationResult> results = selecotor.getSortedFavorites(imgs);
        int numResults = results.size();
        for (int i=0; i<numResults; i++) {
            FavoriteFaceSelector.ClassificationResult result = results.get(i);
            System.out.println("["+result.index+"] "+result.score+" ("+result.label+")");
        }
    }
}
