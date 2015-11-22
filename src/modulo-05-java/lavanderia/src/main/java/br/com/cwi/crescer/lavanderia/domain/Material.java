package br.com.cwi.crescer.lavanderia.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Material")
@SequenceGenerator(name = Material.SEQUENCE_NAME,
sequenceName = Material.SEQUENCE_NAME)
public class Material {
	
	public static final String SEQUENCE_NAME = "SEQ_Material";
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
	private Long idMaterial;
	private String descricao;
	
	public Long getIdMaterial() {
		return idMaterial;
	}
	public void setIdMaterial(Long idMaterial) {
		this.idMaterial = idMaterial;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
