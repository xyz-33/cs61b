public class ArrayDeque<T> implements Deque<T>{
	private T[] items;
	private int size;
	private int nextFirst;
	private int nextLast;

	public ArrayDeque(){
		items = (T []) new Object[8];
		size = 0;
		nextFirst = 3;
		nextLast = 4;
	}

	@Override
	public int size(){
		return size;
	}

	@Override
	public boolean isEmpty(){
		if(size == 0){
			return true;
		}
		else{
			return false;
		}
	}

	private boolean isFull(){
		if(size == items.length - 2){
			//nextFirst和nextLast是队列两端的下一个位子,为了始终保证这两个指向的是空位
			return true;
		}
		else{
			return false;
		}		
	}

	@Override
	public void addLast(T item){
		if(isFull()) {
			resize(items.length * 2);
		}
		items[nextLast] = item;
		size++;
		nextLast = (nextLast + 1) % (items.length);
	}

	@Override
	public void addFirst(T item){
		if(isFull()){
			resize(items.length * 2);
		}
		items[nextFirst] = item;
		size++;
		nextFirst = (nextFirst - 1 + items.length) % items.length;
	}

	@Override
	public T removeFirst(){
		if(isEmpty()){
			return null;
		}
		nextFirst = (nextFirst + 1) % items.length;
		T returnItem = items[nextFirst];
		items[nextFirst] = null;
		size--;
		while(size < items.length/4){
			resize(items.length/2);
		}
		return returnItem;
	}

	@Override
	public T removeLast(){
		if(isEmpty()){
			return null;
		}
		nextLast = (nextLast -1 + items.length) % items.length;
		T returnItem = items[nextLast];
		items[nextLast] = null;
		size--;
		while(size < items.length/4){
			resize(items.length/2);
		}
		return returnItem;
	}

	@Override
	public void printDeque(){
		System.out.println(items.length);
		int current = (nextFirst + 1) % items.length;//队首元素所在位置
		while(current != nextLast){
			System.out.print(items[current] + " ");
			current = (current + 1) % items.length;
		}
	}

	@Override
	public T get(int index){
		if(isEmpty() || (index > size-1)){
			return null;
		}
		int current = (nextFirst + 1) % items.length;//队首元素所在位置
		while(index > 0){
			current = (current + 1) % items.length;
			index--;
		}
		return items[current];		
	}

	private void resize(int capacity){
		T[] a = (T []) new Object[capacity];
		int current = (nextFirst + 1) % items.length;//队首元素所在位置
		//把原数组first到last一共size个元素，复制到新数组的0到size-1
		for(int i=0; i<size; i++){
			a[i] = items[current];
			current = (current + 1) % items.length;
		}
		items = a;
		//所以复制好之后，nextFirst是0前一格，即items.length - 1，nextLast是size-1后一格，即size
		nextFirst = items.length - 1;
		nextLast = size;
	}

}
