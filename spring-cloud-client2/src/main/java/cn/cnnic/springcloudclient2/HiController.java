package cn.cnnic.springcloudclient2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {

	@RequestMapping("/hi")
	public String hi() {
		return "hi 强语欣";
	}
}
