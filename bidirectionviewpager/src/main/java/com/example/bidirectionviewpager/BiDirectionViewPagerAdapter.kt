package com.example.bidirectionviewpager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.bidirectionviewpager.databinding.RItemBinding
import com.example.bidirectionviewpager.repository.CategoryImagesInfo
import com.example.bidirectionviewpager.views.BiDirectionViewPager

class BiDirectionViewPagerAdapter(private val data: List<CategoryImagesInfo>) :
    BiDirectionViewPager.BiDirectionViewPagerAdapter {

    override fun onCreateView(parent: ViewGroup): BiDirectionViewPager.ViewHolder =
        VideoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.r_item, parent, false))

    override fun onBindView(
        viewHolder: BiDirectionViewPager.ViewHolder,
        rowPosition: Int,
        columnPosition: Int
    ) {
        val (groupName, rowData) = data[rowPosition]
        val originalSize = rowData.size
        val url = rowData[columnPosition.rem(originalSize)]

        if (viewHolder is VideoViewHolder) {
            viewHolder.textView.text = groupName
            Glide.with(viewHolder.imageView.context)
                .load(url)
                .into(viewHolder.imageView)
        }
    }

    override fun getItemCount(): Int = data.size

    override fun getHorizontalItemCount(verticalPosition: Int): Int =
        data[verticalPosition].imagesLink.size * REPEAT_COUNT

    private class VideoViewHolder(itemView: View) : BiDirectionViewPager.ViewHolder(itemView) {
        private val binding = RItemBinding.bind(itemView)
        val textView = binding.textView
        val imageView = binding.imageView
    }

    companion object {
        private const val REPEAT_COUNT = 30
    }
}
