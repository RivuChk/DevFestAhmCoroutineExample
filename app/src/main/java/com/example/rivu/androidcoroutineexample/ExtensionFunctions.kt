package com.example.rivu.androidcoroutineexample

import android.net.Uri

fun String.toUri(): Uri = Uri.parse(this)