package com.wonddak.kmmnoti.service

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.wonddak.kmmnoti.KMMNotification

open class KMMNotificationService : FirebaseMessagingService(){

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        KMMNotification.notifyNewToken(token)
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        KMMNotification.processReceived(message)
    }

    override fun onDeletedMessages() {
        super.onDeletedMessages()
    }
}