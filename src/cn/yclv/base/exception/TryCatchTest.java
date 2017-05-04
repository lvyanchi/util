package cn.yclv.base.exception;

public class TryCatchTest {
	public static void main(String[] args) {
		testException();
	}

	private static void testException() {
		try{	int a = 1;
			String s = "aaa";
			System.out.println("异常之前的代码");
			int parseInt = Integer.parseInt(s);
			System.out.println("出异常之后的代码");
			System.out.println(parseInt);
		} catch (Exception e) {
			System.out.println("执行到了Exception catch代码块");
			e.printStackTrace();
			String message = e.getMessage();
			System.out.println("e.getMessage()：" + message);
			System.out.println("e.getLocalizedMessage()：" + e.getLocalizedMessage());
			System.out.println("e.toString()：" + e.toString());
			System.out.println("e.getClass()：" + e.getClass());
			System.out.println("e.getClass().getName()：" + e.getClass().getName());
		} /*catch (NumberFormatException e) {
			System.out.println("执行到了NumberFormatException catch代码块");
			e.printStackTrace();
		} finally {
			System.out.println("打印了finally里的内容");
		}*/
	}
}
