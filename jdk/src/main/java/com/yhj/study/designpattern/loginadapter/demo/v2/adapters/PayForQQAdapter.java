package com.yhj.study.designpattern.loginadapter.demo.v2.adapters;

import com.yhj.study.designpattern.adapter.loginadapter.demo.v1.dto.ResultMsg;

public class PayForQQAdapter implements PayAdapter{

    @Override
    public boolean support(Object adapter) {
        return adapter instanceof PayInfoForQQ;
    }

    @Override
    public ResultMsg pay(String orderId, Object adapter) {
        PayInfoForQQ payInfo = (PayInfoForQQ) adapter;
        ResultMsg msg = new ResultMsg();
        msg.setMsg("成功支付：" + "用QQ：" + payInfo.getQqNo());
        return msg;
    }

    public static class PayInfoForQQ {
        private String qqNo;

        public String getQqNo() {
            return qqNo;
        }

        public void setQqNo(String qqNo) {
            this.qqNo = qqNo;
        }
    }


}
