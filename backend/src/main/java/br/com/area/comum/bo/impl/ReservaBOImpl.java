package br.com.area.comum.bo.impl;

import br.com.area.comum.bo.interfaces.IReservaBO;
import br.com.area.comum.dto.AreaComumReservaDTO;
import br.com.area.comum.dto.ReservaDTO;
import br.com.area.comum.entity.Reserva;
import br.com.area.comum.enums.Status;
import br.com.area.comum.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ReservaBOImpl implements IReservaBO {

	@Autowired
	private ReservaRepository reservaRepository;

	@Override
	public List<AreaComumReservaDTO> buscarTodosPorStatusDTO(Status status) {
		return reservaRepository.getAreasStatus(status);
	}

	@Override
	public Optional<Reserva> buscarReserva(Long id) {
		// TODO Auto-generated method stub
		return reservaRepository.findById(id);
	}

	@Override
	public void removerReserva(Long id) {
		
	}

	@Override
	public Optional<ReservaDTO> buscarReservaDTO(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reserva salvarReserva(Reserva area) {
		// TODO Auto-generated method stub
		return reservaRepository.save(area);
	}	

	

	
}
