public interface IMovement {
	
	void reta(int distance);
	void curvarDireita(int radius, int angle);
	void curvarEsquerda(int radius, int angle);
	void parar(boolean assincrono);
	
}
