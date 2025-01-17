package com.example.messenger

import android.content.Context
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date

fun Context.createImageFile(): File{
    val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
    val imageFileName= "LINK_"+timeStamp+"_"
    val image = File.createTempFile(
        imageFileName,
        ".jpg",
        externalCacheDir
    )
    return image
}