package com.ms.module.impl.pay3;

import com.ms.module.supers.inter.pay.IAliPay;
import com.ms.module.supers.inter.pay.IAliPayAdapter;
import com.ms.module.supers.inter.pay.IPay3Adapter;
import com.ms.module.supers.inter.pay.IWeChatPay;
import com.ms.module.supers.inter.pay.IWeChatPayAdapter;

public class Pay3Impl extends IPay3Adapter {

    private static final String ALI = "com.ms.module.impl.pay3.ali.AliPayImpl";
    private static final String WECHAT = "com.ms.module.impl.pay3.wechat.WeChatPayImpl";


    private IWeChatPay weChatPay;
    private IAliPay aliPay;

    @Override
    public IWeChatPay wechat() {

        if (weChatPay != null) {
            return weChatPay;
        }

        try {
            Class<?> aClass = Class.forName(WECHAT);
            Object o = aClass.newInstance();

            if (o instanceof IWeChatPay) {
                weChatPay = (IWeChatPay) o;
            } else {
                weChatPay = new IWeChatPayAdapter();
            }
        } catch (Exception e) {
            e.printStackTrace();
            weChatPay = new IWeChatPayAdapter();
        }

        return weChatPay;
    }

    @Override
    public IAliPay ali() {
        if (aliPay != null) {
            return aliPay;
        }

        try {
            Class<?> aClass = Class.forName(ALI);
            Object o = aClass.newInstance();
            if (o instanceof IAliPay) {
                aliPay = (IAliPayAdapter) o;
            } else {
                aliPay = new IAliPayAdapter();
            }
        } catch (Exception e) {
            e.printStackTrace();
            aliPay = new IAliPayAdapter();
        }
        return aliPay;
    }
}
