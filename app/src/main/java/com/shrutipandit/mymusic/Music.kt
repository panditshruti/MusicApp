package com.shrutipandit.mymusic

data class Music(
    val id: String,
    val title: String,
    val album: String,
    val artist: String,
    val path: String,
    val duration:Long=0,
)