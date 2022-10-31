package io.github.jerrymatera.hnghelloworld

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.github.jerrymatera.hnghelloworld.databinding.ActivityMainBinding
import io.github.jerrymatera.hnghelloworld.post.PostAdapter
import io.github.jerrymatera.hnghelloworld.post.PostsViewModel


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView
    private val postsViewModel: PostsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        recyclerView = binding.postListRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        val postAdapter = PostAdapter()
        recyclerView.adapter = postAdapter
        postsViewModel.posts.observe(this){
            postAdapter.submitList(it)
        }
    }
}