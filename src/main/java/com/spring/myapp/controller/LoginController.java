package com.spring.myapp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

	//�Խñ� �� ����
    @RequestMapping(value = "/login")
    public String boardLogin(@RequestParam Map<String, Object> paramMap, Model model) {
 
        return "login";
    }
	
  //�Խñ� �� ����
    @RequestMapping(value = "/userRegister")
    public String userRegister(@RequestParam Map<String, Object> paramMap, Model model) {
    	
        return "register";
    }
    
  //AJAX ȣ�� (�α���)
    @RequestMapping(value="/loginChk", method=RequestMethod.POST)
    @ResponseBody
    public Object loginChk(@RequestParam Map<String, Object> paramMap) {
 
        //���ϰ�
        Map<String, Object> retVal = new HashMap<String, Object>();
 
        //�н����� ��ȣȭ
        ShaPasswordEncoder encoder = new ShaPasswordEncoder(256);
        String password = encoder.encodePassword(paramMap.get("reply_password").toString(), null);
        paramMap.put("reply_password", password);
 
        //�����Է�
        //int result = boardService.delReply(paramMap);
    	int result = 0;
        if(result>0){
            retVal.put("code", "OK");
        }else{
            retVal.put("code", "FAIL");
            retVal.put("message", "������ �����߽��ϴ�. �н����带 Ȯ�����ּ���.");
        }
 
        return retVal;
 
    }
    
}
