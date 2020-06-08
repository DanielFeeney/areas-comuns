package br.com.area.comum.repository;

import br.com.area.comum.dto.AreaComumDTO;
import br.com.area.comum.dto.AreaComumReservaDTO;
import br.com.area.comum.dto.ReservaDTO;
import br.com.area.comum.entity.AreaComum;
import br.com.area.comum.entity.Reserva;
import br.com.area.comum.enums.Status;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

	@Query(value = "Select new br.com.area.comum.dto.AreaComumReservaDTO("
			+ "r.id, a.descricao, a.proprietario, a.endereco, a.telefone, r.dataReserva) "
			+ "from Reserva r "
			+ "join r.areaComum a "
			+ "where r.ativo = true and a.ativo = true and r.status = :status")
	List<AreaComumReservaDTO> getAreasStatus(@Param("status") Status status);

	
}
