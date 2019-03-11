package de.tuberlin.ise.prog1;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SkipList<T extends Comparable<T>> implements Collection<T>  {
	
	
public int size;
	
	//declaration and initialisation index list
	SkipListNode<T> fourth= new SkipListNode<T>();
	SkipListNode<T> third= new SkipListNode<T>(fourth,null);
	SkipListNode<T> second= new SkipListNode<T>(third,null);
	SkipListNode<T> first= new SkipListNode<T>(second,null);
	
	//array of my index

	
		//{first,second,third,fourth};
	
	/**
	 * Returns the value at the specified position
	 * // retourne le T à l'index index
	 * @param index
	 * @return
	 */
	public T get(int index) {
		SkipListNode<T> base = first;
		while(base.next!=null){
			//iterating in the upper list
			if(base.next.down!=null){
				if(base.next.down.key>index){
					base=base.next;
				}
				else{
					base=base.down;
				}
			}
			//iterating the floor
			else{
				if(base.key == index)return base.value;
				base=base.next;
			}
			
		}
		return null;//at the end of the list
	}
	

	/**
	 * Inserts a value into the SkipList.
	 * 
	 * @param value
	 * @return 
	 */
	@Override
	public boolean add(T e) {
		SkipListNode<T> newnode = new SkipListNode(e,null);
		if (size==0){
			//initialising the down pointers
			first.down=newnode;
			second.down=newnode;
			third.down=newnode;
			fourth.down=newnode;
			this.size++;
		}
		else{
			SkipListNode<T> node = first;
			while (node.next!=null&& node.next.getValue().compareTo(e)<0){
				node=node.next;
			}
			//while (node.next!=null&&node.next.getValue()<e){//search into the index list
			//	if (node.next.getValue()<e)node=node.next;
			//}
			
			node=node.down;
			while (node.next!=null&&node.next.getValue().compareTo(e)<0){//search into the base list
					node=node.next;
			}
			//adding the new node to the list
			newnode.next=node.next;
			node.next=newnode;
			//updating the list
			this.updateKeyAndPointers();
			return true;		
		}
		
		return false;
	}
	public void updateKeyAndPointers(){
		//updating the key
		SkipListNode<T> node = first.down;
		int key=0;
		
		while (node.next!=null){
			node.key=key++;
			node=node.next;
		}
		//updating the size
			this.size=(key+1);
				
		//updating the index list
		updatingIndexList(this.second,0.3);
		updatingIndexList(this.third,0.6);
		updatingIndexList(this.fourth,0.8);
				
	}
	//to update the down pointers
	public void updatingIndexList(SkipListNode<T> node,double pos){
		double indexPointer = Math.floor(this.size*pos);
		SkipListNode<T> base = this.first.down;
		while(base.next!=null&&base.next.key<indexPointer){
			base=base.next;
		}
		node.down=base;
	}
	
	public String toString(){
		
		//printing the index list
		String str = "Head -> ";
		SkipListNode<T> head= first;
		while(head.next!=null){
			str = str + head.getValue()+" -> ";
			head=head.next;
		}
		str=str+head.getValue()+ " -> null\n";
		//printing the base list
		str=str+"Head ->";
		SkipListNode<T> node = this.first.down;
		do{
			str=str+node.getValue()+" -> ";
			node=node.next;
		}while(node.next!=null);
		str=str+node.getValue()+" -> ";//for the last one
		str=str+ "null\n";
		
		return str;
	}
	
	/**
	 * Checks, whether a number is contained in the list.
	 * @param value
	 * @return boolean value whether number is contained in list
	 */
	public boolean contains(T value) {
		SkipListNode<T> node = this.first;//head
		//search into the index list
		while(node.next!=null&&node.next.getValue().compareTo(value)<=0){
			node=node.next;
		}
		node=node.down;
		//search into the base list
		while(node.next!=null&&node.next.getValue().compareTo(value)<=0){
			node=node.next;
		}
		return (node.getValue()==value);
	}
	
	/**
	 * removes all elements form the list 
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		first.down=null;
		second.down=null;
		third.down=null;
		fourth.down=null;
	}
	
	/**
	 * @return the size of the list
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}
	
	

	//do not change the following methods
	
	@Override
	public boolean isEmpty() {
		return size() <= 0;
	}
	
	@Override
	public boolean contains(Object o) {
		try {
			T casted = (T) o;
			return contains(casted) ;
		} catch (ClassCastException e) {
			return false;
		}
	}
	
	
	@Override
	@Deprecated
	public boolean remove(Object o) {
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		for(Object o : c) {
			if(!contains(o)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		for(T t:c) {
			add(t);
		}
		return true;
	}

	@Override
	@Deprecated
	public boolean removeAll(Collection<?> c) {
		return false;
	}

	@Override
	@Deprecated
	public boolean retainAll(Collection<?> c) {
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		//really slow way to implement this but should be some what understandable
		return new Iterator<T>() {
			int index = 0;
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return index < size();
			}

			@Override
			public T next() {
				return get(index++);
			}
		};
	}

	@Override
	public Object[] toArray() {
		Object[] obj = new Object[size()];
		for (int i = 0; i < size(); i++) {
			obj[i] = get(i);
		}
		return obj;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <X> X[] toArray(X[] a) {
		for (int i = 0; i < size(); i++) {
			a[i] = (X) get(i);
		}
		return a;
	}


}
