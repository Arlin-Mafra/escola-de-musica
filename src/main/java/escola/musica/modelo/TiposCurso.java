package escola.musica.modelo;

public enum TiposCurso {
	CORDAS("Cordas"),
	MADEIRA("Madeira"),
	METAIS("Metais"),
	PERCUSSAO("Percussão"),;

	private String label;

	private TiposCurso(String label) {
		this.label = label;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}



}
