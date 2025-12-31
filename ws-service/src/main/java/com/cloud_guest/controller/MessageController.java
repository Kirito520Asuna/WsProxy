package com.cloud_guest.controller;

import com.cloud_guest.domain.WsProxy;
import com.cloud_guest.manager.WsClientManager;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.SneakyThrows;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author yan
 * @Date 2025/12/31 21:25:51
 * @Description
 */
@Tag(name = "消息")
@RestController
@RequestMapping("/message/")
public class MessageController {

    @Resource
    private WsClientManager wsClientManager;


    @SneakyThrows
    @Operation(summary = "发送消息")
    @PostMapping("send")
    public String send(@Validated @RequestBody WsProxy wsProxy) {
        wsClientManager.send(wsProxy);
        return "success";
    }
}
