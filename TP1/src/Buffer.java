import java.util.concurrent.Semaphore;

public class Buffer { // ISTO É COM SEMAPHOROS COM SEMAFROS

	private static final int CAPACITY = 8;

//
	private int numEspP = 0;
	private int numEspGr = 0;
	private final Semaphore mutex = new Semaphore(1);
	private final Semaphore empty = new Semaphore(CAPACITY);
	private final Semaphore full = new Semaphore(0);

	public Buffer() {
	}

	public void put(Object O) throws InterruptedException {
		mutex.acquire();
		while (isFull()) {
			numEspP++;
			mutex.release();
			full.acquire();
			mutex.acquire();
			numEspP--;
		}

		input(O); // Enviar para o robô???
		if (numEspGr > 0)
			empty.release();
		mutex.release();
	}

	public Object get() throws InterruptedException {
		mutex.acquire();
		while (isEmpty()) {
			numEspGr++;
			mutex.release();
			empty.acquire();
			mutex.acquire();
			numEspGr--;
		}

		Object O = remove(); // não sei
		if (numEspP > 0)
			full.release();
		mutex.release();

		return 0;

	}

	private boolean isFull() {
		return // (CAPACITY == elementos?????)    Do quadro --> C = e 

	private boolean isEmpty() {
		return (CAPACITY == 0); // WUT, isto não faz sentido??? Do quadro --> c = 0
	}

	private void input(Object O) {
		// POR FAZER
	}

	private Object remove() {
		return null; // POR FAZER
	}
}