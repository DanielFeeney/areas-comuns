package br.com.area.comum.endPoint;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.area.comum.bo.interfaces.IAreaComumBO;
import br.com.area.comum.bo.interfaces.IReservaBO;
import br.com.area.comum.dto.AreaComumReservaDTO;
import br.com.area.comum.dto.ReservaDTO;
import br.com.area.comum.bo.interfaces.IAreaComumBO;
import br.com.area.comum.entity.AreaComum;
import br.com.area.comum.entity.Reserva;
import br.com.area.comum.enums.Status;

@RestController
@CrossOrigin
@RequestMapping("/reserva")
public class AreaReservaProvider {

	@Autowired
	private IReservaBO reservaBO;
	
	@Autowired
	private IAreaComumBO areaComumBO;
	
	@GetMapping("/pendentes")
	public ResponseEntity<Object> buscarTodosAreaComumPendente() {
		List<AreaComumReservaDTO> listAreaComumReservaDTO = reservaBO.buscarTodosPorStatusDTO(Status.PENDENTE);
		return ResponseEntity.status(HttpStatus.OK).body(listAreaComumReservaDTO);
	}
	
	@GetMapping("/aprovadas")
	public ResponseEntity<Object> buscarTodosAreaComumAprovada() {
		List<AreaComumReservaDTO> listAreaComumReservaDTO = reservaBO.buscarTodosPorStatusDTO(Status.APROVADA);
		return ResponseEntity.status(HttpStatus.OK).body(listAreaComumReservaDTO);
	}
	
	@GetMapping("/rejeitadas")
	public ResponseEntity<Object> buscarTodosAreaComumRejeitada() {
		List<AreaComumReservaDTO> listAreaComumReservaDTO = reservaBO.buscarTodosPorStatusDTO(Status.REJEITADA);
		return ResponseEntity.status(HttpStatus.OK).body(listAreaComumReservaDTO);
	}
	
	@GetMapping("/canceladas")
	public ResponseEntity<Object> buscarTodosAreaComumCancelada() {
		List<AreaComumReservaDTO> listAreaComumReservaDTO = reservaBO.buscarTodosPorStatusDTO(Status.CANCELADA);
		return ResponseEntity.status(HttpStatus.OK).body(listAreaComumReservaDTO);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> reservarArea(
			@PathVariable Long id,
			@RequestBody ReservaDTO reservaDTO) {
		Optional<AreaComum> areaOpt = areaComumBO.buscarArea(id);
		if(areaOpt.isPresent()) {
			Reserva reserva = new Reserva();
			reserva.setReservaPendente(reservaDTO);
			reserva.setAreaComum(areaOpt.get());
			reserva = reservaBO.salvarReserva(reserva);
			return ResponseEntity.status(HttpStatus.OK).body(reserva);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@PutMapping("/aprovar/{id}")
	public ResponseEntity<Object> aprovarReserva(
			@PathVariable Long id) {
		Optional<Reserva> reservaOpt = reservaBO.buscarReserva(id);
		if(reservaOpt.isPresent()) {
			Reserva reserva = reservaOpt.get();
			reserva.setStatus(Status.APROVADA);
			reserva = reservaBO.salvarReserva(reserva);
			return ResponseEntity.status(HttpStatus.OK).body(reserva);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@PutMapping("/rejeitar/{id}")
	public ResponseEntity<Object> rejeitarReserva(
			@PathVariable Long id) {
		Optional<Reserva> reservaOpt = reservaBO.buscarReserva(id);
		if(reservaOpt.isPresent()) {
			Reserva reserva = reservaOpt.get();
			reserva.setStatus(Status.REJEITADA);
			reserva = reservaBO.salvarReserva(reserva);
			return ResponseEntity.status(HttpStatus.OK).body(reserva);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@PutMapping("/cancelar/{id}")
	public ResponseEntity<Object> cancelarReserva(
			@PathVariable Long id) {
		Optional<Reserva> reservaOpt = reservaBO.buscarReserva(id);
		if(reservaOpt.isPresent()) {
			Reserva reserva = reservaOpt.get();
			reserva.setStatus(Status.CANCELADA);
			reserva = reservaBO.salvarReserva(reserva);
			return ResponseEntity.status(HttpStatus.OK).body(reserva);
		}
		return ResponseEntity.badRequest().build();
	}



	/*public ResponseEntity<Object> reservarArea(@RequestBody AreaComumDTO areaDTO) {
		Optional<AreaComum> areaOpt = reservaBO.buscarArea(areaDTO.getId());	
		if(areaOpt.isPresent()) {
			AreaComum area = areaOpt.get();
			area.setDataReserva(areaDTO.getDataReserva());
			area = reservaBO.salvarReserva(area);
			return ResponseEntity.status(HttpStatus.OK).body(area);
		}
		return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
	}*/

	/*
	 * @PostMapping("/status") public ResponseEntity<Object> statusArea(@RequestBody
	 * AreaComumDTO areaDTO) { Optional<AreaComum> areaOpt =
	 * areaComumBO.buscarArea(areaDTO.getId()); if(areaOpt.isPresent()) { AreaComum
	 * area = areaOpt.get(); Status status = Status.valueOf(areaDTO.getStatus());
	 * area.setStatus(status); area = areaComumBO.salvarArea(area); return
	 * ResponseEntity.status(HttpStatus.OK).body(area); } return
	 * ResponseEntity.status(HttpStatus.BAD_GATEWAY).build(); }
	 */

}
