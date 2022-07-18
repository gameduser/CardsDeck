package com.cardsdeck;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.logging.Logger;

import org.apache.commons.lang3.ArrayUtils;

/**
 * Class representing a deck of cards.
 */
class Deck implements Iterable<Card> {

   private Card[] cards;
   private int top;
   private static final Logger logger = Logger.getLogger(Deck.class.getName()); 


   /**
    * Deck constructor.
    */
   public Deck() {
      cards = new Card[Suit.values().length * (Card.getMaxValue() - Card.getMinValue() + 1)];
      createDeck();
   }

   /**
    * Return the number of remaining cards.
    */ 
   public int getSize() {
      return cards.length;
   }

   /**
    * Creates the deck with a full set of cards.
    */
   private void createDeck() {
      Suit[] suits = Suit.values();
      int minValue = Card.getMinValue();
      int maxValue = Card.getMaxValue();

      int i = 0;
      for (Suit suit : suits) {
         for (int value = minValue; value <= maxValue; value++) {
            cards[i++] = new Card(value, suit);
         }
      }
      top = cards.length - 1;
      assert cards[top] != null;
   }

   /**
    * Shuffle the deck, leaving the cards in a random order.
    */
   public void shuffle() {

      Random rng = new Random();

      for (int i = cards.length - 1; i > 0; i--) {
         // Swap the i-th card with a random one with linear complexity.
         int j = rng.nextInt(i + 1);
         Card tmp = cards[j];
         cards[j] = cards[i];
         cards[i] = tmp;
      }
   }

   /**
    * Return true if the deck is empty.
    */
   public boolean empty() {
      return top < 0;
   }

   /**
    * Take a card from the deck and return it. We remove it from the deck.
    */
   public Card dealOneCard() {
      if (empty()) {
         throw new IllegalStateException("Can't deal from an empty deck.");
      }
      Card card = cards[top--];
      cards = ArrayUtils.remove(cards, top + 1);
      return card;
   }

   /**
    * Print the current state of the deck.
    */
   public void print() {
      if (empty()) {
         logger.info("The deck is empty.");
         return;
      }

      logger.info("The current deck:");
      for (Card card : this) {
         logger.info("  " + card);
      }
   }

   /**
    * Return an iterator of the deck's cards.
    */
   public Iterator<Card> iterator() {
      return new Iterator<Card>() {
         private int cursor = top;

         public boolean hasNext() {
            return cursor >= 0;
         }

         public Card next() {
            if (hasNext()) {
               return cards[cursor--];
            }
            throw new NoSuchElementException();
         }

         public void remove() {
            throw new UnsupportedOperationException();
         }
      };
   }

   @Override
   public boolean equals(Object obj) {
      if (!(obj instanceof Deck)) {
         return false;
      }
      if (obj == this) {
         return true;
      }
      Deck that = (Deck) obj;
      return Arrays.equals(that.cards, cards);
   }
}