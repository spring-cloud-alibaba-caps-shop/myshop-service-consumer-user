package org.caps.myshop.service.consumer.usr.service;

import org.caps.myshop.commons.domain.TbUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author caps
 * @Date 2019/5/30 14:20
 * @Description
 */
@FeignClient(value = "myshop-service-provider-user")
public interface TbUserService {

    @GetMapping(value = "/user/page/{pageNum}/{pageSize}")
    String page(TbUser tbUser, @PathVariable(name = "pageNum") int pageNum, @PathVariable(name = "pageSize") int pageSize);
}
