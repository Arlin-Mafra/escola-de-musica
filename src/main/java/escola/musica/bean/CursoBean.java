package escola.musica.bean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import escola.musica.dao.CursoDAO;
import escola.musica.modelo.Curso;
import escola.musica.modelo.TiposCurso;

@ManagedBean
@SessionScoped
public class CursoBean {


	private Curso curso;

	private List<TiposCurso> tipos = Arrays.asList(TiposCurso.values());
	private List<Curso> cursos = new ArrayList<Curso>();

	public CursoBean() {
		cursos = new CursoDAO().listarCursos();
		curso = new Curso();
	}

	public String getDataAtual() {
		return new SimpleDateFormat("dd/MM/yyyy").format(new Date());
	}

	public String salvar() {
		new CursoDAO().salvar(curso);
		cursos = new CursoDAO().listarCursos();
		curso = new Curso();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Curso Salvo com sucesso!"));
		return "curso_lista?faces-redirect=true";
	}

	public String editar(Curso curso) {
		this.curso = curso;
		return "curso_formulario?faces-redirect=true";
	}


	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<TiposCurso> getTipos() {
		return tipos;
	}

	public void setTipos(List<TiposCurso> tipos) {
		this.tipos = tipos;
	}

}
