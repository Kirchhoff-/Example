package com.example.showmoretextview

import android.content.Context
import android.text.Spannable
import android.text.SpannableString
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.util.AttributeSet
import android.view.View
import android.view.ViewTreeObserver
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat

class ShowMoreTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    private val layoutObserver = LayoutObserver()
    private val mainText: CharSequence
    private val data: Data

    private val typedArray =
        context.obtainStyledAttributes(attrs, R.styleable.ShowMoreTextView, defStyleAttr, 0)

    init {
        try {
            data = Data(
                showMoreText = typedArray.getString(R.styleable.ShowMoreTextView_showMoreText)
                    ?: resources.getString(R.string.show_more_text_view_show_more),
                showLessText = typedArray.getString(R.styleable.ShowMoreTextView_showLessText)
                    ?: resources.getString(R.string.show_more_text_view_show_less),
                ellipsisCharacter = typedArray.getString(R.styleable.ShowMoreTextView_ellipsisCharacter)
                    ?: resources.getString(R.string.show_more_text_view_ellipsis_character),
                showMoreTextColor = typedArray.getColor(
                    R.styleable.ShowMoreTextView_showMoreTextColor,
                    ContextCompat.getColor(context, R.color.show_more_text_view_show_more_color)
                ),
                showLessTextColor = typedArray.getColor(
                    R.styleable.ShowMoreTextView_showLessTextColor,
                    ContextCompat.getColor(context, R.color.show_more_text_view_show_less_color)
                ),
                showLineCount =
                typedArray.getInt(
                    R.styleable.ShowMoreTextView_showLineCount,
                    DEFAULT_SHOW_LINE_COUNT
                )
            )
        } finally {
            typedArray.recycle()
        }

        mainText = text
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        viewTreeObserver.addOnGlobalLayoutListener(layoutObserver)
    }

    private companion object {
        const val DEFAULT_SHOW_LINE_COUNT = 2
    }

    private inner class LayoutObserver : ViewTreeObserver.OnGlobalLayoutListener {
        override fun onGlobalLayout() {
            initialize()
            viewTreeObserver.removeOnGlobalLayoutListener(this)
        }

        private fun initialize() {
            val initialText = text.toString()

            var showingText = ""
            var startIndex = 0
            for (i in 0 until data.showLineCount) {
                val end = layout.getLineEnd(i)
                showingText += initialText.substring(startIndex, end)
                startIndex = end
            }

            var resultText = showingText.substring(
                0,
                showingText.length - (data.ellipsisCharacter.length + data.showMoreText.length)
            )
            resultText += data.ellipsisCharacter + data.showMoreText

            text = resultText
            showMoreButton()
        }

        private fun showMoreButton() {
            val showMoreTextStartIndex =
                text.length - (data.ellipsisCharacter.length + data.showMoreText.length)
            val resultSpannableString = SpannableString(text)

            resultSpannableString.setSpan(
                object : ClickableSpan() {
                    override fun onClick(widget: View) {
                        maxLines = Int.MAX_VALUE
                        text = mainText
                        showLessButton()
                    }
                },
                showMoreTextStartIndex,
                text.length,
                0
            )

            resultSpannableString.setSpan(
                ForegroundColorSpan(data.showMoreTextColor),
                showMoreTextStartIndex,
                text.length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )

            movementMethod = LinkMovementMethod.getInstance()
            setText(resultSpannableString, BufferType.SPANNABLE)
        }

        private fun showLessButton() {
            val resultSpannableString = SpannableString(text.toString() + data.showLessText)
            val showLessTextStartIndex = resultSpannableString.length - data.showLessText.length

            resultSpannableString.setSpan(
                object : ClickableSpan() {
                    override fun onClick(widget: View) {
                        maxLines = data.showLineCount
                        initialize()
                    }
                },
                showLessTextStartIndex,
                resultSpannableString.length,
                0
            )

            resultSpannableString.setSpan(
                ForegroundColorSpan(data.showLessTextColor),
                showLessTextStartIndex,
                resultSpannableString.length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )

            movementMethod = LinkMovementMethod.getInstance()
            setText(resultSpannableString, BufferType.SPANNABLE)
        }
    }

    private data class Data(
        val showMoreText: String,
        val showLessText: String,
        val ellipsisCharacter: String,
        val showMoreTextColor: Int,
        val showLessTextColor: Int,
        val showLineCount: Int
    )
}
