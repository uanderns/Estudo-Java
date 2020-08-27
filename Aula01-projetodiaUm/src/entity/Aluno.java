package entity;

import javax.xml.bind.annotation.XmlElement;


public class Aluno {

	///tecnicas (refatorar do Codigo ou refinar)
	
	private Long id;
	private String nome;
	private String disciplina;
	private Double nota1;
	private Double nota2;
	@XmlElement
	private Double media;
	@XmlElement
	private String situacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public Double getNota1() {
		return nota1;
	}

	public void setNota1(Double nota1) {
		this.nota1 = nota1;
	}

	public Double getNota2() {
		return nota2;
	}

	public void setNota2(Double nota2) {
		this.nota2 = nota2;
	}

	public Double getMedia() {
		return media;
	}

	public void setMedia(Double media) {
		this.media = media;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public static void main(String[] args) {
		Aluno a = new Aluno();
		try {
			a.setId(10l);
			a.setNome("Uanderson");
			a.setNota1(8d);
			a.setNota2(10.);
			
			a.gerarMedia().gerarSituacao();
			System.out.println(a.getNome() + "," + a.getMedia() + 
					"," + a.getSituacao());
			System.out.println("Deu tudo OK");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	// gerarMedia REGRA DE NEGOCIO CRIADA ...
	// throws Exception ... (Informacao de metodo de Perigoso)
	public Aluno gerarMedia() throws Exception {
		if (this.getNota1() < 0 || this.getNota2() < 0) {
			throw new Exception("Nao existe nota negativa");
		}
		if (this.getNota1() > 10 || this.getNota2() > 10) {
			throw new Exception("A nota Máxima no sistema decimal 10");
		}
		this.setMedia((this.getNota1() + this.getNota2()) / 2);
		return this;
	}

	public Aluno gerarSituacao() {
		this.setSituacao((this.getMedia() >= 7) ? "aprovado" : "reprovado");
		return this;
	}

}
