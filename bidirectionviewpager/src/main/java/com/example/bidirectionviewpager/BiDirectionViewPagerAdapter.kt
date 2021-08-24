package com.example.bidirectionviewpager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.bidirectionviewpager.repository.CategoryImagesInfo
import com.example.bidirectionviewpager.views.BiDirectionViewPager
import kotlinx.android.synthetic.main.r_item.view.imageView
import kotlinx.android.synthetic.main.r_item.view.textView

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
            viewHolder.itemView.apply {
                textView.text = groupName
                Glide.with(imageView.context)
                    .load(url)
                    .into(imageView)
            }
        }
    }

    override fun getItemCount(): Int = data.size

    override fun getHorizontalItemCount(verticalPosition: Int): Int =
        data[verticalPosition].imagesLink.size * REPEAT_COUNT

    class VideoViewHolder(itemView: View) : BiDirectionViewPager.ViewHolder(itemView)

    companion object {
        private const val REPEAT_COUNT = 30
    }
}
