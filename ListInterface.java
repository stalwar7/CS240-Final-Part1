/*An Interface for ADT List * 
 * @author Sana Talwar
 * @version 1.0
 */
public interface ListInterface<T> {
	/** 
	 * Add an entry to the end of the list
	 * List size increased by one
	 * Other entry positions, will be unaffected
	 * @param item (the object added)
	 */
	  public void add(T item);
	  
	  /**
	   * Add an entry at a specified position of the list
	   * List size will be incremented by one
	   * Other item positions at or below specified position will be affected
	   * @param item
	   * @param position  - where item is added
	   * @throw IndexOutOfBoundsException if either position < 1 or position > getLength +1 
	   */
	  public void add (int position, T item);
	  
	  /**
	   * Remove an entry from the list at specified position
	   * @param position
	   * @return item at specified position
	   */
	  public T remove(int position);
	  
	  /**
	   * Gets item at specified position
	   *@param position
	   *@return Item at that position
	   *@throws IndexOutofBounds if List is empty 
	   */
	  public T view (int position);
	  
	  /**
	   * replaces item with entry at position
	   *@param position
	   *@param item
	   */
	  public void replace(int position, T item);
	  
	  /**
	   * Checks if list is contains any elements
	   * @return T/F
	   */
	  public boolean isEmpty();
	  
	  /**
	   * Removes all elements from the list
	   */
	  public void clear();	
	  
	  /**
	   * Checks to find item in list
	   * @return T/F
	   * @param item
	   * @return
	   */
	  public boolean contains(T item);
	  
	  /**
	   * @return number of elements in list
	   * @return
	   */
	  public int size();
	    
}
