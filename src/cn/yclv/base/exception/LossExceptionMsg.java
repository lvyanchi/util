package cn.yclv.base.exception;

public class LossExceptionMsg {
	void f() throws VeryImportantException{
		throw new VeryImportantException();
	}
	
	void dispose() throws TrivaialException{
		throw new TrivaialException();
	}
	
	public static void main(String[] args) {
		try {
			LossExceptionMsg le = new LossExceptionMsg();
			try {
				le.f();
			} finally{
				le.dispose();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}

class TrivaialException extends Exception{
	@Override
	public String toString() {
		return "a trivial exception";
	}
}

class VeryImportantException extends Exception{
	@Override
	public String toString() {
		return "a very important exception";
	}
}
