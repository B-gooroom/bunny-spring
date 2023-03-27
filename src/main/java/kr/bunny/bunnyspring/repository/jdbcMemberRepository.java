package kr.bunny.bunnyspring.repository;

import kr.bunny.bunnyspring.domain.Member;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class jdbcMemberRepository implements MemberRespository{

    private final DataSource dataSource;

    public jdbcMemberRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Member save(Member member) {
        String sql = "insert into member(name) values(?)";

//        Connection conn = dataSource.getConnection();
//        PreparedStatement pstmt = conn.prepareStatement(sql);
//        pstmt.setString(1, member.getName());
//
//        pstmt.executeUpdate();

        return null;
    }

    @Override
    public Optional<Member> findById(int id) {
        return null;
    }

    @Override
    public Optional<Member> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        return null;
    }
}
