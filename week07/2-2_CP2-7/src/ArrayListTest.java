
public class ArrayListTest {

	public static void main(String[] args) {
		// ����1 ��������
		List<Integer> list1 = new ArrayList<>(3);
		for (int i = 0; i < 20; i++)
			list1.addLast(i);
		System.out.println(list1);

		// ���� 2-1 ����ó��(add)
		List<Integer> list2 = new ArrayList<>(3);
		list2.add(1, 30); // �߸��� ��ġ�� ����
		System.out.println("List : " + list2 + "\n" + "size : " + list2.size());
		// remove�޼ҵ忡�� �߸��� ���ڰ� ���޵ȴٴ� ���� �迭�� null���� ����
		// �迭ũ�⸦ �Ѿ �ε����� �������� ���ε�, �迭�� null�̸� null�� ����ϵ���
		// �ڵ带 �����߰�, �走ũ�⸦ �Ѿ�� �����ڵ忡���� IndexOutOfBoundsException��
		// �߻��ϴµ� ������ �����϶���� �� �𸣰ڽ��ϴ�.

		// ���� 2-3 ����ó��(remove)
		List<Integer> list3 = new ArrayList<>(3);
		System.out.println(list3.remove(0)); // �ε������� null���� ��
		System.out.println(list3.remove(5)); // �迭ũ�⸦ �Ѿ �ε����� ȣ���� ��

		// ----------�ǽ�----------
		// ���� �ǽ� 2,3
		List<Integer> list = new ArrayList<>();
		// list.addLast(10);
		// list.addLast(20);
		// list.addLast(30);
		// System.out.println(list);
		// System.out.println();

		// ���� �ǽ� 4
		// list.addLast(10);
		// list.addLast(20);
		// list.addLast(30);
		// list.add(1, 15);
		// list.addFirst(-10);
		// System.out.println(list);
		// System.out.println();

		// �����ǽ� 5,6
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

		// �����ǽ� 7,8
		// list.addLast(10);
		// list.addLast(20);
		// list.addLast(30);
		// list.add(1, 15);
		// list.addFirst(-10);
		// System.out.println(list);
		// System.out.println("size : " + list.size());
		// System.out.println("20�� index : " + list.indexOf(20));
		// System.out.println("100�� index : " + list.indexOf(100));

	}

}
