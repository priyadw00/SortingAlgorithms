/**
 *  Program pretends to sort cards, omitting graphics
 *
 *  @author Priya Dalal-Whelan
 *  @version March 2022
 */
public class QuickSortTimer {

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

    // Here are the two partitions you will be creating
    CardPile smaller = new CardPile(2,2);
    CardPile bigger = new CardPile(2,2);


//System.out.println("unsorted:" + unsorted);
    Card pivot = unsorted.remove(); 
     //System.out.println("pivot: " + pivot);
    Card current_card; 
    while (unsorted.isEmpty() == false){
      current_card = unsorted.remove();
      //System.out.println("current card: " + current_card);
     
      if (current_card.compareTo(pivot) < 0) 
      {
        smaller.add(current_card);
        //System.out.println("compareTo is: " + current_card.compareTo(pivot) + "added to smaller");
      }
      else {
         //System.out.println("compareTo is: " + current_card.compareTo(pivot) + "add to bigger");
        bigger.add(current_card);
      }
    }
   

    // This will hold the assembled result
    CardPile result = new CardPile(2,2);
    

    if (smaller.isEmpty()==false){
       smaller = sort(smaller);
        
    }
    if (bigger.isEmpty() == false){
        bigger = sort(bigger);
  
    }
  

    result.append(smaller); 
    result.add(pivot);
    result.append(bigger);

    
    // return the sorted result here
    return result;
  } 

  





}