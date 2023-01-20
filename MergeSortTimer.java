/**
 *  Program sorts cards via merge sort 
 *
 *  @author Priya Dalal-Whelan
 *  @version March 2022
 */

import java.util.ArrayDeque;
import java.util.Iterator;

public class MergeSortTimer {

  /** Starts the program running */
  public static void main(String args[]) {
    
    if (args.length<1) {
      System.err.println("Please specify how many cards to sort!");
    } else {
      Card[] deck = Card.newDeck(true);
      CardPile cards = new CardPile(2,2);
      
      for (int i = 0; i<Integer.parseInt(args[0]); i++ ) {
        cards.add(deck[(int)(52*Math.random())]);
      }
      sort(cards);
      
    }
  }


  public static CardPile merge(CardPile a, CardPile b){
  
    //create new empty cardpile 
    CardPile c = new CardPile(2,2);
    
    while ((a.isEmpty() == false) & (b.isEmpty()== false)) {
      //System.out.println("in first while");
      
       if (a.getFirst().compareTo(b.getFirst()) < 0){
         c.addLast(a.remove()); 
       }
       else{
         c.addLast(b.remove());
       }   
    }
  c.append(a);
  c.append(b); 
  return c;
  }

  

  /** this method sorts by merge */
  
  public static CardPile sort(CardPile unsorted) {

        ArrayDeque<CardPile> queue = new ArrayDeque<CardPile>();

    Iterator<Card> iterator = unsorted.iterator(); 


    // creating singleton lists and adding them to the queue 
    
    while (iterator.hasNext()){
      CardPile next_cardpile = new CardPile(2,2);
      next_cardpile.addFirst(iterator.next());
      queue.addFirst(next_cardpile);

    }

    /// 
    while (queue.size() > 1){
      CardPile list_one = new CardPile(2,2);
      list_one = queue.remove();
      CardPile list_two = new CardPile(2,2);
      list_two= queue.remove(); 
      CardPile list_three = new CardPile(2,2);
      list_three = merge(list_one, list_two);
      queue.addLast(list_three);
    }
    
    // return the sorted result here
    return queue.remove();
    
    
    
    }
  }



