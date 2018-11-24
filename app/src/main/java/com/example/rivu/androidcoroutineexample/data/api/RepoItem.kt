package com.example.rivu.androidcoroutineexample.data.api

import android.net.Uri
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RepoItem(val name: String, val url: Uri) : Parcelable