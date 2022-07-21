package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.dto.PessoaCompletaDTO;
import br.com.dbc.vemser.pessoaapi.dto.RelatorioPersonalizadoDTO;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {

    List<PessoaEntity> findAllByNomeContainingIgnoreCase (String nome);

    List<PessoaEntity> findAllByCpfContainingIgnoreCase (String cpf);

    @Query(value = " select new br.com.dbc.vemser.pessoaapi.dto.RelatorioPersonalizadoDTO(" +
            " p.idPessoa," +
            " p.nome," +
            " p.email," +
            " c.numero," +
            " e.cep," +
            " e.cidade," +
            " e.estado," +
            " e.pais," +
            " pety.nome" +
            ") " +
            " from PESSOA p " +
            " left join p.contatos c " +
            " left join p.enderecos e " +
            " left join p.pet pety " +
            " where (:idPessoa is null OR p.idPessoa = :idPessoa )")
    List<RelatorioPersonalizadoDTO> relatorioPersonalizado(@Param("idPessoa") Integer idPessoa);

    @Query(value = " select new br.com.dbc.vemser.pessoaapi.dto.PessoaCompletaDTO(" +
            " p.idPessoa," +
            " p.nome," +
            " p.cpf," +
            " p.dataNascimento," +
            " p.email," +
            " pety.nome," +
            " pety.tipo," +
            " e.numero," +
            " e.complemento, " +
            " e.cep," +
            " e.cidade," +
            " e.estado," +
            " e.pais," +
            " e.logradouro," +
            " e.tipo," +
            " c.numero," +
            " c.tipoContato," +
            " c.descricao" +
            ")" +
            "  from PESSOA p " +
            "  join p.pet pety " +
            "  join p.enderecos e " +
            "  join p.contatos c " +
            " where (:idPessoa is null OR p.idPessoa = :idPessoa )")
    List<PessoaCompletaDTO> pessoaCompleta(@Param("idPessoa") Integer idPessoa);

}