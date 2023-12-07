package com.shrutipandit.mymusic

import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import androidx.annotation.RequiresApi
import com.shrutipandit.mymusic.R.drawable
import com.shrutipandit.mymusic.databinding.ActivityPlayerBinding

class PlayerActivity : AppCompatActivity() {
    private lateinit var binding:ActivityPlayerBinding
    private lateinit var mediaplayer :MediaPlayer

    var position = 0
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        position = intent
            .getIntExtra("position",0)
        createMusicPlayer()



        binding.playbtn.setOnClickListener {
            binding.title.text = title
            if (mediaplayer.isPlaying){
                binding.playbtn.setImageResource(R.drawable.baseline_play_arrow_24)
                mediaplayer.pause()
            }
            else{
                binding.playbtn.setImageResource(R.drawable.baseline_pause_24)
                mediaplayer.start()
            }

        }

        binding.previous.setOnClickListener {
            if (position>0){
                --position
                createMusicPlayer()
            }


        }
        binding.next.setOnClickListener {
          if (position<MainActivity.musicArray.size-1){
              ++position
              createMusicPlayer()
          }
        }

        binding.seekbar.min = 0
        binding.seekbar.max = mediaplayer.duration

        binding.seekbar.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(SeekBar: SeekBar?, Progress: Int, fromUser: Boolean) {

                mediaplayer.seekTo(Progress)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                TODO("Not yet implemented")
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                TODO("Not yet implemented")
            }

        })

    }
    private fun createMusicPlayer(){
        val  pathMusic = MainActivity.musicArray[position].path
        mediaplayer = MediaPlayer()
        mediaplayer.reset()
        mediaplayer.setDataSource(pathMusic)
        mediaplayer.prepare()
        mediaplayer.start()

    }
}