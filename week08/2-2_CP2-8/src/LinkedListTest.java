
public class LinkedListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 실습 1, 2, 3
		List<Integer> list = new LinkedList<>();
		System.out.println("list size : " + list.size());
		System.out.println("list isEpmty? : " + list.isEmpty());
		System.out.println("list : " + list);
		System.out.println();

		// 실습 4, 5, 6, 7
		List<Integer> list2 = new LinkedList<>();
		for (int i = 5; i >= 0; i--)
			list2.addFirst(i);
		for (int i = 11; i <= 15; i++)
			list2.addLast(i);
		for (int i = 6; i <= 10; i++)
			list2.add(i, i);
		System.out.println(list2);

		System.out.println();

		// 실습 8, 9, 10
		List<Integer> list3 = new LinkedList<>();
		for (int i = 0; i < 20; i++)
			list3.addLast(i);
		System.out.println("리스트 : " + list3);
		System.out.println("removeFirst() 호출 : " + list3.removeFirst());
		System.out.println("removeLast() 호출 : " + list3.removeLast());
		System.out.println("remove(4) 호출 : " + list3.remove(4));
		System.out.println("변경된 리스트 : " + list3);
		System.out.println("get(5) 호출 : " + list3.get(5));
	}

}
