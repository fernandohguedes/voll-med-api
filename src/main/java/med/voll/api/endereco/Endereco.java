package med.voll.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String complemento;
    private String numero;

    public Endereco(DadosEndereco dados) {
        this.logradouro = dados.logradouro();
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.cidade = dados.cidade();
        this.uf = dados.uf();
        this.complemento = dados.complemento();
        this.numero = dados.numero();
    }

    public void atualizarInformacoes(DadosEndereco dados) {
        if (Objects.nonNull(dados.logradouro())) {
            this.logradouro = dados.logradouro();
        }
        if (Objects.nonNull(dados.bairro())) {
            this.bairro = dados.bairro();
        }
        if (Objects.nonNull(dados.cep())) {
            this.cep = dados.cep();
        }
        if (Objects.nonNull(dados.cidade())) {
            this.cidade = dados.cidade();
        }
        if (Objects.nonNull(dados.uf())) {
            this.uf = dados.uf();
        }
        if (Objects.nonNull(dados.complemento())) {
            this.complemento = dados.complemento();
        }
        if (Objects.nonNull(dados.numero())) {
            this.numero = dados.numero();
        }
    }
}
