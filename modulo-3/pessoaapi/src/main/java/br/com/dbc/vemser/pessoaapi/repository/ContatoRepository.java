package br.com.dbc.vemser.pessoaapi.repository;
/**
 * @author Cesar
 * @version vemSer - DBC
 */
import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends JpaRepository<ContatoEntity, Integer> {}