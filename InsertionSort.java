import java.util.ListIterator;


public class InsertionSort {
  
  public static CardPile sort(CardPile unsorted, SortRecorder record) {
    
    // register the starting configuration with the recorder
    record.add(unsorted);

    // Here is the result list you will be creating
    CardPile sorted = new CardPile(2,2);

    sorted.add(unsorted.remove());
    
    while (unsorted.isEmpty() == false){
      //System.out.println("in first while loop");
      record.next();
      Card moving_card = unsorted.removeFirst(); 
      //System.out.println("moving card is:" + moving_card);


/// if the moving card is bigger then the last card in the list 
      Card last_card = sorted.getLast(); 
      //System.out.println("last card:" + last_card);
      if (moving_card.compareTo(last_card) >= 0){
          //System.out.println("moving card is bigger then last card");
          sorted.addLast(moving_card);
          //System.out.println("inserted at end of unsorted");  
        }

        // if not iteratre throught sorted to find the right spot 
        
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
          ///ITERATOR IS ADDING IT AFTER IM GOING TO CRY 
          
          // use itereator to insert 
          //System.out.println("inserted ");
          break ;
          }
      }
      
       
      
        
     // adjust for what to do if there's no spot for the moving card, meanin g moving card is bigger then everything else 
    
      }
      record.add(sorted);
      record.add(unsorted);

  }
 return sorted;
 }
}
