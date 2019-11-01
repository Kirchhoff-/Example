package com.example.recyclertoviewpager.fragment

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.recyclertoviewpager.R

/**
 * A fragment for displaying an image.
 */
internal class ImageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.f_image, container, false)

        val arguments = arguments
        @DrawableRes val imageRes = arguments!!.getInt(KEY_IMAGE_RES)

        // Just like we do when binding views at the grid, we set the transition name to be the string
        // value of the image res.
        view.findViewById<View>(R.id.image).transitionName = imageRes.toString()

        // Load the image with Glide to prevent OOM error when the image drawables are very large.
        Glide.with(this)
                .load(imageRes)
                .listener(ImageRequestListener())
                .into(view.findViewById<View>(R.id.image) as ImageView)
        return view
    }

    private inner class ImageRequestListener : RequestListener<Drawable> {

        override fun onLoadFailed(
            e: GlideException?,
            model: Any?,
            target: Target<Drawable>?,
            isFirstResource: Boolean
        ): Boolean {
            parentFragment!!.startPostponedEnterTransition()
            return false
        }

        override fun onResourceReady(
            resource: Drawable?,
            model: Any?,
            target: Target<Drawable>?,
            dataSource: DataSource?,
            isFirstResource: Boolean
        ): Boolean {
            parentFragment!!.startPostponedEnterTransition()
            return false
        }
    }

    companion object {

        private const val KEY_IMAGE_RES = "com.google.samples.gridtopager.key.imageRes"

        fun newInstance(@DrawableRes drawableRes: Int): ImageFragment {
            val fragment = ImageFragment()
            val argument = Bundle()
            argument.putInt(KEY_IMAGE_RES, drawableRes)
            fragment.arguments = argument
            return fragment
        }
    }
}
