package com.wzx.notificationchannels

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.ContextWrapper
import android.graphics.Color
import android.support.annotation.DrawableRes
import android.support.annotation.NonNull

/**
 * 描述：通知帮助类
 *
 * 创建人： Administrator
 * 创建时间： 2018/9/28
 * 更新时间：
 * 更新内容：
 *
 */
internal class NotificationHelper(@NonNull context: Context) : ContextWrapper(context) {

    private val manager by lazy {
        getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    }

    companion object {
        /**
         * 通知渠道
         */
        val PRIMARY_CHANNEL = "default"
        /**
         * 通知渠道
         */
        val SECONDARY_CHANNEL = "second"
    }

    init {
        /**
         * 创建通知渠道（createNotificationChannel）
         */

        val chan1 = NotificationChannel(PRIMARY_CHANNEL, "主通知渠道", NotificationManager.IMPORTANCE_DEFAULT)
        chan1.lightColor = Color.GREEN
        chan1.lockscreenVisibility = Notification.VISIBILITY_PRIVATE
        manager.createNotificationChannel(chan1)

        val chan2 = NotificationChannel(SECONDARY_CHANNEL, "副通知渠道", NotificationManager.IMPORTANCE_HIGH)
        chan2.lightColor = Color.BLUE
        chan2.lockscreenVisibility = Notification.VISIBILITY_PUBLIC
        manager.createNotificationChannel(chan2)
    }

    /**
     * 创建通知
     *
     * @param channelId 通知渠道编码
     * @param title 通知标题
     * @param body 通知内容
     * @param smallIcon 通知图标
     */
    fun createNotification(@NonNull channelId: String, @NonNull title: String, @NonNull body: String, @DrawableRes smallIcon: Int) = Notification.Builder(applicationContext, channelId)
            .setContentTitle(title)
            .setContentText(body)
            .setSmallIcon(smallIcon)
            .setAutoCancel(true)
            .build()

    /**
     * 发送通知
     */
    fun notify(id: Int, notification: Notification) {
        manager.notify(id, notification)
    }
}