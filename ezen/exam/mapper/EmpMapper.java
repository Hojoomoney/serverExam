package ezen.exam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import ezen.exam.vo.EmpVO;

@Mapper
public interface EmpMapper {
	
	@Select("select * from emp")
	public List<EmpVO> getList();
	
	@Insert("insert into emp (empno, ename, job, mgr, sal) values (#{empno}, #{ename}, #{job}, #{mgr}, #{sal})")
	public int insert(EmpVO vo);
	
	@Select("select * from emp where empno = #{empno}")
	public EmpVO read(Integer empno);
	
	@Delete("delete from emp where empno = #{empno}")
	public int delete(Integer empno);

}
