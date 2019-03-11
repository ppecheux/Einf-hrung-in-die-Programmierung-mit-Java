package de.tuberlin.ise.prog1;

import java.util.Collection;
import java.util.Iterator;

public class SkipList implements Collection<Integer> {
	
	public int size;
	
	//declaration and initialisation index list
	SkipListNode fourth= new SkipListNode();
	SkipListNode third= new SkipListNode(fourth,null);
	SkipListNode second= new SkipListNode(third,null);
	SkipListNode first= new SkipListNode(second,null);
	
	//array of my index
	//SkipListNode ArrayIndex[]= new SkipListNode[4];
	SkipListNode ArrayIndex[]= {first,second,third,fourth};

	

	
	/**
	 * Returns the value at the specified position
	 * 
	 * @param index
	 * @return
	 */
	public Integer get(int index) {
		SkipListNode base = first.down;
		while (base.next!=null){
			if(base.key == index)return base.value;
			base=base.next;
		}
		return null;
	}
	

	/**
	 * Inserts a value into the SkipList.
	 * 
	 * @param value
	 * @return 
	 */
	//@Override
	public boolean add(Integer e) {
		SkipListNode newnode = new SkipListNode(e,null);
		if (size==0){
			for(SkipListNode node : ArrayIndex){
				node.down=newnode;
			}
			this.size++;
		}
		else{
			SkipListNode node = ArrayIndex[0];
			while (node.next!=null&&node.next.getValue()<e){//search into the index list
				if (node.next.getValue()<e)node=node.next;
				//System.out.println("getValueIndex");
			}
			
			node=node.down;
			while (node.next!=null&&node.next.getValue()<e){//search into the base list
				if (node.next.getValue()<e)node=node.next;
				//System.out.println("getValueBase");
			}
			//System.out.println("getValueBase");
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
		SkipListNode node = ArrayIndex[0].down;
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
	public void updatingIndexList(SkipListNode node,double pos){
		double indexPointer = Math.floor(this.size*pos);
		SkipListNode base = this.first.down;
		while(base.next!=null&&base.next.key<indexPointer){
			base=base.next;
		}
		node.down=base;
	}
	
	public String toString(){
		
		//printing the index list
		String str = "Head -> ";
		for(int i=0;i<4;i++){
			str = str + ArrayIndex[i].getValue()+" -> ";
		}
		str=str+ "null\n";
		//printing the base list
		str=str+"Head ->";
		SkipListNode node = this.first.down;
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
	public boolean contains(int value) {
		SkipListNode node = this.first;//head
		//search into the index list
		while(node.next!=null&&node.next.getValue()<=value){
			node=node.next;
		}
		node=node.down;
		//search into the base list
		while(node.next!=null&&node.next.getValue()<=value){
			node=node.next;
		}
		return (node.getValue()==value);
	}
	
	/**
	 * removes all elements form the list 
	 */
	//@Override
	public void clear() {
		// TODO Auto-generated method stub
		for(SkipListNode index: ArrayIndex){
			index.down=null;
		}
		
	}
	
	/**
	 * @return the size of the list
	 */
	//@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}
	
	

	//do not change the following methods
	
	//@Override
	public boolean isEmpty() {
		return size() <= 0;
	}
	
	//@Override
	public boolean contains(Object o) {
		try {
			Integer casted = (Integer) o;
			return contains(casted) ;
		} catch (ClassCastException e) {
			return false;
		}
	}
	
	
	//@Override
	@Deprecated
	public boolean remove(Object o) {
		return false;
	}

	//@Override
	public boolean containsAll(Collection<?> c) {
		for(Object o : c) {
			if(!contains(o)) {
				return false;
			}
		}
		return true;
	}

	//@Override
	public boolean addAll(Collection<? extends Integer> c) {
		for(Integer t:c) {
			add(t);
		}
		return true;
	}

	//@Override
	@Deprecated
	public boolean removeAll(Collection<?> c) {
		return false;
	}

	//@Override
	@Deprecated
	public boolean retainAll(Collection<?> c) {
		return false;
	}

	//@Override
	public Iterator<Integer> iterator() {
		//really slow way to implement this but should be some what understandable
		return new Iterator<Integer>() {
			int index = 0;
			//@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return index < size();
			}

			//@Override
			public Integer next() {
				return get(index++);
			}
		};
	}

	//@Override
	public Object[] toArray() {
		Object[] obj = new Object[size()];
		for (int i = 0; i < size(); i++) {
			obj[i] = get(i);
		}
		return obj;
	}

	@SuppressWarnings("unchecked")
	//@Override
	public <X> X[] toArray(X[] a) {
		for (int i = 0; i < size(); i++) {
			a[i] = (X) get(i);
		}
		return a;
	}


}
