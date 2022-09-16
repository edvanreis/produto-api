package productapi.com.infra;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import productapi.com.dto.TypeDTO;

import java.util.List;

@FeignClient( name = "estoque",url = "https://estoque-loja-api-new.herokuapp.com",path = "/type")
public interface TypeClient {

    @GetMapping
    ResponseEntity<List<TypeDTO>> findAll();
}
