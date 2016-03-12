package se01;

class Par1 {

	private int num = 20;

	public Par1() {
		System.out.println("par-num:" + num);
		this.display();
	}

	public void display() {
		System.out.println("num:" + num + "   class:"
				+ this.getClass().getName());
	}

}

class Sub1 extends Par1 {
	private int num = 40;

	public Sub1() {
		num = 4000;
	}

	public void display() {
		System.out.println("sub-num:" + num + "   class:"
				+ this.getClass().getName());
	}
}

public class ParSubErrorTest {

	public static void main(String[] args) {
		new Sub1();
	}

}
