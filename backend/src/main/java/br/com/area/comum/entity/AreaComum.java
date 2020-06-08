package br.com.area.comum.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.google.gson.annotations.Expose;

import br.com.area.comum.dto.AreaComumDTO;
import br.com.area.comum.enums.Status;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class AreaComum implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "Insira uma descrição")
    @Column(columnDefinition = "text")
    private String descricao;
    
    @NotNull
    @Column
    private String proprietario;

    @NotNull(message = "Insira o endereço")
    @Column
    private String endereco;
    
    @NotNull(message = "Insira o telefone")
    @Length(max = 11, min = 7, message = "Tamanho inválido de telefone")
    @Column
    private String telefone;
    
    @Column
    private boolean churrasqueira;
    
    @Column
    private boolean piscina;
    
    @Column
    private boolean salao;
    
    
    @NotNull
    @Column
    private boolean ativo;
    
    
    
    public AreaComum() {
    	this.ativo = true;
    	this.churrasqueira = false;
    	this.piscina = false;
    	this.salao = false;
	}

    //CRUD
	public void setArea(AreaComumDTO areaComumDTO) {
		this.ativo = true;
		this.descricao = areaComumDTO.getDescricao();
		this.proprietario = areaComumDTO.getProprietario();
		this.endereco = areaComumDTO.getEndereco();
		this.telefone = areaComumDTO.getTelefone().replace("(", "").replace(")", "").replace("-", "").replace(" ", "");		
		this.churrasqueira = areaComumDTO.isChurrasqueira();
    	this.piscina = areaComumDTO.isPiscina();
    	this.salao = areaComumDTO.isSalao();
    }
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public boolean isChurrasqueira() {
		return churrasqueira;
	}

	public void setChurrasqueira(boolean churrasqueira) {
		this.churrasqueira = churrasqueira;
	}

	public boolean isPiscina() {
		return piscina;
	}

	public void setPiscina(boolean piscina) {
		this.piscina = piscina;
	}

	public boolean isSalao() {
		return salao;
	}

	public void setSalao(boolean salao) {
		this.salao = salao;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AreaComum other = (AreaComum) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
