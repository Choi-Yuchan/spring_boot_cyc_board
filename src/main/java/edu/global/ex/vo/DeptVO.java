package edu.global.ex.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/* 
 * ORM : RDBMS <= Java Class mapping을 도와주는 프레임워크
 * JPA : 솔루션 회사
 * Mybatis: SI 에서 많이 
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DeptVO {
	private String deptno;
	private String dname; // 부서이름
	private String loc; // 지역

	List<EmpDeptVO> empList;
}
