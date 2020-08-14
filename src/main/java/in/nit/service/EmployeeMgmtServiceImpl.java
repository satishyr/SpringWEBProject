package in.nit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nit.bo.EmployeeBO;
import in.nit.dao.EmployeeDAO;
import in.nit.dto.EmployeeDTO;

@Service("/empService")
public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {

	@Autowired
	private EmployeeDAO dao;

	public List<EmployeeDTO> fetchAllEmps() {
		List<EmployeeBO> listBO = null;
		@SuppressWarnings("rawtypes")
		List<EmployeeDTO> listDTO = new ArrayList();
		// use DAO
		listBO = dao.getAllEmps();
		// convert listBO to listDTO
		listBO.forEach(bo -> {
			EmployeeDTO dto = new EmployeeDTO();
			BeanUtils.copyProperties(bo, dto);
			dto.setSrNo(listDTO.size() + 1);
			listDTO.add(dto);
		});

		return listDTO;
	}// method

}// class
