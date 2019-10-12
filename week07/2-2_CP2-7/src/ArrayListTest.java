
public class ArrayListTest {

	public static void main(String[] args) {
		// 과제1 가변길이
		List<Integer> list1 = new ArrayList<>(3);
		for (int i = 0; i < 20; i++)
			list1.addLast(i);
		System.out.println(list1);

		// 과제 2-1 예외처리(add)
		List<Integer> list2 = new ArrayList<>(3);
		list2.add(1, 30); // 잘못된 위치에 삽입
		System.out.println("List : " + list2 + "\n" + "size : " + list2.size());
		// remove메소드에서 잘못된 인자가 전달된다는 것이 배열이 null값일 때랑
		// 배열크기를 넘어간 인덱스를 삭제했을 때인데, 배열이 null이면 null을 출력하도록
		// 코드를 수정했고, 배뎔크기를 넘어가면 원래코드에서도 IndexOutOfBoundsException이
		// 발생하는데 무엇을 수정하라는지 잘 모르겠습니다.

		// 과제 2-3 예외처리(remove)
		List<Integer> list3 = new ArrayList<>(3);
		System.out.println(list3.remove(0)); // 인덱스값이 null값일 때
		System.out.println(list3.remove(5)); // 배열크기를 넘어간 인덱스를 호출할 때

		// ----------실습----------
		// 구현 실습 2,3
		List<Integer> list = new ArrayList<>();
		// list.addLast(10);
		// list.addLast(20);
		// list.addLast(30);
		// System.out.println(list);
		// System.out.println();

		// 구현 실습 4
		// list.addLast(10);
		// list.addLast(20);
		// list.addLast(30);
		// list.add(1, 15);
		// list.addFirst(-10);
		// System.out.println(list);
		// System.out.println();

		// 구현실습 5,6
		// list.addLast(10);
		// list.addLast(20);
		// list.addLast(30);
		// list.add(1, 15);
		// list.addFirst(-10);
		// System.out.println(list.remove(2));
		// System.out.println(list.removeLast());
		// System.out.println(list.removeFirst());
		// System.out.println(list.get(0));
		// System.out.println(list);

		// 구현실습 7,8
		// list.addLast(10);
		// list.addLast(20);
		// list.addLast(30);
		// list.add(1, 15);
		// list.addFirst(-10);
		// System.out.println(list);
		// System.out.println("size : " + list.size());
		// System.out.println("20의 index : " + list.indexOf(20));
		// System.out.println("100의 index : " + list.indexOf(100));

	}

}
