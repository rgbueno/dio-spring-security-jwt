package dio.dio.spring.security.jwt.handler;

public class BusinessException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 6581666443290759935L;
	public BusinessException(String mensagem) {
        super(mensagem);
    }
    public BusinessException(String mensagem, Object ... params) {
        super(String.format(mensagem, params));
    }
}
