package io.github.jerrymatera.hnghelloworld.post

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.github.jerrymatera.hnghelloworld.R
import io.github.jerrymatera.hnghelloworld.data.model.Post
import io.github.jerrymatera.hnghelloworld.databinding.FragmentPostsBinding


class PostsFragment : Fragment() {
    private  var _binding: FragmentPostsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: PostsViewModel by viewModels()
    private lateinit var postAdapter: PostAdapter
    private var posts = listOf<Post>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentPostsBinding.inflate(inflater,container,false)
        val adapter = PostAdapter()
        binding.postListRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.postListRecyclerView.adapter= adapter

        viewModel.posts.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}