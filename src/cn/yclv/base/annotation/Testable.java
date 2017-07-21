package cn.yclv.base.annotation;

public class Testable {
	
	public void execute(){
		System.out.println("executing...");
	}
	
	@Test
	void testExecute(){
		execute();
	}
}
