public interface RadioGeneral {

    boolean isON();
    void encender();
    void apagar();
    void incrementar();
	//num posicion (1-12)
    boolean asignar(int num);
    boolean emisora(int num);
    void frecuencia();

}
