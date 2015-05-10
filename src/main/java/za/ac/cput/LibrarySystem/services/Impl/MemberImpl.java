package za.ac.cput.LibrarySystem.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.LibrarySystem.domain.Impl.Member;
import za.ac.cput.LibrarySystem.repository.MemberRepository;
import za.ac.cput.LibrarySystem.services.MemberService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yongama on 2015-05-10.
 */
public class MemberImpl implements MemberService{
    @Autowired
    MemberRepository repository;
    public List<Member> getMembers() {
        List<Member> memberList = new ArrayList<Member>();
        Iterable<Member> members = repository.findAll();
        for (Member m : members){
            memberList.add(m);
        }
        return memberList;
    }
}
