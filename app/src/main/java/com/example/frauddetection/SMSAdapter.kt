package com.example.frauddetection

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SMSAdapter(private val smsList: List<SMS>) : RecyclerView.Adapter<SMSAdapter.SMSViewHolder>() {

    class SMSViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val sender: TextView = itemView.findViewById(R.id.tvSender)
        val message: TextView = itemView.findViewById(R.id.tvMessage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SMSViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return SMSViewHolder(view)
    }

    override fun onBindViewHolder(holder: SMSViewHolder, position: Int) {
        val sms = smsList[position]
        holder.sender.text = sms.sender
        holder.message.text = sms.message
        if(sms.sender.contains("+91")){
            sms.sender = sms.sender.removePrefix("+91")

        }

          if (sms.message.toLowerCase().contains("win", ignoreCase = true) ||
              sms.message.toLowerCase().contains("prize", ignoreCase = true) ||
              sms.message.toLowerCase().contains("urgent", ignoreCase = true) ||
              sms.message.toLowerCase().contains("free", ignoreCase = true) ||
              sms.message.toLowerCase().contains("otp", ignoreCase = true) ||
              sms.message.toLowerCase().contains("balance", ignoreCase = true) ||
              sms.message.toLowerCase().contains("A/C", ignoreCase = true) ||
              sms.message.toLowerCase().contains("congratulations", ignoreCase = true)
          ) {
              holder.itemView.setBackgroundColor(Color.RED)

      }
    }

    override fun getItemCount() = smsList.size
}
