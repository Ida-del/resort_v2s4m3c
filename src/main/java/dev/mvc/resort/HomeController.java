package dev.mvc.resort;

import java.util.Locale;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HomeController {

  @RequestMapping(value = { "/", "/index.do" }, method = RequestMethod.GET)
  public String home(Locale locale, Model model) {

    return "index"; // /resort/index.jsp
  }
  
  /**
   * Spring + JSON array http://localhost:9090/resort/json_array.do
   * @param response 
   * @return
   */
  @ResponseBody
  @RequestMapping(value = "/json_array.do", method = RequestMethod.GET,
                          produces = "application/json; charset=utf8")
  public String json_array() {
    try {
      Thread.sleep(1500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    JSONArray json_list = new JSONArray();  // 배열
    JSONObject json = new JSONObject();  // json object 선언
    json.put("title", "Trend Korea");  // 요소 추가
    json.put("price", 6000);
    json.put("dc", 0.1);

    json_list.put(json);  // 배열에 JSON Object 추가

    return json_list.toString();
  }

}
