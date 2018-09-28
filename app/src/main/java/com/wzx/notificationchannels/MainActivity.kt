package com.wzx.notificationchannels

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.wzx.notificationchannels.NotificationHelper.Companion.PRIMARY_CHANNEL
import kotlinx.android.synthetic.main.activity_main.*

/**
 * 通知渠道
 *
 *
 */
class MainActivity : AppCompatActivity() {

    companion object {
        const val MAIN_PRIMARY_CHANNEL = 1001
        const val MAIN_SECONDARY_CHANNEL = 1002
    }

    private lateinit var helper: NotificationHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        helper = NotificationHelper(this)

        sendPrimaryChannelBTN.setOnClickListener {
            //Random().nextInt(1000)
            helper.notify(MAIN_PRIMARY_CHANNEL,
                    helper.createNotification(PRIMARY_CHANNEL,
                            mainPrimaryTitleET.text.toString(),
                            mainPrimaryTitleET.text.toString(),
                            R.mipmap.ic_launcher))
        }

        sendSecondaryChannelBTN.setOnClickListener {
            helper.notify(MAIN_SECONDARY_CHANNEL,
                    helper.createNotification(PRIMARY_CHANNEL,
                            mainSecondaryTitleET.text.toString(),
                            mainSecondaryTitleET.text.toString(),
                            R.mipmap.ic_launcher))
        }
    }
}
