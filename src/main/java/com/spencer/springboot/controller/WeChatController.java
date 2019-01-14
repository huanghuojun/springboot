package com.spencer.springboot.controller;

import cn.teamar.genki.common.tools.response.Response;
import cn.teamar.genki.common.tools.utils.JSON;
import cn.teamar.genki.common.tools.utils.StringUtils;
import com.spencer.springboot.model.Code2OpenId;
import com.spencer.springboot.model.WxCode2Session;
import com.spencer.springboot.service.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author Spencer
 * @Date 2019/1/14 15:21
 * @Description
 */
@RestController
@RequestMapping("/wechat")
public class WeChatController {
    @Autowired
    private HttpClient httpClient;

    @Value("${wechat.code2session.url}")
    private String url;

    @Value("${wechat.code2session.appid}")
    private String appid;

    @Value("${wechat.code2session.secret}")
    private String secret;

    @Value("${wechat.code2session.grant_type}")
    private String grant_type;

    @PostMapping("code2session")
    public Response<Code2OpenId> code2session(@RequestBody WxCode2Session code){
        System.out.println(code.getCode()+"-----------------------------------");
        // 封装参数，千万不要替换为Map与HashMap，否则参数无法传递
        MultiValueMap<String, String> params= new LinkedMultiValueMap<String, String>();
        params.add("appid",appid);
        params.add("secret", secret);
        params.add("js_code", code.getCode());
        params.add("grant_type", grant_type) ;

        String client = httpClient.client(url, HttpMethod.GET, params);
        System.out.println(code.getCode()+"-----------------------------------"+client);
        Code2OpenId openId = JSON.parseObject(client, Code2OpenId.class);

        if(StringUtils.isBlank(openId.getOpenid())){
            return Response.error(openId.getErrmsg());
        }
        return Response.success(openId);
    }
}
