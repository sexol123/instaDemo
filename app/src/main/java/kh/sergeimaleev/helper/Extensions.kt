package kh.sergeimaleev.helper

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import kh.sergeimaleev.testtaskanoda.R

@BindingAdapter("android:binding_url")
fun setImageViewPicasso(imageView: ImageView, url: String) {
    Picasso.get().apply {
        isLoggingEnabled = true
    }.load(url)
        .placeholder(R.drawable.ic_reload)
        .error(R.drawable.ic_problem)
        .priority(Picasso.Priority.HIGH)
        .into(imageView)
}