package com.estsoft.springproject.coupon;

import com.estsoft.springproject.user.coupon.ICoupon;
import com.estsoft.springproject.user.coupon.User;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserCouponTest {
    @Test
    public void 쿠폰이_유효할_경우_발급() {
        User user = new User("area00");
        assertEquals(0, user.getTotalCouponCount()); // 쿠폰 수령 전

        ICoupon coupon = Mockito.mock(ICoupon.class);    // mock객체 - 행위 정의
        Mockito.when(coupon.isValid()).thenReturn(true); // stub 처리

        user.addCoupon(coupon);
        assertEquals(1, user.getTotalCouponCount()); // 쿠폰 수령 후 쿠폰수 검증
    }


    @Test
    public void 쿠폰이_유효하지_않을_경우_발급되지_않음() {
        User user = new User("area00");
        assertEquals(0, user.getTotalCouponCount()); // 쿠폰 수령 전

        ICoupon coupon = Mockito.mock(ICoupon.class);
        Mockito.when(coupon.isValid()).thenReturn(false);

        user.addCoupon(coupon);
        assertEquals(0, user.getTotalCouponCount());
    }
}
