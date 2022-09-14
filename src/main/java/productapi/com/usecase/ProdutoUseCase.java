package productapi.com.usecase;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import productapi.com.dto.EstoqueDTO;
import productapi.com.infra.ProdutoClient;


@Component
@RequiredArgsConstructor
public class ProdutoUseCase {

    private final ProdutoClient client;

    public EstoqueDTO save(EstoqueDTO estoque){
       return  client.save(estoque).getBody();
    }
}
