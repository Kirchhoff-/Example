package com.kirchhoff.gmailselectinganimation.data

data class EmailUiModel(
    val id: String,
    val contactImageUrl: String,
    val preview: String,
    val isSelected: () -> Boolean,
    val setSelected: (Boolean) -> Unit,
    val onClick: () -> Unit
)
