package com.hyena.springboot.controller.user;

import com.hyena.model.User;
import com.hyena.springboot.common.webUtil.response.JsonCommonResponse;
import com.hyena.springboot.controller.BaseController;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/user")
@Log4j
public class UserController extends BaseController {

    /**
     * 根据Id获取user对象
     *
     * @return
     */
    @RequestMapping(value = "/get", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public JsonCommonResponse<User> getUserById(@RequestBody Map<String, Long> map) {
        Long id = map.get("id");
        log.info("id: " + id);

        User user = User.builder().age(12).name("hyena").build();

        return JsonCommonResponse.success(user);
    }

    /**
     * 不传入id
     *
     * @return
     */
    @RequestMapping(value = "/put", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public JsonCommonResponse<User> putUser(@RequestBody() Map<String, Long> map) {
        Long id = map.get("id");
        log.info("id: " + id);
        User user = User.builder().age(12).name("hyena").build();

        if (id == null) {
            throw new RuntimeException("id不存在");
        }

        return JsonCommonResponse.success(user);
    }


    @RequestMapping(value = "/returnStr", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String putsUser(@RequestBody() Map<String, Long> map) {

        return "hellowrold";
    }



}
