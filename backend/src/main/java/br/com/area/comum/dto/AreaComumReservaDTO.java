package br.com.area.comum.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AreaComumReservaDTO {
	
	private Long id;

    private String descricao;
    
    private String proprietario;

    private String endereco;
    
    private String telefone;
    
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date dataReserva;
    
    

	public AreaComumReservaDTO() {
		super();
	}

	public AreaComumReservaDTO(Long id, String descricao, String proprietario, String endereco, String telefone, Date dataReserva) {
		this.id = id;
		this.descricao = descricao;
		this.proprietario = proprietario;
		this.endereco = endereco;
		this.telefone = telefone;
		this.dataReserva = dataReserva;
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

	public Date getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(Date dataReserva) {
		this.dataReserva = dataReserva;
	}
	
	
}
