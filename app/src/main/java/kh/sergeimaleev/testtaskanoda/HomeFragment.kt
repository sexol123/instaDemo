package kh.sergeimaleev.testtaskanoda

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kh.sergeimaleev.testtaskanoda.adapter.PostAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    private val layoutId = R.layout.fragment_home
    private lateinit var mViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: ViewDataBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        initRecycler()
    }

    private fun initRecycler() {
        val adapter = PostAdapter(
            postList = listOf(),
            onLikeAction = { showToast("Like") },
            onCommentAction = { showToast("Comment") },
            onShareAction = { showToast("Share") },
            onBookmarkAction = { showToast("Bookmark") },
            onTreeDotsAction = { showToast("3 dots clicked") }
        )
        recycler_posts?.let {
            it.layoutManager = LinearLayoutManager(context)
            it.adapter = adapter
        }

        mViewModel.posts.observe(viewLifecycleOwner, Observer {
            adapter.updateData(it)
        })
    }

    private fun showToast(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }
}
