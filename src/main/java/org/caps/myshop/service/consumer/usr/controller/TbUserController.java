package org.caps.myshop.service.consumer.usr.controller;

import com.fasterxml.jackson.databind.JavaType;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.caps.myshop.commons.domain.TbUser;
import org.caps.myshop.commons.dto.AbstractBaseResult;
import org.caps.myshop.commons.utils.MapperUtils;
import org.caps.myshop.commons.web.AbstractBaseController;
import org.caps.myshop.service.consumer.usr.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author caps
 * @Date 2019/5/30 14:22
 * @Description
 */
@RestController
@RequestMapping(value = "user")
public class TbUserController extends AbstractBaseController<TbUser> {

    @Autowired
    private TbUserService tbUserService;

    @ApiOperation(value = "商品分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true, paramType = "path"),
            @ApiImplicitParam(name = "pageSize", value = "笔数", required = true, paramType = "path")
    })
    @GetMapping(value = "page/{pageNum}/{pageSize}")
    public AbstractBaseResult page(
            @ApiParam(name = "用户信息", required = false) TbUser tbUser,
            @PathVariable int pageNum,
            @PathVariable int pageSize) {
        String json = tbUserService.page(tbUser, pageNum, pageSize);
        try {
            JavaType javaType = MapperUtils.getCollectionType(PageInfo.class, TbUser.class);
            PageInfo<TbUser> pageInfo = MapperUtils.getInstance().readValue(json, javaType);
            return success(request.getRequestURI(), pageInfo.getNextPage(), pageInfo.getPages(), pageInfo.getList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
