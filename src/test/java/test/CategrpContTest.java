package test;
 
import javax.inject.Inject;
 
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
 
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class CategrpContTest {
  
  private static final Logger logger = LoggerFactory.getLogger(CategrpContTest.class);
 
  @Inject
    private WebApplicationContext wac;
 
    private MockMvc mockMvc;  // Tomcat 서버에서의 요청인것으로 작동함.
    
    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        logger.info("setup............");
    }
 
    // INSERT INTO categrp(categrpno, classification, name, seqno, visible, rdate)
    // VALUES(1, 1, '여행', 1, 'Y', sysdate);
    
     // 성공하는 경우
     // Controller GET 방식 요청 테스트, jsp view 이동은 체크 안함.
//      @Test public void testCreateGet() throws Exception{
//      mockMvc.perform(MockMvcRequestBuilders.get("/categrp/create.do")); }
     
      // 실패하는 경우, 처리 안됨
      // Controller GET 방식 요청 테스트, jsp view 이동은 체크 안함.    
//      @Test public void testCreateGet() throws Exception{
//        mockMvc.perform(MockMvcRequestBuilders.get("/categrp/create.doX")); }
      
      // 톰캣 사용 없이 컨트롤러 사용에 성공하는 경우
      // Controller POST 방식 요청 테스트
      @Test public void testCreatePost() throws Exception{ // 파라미터 전송
            MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
            multiValueMap.add("name", "나를 찾는 여행"); 
            multiValueMap.add("seqno", "30");   //  숫자도 문자열로 값을 지정
            multiValueMap.add("visible", "Y");
          
          // <form> 태그에서 전송한 효과 발생
          // @RequestMapping(value = "/cate/create.do", method = RequestMethod.GET)
           mockMvc.perform(MockMvcRequestBuilders.post("/categrp/create.do").params(multiValueMap));
        
        }
     
      // 실패하는 경우
      // Controller POST 방식 요청 테스트
    /*
     * @Test public void testCreatePost() throws Exception{ // 파라미터 전송
     * MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
     * multiValueMap.add("name", ""); multiValueMap.add("seqno", ""); // 숫자도 문자열로 값을
     * 지정 multiValueMap.add("visible", "");
     * 
     * // <form> 태그에서 전송한 효과 발생 // @RequestMapping(value = "/cate/create.do", method
     * = RequestMethod.GET)
     * mockMvc.perform(MockMvcRequestBuilders.post("/categrp/create.do").params(
     * multiValueMap));
     * 
     * }
     */
     
    
    
}