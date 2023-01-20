import java.util.Iterator;
/**
 *  Program pretends to sort cards, omitting graphics
 *
 *  @author Priya Dalal-Whelan
 *  @version March 2022
 */
public class SelectionSortTimer {

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

  public static CardPile sort(CardPile unsorted) {

    CardPile sorted = new CardPile(2,2);

    while (unsorted.isEmpty() == false){

      Card smallest_card = unsorted.getFirst();
    
      Iterator<Card> iterator = unsorted.iterator();
  
    while(iterator.hasNext()){
      Card e = iterator.next();
      if (e.compareTo(smallest_card) > 0){
        smallest_card = e;
        }
      }
      
  unsorted.remove(smallest_card);
  sorted.addFirst(smallest_card);

  }
    return sorted;

  }
}

  