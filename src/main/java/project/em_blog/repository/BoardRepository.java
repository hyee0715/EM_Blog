package project.em_blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.em_blog.domain.Board;
import project.em_blog.domain.User;

import java.util.List;

// JpaRepository<Entity 클래스, PK 타입>
public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findByTitleContaining(String keyword);

    Board findByUser(User user);
}