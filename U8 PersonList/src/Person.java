public class Person {
	String name;
	int alter;
	private boolean angry;
	
	Person(String name,int a){
		this.name=name;
		this.alter= a;
	}
	
	public String toString(){
		return this.name+" is " +alter+" years old.";
	}
	
	void Update(){
		this.alter++;
	}

	public boolean isAngry() {
		return angry;
	}

	public void setAngry(boolean angry) {
		this.angry = angry;
	}

}
