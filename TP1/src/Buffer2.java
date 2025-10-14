import java.util.concurrent.Semaphore;

public class Buffer2 { // O GAJO DECIDIU APAGAR O QUADRADO E "CRIOU" OUTRA MANEIRA DE FAZER O BUFFER.
						// EU NAO TO A ENTENDER NADA
						// EU ACHO QUE ISTO É "MONITORES"
	}

	private static final int CAPACITY = 8;

	private int numEspP = 0;
	private int numEspGr = 0;
	private final Semaphore mutex = new Semaphore(1);
	private final Semaphore empty = new Semaphore(CAPACITY);
	private final Semaphore full = new Semaphore(0);

	public Buffer2() {
	}

	public synchronized void put(Object O) throws InterruptedException {
		while (isFull()) {
			this.wait();
		}

		input(O); // Enviar as ações para o robô, penso eu???
		notifyAll();
	}

	public synchronized Object get() throws InterruptedException {
		while (isEmpty()) {
			this.wait();
		}

		Object O = remove(); // não sei, juro que não sei, elimninar a queue atual????
		notifyAll();

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