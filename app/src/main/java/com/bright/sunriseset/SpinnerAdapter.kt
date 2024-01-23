package com.bright.sunriseset

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class SpinnerAdapter(context: Context, private val languageList: ArrayList<Language>) :
    ArrayAdapter<Language>(context, 0, languageList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return createCustomView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return createCustomView(position, convertView, parent)
    }

    private fun createCustomView(position: Int, convertView: View?, parent: ViewGroup): View {
        val language = getItem(position)
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.spinner_item, parent, false)

        val flagView = view.findViewById<ImageView>(R.id.imageViewFlag)
        val textView = view.findViewById<TextView>(R.id.textViewLanguage)

        if (language != null) {
            flagView.setImageResource(language.flag)
            textView.text = language.name
        }

        return view
    }
}
