package com.shrutipandit.mymusic.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shrutipandit.mymusic.Music
import com.shrutipandit.mymusic.PlayerActivity
import com.shrutipandit.mymusic.R

class MusicAdapter(private val music: ArrayList<Music>,private val context: Context) : RecyclerView.Adapter<MusicAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val musicName: TextView = itemView.findViewById(R.id.musicName)
        val singer: TextView = itemView.findViewById(R.id.singer)
        val duration: TextView = itemView.findViewById(R.id.duration)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sample_music, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val song = music[position]
        holder.musicName.text = song.title
        holder.singer.text = song.artist
        holder.duration.text = song.duration.toString()

        holder.itemView.setOnClickListener {
             val intent = Intent(context,PlayerActivity::class.java)
            intent.putExtra("position",position)
            context.startActivity(intent)


        }


    }

    override fun getItemCount(): Int {
        return music.size
    }
}
