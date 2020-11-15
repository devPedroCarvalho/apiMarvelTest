package test.test.apimarveltest.utils

import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import test.test.apimarveltest.R

fun loadImage(imageUrl: String,
              imageView: ImageView,
              fragment: Fragment) {
    Glide.with(fragment)
            .load(imageUrl)
            .error(R.drawable.ic_not_found_image)
            .into(imageView)
}

fun  showAlert (context: Context? ,
                message: String?) {
    Toast.makeText(context, message, Toast.LENGTH_LONG).show()
}