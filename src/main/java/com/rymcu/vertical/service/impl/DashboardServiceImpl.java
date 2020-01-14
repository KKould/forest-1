package com.rymcu.vertical.service.impl;

import com.rymcu.vertical.dto.admin.Dashboard;
import com.rymcu.vertical.mapper.DashboardMapper;
import com.rymcu.vertical.service.DashboardService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ronger
 */
@Service
public class DashboardServiceImpl implements DashboardService {

    @Resource
    private DashboardMapper dashboardMapper;

    @Override
    public Dashboard dashboard() {
        Dashboard dashboard = new Dashboard();
        dashboard.setCountUserNum(dashboardMapper.selectUserCount());
        dashboard.setNewUserNum(dashboardMapper.selectNewUserCount());
        dashboard.setCountArticleNum(dashboardMapper.selectArticleCount());
        dashboard.setNewArticleNum(dashboardMapper.selectNewArticleCount());
        // TODO 待完成浏览量统计
        dashboard.setCountViewNum(1000);
        dashboard.setToadyViewNum(100);
        return dashboard;
    }
}