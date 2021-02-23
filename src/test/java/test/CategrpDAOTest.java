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
 

  // ��ϵ� �ڷ�� ���� �׽�Ʈ, increaseCnt() update sql�� ���������� 1�� ������.
  @Test
  public void testIncreaseCnt() {
    assertEquals(1, cateDAO.increaseCnt(1));
  }
 
}