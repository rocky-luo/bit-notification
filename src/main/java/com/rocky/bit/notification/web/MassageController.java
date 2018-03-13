package com.rocky.bit.notification.web;

import com.rocky.bit.notification.telegram.SimpleBot;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by rocky on 18/3/13.
 */
@Controller
@RequestMapping("/massage")
public class MassageController {

    @Resource
    private SimpleBot simpleBot;

    @RequestMapping(value = "/telegram/chart/{chartId}", method = RequestMethod.POST)
    @ResponseBody
    public void telegramChart(@RequestBody String text, @PathVariable Long chartId, HttpServletResponse response) {
        simpleBot.sendChartMsg(chartId, text);
        response.setStatus(201);
    }
}
