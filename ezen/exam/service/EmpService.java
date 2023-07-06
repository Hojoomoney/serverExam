package ezen.exam.service;

import java.util.List;

import ezen.exam.vo.EmpVO;

public interface EmpService {
	
	public List<EmpVO> getList();
	public void insert(EmpVO vo);
	public EmpVO read(Integer empno);
	public boolean delete(Integer empno);

}
