package br.com.area.comum.bo.interfaces;

import br.com.area.comum.dto.AreaComumDTO;
import br.com.area.comum.entity.AreaComum;
import br.com.area.comum.enums.Status;

import java.util.List;
import java.util.Optional;

public interface IAreaComumBO {

	List<AreaComum> buscarTodos();

	Optional<AreaComum> buscarArea(Long id);

	void removerArea(Long id);

	List<AreaComumDTO> buscarTodosDTO();

	Optional<AreaComumDTO> buscarAreaDTO(Long id);

	AreaComum salvarArea(AreaComum area);
}
