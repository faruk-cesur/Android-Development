package com.example.instagramdesign.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.instagramdesign.R

class PostDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_post_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // Bundle'dan resim ID'sini al
        val imageResId = arguments?.getInt("postImage")

        // ImageView'a set et
        val imageView = view.findViewById<ImageView>(R.id.imageViewPostDetail)
        if (imageResId != null) {
            imageView.setImageResource(imageResId)
        }
    }
}
