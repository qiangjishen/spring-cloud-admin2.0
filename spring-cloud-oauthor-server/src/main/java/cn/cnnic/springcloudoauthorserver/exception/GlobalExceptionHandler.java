package cn.cnnic.springcloudoauthorserver.exception;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

/**
 * 统一异常处理
 * 
 * @author qiangjishen
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	
	
	/**
	 * 其他异常
	 * 
	 * @param e
	 * @return
	 * @throws JSONException
	 */
	@ResponseBody
	@ExceptionHandler(Exception.class)
	public Object handleExpiredJwtException(Exception e) throws JSONException {
		logger.error(ExceptionUtils.getFullStackTrace(e)); // 记录错误信息
		String msg = "参数解析错误:";
		if (msg != null || !msg.equals("")) {
			msg = msg + e.getMessage();
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("errorMsg", msg);
		return jsonObject;
	}
	
	/**
	 * 处理JWT权限异常
	 * 
	 * @param e
	 * @return
	 * @throws JSONException
	 */
	@ResponseBody
	@ExceptionHandler(TokenException.class)
	public Object handleExpiredJwtException(TokenException e) throws JSONException {
		logger.error(ExceptionUtils.getFullStackTrace(e)); // 记录错误信息
		String msg = "参数解析错误:";
		if (msg == null || msg.equals("")) {
			msg = msg + e.getMessage();
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("errorMsg", msg);
		return jsonObject;
	}

//	/**
//	 * 处理api接口参数不正确
//	 * 
//	 * @param e
//	 * @return
//	 * @throws JSONException
//	 */
//	@ResponseBody
//	@ExceptionHandler(HttpMessageNotReadableException.class)
//	public Object handleJsonException(HttpMessageNotReadableException e) throws JSONException {
//		logger.error(ExceptionUtils.getFullStackTrace(e)); // 记录错误信息
//		String msg = "参数解析错误:";
//		if (msg == null || msg.equals("")) {
//			msg = msg + e.getMessage();
//		}
//		JSONObject jsonObject = new JSONObject();
//		jsonObject.put("errorMsg", msg);
//		return jsonObject;
//	}
//
//	/**
//	 * 处理不可知异常
//	 * 
//	 * @param e
//	 * @return
//	 * @throws JSONException
//	 */
//	@ResponseBody
//	@ExceptionHandler(Exception.class)
//	public Object handleException(Exception e) throws JSONException {
//		logger.error(ExceptionUtils.getFullStackTrace(e)); // 记录错误信息
//		String msg = e.getMessage();
//		if (msg == null || msg.equals("")) {
//			msg = "服务器出错";
//		}
//		JSONObject jsonObject = new JSONObject();
//		jsonObject.put("errorMsg", msg);
//		return jsonObject;
//	}

	// /**
	// * 处理业务异常
	// * @param e
	// * @return
	// */
	// @ResponseBody
	// @ExceptionHandler(BusinessException.class)
	// public Object handleBsException(Exception e) {
	// logger.error(ExceptionUtils.getFullStackTrace(e)); // 记录错误信息
	// String msg = e.getMessage();
	// if (msg == null || msg.equals("")) {
	// msg = "服务器出错";
	// }
	// JSONObject jsonObject = new JSONObject();
	// jsonObject.put("message", msg);
	// return jsonObject;
	// }

	/**
//	 * 处理所有接口数据验证异常
//	 * 
//	 * @param e
//	 * @return
//	 * @throws JSONException
//	 */
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	@ResponseBody
//	public Object handleMethodArgumentNotValidException(MethodArgumentNotValidException e) throws JSONException {
//		logger.error(ExceptionUtils.getFullStackTrace(e)); // 记录错误信息
//
//		String msg = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
//		if (msg == null || msg.equals("")) {
//			msg = "服务器出错";
//		}
//		JSONObject jsonObject = new JSONObject();
//		jsonObject.put("message", msg);
//
//		return jsonObject;
//	}

}
