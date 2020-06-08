package br.com.area.comum.bo.interfaces;

import br.com.area.comum.dto.AreaComumReservaDTO;
import br.com.area.comum.dto.ReservaDTO;
import br.com.area.comum.entity.Reserva;
import br.com.area.comum.enums.Status;

import java.util.List;
import java.util.Optional;

public interface IReservaBO {
	
	List<AreaComumReservaDTO> buscarTodosPorStatusDTO(Status status);

	Optional<Reserva> buscarReserva(Long id);

	void removerReserva(Long id);

	Optional<ReservaDTO> buscarReservaDTO(Long id);

	Reserva salvarReserva(Reserva area);
}
