public class Buffer {

	private static final int CAPACITY = 8;

	private final Movement[] buffer;
	private int count = 0;
	private int in = 0;
	private int out = 0;

	public Buffer() {
		this.buffer = new Movement[CAPACITY];
	}

	public synchronized void put(Movement O) {
		while (isFull()) {
			try {
				this.wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		input(O);
		notifyAll();
	}

	public synchronized Movement get() {
		while (isEmpty()) {
			try {
				this.wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		Movement O = remove();
		notifyAll();

		return O;
	}

	private boolean isFull() {
		return (count == CAPACITY);
	}

	private boolean isEmpty() {
		return (count == 0);
	}

	public void input(Movement O) {
		buffer[in] = O;
		in = (in + 1) % CAPACITY;
		count++;
	}

	private Movement remove() {
		Movement O = buffer[out];
		out = (out + 1) % CAPACITY;
		count--;
		return O;
	}
}