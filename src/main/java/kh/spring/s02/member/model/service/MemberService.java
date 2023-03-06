package kh.spring.s02.member.model.service;

import java.util.List;

import kh.spring.s02.member.model.vo.MemberVo;

public interface MemberService {
	
	public int insert(MemberVo vo) throws Exception;
	public int update(MemberVo vo) throws Exception;
	public int delete(String id) throws Exception;
	public MemberVo selectOne(String id) throws Exception;
	public List<MemberVo> selectList() throws Exception;
}
