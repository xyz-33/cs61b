public class LinkedListDeque<T> implements Deque<T> {
	private Node sentinel;
	private int size;

	private class Node{
		public T data;
		public Node previous;
		public Node next;

		public Node(T item){
			data = item;
			previous = null;
			next = null;
		}
	}
	public LinkedListDeque(){
		sentinel = new Node(null);
		sentinel.next = sentinel.previous = sentinel;
		//初始时sentinel的next和previous都指向自己
		//这句很重要，sentinel的next和previous不能为null
		//这句也保证了只有sentinel时，addFirst()不出错，唯一一个节点能和sentinel组成循环链表
		size = 0;
	}

	@Override
	public boolean isEmpty(){
		if(sentinel.next == sentinel){
			return true;
		}
		return false;
	}

	@Override
	public int size(){
		return size;
	}

	@Override
	public void addFirst(T item){
		Node x = new Node(item);
		//x的next指向下一个节点
		x.next = sentinel.next;
		//x的previous指向sentinel
		x.previous = sentinel;
		//x的下一个节点的previous指向x
		sentinel.next.previous = x;
		//sentinel的next指向x
		sentinel.next = x;
		//可以在纸上画一下，只有sentinel时也是对的，能保证唯一一个节点能和sentinel组成循环链表
		size++;
	}

	@Override
	public T removeFirst(){
		if(isEmpty()){
			return null;
		}
		Node firstNode = sentinel.next;
		sentinel.next = sentinel.next.next;
		sentinel.next.previous = sentinel;
		size--;
		return firstNode.data;
	}

	@Override
	public void addLast(T item){
		Node x = new Node(item);
		//x的next指向sentinel
		x.next = sentinel;
		//x的previous指向之前的最后一个节点
		x.previous = sentinel.previous;
		//之前的最后一个节点的next指向x
		sentinel.previous.next = x;
		//sentinel的previous指向x
		sentinel.previous = x;
		size++;
	}

	@Override
	public T removeLast(){
		if(isEmpty()){
			return null;
		}
		Node lastNode = sentinel.previous;
		sentinel.previous.previous.next = sentinel;
		sentinel.previous = sentinel.previous.previous;
		size--;
		return lastNode.data;
	}

	@Override
	public void printDeque(){
		if(isEmpty()){
			return;
		}
		Node current = sentinel.next;//从第一个节点开始
		while(current.next != sentinel){
			System.out.print(current.data + " ");
			current = current.next;
		}
		//当current移动到最后一个节点时,current.next==sentinel
		//所以还要单独打印最后一个节点的内容
		System.out.print(current.data);
	}

	@Override
	public T get(int index){
		if(isEmpty() || (index > size-1)){
			return null;
		}
		Node current = sentinel.next;//从第一个节点开始
		while(index > 0){
			current = current.next;
			index--;
		}
		return current.data;
	}

	private T getRecursiveHelper(Node firstNode, int index){
		if(index == 0){
			return firstNode.data;
		}
		else{
			return getRecursiveHelper(firstNode.next, index-1);
		}
	}

	public T getRecursive(int index){
		if(index > size - 1){
			return null;
		}
		return getRecursiveHelper(sentinel.next, index);
	}
}
