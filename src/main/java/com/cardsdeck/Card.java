package com.cardsdeck;

/**
 * Class representing a playing card from a standard 52-card deck.
 */
public class Card {

   // The min and max valid card values
   private static final int MIN_VALUE = 1;
   private static final int MAX_VALUE = 13;

   // This instance's value and suit
   private int value;
   private Suit suit;

   /**
    * Construct a Card with a given value and suit.
    */
   public Card(final int value, final Suit suit) {
      setValue(value);
      setSuit(suit);
   }

   /**
    * Return the card's value.
    */
   public int getValue() {
      return value;
   }

   /**
    * Set the card's value, with input validation.
    */
   public void setValue(final int value) {
      if (value < MIN_VALUE || value > MAX_VALUE) {
         throw new RuntimeException(
            String.format("Invalid value: %d (must be between %d and %d)", 
            value, MIN_VALUE, MAX_VALUE));
      }
      this.value = value;
   }

   /**
    * Return the card's value string name.
    */
   public String getStringValue() {

      String valueName = "";
      switch (this.value) {
         case MIN_VALUE:
            valueName = "Ace";
            break;
         case MAX_VALUE - 2:
            valueName = "Jack";
            break;
         case MAX_VALUE - 1:
            valueName = "Queen";
            break;
         case MAX_VALUE:
            valueName = "King";
            break;
         default:
            valueName = String.valueOf(value);
      }
      return valueName;
   }

   /**
    * Return the card's suit.
    */
   public Suit getSuit() {
      return suit;
   }

   /**
    * Set the card's suit, with input validation.
    */
   public void setSuit(final Suit suit) {
      if (suit == null) {
         throw new RuntimeException("Suit mustn't be null");
      }
      this.suit = suit;
   }

   @Override
   public final String toString() {
      return String.format("[%s%s]",
                           getStringValue(),
                           getSuit().getValue());
   }

   @Override
   public boolean equals(Object obj) {
      if (!(obj instanceof Card)) {
         return false;
      }
      if (obj == this) {
         return true;
      }
      Card that = (Card) obj;
      return that.getValue() == getValue() && that.getSuit() == getSuit();
   }

   /**
    * Return the minimum allowed value.
    */
   public static int getMinValue() {
      return MIN_VALUE;
   }

   /**
    * Return the maximum allowed value.
    */
   public static int getMaxValue() {
      return MAX_VALUE;
   }
}