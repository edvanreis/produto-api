package productapi.com.infra;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import productapi.com.dto.EstoqueDTO;

@FeignClient( name = "estoque-api",url = "https://estoque-loja-api-new.herokuapp.com",path = "/estoque")
public interface ProdutoClient {

    @PostMapping
    ResponseEntity<EstoqueDTO> save(@Validated @RequestBody EstoqueDTO estoque);
}
