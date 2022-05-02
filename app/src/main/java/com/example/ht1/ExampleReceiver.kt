package com.example.ht1

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.Intent.ACTION_POWER_CONNECTED
import android.widget.Toast

class ExampleReceiver : BroadcastReceiver() {

    //ловим интенты с нужными нам сообщениями
    //фильтр получаемых интентов выставлен в манифесте
    //также можно получать системные сообщения, по типу подключения/отключения зарядки
    override fun onReceive(context: Context, intent: Intent) {


        Toast.makeText(context, "Button " + intent.extras?.get("button num") + " clicked", Toast.LENGTH_SHORT).show()

    }
}