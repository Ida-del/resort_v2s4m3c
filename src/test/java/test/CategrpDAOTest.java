package test;
 
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dev.mvc.cate.CateDAOInter;
import dev.mvc.categrp.CategrpDAOInter;
import dev.mvc.categrp.CategrpVO;
 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class CategrpDAOTest {
 
  @Autowired
  private CateDAOInter cateDAO = null;
 

  // 등록된 자료수 증가 테스트, increaseCnt() update sql을 실행함으로 1을 리턴함.
  @Test
  public void testIncreaseCnt() {
    assertEquals(1, cateDAO.increaseCnt(1));
  }
 
}