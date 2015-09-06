package enums;

public enum EspecialesTeclado {

	TAB("Tabulador"),
	CTRL_P("Control pulsado"),
	CTRL_S("Control suelto"),
	WIN("Windows"),
	ALT_P("Alt pulsado"),
	ALT_S("Alt suelto"),
	ENTRAR("Entrar"),
	BACKSPACE("BackSpace"),
	ESC("Escapar"),
	BLOQ_MAYUS("Bloqueo mayusculas"),
	MAYUS_P("Mayusculas pulsado"),
	MAYUS_S("Mayusculas suelto"),
	SUPR("Suprimir"),
	ALT_GR_P("Alt Gr pulsado"),
	ALT_GR_S("Alt Gr suelto"),
	INICIO("Inicio"),
	FIN("Fin"),
	F1("F1"),
	F2("F2"),
	F3("F3"),
	F4("F4"),
	F5("F5"),
	F6("F6"),
	F7("F7"),
	F8("F8"),
	F9("F9"),
	F10("F10"),
	F11("F11"),
	F12("F12");
	
	private String descripcion;
	
	private EspecialesTeclado(String descrip){
		this.descripcion=descrip;
	}
	
	public String getDescripcion(){
		return this.descripcion;
	}
	
}
