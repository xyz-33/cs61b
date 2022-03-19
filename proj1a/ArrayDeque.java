public class ArrayDeque<T>{
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

	public int size(){
		return size;
	}

	public boolean isEmpty(){
		int arraySize = size();
		if(arraySize == 0){
			return true;
		}
		else{
			return false;
		}
	}

	public boolean isFull(){
		int arraySize = size();
		if(arraySize == items.length - 2){
			//nextFirst和nextLast是队列两端的下一个位子,为了始终保证这两个指向的是空位
			return true;
		}
		else{
			return false;
		}		
	}

	public void addLast(T item){
		if(isFull()){
			resize(items.length * 2);
		}
		else{
			items[nextLast] = item;
			size++;
			nextLast = (nextLast + 1) % (items.length);
		}
	}

	public void addFirst(T item){
		if(isFull()){
			resize(items.length * 2);
		}
		else{
			items[nextFirst] = item;
			size++;
			nextFirst = (nextFirst - 1 + items.length) % items.length;
		}		
	}

	public T removeFirst(){
		if(isEmpty()){
			return null;
		}
		nextFirst = (nextFirst + 1) % items.length;
		T returnItem = items[nextFirst];
		items[nextFirst] = null;
		size--;
		return returnItem;
	}

	public T removeLast(){
		if(isEmpty()){
			return null;
		}
		nextLast = (nextLast -1 + items.length) % items.length;
		T returnItem = items[nextLast];
		items[nextLast] = null;
		size--;
		return returnItem;
	}

	public void printDeque(){
		int current = (nextFirst + 1) % items.length;//队首元素所在位置
		while(current != nextLast){
			System.out.print(items[current] + " ");
			current = (current + 1) % items.length;
		}
	}

	public T get(int index){
		int arraySize = size();
		if(isEmpty() || (index > arraySize-1)){
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
		int i;
		int current = (nextFirst + 1) % items.length;//队首元素所在位置
		for(i=0; i<size; i++){
			a[i] = items[current];
			current = (current + 1) % items.length;
		}
		items = a;
	}

}
