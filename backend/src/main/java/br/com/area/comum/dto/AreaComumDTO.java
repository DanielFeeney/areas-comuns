package br.com.area.comum.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.area.comum.entity.AreaComum;
import br.com.area.comum.enums.Status;

public class AreaComumDTO {
	
	private Long id;

    private String descricao;
    
    private String proprietario;

    private String endereco;
    
    private String telefone;
    
    private boolean churrasqueira;
    
    private boolean piscina;
    
    private boolean salao;
    

	public AreaComumDTO() {
	}

	

	public AreaComumDTO(Long id, String descricao, String proprietario, String endereco, String telefone) {
		this.id = id;
		this.descricao = descricao;
		this.proprietario = proprietario;
		this.endereco = endereco;
		this.telefone = telefone;
	}
	
	
	
	public AreaComumDTO(Long id, String descricao, String proprietario, String endereco, String telefone,
			boolean churrasqueira, boolean piscina, boolean salao) {
		this.id = id;
		this.descricao = descricao;
		this.proprietario = proprietario;
		this.endereco = endereco;
		this.telefone = telefone;
		this.churrasqueira = churrasqueira;
		this.piscina = piscina;
		this.salao = salao;
	}


	public AreaComumDTO(AreaComum areaComum) {
		this.id = areaComum.getId();

	    this.descricao = areaComum.getDescricao();
	    
	    this.proprietario = areaComum.getProprietario();

	    this.endereco = areaComum.getEndereco();
	    
	    this.telefone = areaComum.getTelefone();
	    
	    this.churrasqueira = areaComum.isChurrasqueira();
	    
	    this.piscina = areaComum.isPiscina();
	    
	    this.salao = areaComum.isSalao();
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
	
	
    
}
