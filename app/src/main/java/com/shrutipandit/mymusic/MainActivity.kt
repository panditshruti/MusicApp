package com.shrutipandit.mymusic


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.shrutipandit.mymusic.adapter.MusicAdapter
import com.shrutipandit.mymusic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
 private lateinit var binding: ActivityMainBinding
private lateinit var musucAdapter :MusicAdapter
 companion object {
     lateinit var musicArray:ArrayList<Music>
 }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        musicArray = MusicLoader.getAllAudio(this)
        musucAdapter = MusicAdapter(musicArray,this)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = musucAdapter


        }
    }


