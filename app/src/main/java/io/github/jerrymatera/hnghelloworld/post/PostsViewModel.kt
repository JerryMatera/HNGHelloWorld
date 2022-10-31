package io.github.jerrymatera.hnghelloworld.post

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.jerrymatera.hnghelloworld.data.model.Post
import io.github.jerrymatera.hnghelloworld.data.network.PostApi
import kotlinx.coroutines.launch

class PostsViewModel : ViewModel() {
    private val _posts = MutableLiveData<List<Post>>()
    val posts: LiveData<List<Post>> = _posts

    init {
        getPosts()
    }

    private fun getPosts() {
        viewModelScope.launch {
            val response = PostApi.retrofitService.getPosts()
            _posts.value = response
            println(response)
        }
    }
}