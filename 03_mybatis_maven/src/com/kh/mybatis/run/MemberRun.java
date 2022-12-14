package com.kh.mybatis.run;


import java.util.List;


import com.kh.mybatis.member.model.service.MemberService;
import com.kh.mybatis.member.model.vo.Member;

public class MemberRun {
	public static void main(String[] args) {
		MemberService service = new MemberService();
		
		//1. 가입된 member객수 구하기
		System.out.println("1. 가입된 맴버수 : " + service.getMemberCount());
		System.out.println("--------------------------------------------\n");
		
		//2. 가입된 모든 맴버 조회하기
		System.out.println("2. 가입된 모든맴버조회하기");
		List<Member> list = service.findAll();
		for(Member m : list) {
			System.out.println(m.toString());
		}
		System.out.println("--------------------------------------------\n");
		
		//3.가입된 한명의 맴버 조회하기
		System.out.println("3.가입된 한명의 맴버 조회하기 - admin");
		Member member = service.findMemberById("admin");
		System.out.println(member);
		System.out.println("--------------------------------------------\n");
		
		//4. 회원가입하기
		System.out.println("4. 회원가입하기");
		String id = "admin3";
		member.setNo(0);
		member.setId(id);
		member.setName("김길동");
		int result = service.insertMember(member);
		System.out.println("결과 : " + result);
		member = service.findMemberById(id);
		System.out.println("조회 : " + member);
		System.out.println("--------------------------------------------\n");

		//5. 회원 정보 수정하기
		System.out.println("5. 회원정보수정하기");
		member.setName("박길동");
		member.setAddress("김해시 내외동 1209");
		member.setPhone("010-1234-5678");
		result = service.updateMember(member);
		System.out.println("결과 : " + result);
		member = service.findMemberById(id);
		System.out.println("조회 : " + member);
		System.out.println("--------------------------------------------\n");
		
		//6. 회원탈퇴
		System.out.println("6.회원탈퇴");
		result = service.deleteMember(member.getNo());
		System.out.println("결과 : " + result);
		member = service.findMemberById(id);
		System.out.println("조회 : " + member);
		System.out.println("--------------------------------------------\n");
		


	}
}
