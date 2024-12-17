package br.com.amandazaine.apiJavaSpringBootMongoDB.httpClient;

import br.com.amandazaine.apiJavaSpringBootMongoDB.model.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "cep-client", url = "https://brasilapi.com.br/api/")
public interface CepHttpClient {

    @GetMapping("cep/v2/{cep}")
    public Endereco findEndereco(@PathVariable("cep") String cep);
}
