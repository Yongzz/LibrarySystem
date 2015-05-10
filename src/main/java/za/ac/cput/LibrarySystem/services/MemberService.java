package za.ac.cput.LibrarySystem.services;

import za.ac.cput.LibrarySystem.domain.Impl.Member;

import java.util.List;

/**
 * Created by Yongama on 2015-05-10.
 */
public interface MemberService {
    List<Member> getMembers();
}
