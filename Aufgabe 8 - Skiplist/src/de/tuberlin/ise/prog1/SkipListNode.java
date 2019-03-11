package de.tuberlin.ise.prog1;

public final class SkipListNode<T extends Comparable<T>> {
	
	SkipListNode<T> next;
	SkipListNode<T> down;
	
    double key;//index of the getter
    T value;
    
    //Here are the constructors
    
    //constructor for index list:
    public SkipListNode(SkipListNode<T> next,SkipListNode<T> down){
    	this.next=next;
    	this.down=down;
    }
    //default constructor
    
    public SkipListNode(){
    	this.next=null;
    	this.down=null;
    }
    //constructor for the base list
    public SkipListNode(T i,SkipListNode<T> next){
    	this.next=next;
    	this.down=null;
    	this.value=i;
    }
    
    public void setNext(SkipListNode<T> node){
    	this.next=node;
    }
    public void setDown(SkipListNode<T> node){
    	this.down=node;
    }
    public void setValue(T value){
    	this.value=value;
    }
    public T getValue(){
    	if (this.down!=null){
    		return (T)this.down.getValue();
    	}
    	return this.value;
    }
    public void setKey(int key){
    	this.key=key;
    }

    


}
