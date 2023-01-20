public class Quicksort {
  
  public static CardPile sort(CardPile unsorted, SortRecorder record) {

    
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
    
    // register the partitions with the recorder
    record.add(smaller);
    record.add(pivot);
    record.add(bigger);
    record.next();

    // This will hold the assembled result
    CardPile result = new CardPile(2,2);
    

    if (smaller.isEmpty()==false){
        //System.out.println("smaller has contents");
       smaller = sort(smaller, record);
        
    }
    if (bigger.isEmpty() == false){
       //System.out.println("bigger has contents");
        bigger = sort(bigger, record);
  
    }
  

    result.append(smaller); 
    result.add(pivot);
    result.append(bigger);
    //System.out.println("result: " + result);


    // record the sorted result
    record.add(result);
    record.next();
    
    // return the sorted result here
    return result;
  }
}
