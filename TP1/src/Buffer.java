public class Buffer {

	private static final int CAPACITY = 8;

	private final Object[] buffer; 
	private int count = 0;        
	private int in = 0;           
	private int out = 0;          

	public Buffer() {
		this.buffer = new Object[CAPACITY]; 
	}

	public synchronized void put(Object O) throws InterruptedException {
		while (isFull()) {
			this.wait();
		}

		input(O); 
		notifyAll();
	}

	public synchronized Object get() throws InterruptedException {
		while (isEmpty()) {
			this.wait();
		}

		Object O = remove(); 
		notifyAll();

		return O; 
	}
    
	private boolean isFull() {
		return (count == CAPACITY);
	}

	private boolean isEmpty() {
		return (count == 0); 
	}

	private void input(Object O) {
		buffer[in] = O;
		in = (in + 1) % CAPACITY;
		count++;
	}

	private Object remove() {
		Object O = buffer[out]; 
		out = (out + 1) % CAPACITY;
		count--;
		return O; 
	}
}