package project.em_blog.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import project.em_blog.dto.BoardDto;
import project.em_blog.repository.BoardRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class BoardServiceTest {
    @Autowired
    BoardRepository boardRepository;
    @Autowired BoardService boardService;

    private static final int BLOCK_PAGE_NUM_COUNT = 5; // 블럭에 존재하는 페이지 번호 수
    private static final int PAGE_POST_COUNT = 4; // 한 페이지에 존재하는 게시글 수

    @Test
    public void getBoardListTest() {
        Integer pageNum = 3;
        List<BoardDto> boardList = boardService.getBoardlist(pageNum);

        for (BoardDto board : boardList) {
            System.out.println(board + " ");
        }
    }

    @Test
    public void searchPostsTest() {
        String keyword = "1";
        List<BoardDto> boardDtoList = boardService.searchPosts(keyword);

        for (BoardDto board : boardDtoList) {
            System.out.println(board);
        }
    }

    @Test
    @Transactional
    public void getPageListTest() {

        Integer curPageNum = 4;
        Integer[] pageList = boardService.getPageList(curPageNum);

        for (Integer page : pageList) {
            System.out.print(page + " ");
        }
    }

    @Test
    public void getBoardCountTest() {
        log.info("count = {}" , boardService.getBoardCount());
    }
}