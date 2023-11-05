package hpl.utils;

import arc.math.Mathf;

import java.util.Arrays;

public class BoolGrid{
    boolean[] array;
    int width, height;

    public BoolGrid(){
    }

    public void updateSize(int newWidth, int newHeight){
        if(newWidth != width || newHeight != height){
            array = new boolean[newWidth * newHeight];
        }
        width = newWidth;
        height = newHeight;
    }

    public void clear(){
        Arrays.fill(array, false);
    }

    public boolean within(int x, int y){
        return x >= 0 && y >= 0 && x < width && y < height;
    }

    public boolean get(int x, int y){
        return array[x + (y * width)];
    }

    public int clampX(int x){
        return Mathf.clamp(x, 0, width - 1);
    }

    public int clampY(int y){
        return Mathf.clamp(y, 0, height - 1);
    }

    public void set(int x, int y, boolean b){
        array[x + (y * width)] = b;
    }
}