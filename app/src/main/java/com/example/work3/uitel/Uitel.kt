package com.example.work3.uitel

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.work3.R
import androidx.databinding.BindingAdapter as BindingAdapter1

fun getProgessDrawable(c:Context): CircularProgressDrawable {
    return CircularProgressDrawable(c).apply {
        strokeWidth = 5f
        centerRadius = 40f
        start()
    }

}

/**set Images*/
fun ImageView.loadImage(uri:String?,progressDawable:CircularProgressDrawable){

    val option = RequestOptions().placeholder(progressDawable)
        .error(R.mipmap.ic_launcher)

    Glide.with(context)
        .setDefaultRequestOptions(option)
        .load(uri)
        .into(this)

}

@BindingAdapter1("android:imageUrl")
fun loadImage(view:ImageView,url:String){
    view.loadImage(url, getProgessDrawable(view.context))
}