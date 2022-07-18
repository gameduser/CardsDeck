package com.cardsdeck;

import static org.junit.Assert.assertFalse;

import java.util.logging.Logger;

import org.junit.Test;

/**
 * Unit test for Deck.
 */
public class DeckTest {

   private static final Logger logger = Logger.getLogger(DeckTest.class.getName()); 
    
   /**
   * Shuffles the deck.
   */
   @Test
   public void deckTestShuffle() {
      Deck deck1 = new Deck();
      Deck deck2 = new Deck();
      
      assert deck1.equals(deck2);
      logger.info("Deck before shuffle:");
      deck1.print();

      deck1.shuffle();
      logger.info("Deck after shuffle:");
      deck1.print();
      assertFalse(deck1.equals(deck2));
   }

   /**
   * Deals the cards from the desk.
   */
   @Test
   public void deckTestDealOneCard() {
      Deck deck = new Deck();
      int cardsNumber = Suit.values().length * (Card.getMaxValue() - Card.getMinValue() + 1);

      logger.info("Let's start dealing cards.");
      for (int i = 0; i < cardsNumber; i++) {
         assert deck.getSize() == cardsNumber - i;
         Card card = deck.dealOneCard();
         logger.info(card.toString());
         assert deck.getSize() == cardsNumber - i - 1;
      }

      logger.info("After dealing every card:");
      deck.print();
   }
}
