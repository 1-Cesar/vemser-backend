package br.com.dbc.vemser.pessoaapi.repository;
/**
 * @author Cesar
 * @version vemSer - DBC
 */
import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.entity.EnumTipo;
import feign.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContatoRepository extends JpaRepository<ContatoEntity, Integer> {

    @Query(" select c" +
            " from CONTATO c" +
            " where c.tipoContato = :tipoContato")
    List<ContatoEntity> listContatosByTipo(@Param("tipoContato") EnumTipo tipoContato);

    @Query(" select c" +
            " from CONTATO c"
            )
    Page<ContatoEntity> paginacaoContatosByDescricao(Pageable pageable);

}