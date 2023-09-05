package com.at.yuntai.statistic.controller;

import com.at.yuntai.statistic.bean.Page;
import com.at.yuntai.statistic.bean.TrafficStatistic;
import com.at.yuntai.statistic.service.StatisticService;
import com.at.yuntai.util.Result;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @create 2023-09-10
 */
@RestController
@RequestMapping("/statistic/visit")
public class TrafficController {

    @GetMapping("getTrafficStats/{page}/{limit}")
    public Result<Page<TrafficStatistic>> getTrafficStats(
            @PathVariable Integer page,
            @PathVariable Integer limit,
             TrafficStatistic trafficStatistic) {

        var trafficStatistics = StatisticService.getTrafficStatistics(page, limit, trafficStatistic.getDt(), trafficStatistic.getRecentDays());
        return Result.of(200, "success", trafficStatistics);

    }

    @GetMapping("getPagePath")
    public Result<Map<String, Object>> getPagePath( TrafficStatistic trafficStatistic) {

        return Result.of(200, "success", StatisticService.getPagePathCount(trafficStatistic));

    }

}
