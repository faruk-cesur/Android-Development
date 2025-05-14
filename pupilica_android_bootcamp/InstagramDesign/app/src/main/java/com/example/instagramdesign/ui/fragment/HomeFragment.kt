package com.example.instagramdesign.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.instagramdesign.R
import com.example.instagramdesign.ui.adapter.PostAdapter
import com.example.instagramdesign.ui.adapter.StoryAdapter

class HomeFragment : Fragment() {

    private lateinit var postAdapter: PostAdapter
    private lateinit var storyAdapter: StoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val postImages = listOf(
            R.drawable.kabefoto, R.drawable.senafaruknisan, R.drawable.naksibendi,R.drawable.money
        )
        val storyImages = listOf(
            R.drawable.star, R.drawable.plus, R.drawable.gold,R.drawable.hand
        )

        // POST Adapter
        postAdapter = PostAdapter(postImages) { imageRes ->
            val bundle = bundleOf("postImage" to imageRes)
            findNavController().navigate(R.id.action_homeFragment_to_postDetailFragment, bundle)
        }
        view.findViewById<RecyclerView>(R.id.recyclerViewPosts).apply {
            //layoutManager = LinearLayoutManager(context)
            layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
            adapter = postAdapter
        }

        // STORY Adapter
        storyAdapter = StoryAdapter(storyImages)
        view.findViewById<RecyclerView>(R.id.recyclerViewStories).apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = storyAdapter
        }
    }
}
