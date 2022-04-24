package org.example.overrideexample;

public abstract class ItemImpl implements Item{
     private final int x;
     private final int y;
     private final int color;

     public ItemImpl(int x, int y, int color) {
          this.x = x;
          this.y = y;
          this.color = color;
     }


     @Override
     public String toString() {
          return "ItemImpl{" +
                  "x=" + x +
                  ", y=" + y +
                  ", color=" + color +
                  '}';
     }
}
