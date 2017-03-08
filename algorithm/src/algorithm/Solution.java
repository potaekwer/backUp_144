package algorithm;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		// 11654��
		// Scanner scan = new Scanner(System.in);
		// String test;
		// test = scan.nextLine();
		// System.out.println((int)test.charAt(0));

		//
		// Scanner scan = new Scanner(System.in);
		// String test;
		//
		// test = scan.nextLine();
		//
		// for()

		int size, tern, num = 0;

		Scanner scan = new Scanner(System.in);
		size = scan.nextInt();
		tern = scan.nextInt();
		LinkedList list = new LinkedList();
		boolean check [] = new boolean [size];//갯수만큼의 논리형 배열지정
 		for(int i=0; i<size-1; i++){//1부터 입력받은 값 넣기
			num = i+1;
			list.add(i, num);			
		}
		list.addLast(num+1);//tail을 지정해줘야 원형 리스트가 됌
		num=-1;//방법이없음
		while(size>0){
			for(int i = 0; i<tern; i++){//2번째 이동갯수만큼 이동
				num++;
				if(check[(int) list.get(num)-1]){//지워진 값 검사32
					i--;
				}
			}
			System.out.print((int)list.get(num) +" ");
			check[(int) list.get(num)-1] = true;
			size--;		
		}
	}
}
class LinkedList {
	private Node head;
	private Node tail;
	private int size = 0;
	private class Node {
		private Object data;
		private Node next;

		public Node(Object input) {
			this.data = input;
			this.next = null;
		}

		public Node(Object input, Node re) {
			this.data = input;
			this.next = re;
		}
		public String toString() {
			return String.valueOf(this.data);
		}
	}

	public void addFirst(Object input) {
		Node newNode = new Node(input);
		newNode.next = head;
		head = newNode;
		size++;
		if (head.next == null) {
			tail = head;
		}
	}

	public void addLast(Object input) {
		Node newNode = new Node(input, head);
		if (size == 0) {
			addFirst(input);
		} else {
			tail.next = newNode;
			tail = newNode;
			size++;
		}
	}

	Node node(int index) {
		Node x = head;
		for (int i = 0; i < index; i++)
			x = x.next;
		return x;
	}

	public void add(int k, Object input) {
		if (k == 0) {
			addFirst(input);
		} else {
			Node temp1 = node(k - 1);
			Node temp2 = temp1.next;
			Node newNode = new Node(input);
			temp1.next = newNode;
			newNode.next = temp2;
			size++;
			if (newNode.next == null) {
				tail = newNode;
			}
		}
	}

	public String toString() {
		if (head == null) {
			return "[]";
		}
		Node temp = head;
		String str = "[";
		while (temp.next != null) {
			str += temp.data + ",";
			temp = temp.next;
		}
		str += temp.data;
		return str + "]";
	}

	public Object removeFirst() {
		// ù��° ��带 temp�� �����ϰ� head�� ���� �ι�° ���� �����մϴ�.
		Node temp = head;
		head = temp.next;
		// �����͸� �����ϱ� ���� ������ ���� �ӽ� ������ ����ϴ�.
		Object returnData = temp.data;
		temp = null;
		size--;
		return returnData;
	}

	public Object remove(int k) {
		if (k == 0)
			return removeFirst();
		// k-1��° ��带 temp�� ������ �����մϴ�.
		Node temp = node(k - 1);
		// ���� ��带 todoDeleted�� ����� �Ӵϴ�.
		// ���� ��带 ���� �����ϸ� ���� �� ���� ���� �� ��带 ������ �� �����ϴ�.
		Node todoDeleted = temp.next;
		// ���� �� ����� ���� ���� ���� �� ��带 �����մϴ�.
		temp.next = temp.next.next;
		// ������ �����͸� �����ϱ� ���ؼ� returnData�� �����͸� �����մϴ�.
		Object returnData = todoDeleted.data;
		if (todoDeleted == tail) {
			tail = temp;
		}
		// cur.next�� ���� �մϴ�.
		todoDeleted = null;
		size--;
		return returnData;
	}

	public Object removeLast() {
		return remove(size - 1);
	}

	public int size() {
		return size;
	}

	public Object get(int k) {
		Node temp = node(k);
		return temp.data;
	}

	public int indexOf(Object data) {
		// Ž�� ����� �Ǵ� ��带 temp�� �����մϴ�.
		Node temp = head;
		// Ž�� ����� ���° ������Ʈ�� �ִ����� �ǹ��ϴ� ������ index�� ����մϴ�.
		int index = 0;
		// Ž�� ���� Ž�� ����� ���� ���մϴ�.
		while (temp.data != data) {
			temp = temp.next;
			index++;
			// temp�� ���� null�̶�� ���� �� �̻� Ž�� ����� ���ٴ� ���� �ǹ��մϴ�.�� �� -1�� �����մϴ�.
			if (temp == null)
				return -1;
		}
		// Ž�� ����� ã�Ҵٸ� ����� �ε��� ���� �����մϴ�.
		return index;
	}

	// �ݺ��ڸ� �����ؼ� �������ݴϴ�.
	public ListIterator listIterator() {
		return new ListIterator();
	}

	class ListIterator {
		private Node lastReturned;
		private Node next;
		private int nextIndex;

		ListIterator() {
			next = head;
			nextIndex = 0;
		}

		// �� �޼ҵ带 ȣ���ϸ� next�� �������� ���� next.next�� ����˴ϴ�.
		public Object next() {
			lastReturned = next;
			next = next.next;
			nextIndex++;
			return lastReturned.data;
		}

		public boolean hasNext() {
			return nextIndex < size();
		}

		public void add(Object input) {
			Node newNode = new Node(input);
			if (lastReturned == null) {
				head = newNode;
				newNode.next = next;
			} else {
				lastReturned.next = newNode;
				newNode.next = next;
			}
			lastReturned = newNode;
			nextIndex++;
			size++;
		}

		public void remove() {
			if (nextIndex == 0) {
				throw new IllegalStateException();
			}
			LinkedList.this.remove(nextIndex - 1);
			nextIndex--;
		}

	}

}
