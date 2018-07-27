public class Object_16 {
	/**
	 * HashCodd
	 * Reference 주소를 반환해준다
	 * Equals가 같다면 HashCode도 같아야한다.
	 * 객체를 구별하기 위한 고유한 정수값 메소드
	 * HashTable, HashMap HashSet등에서 HashCode를 사용한다
	 * @param args
	 */

	public static void main(String[] args) {
		String hash = "Hash";
		System.out.println(hash.hashCode());

		Object obj = new Object();

		//public native int hashCode();
		//참조 변수를 출력하기 위한 Reference Address를 16진수로 출력한값이다.
		System.out.println(obj);
		System.out.println(Integer.toHexString(obj.hashCode()));
		System.out.println(obj.hashCode());

		//getClass 메소드 Runtime Type을 반환한다
		//다음과같이 수행된다. //Class<? extends String> cls = "".getClass();
		User user = new User("user");
		User specificUser = new SpecificUser("specificUser", "id");

		System.out.println(user.getClass());
		System.out.println(specificUser.getClass());

		//The actual static type returned by a call to getClass is Class<? on which getClass is called.
		//i.e. the following will compile:
		//{@code Class<? extends Number> c = n.getClass(); }
		//public final native Class<?> getClass();
		//Class<? extends String> cls = "".getClass();

		//clone 메소드
		//객체가 cloneable을 구현해야한다, 객체의 참조가 클론된 객체까지 미칠수있으므로 고려를해야한다
		User clonedUser = user.clone();
		System.out.println(user);
		System.out.println(clonedUser);

		//object constructor
		//object생성자는 암묵적으로 호출해준다. 추가 초기화가 수행되기전에 실제 Heap Object를 작성한다
		//생성자에서 super()를 넣지않으면 컴파일러에서 대신 넣습니다.
		//그런 다음 Object 생성자에서 실제 객체 생성은 JVM이 init 인스턴스 초기화를 담당하는 init 이라는 특수 메서드로 나타납니다
		//JVM에서 invokespecial이라는 명령어를 사용하여 객체의 init메소드를 호출한다.

		//finalize 메소드
		//객체에서 보호되어있으며 메모리에서 제거되기 전에 객체에 대한 작업을 정리할수 있다.
		//protected void finalize() throws Throwable { }
		//garbage collector가 더이상의 참조가 필요없다고 결정할 때, 이 메소드는 객체의 가비지 컬렉터에 의해 호출된다.
		//그러나 객체가 루트참조로 여전히 도달하면 가비지 컬렉터에 실행되지않으면 finlizer 메소드가 호출된다는 보장은 없다
		//@see FileInputStream finalize
		//filialize 메소드는 피해야하는 패턴이다 가비지컬렉터가 Heap 메모리영역이 부족할때 호출하는데
		//시스템이 임박한상태에 호출되는것이기 때문에 이럴때는 WeakRefercen를 쓰는게 좋다!
	}
}

class User implements Cloneable {
	private String name;

	public User(String name) {
		this.name = name;
	}

	public User clone() {
		User user = new User(name);

		return user;
	}
}

class SpecificUser extends User {
	private String id;

	public SpecificUser(String name, String id) {
		super(name);
		this.id = id;
	}
}

class MyClass {
	public MyClass() {
		super();
	}
}

class MyClass1 {
	//암묵적으로 super() 호출
	public MyClass1() {
	}
}

