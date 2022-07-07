package com.cardsdeck;

import static org.junit.Assert.assertTrue;

import java.util.logging.Logger;

import org.junit.Test;

/**
 * Unit test for Cards.
 */
public class CardTest {

   private static final Logger logger = Logger.getLogger(CardTest.class.getName()); 
    
   /**
   * Creates an Ace of hearts.
   */
   @Test
   public void cardTestAceOfHearts() {
      Card card = new Card(1, Suit.HEARTS);
      logger.info("An ace of hearts:");
      logger.info("Suit = " + card.getSuit().toString().toLowerCase());
      logger.info("Value = " + card.getValue());
      logger.info("Card = " + card.toString());
      
      assertTrue(card.getSuit().toString().toLowerCase().equals("hearts"));
      assertTrue(card.getValue() == 1);
   }

   /**
   * Creates an Jack of spades.
   */
   @Test
   public void cardTestJackOfSpades() {
      Card card = new Card(11, Suit.SPADES);
      logger.info("A jack of spades:");
      logger.info("Suit = " + card.getSuit().toString().toLowerCase());
      logger.info("Value = " + card.getValue());
      logger.info("Card = " + card.toString());
      
      assertTrue(card.getSuit().toString().toLowerCase().equals("spades"));
      assertTrue(card.getValue() == 11);
   }

   /**
   * Creates an Queen of clubs.
   */
   @Test
   public void cardTestQueenOfClubs() {
      Card card = new Card(12, Suit.CLUBS);
      logger.info("A queen of clubs:");
      logger.info("Suit = " + card.getSuit().toString().toLowerCase());
      logger.info("Value = " + card.getValue());
      logger.info("Card = " + card.toString());
      
      assertTrue(card.getSuit().toString().toLowerCase().equals("clubs"));
      assertTrue(card.getValue() == 12);
   }

   /**
   * Creates an King of diamonds.
   */
   @Test
   public void cardTestKingOfDiamonds() {
      Card card = new Card(13, Suit.DIAMONDS);
      logger.info("A king of diamonds:");
      logger.info("Suit = " + card.getSuit().toString().toLowerCase());
      logger.info("Value = " + card.getValue());
      logger.info("Card = " + card.toString());
      
      assertTrue(card.getSuit().toString().toLowerCase().equals("diamonds"));
      assertTrue(card.getValue() == 13);
   }

   /**
   * Creates an three of diamonds.
   */
   @Test
   public void cardTestThreeOfDiamonds() {
      Card card = new Card(3, Suit.DIAMONDS);
      logger.info("A three of diamonds:");
      logger.info("Suit = " + card.getSuit().toString().toLowerCase());
      logger.info("Value = " + card.getValue());
      logger.info("Card = " + card.toString());
      
      assertTrue(card.getSuit().toString().toLowerCase().equals("diamonds"));
      assertTrue(card.getValue() == 3);
   }

}
