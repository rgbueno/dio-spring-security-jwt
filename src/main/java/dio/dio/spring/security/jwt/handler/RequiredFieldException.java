package dio.dio.spring.security.jwt.handler;

public class RequiredFieldException extends BusinessException{

	public RequiredFieldException(String field) {
		super("O campo "+ field +" é obrigatório!");
	}
	
}
