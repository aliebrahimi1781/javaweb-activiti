package com.haozileung.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.haozileung.test.common.base.BaseController;
import com.haozileung.test.dto.Response;
import com.haozileung.test.pojo.apply.Apply;
import com.haozileung.test.service.IApplyService;

@Controller("ApplyController")
@RequestMapping("/apply")
public class ApplyController extends BaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5800952029898922120L;

	private IApplyService applyService;

	@RequestMapping(method = RequestMethod.PUT)
	public Response<Apply> saveApply(Apply apply) {
		applyService.saveApply(apply);
		Response<Apply> response = new Response<Apply>();
		response.setStatus(0);
		List<Apply> data = new ArrayList<Apply>();
		data.add(apply);
		response.setData(data);
		return response;
	}
}
