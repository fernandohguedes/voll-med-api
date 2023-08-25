package med.voll.api.domain.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> findAllByAtivoTrue(Pageable paginacao);

    @Query("""
            select medico from Medico medico
            where medico.ativo = 1
            and medico.especialidade = :especialidade
            and medico.id not in( 
                select consulta.medico.id from Consulta consulta
                where consulta.data = :data 
                and consulta.motivoCancelamento is null )
            order by rand()
            limit 1             
            """)
    Medico escolherMedicoAleatorioLivreNaData(Especialidade especialidade, LocalDateTime data);

    @Query("""
            select medico.ativo from Medico medico
            where medico.id = :id
            """)
    Boolean findAtivoById(Long id);
}
