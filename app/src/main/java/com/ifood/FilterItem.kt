package com.ifood

import android.content.Context
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import androidx.annotation.DrawableRes
import com.google.android.material.chip.Chip

data class FilterItem(
    val id: Int,
    val text: String,
    @DrawableRes val icon: Int? = null,
    val iconSize: Float = 32.0f,
    @DrawableRes val closeIcon: Int? = null
)

fun FilterItem.toChip(context: Context): Chip {
    val chip = if(closeIcon == null){
        LayoutInflater.from(context).inflate(R.layout.chip_choice, null, false) as Chip
    } else {
        Chip(ContextThemeWrapper(context, com.google.android.material.R.style.Widget_MaterialComponents_Chip_Choice))
    }

    if (closeIcon != null)
        chip.setChipBackgroundColorResource(R.color.white)

    chip.setChipStrokeColorResource(R.color.lt_gray)

    chip.chipStrokeWidth = 2f

    if(closeIcon == null && icon == null) {
        chip.chipIcon = null
    }

    icon?.let {
        chip.chipIconSize = iconSize
        chip.setChipIconResource(it)
        chip.chipStartPadding = 20f
    }
    closeIcon?.let {
        chip.setCloseIconResource(it)
        chip.isCloseIconVisible = true
    }


    chip.text = text

    return chip
}