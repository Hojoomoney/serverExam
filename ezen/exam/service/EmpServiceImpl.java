package ezen.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ezen.exam.mapper.EmpMapper;
import ezen.exam.vo.EmpVO;
import lombok.Setter;


@Service
public class EmpServiceImpl implements EmpService{
	
	@Setter(onMethod_=@Autowired)
	public EmpMapper mapper;
	
	@Override
	public List<EmpVO> getList(){
		return mapper.getList();
	}
	
	@Transactional
	@Override
	public void insert(EmpVO vo) {
		mapper.insert(vo);
	}
	
	@Override
	public EmpVO read(Integer empno) {
		return mapper.read(empno);
	}
	
	@Transactional
	@Override
	public boolean delete(Integer empno) {
		return mapper.delete(empno) == 1;
	}
		

}
