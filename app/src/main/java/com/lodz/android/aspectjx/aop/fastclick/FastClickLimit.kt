package com.lodz.android.aspectjx.aop.fastclick

/**
 * 快速点击限制
 * @author zhouL
 * @date 2022/6/2
 */
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
/** 快速点击限制，间隔时间[duration]，默认1000毫秒 */
annotation class FastClickLimit(val duration: Long = 1000)
