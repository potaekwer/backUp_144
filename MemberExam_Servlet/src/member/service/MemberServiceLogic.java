package member.service;

import java.util.List;

import member.domain.Member;
import member.store.MemberStoreLogic;

public class MemberServiceLogic {
	
	private MemberStoreLogic store;
	
	public MemberServiceLogic(){
		store = new MemberStoreLogic();
	}

	
	public boolean registerMember(Member member){
		return store.insert(member);
	}
	
	
	public List<Member> searchAll(){
		
		return store.selectAll();
	}
	
	public List<Member> searchByName(String name){
		return store.selectByName(name);
	}
	public boolean removeMember(int no){
		return store.deleteByNo(no);
	}
	public Member searchByNo(int no){		
		return store.searchByNo(no);
	}
	
	
	
	
	
	
}
