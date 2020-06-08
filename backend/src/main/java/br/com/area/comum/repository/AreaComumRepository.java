package br.com.area.comum.repository;

import br.com.area.comum.dto.AreaComumDTO;
import br.com.area.comum.entity.AreaComum;
import br.com.area.comum.enums.Status;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AreaComumRepository extends JpaRepository<AreaComum, Long> {

	@Query(value = "Select new br.com.area.comum.dto.AreaComumDTO("
			+ "a.id, a.descricao, a.proprietario, "
			+ "a.endereco, a.telefone) "
			+ "from AreaComum a where a.ativo = true ")
	List<AreaComumDTO> getAllDTO();

	@Query(value = "Select a "
			+ "from AreaComum a where a.ativo = true and a.id = :id")
	Optional<AreaComum> getArea(@Param("id") Long id);

	@Query(value = "Select new br.com.area.comum.dto.AreaComumDTO("
			+ "a.id, a.descricao, a.proprietario, "
			+ "a.endereco, a.telefone, "
			+ "a.churrasqueira, a.piscina, a.salao) "
			+ "from AreaComum a where a.ativo = true and a.id = :id")
	Optional<AreaComumDTO> getAreaDTO(@Param("id") Long id);

	

	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE AreaComum a" 
			+ " SET a.ativo = false "
			+ " where a.id = :id")
	void deleteArea(@Param("id") Long id);
}
