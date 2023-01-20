import java.util.ListIterator;


public class InsertionSortTimer {

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

/**sorts by insertion sort**/ 
  public static CardPile sort(CardPile unsorted) {

    // Here is the result list you will be creating
    CardPile sorted = new CardPile(2,2);

    sorted.add(unsorted.remove());
    
    while (unsorted.isEmpty() == false){

      Card moving_card = unsorted.removeFirst(); 
      /// with an iterator - 

/// if the moving card is bigger then the last card in the list 
      Card last_card = sorted.getLast(); 
      if (moving_card.compareTo(last_card) >= 0){
          sorted.addLast(moving_card);
        }
        
      else {
        ListIterator <Card> iterator = sorted.listIterator();
      while (iterator.hasNext()){
        Card e = iterator.next(); 
        //System.out.println("in iterator. e: " + e);
//System.out.println("compareTo is" + moving_card.compareTo(e));
        // if moving card is bigger 
        if (moving_card.compareTo(e) < 0){    
          //sorted.insertBefore(moving_card, e);
          //System.out.println("moving card is smaller");
          iterator.previous();
          iterator.add(moving_card);
          iterator.next();
          break ;
          }
       }
      
      }
   }
 return sorted;
  }

} // close class 