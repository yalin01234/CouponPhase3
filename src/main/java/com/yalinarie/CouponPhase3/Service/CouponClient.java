package com.yalinarie.CouponPhase3.Service;

import com.yalinarie.CouponPhase3.Bean.ClientType;

public interface CouponClient {

	public CouponClient login(String userName, String password, ClientType clientType);

}