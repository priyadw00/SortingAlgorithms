import java.util.Iterator;




public class SelectionSort {
  
  public static CardPile sort(CardPile unsorted, SortRecorder record) {
    
    record.add(unsorted);

    CardPile sorted = new CardPile(2,2);

while (unsorted.isEmpty() == false){
  record.next(); 
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
  
   record.add(sorted);
   record.add(unsorted);
  }
  
    return sorted;
}
}
