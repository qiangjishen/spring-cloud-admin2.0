package cn.cnnic.springcloudoauthorserver.exception;

/**
 * 验证权限自定义异常
 * 
 * @author qiang
 *
 */
public class TokenException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TokenException(String message) {
        super(message);
    }

    public TokenException(String message, Throwable cause) {
        super(message, cause);
    }
}