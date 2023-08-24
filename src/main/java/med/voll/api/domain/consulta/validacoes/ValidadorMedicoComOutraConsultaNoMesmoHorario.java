package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;

public class ValidadorMedicoComOutraConsultaNoMesmoHorario {

    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {
        var medicoPosuiOutraConsultaNoMesmoHorario = repository.existsByMedicoIdAndData(dados.idMedico(), dados.data());
        if (medicoPosuiOutraConsultaNoMesmoHorario) {
            throw new ValidacaoException("Médico já possui consulta agendada nesse mesmo horário");
        }
    }
}
