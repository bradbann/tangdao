package org.tangdao.modules.jobs.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tangdao.common.suports.BaseController;

/**
 * 统计信息
 *
 * @author jobob
 * @since 2019-06-15
 */
@Controller
@RequestMapping("${adminPath}/jobStatistics")
public class JobsStatisticsController extends BaseController {
	
//    @Autowired
//    private IJobsStatisticsService statisticsService;

//    /**
//     * 重要参数数量
//     */
//    @GetMapping("/important-num")
//    public R<JobsImportantNumVO> importantNum() {
//        return success(statisticsService.getImportantNum());
//    }
//
//    /**
//     * 成功比例
//     */
//    @GetMapping("/success-ratio")
//    public R<JobsSuccessRatioVO> successRatio() {
//        return success(statisticsService.getSuccessRatio());
//    }
//
//    /**
//     * 日期分布图
//     */
//    @GetMapping("/date-distribution")
//    public R<List<JobsDateDistributionVO>> dateDistribution() {
//        return success(statisticsService.getDateDistribution());
//    }
}
