package de.tuberlin.ise.prog1;

public final class SkipListNode extends Object {
	
	SkipListNode next;
	SkipListNode down;
	
    double key;//index of the getter
    Integer value;
    
    //Here are the constructors
    
    //constructor for index list:
    public SkipListNode(SkipListNode next,SkipListNode down){
    	this.next=next;
    	this.down=down;
    }
    //default constructor
    
    public SkipListNode(){
    	this.next=null;
    	this.down=null;
    }
    //constructor for the base list
    public SkipListNode(Integer i,SkipListNode next){
    	this.next=next;
    	this.down=null;
    	this.value=i;
    }
    
    public void setNext(SkipListNode node){
    	this.next=node;
    }
    public void setDown(SkipListNode node){
    	this.down=node;
    }
    public void setValue(Integer value){
    	this.value=value;
    }
    public Integer getValue(){
    	if (this.down!=null){
    		return this.down.getValue();
    	}
    	return this.value;
    }
    public void setKey(int key){
    	this.value=key;
    }
}
