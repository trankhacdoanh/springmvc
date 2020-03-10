package com.laptrinhjavaweb.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class MessageUtil {
	public Map<String, String> getMessage(String message){
		Map<String, String> result = new HashMap<String, String>();
		if(message.equals("insert_succes")) {
			result.put("message", "thêm thành công");
			result.put("alert", "success");
		}else if(message.equals("update_succes")) {
			result.put("message", "cập nhật thành công");
			result.put("alert", "success");
		}else if(message.equals("delete_success")) {
			result.put("message", "xóa thành công");
			result.put("alert", "success");
		}else if(message.equals("error_system")) {
			result.put("message", "lỗi hệ thống");
			result.put("alert", "danger");
		}
		return result;
	}
}
