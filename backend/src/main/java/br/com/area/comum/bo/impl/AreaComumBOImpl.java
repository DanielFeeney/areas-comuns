package br.com.area.comum.bo.impl;

import br.com.area.comum.bo.interfaces.IAreaComumBO;
import br.com.area.comum.dto.AreaComumDTO;
import br.com.area.comum.entity.AreaComum;
import br.com.area.comum.enums.Status;
import br.com.area.comum.repository.AreaComumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Component
public class AreaComumBOImpl implements IAreaComumBO {

	@Autowired
	private AreaComumRepository areaComumRepository;

	@Override
	public List<AreaComum> buscarTodos() {
		return null;
	}

	@Override
	public Optional<AreaComum> buscarArea(Long id) {
		return areaComumRepository.getArea(id);
	}

	@Override
	public void removerArea(Long id) {
		Optional<AreaComum> areaOpt = areaComumRepository.getArea(id);
		if(areaOpt.isPresent()) {
			AreaComum area = areaOpt.get();
			area.setAtivo(false);
			areaComumRepository.save(area);
		}
	}

	@Override
	public List<AreaComumDTO> buscarTodosDTO() {
		return areaComumRepository.getAllDTO();
	}

	@Override
	public Optional<AreaComumDTO> buscarAreaDTO(Long id) {
		return areaComumRepository.getAreaDTO(id);
	}

	@Override
	public AreaComum salvarArea(AreaComum area) {
		return areaComumRepository.save(area);
	}

	
	

	
}
