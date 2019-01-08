public class Foo implements AutoCloseable{
	private final String name;

	
	public Foo(String name) {this.name=name;}
	
	
	@Override
	public void close(){
		// TODO Auto-generated method stub
		throw new RuntimeException(name);
	}
	
	
	public static void main(String[] args){
		try(Foo foo0=new Foo("Foo0");
			Foo foo1=new Foo("Foo1");
			Foo foo2=new Foo("Foo2")){
			throw new ArrayIndexOutOfBoundsException("Initial");
		}
	}
	
}


	  

	  

	  

	



