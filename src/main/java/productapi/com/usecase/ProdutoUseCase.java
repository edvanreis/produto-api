package productapi.com.usecase;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import productapi.com.dto.EstoqueDTO;
import productapi.com.dto.TypeDTO;
import productapi.com.infra.ProdutoClient;
import productapi.com.infra.TypeClient;

import java.util.List;


@Component
@RequiredArgsConstructor
public class ProdutoUseCase {

    private final ProdutoClient client;

    private final TypeClient clientType;

    public EstoqueDTO save(EstoqueDTO estoque){
       return  client.save(estoque).getBody();
    }

    public List<TypeDTO> findAll(){
        return  clientType.findAll().getBody();
    }
}
