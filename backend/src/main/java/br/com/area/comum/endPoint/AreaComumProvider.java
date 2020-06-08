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
import br.com.area.comum.dto.AreaComumDTO;
import br.com.area.comum.bo.interfaces.IAreaComumBO;
import br.com.area.comum.entity.AreaComum;

@RestController
@CrossOrigin
@RequestMapping("/area")
public class AreaComumProvider {

	@Autowired
	private IAreaComumBO areaComumBO;

	@GetMapping
	public ResponseEntity<Object> buscarTodosAreaComum() {
		List<AreaComumDTO> listAreaDTO = areaComumBO.buscarTodosDTO();
		return ResponseEntity.status(HttpStatus.OK).body(listAreaDTO);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> buscarArea(@PathVariable Long id) {

		Optional<AreaComum> areaDTO = areaComumBO.buscarArea(id);
		if (areaDTO.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(areaDTO.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<Object> salvarArea(@RequestBody AreaComumDTO areaDTO) {
		AreaComum area = new AreaComum();
		area.setArea(areaDTO);		
		area = areaComumBO.salvarArea(area);
		return ResponseEntity.status(HttpStatus.CREATED).body(areaDTO);
	}

	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletar(@PathVariable Long id) {

		try {
			areaComumBO.removerArea(id);
			return ResponseEntity.ok().build();
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
		
		
	}

}
