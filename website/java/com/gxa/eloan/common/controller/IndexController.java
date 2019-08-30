package com.gxa.eloan.common.controller;

import com.gxa.eloan.business.domain.Bidrequest;
import com.gxa.eloan.business.query.BidRequestQueryObject;
import com.gxa.eloan.business.service.IBidrequestService;
import com.gxa.eloan.common.domain.LoginInfo;
import com.gxa.eloan.common.util.SysConstant;
import com.gxa.eloan.common.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private IBidrequestService iBidRequestService;


    /**
     * 用户端首页
     *
     * @param model
     * @return
     */
    @RequestMapping("index")
    public String index(Model model) {

        BidRequestQueryObject bidRequestQueryObject = new BidRequestQueryObject();
        bidRequestQueryObject.setStates(
                new int[]{
                        SysConstant.BIDREQUEST_STATE_BIDDING,
                        SysConstant.BIDREQUEST_STATE_PAYING_BACK,
                        SysConstant.BIDREQUEST_STATE_COMPLETE_PAY_BACK
                });
        bidRequestQueryObject.setOrderBy("bidRequestState"); //按照借款的状态排序
        bidRequestQueryObject.setOrderType("ASC");
        bidRequestQueryObject.setPageSize(5);

        List<Bidrequest> list = iBidRequestService.queryForList(bidRequestQueryObject);

        model.addAttribute("bidRequests", list);
        return "main";
    }
}
