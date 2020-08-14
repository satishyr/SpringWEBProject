package in.nit.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import in.nit.dto.EmployeeDTO;
import in.nit.service.EmployeeMgmtService;

@Controller
public class ListEmployeesController {

	@Autowired
	private EmployeeMgmtService service;

	@RequestMapping("/welcome.htm")
	public String showHome() {
		return "home";
	}

	@RequestMapping("/list_emps.htm")
	public String showEmps(Map<String, Object> map) {
		List<EmployeeDTO> listDTO = null;
		// use service
		listDTO = service.fetchAllEmps();
		// put data in model attribute
		map.put("listDTO", listDTO);
		// return MAV
		return "show_emps";
	}

}
