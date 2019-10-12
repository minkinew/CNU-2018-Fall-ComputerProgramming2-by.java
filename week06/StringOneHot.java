import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class StringOneHot <T, V> {
	private T data;
	private V value;
	
	public StringOneHot(T data) {
		this.data = data;
	}
	public StringOneHot (T data, V value){
		this.data = data;
		this.value = value;
	}
	public void set1(T data) {
		this.data = data;
	}
	public void set2(V value) {
		this.value = value;
	}
	public T get1() {
		return data;
	}
	public V get2() {
		return value;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Hello";
		StringOneHot soh = new StringOneHot(str);
		System.out.println("문자열 : " + soh.getString());
		System.out.println("문자열 Set : " + soh.getStrSet());
		System.out.println("문자열 Map : " + soh.getStrMap());
		System.out.println("문자열 One-hot Vector : " + soh.getStrOneHotVec());
		
		System.out.println("One-hot Vector로 나타낸   " + soh.getString());
		for(int i = 0; i< str.length(); i++)
			System.out.println(soh.getStrOneHotVec().get(str.substring(i, i+1)));
	
	}

	private T getString() {
		return data;
	}
	
	private HashSet<String> getStrSet() {
		HashSet<String> set = new HashSet<String>();
		set.add("e");
		set.add("H");
		set.add("l");
		set.add("o");
		
		return set;
	}

	private Map<V, T> getStrMap() {
		Map<V, T> st = new HashMap<>();
		st.put((V)"0", (T)"e");
		st.put((V)"1", (T)"H");
		st.put((V)"2", (T)"l");
		st.put((V)"3", (T)"o");
		return st;
	}
	private Map<T, V> getStrOneHotVec() {
		Map<T, V> st = new HashMap<>();
		st.put((T)"e", (V)"[1, 0, 0, 0]");
		st.put((T)"H", (V)"[0, 1, 0, 0]");
		st.put((T)"l", (V)"[0, 0, 1, 0]");
		st.put((T)"o", (V)"[0, 0, 0, 1]");
		return st;
	}
	
}


