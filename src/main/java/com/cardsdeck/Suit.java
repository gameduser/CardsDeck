package com.cardsdeck;


/**
 * Enum representing playing card suits.
 */
public enum Suit {

   HEARTS("\u2665"),
   SPADES("\u2660"),
   CLUBS("\u2663"),
   DIAMONDS("\u2666");

   private final String value;

   private Suit(String value) {
      this.value = value;
   }

   public String getValue() {
      return this.value;
   }
}
