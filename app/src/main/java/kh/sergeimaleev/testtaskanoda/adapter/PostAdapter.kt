package kh.sergeimaleev.testtaskanoda.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import kh.sergeimaleev.model.PhotoItem
import kh.sergeimaleev.model.PostItem
import kh.sergeimaleev.testtaskanoda.R
import kh.sergeimaleev.testtaskanoda.databinding.ItemPostBinding
import kotlinx.android.synthetic.main.item_post.view.*

class PostAdapter(
    private var postList: List<PostItem>,
    private val onLikeAction: () -> Unit,
    private val onCommentAction: () -> Unit,
    private val onShareAction: () -> Unit,
    private val onBookmarkAction: () -> Unit,
    private val onTreeDotsAction: () -> Unit
): RecyclerView.Adapter<PostAdapter.PostVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return PostVH(view)
    }

    override fun getItemCount(): Int = postList.size

    override fun onBindViewHolder(holder: PostVH, position: Int) {
        holder.bind(postList[position])
        holder.bindAction(
            onLikeAction = onLikeAction,
            onCommentAction = onCommentAction,
            onShareAction = onShareAction,
            onBookmarkAction = onBookmarkAction,
            onTreeDotsAction = onTreeDotsAction
        )
    }

    fun updateData(list: List<PostItem>) {
        postList = list
        notifyDataSetChanged()
    }

    class PostVH(private val v: View): RecyclerView.ViewHolder(v){
        private val binding by lazy<ItemPostBinding?> { DataBindingUtil.bind(v) }

        private fun initViewPager(
            v: View,
            photos: List<PhotoItem>
        ) {
            val viewPager = v.item_post_main_viewpager
            val adapter = ImageSlideAdapter(photos)
            viewPager.adapter = adapter

            val circleIndicator = v.view_pager_indicator
            circleIndicator.setViewPager(viewPager)
        }

        fun bind(postItem: PostItem){
            binding?.post = postItem
            initViewPager(v, postItem.photos)
        }

        fun bindAction(
            onLikeAction: () -> Unit,
            onCommentAction: () -> Unit,
            onShareAction: () -> Unit,
            onBookmarkAction: () -> Unit,
            onTreeDotsAction: () -> Unit
        ){
            v.iv_like.setOnClickListener { onLikeAction.invoke() }
            v.iv_comments.setOnClickListener{ onCommentAction() }
            v.iv_share.setOnClickListener { onShareAction() }
            v.iv_bookmark.setOnClickListener { onBookmarkAction() }
            v.item_post_header_three_dots.setOnClickListener { onTreeDotsAction() }
        }
    }
}