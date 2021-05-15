package model;

public class Chip {
   
   // enum - WHITE, BLACK, or RED
   private ChipColor color;

   public Chip(ChipColor color) {
      this.color = color;
   }
   public void setColor(ChipColor color) {
      this.color = color;
   }

   public ChipColor getColor() {
      return color;
   }
   
}
