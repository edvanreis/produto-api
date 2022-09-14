package productapi.com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import productapi.com.rest.ProdutoController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Data de Criação:07/05/2021
 * 
 * @author endr
 * @version 1.0
 */
@ControllerAdvice(basePackageClasses = ProdutoController.class)
public class EstoqueApiExcEptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Throwable.class)
	public @ResponseBody Erro handleThrowable(HttpServletRequest request, HttpServletResponse response, Throwable ex)
			throws IOException {
		response.setContentType("application/json");
		return new Erro(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());

	}

	public static class Erro {

		private int status;
		private String mensagem;

		public Erro(int status, String mensagem) {
			this.setStatus(status);
			this.setMensagem(mensagem);
		}

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		public String getMensagem() {
			return mensagem;
		}

		public void setMensagem(String mensagem) {
			this.mensagem = mensagem;
		}

	}

}
