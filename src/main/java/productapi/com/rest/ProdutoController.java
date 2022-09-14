package productapi.com.rest;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import productapi.com.dto.EstoqueDTO;
import productapi.com.exception.EstoqueApiException;
import productapi.com.usecase.ProdutoUseCase;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {

private final  ProdutoUseCase useCase;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = ""),
            @ApiResponse(responseCode = "400", description = "Invalid parameters"),
            @ApiResponse(responseCode = "404", description = "not found"),
            @ApiResponse(responseCode = "500", description = "Failure")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<EstoqueDTO> save(@Validated @RequestBody EstoqueDTO estoque){
        try {
            return ResponseEntity.ok().body(this.useCase.save(estoque));
        } catch (EstoqueApiException ex) {
            throw new EstoqueApiException(ex.getMessage());
        }


    }
}
